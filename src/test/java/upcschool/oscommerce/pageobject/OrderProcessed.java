package upcschool.oscommerce.pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProcessed {
	
	WebDriver driver=null;
	
	@FindBy(id = "tdb5")
	private WebElement continueButton;
	
	@FindBy(xpath = "//*[@id=\"bodyContent\"]/h1")
	private WebElement successfulFinalText;
	
	public OrderProcessed (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyOrder(WebDriverWait wait, String verificationText) {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		Assertions.assertEquals(verificationText, successfulFinalText.getText());
	}
	
}
