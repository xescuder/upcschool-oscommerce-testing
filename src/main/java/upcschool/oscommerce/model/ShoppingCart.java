package upcschool.oscommerce.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

//A shopping cart represents a container for adding product items, and computes the total price
public class ShoppingCart {

    //The list of items
    List<ProductItem> productItems;

    //The name of the shopping cart
    String shoppingCartName;

    public ShoppingCart(String shoppingCartName) {
        productItems = new LinkedList<ProductItem>();
        this.shoppingCartName = shoppingCartName;
    }

    public void addProductItem(ProductItem productItem) {
        productItems.add(productItem);
    }

    public void removeProductItem(int index) {
        productItems.remove(index);
    }

    public int numberOfItems() {
        return productItems.size();
    }

    public Price totalPrice() {

        double priceInDefaultCurrency = 0;

        for (ProductItem item : productItems) {
            priceInDefaultCurrency += item.getQuantity() * item.getSingleItemPriceInDefaultCurrency();
        }

        Price result = new Price(priceInDefaultCurrency, Configuration.getInstance().getDefaultCurrency());
        return result;

    }

    public Price totalPrice(Currency c) throws IOException {

        double conversionRate = getCurrencyConvertRate(Configuration.getInstance().getDefaultCurrency(), c);

        Price result = new Price(this.totalPrice().getAmount() * conversionRate, c);
        return result;

    }


    private static double getCurrencyConvertRate(Currency fromCurrency, Currency toCurrency) throws IOException {
        URL urlForGetRequest = new URL("https://api.exchangeratesapi.io/latest?symbols=" + toCurrency.getCurrencyCode());
        String readLine = null;
        System.out.println(urlForGetRequest.toExternalForm());
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        StringBuffer response = null;
        conection.setRequestProperty("base", fromCurrency.getCurrencyCode()); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            //System.out.println("GET NOT WORKED");
        }

        JSONObject obj = null;
        try {
            obj = new JSONObject(response.toString());
            JSONObject rates = (JSONObject) obj.get("rates");
            double rateValue = (double) rates.get(toCurrency.getCurrencyCode());
            System.out.println("rateValue:" + rateValue);
            return rateValue;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
