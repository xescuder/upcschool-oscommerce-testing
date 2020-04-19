package upcschool.oscommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Catalog {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Samsung Galaxy Tab']")
	private WebElement samsungGalaxyTab;
	
	@FindBy(xpath = "//img[@title='Beloved']")
	private WebElement beloved;
	
	public Catalog (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSamsungGalaxyTab(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(samsungGalaxyTab));
		samsungGalaxyTab.click();
	}
	
	public void clickBeloved(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(beloved));
		beloved.click();
	}

}
