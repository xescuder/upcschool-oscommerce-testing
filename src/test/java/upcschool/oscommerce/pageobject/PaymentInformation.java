package upcschool.oscommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentInformation {
	
	WebDriver driver=null;
	
	@FindBy(xpath = "//input[@name='payment' and @value='cod']")
	private WebElement cashOnDelivery;
	
	@FindBy(id = "tdb6")
	private WebElement continueButton;
	
	public PaymentInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectPaymentMethod(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(cashOnDelivery));
		cashOnDelivery.click();
		continueButton.click();
	}
	
}
