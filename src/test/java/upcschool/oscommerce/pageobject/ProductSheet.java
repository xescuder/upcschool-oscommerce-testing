package upcschool.oscommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSheet {
	
	WebDriver driver=null;
	
	@FindBy(id = "tdb4")
	private WebElement addToCart;
	
	@FindBy(id = "tdb4")
	private WebElement numberOfItems;
	
	public ProductSheet (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
	}
}
