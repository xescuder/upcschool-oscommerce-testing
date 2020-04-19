package upcschool.oscommerce.test;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import upcschool.oscommerce.common.Process;


class ShoppingTest {
	public static final String OSCOMMERCE_URL = "https://demo.oscommerce.com/";

	private static WebDriver driver;
	private static ChromeDriverService service;

	private Process process; 
	
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
		      .usingDriverExecutable(new File("chromedriver"))
		      .usingAnyFreePort()
		      .build();
		  service.start();
	}
	
	public static void createDriver() {
		  driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());	  
	}
	
	public static void quitDriver() {
		  driver.quit();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		createAndStartService();	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception {
		createDriver();
		driver.manage().window().maximize();
		process = new Process(driver);
	}

	@AfterEach
	void tearDown() throws Exception {
		quitDriver();
	}

	@Test
	void test1() {
		process.enterSite(OSCOMMERCE_URL);
		process.selectProduct("Samsung");
		process.addToCart();
		process.updateQuantity("2");
		process.signInProcess();
		process.processOrderAndConfirm();
	}
	
	@Test
	void test2() {
		process.enterSite(OSCOMMERCE_URL);
		process.selectProduct("Beloved");
		process.addToCart();
		process.updateQuantity("3");
		process.signInProcess();
		process.processOrderAndConfirm();
	}

}



