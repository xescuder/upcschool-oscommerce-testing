package upcschool.oscommerce.model;

public class ProductItem {
	
	//A productItem is a product description with a quantity and a single item price
	private String productReference;
	private int quantity;
	private double singleItemPriceInDefaultCurrency;
	
	public ProductItem (String productReference, double singleItemPriceInDefaultCurrency, int quantity) {
		this.productReference=productReference;
		this.singleItemPriceInDefaultCurrency=singleItemPriceInDefaultCurrency;
		this.quantity=quantity;
	}

	public String getProductReference() {
		return productReference;
	}

	public void setProductReference(String productReference) {
		this.productReference = productReference;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSingleItemPriceInDefaultCurrency() {
		return singleItemPriceInDefaultCurrency;
	}

	public void setSingleItemPrice(double singleItemPriceInDefaultCurrency) {
		this.singleItemPriceInDefaultCurrency = singleItemPriceInDefaultCurrency;
	}
	
	

}
