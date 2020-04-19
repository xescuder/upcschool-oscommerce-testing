package upcschool.oscommerce.common;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import upcschool.oscommerce.pageobject.Catalog;
import upcschool.oscommerce.pageobject.DeliveryInformation;
import upcschool.oscommerce.pageobject.OrderConfirmation;
import upcschool.oscommerce.pageobject.OrderProcessed;
import upcschool.oscommerce.pageobject.PaymentInformation;
import upcschool.oscommerce.pageobject.ProductSheet;
import upcschool.oscommerce.pageobject.ShoppingCart;
import upcschool.oscommerce.pageobject.SignIn;

public class Process {
	private static final int ESPERA = 10;
	
	private  WebDriverWait wait;
	private WebDriver driver;
	
	public Catalog catalog;
	public ProductSheet productSheet;
	public ShoppingCart shoppinCart;
	public SignIn signIn;
	public DeliveryInformation deliveryInformation;
	public PaymentInformation paymentInformation;
	public OrderConfirmation orderConfirmation;
	public OrderProcessed orderProcessed;
	
	public Process(WebDriver driver) {
		this.driver=driver;
		
		catalog = new Catalog(driver);
		productSheet = new ProductSheet(driver);
		shoppinCart = new ShoppingCart(driver);
		signIn = new SignIn(driver);
		deliveryInformation = new DeliveryInformation(driver);
		paymentInformation = new PaymentInformation(driver);
		orderConfirmation = new OrderConfirmation(driver);
		orderProcessed = new OrderProcessed(driver);
		
		wait = new WebDriverWait(driver, ESPERA);
	}

	public void enterSite (String url) {
		driver.get(url);
	}


	@Step("Selecting product {product}")
	public void selectProduct(String product) {
		if(product.equals("Samsung")) {
			catalog.clickSamsungGalaxyTab(wait);
		}
		if (product.equals("Beloved")) {
			catalog.clickBeloved(wait);
		}
	}


	@Step("Updating quantity to {quantity}")
	public void updateQuantity(String quantity) {
		shoppinCart.updateQuantity(wait, quantity);
		shoppinCart.clickCheckout(wait);
	}


	@Step("Adding to cart")
	public void addToCart() {
		productSheet.addToCart(wait);
	}


	@Step("Sign in")
	public void signInProcess() {
		signIn.enterUserCredentials(wait, "ivanmolmar@outlook.es", "paswordfalso123");
		deliveryInformation.clickContinue(wait);
	}

	@Step("Processing order and confirmation")
	public void processOrderAndConfirm() {
		paymentInformation.selectPaymentMethod(wait);
		orderConfirmation.orderPayment(wait);
		orderProcessed.verifyOrder(wait, "Your Order Has Been Processed!");
	}

}
