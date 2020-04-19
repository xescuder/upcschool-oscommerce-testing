package upcschool.oscommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmation {
	
	WebDriver driver=null;
	
	@FindBy(id = "tdb5")
	private WebElement payNow;
	
	public OrderConfirmation (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void orderPayment(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(payNow));
		payNow.submit();
	}
}
