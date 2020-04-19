package upcschool.oscommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {
	
	WebDriver driver=null;
	
	@FindBy(name = "email_address")
	private WebElement emailAdress;

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(id = "tdb1")
	private WebElement SignInButton;
	
	public SignIn (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserCredentials(WebDriverWait wait, String userMail, String userPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
		
		emailAdress.click();
		emailAdress.clear();
		emailAdress.sendKeys(userMail);
		
		password.click();
		password.clear();
		password.sendKeys(userPassword);
		
		SignInButton.submit();	
	}
	
}
