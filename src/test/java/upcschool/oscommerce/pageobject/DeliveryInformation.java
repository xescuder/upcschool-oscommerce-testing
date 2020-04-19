package upcschool.oscommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryInformation {
	
	WebDriver driver=null;
	
	@FindBy(id = "tdb6")
	private WebElement continueButton;
	
	public DeliveryInformation (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickContinue(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.submit();
	}
}
