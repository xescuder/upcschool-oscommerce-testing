package upcschool.oscommerce.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import upcschool.oscommerce.common.Process;
import upcschool.oscommerce.common.ScreenshotUtils;

import java.io.File;
import java.io.IOException;


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

    private WebDriver createDriver() {
        return new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
    }

    public static void quitDriver() {
        driver.quit();
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        createAndStartService();
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        driver = createDriver();
        driver.manage().window().maximize();
        process = new Process(driver);
    }

    @AfterEach
    void tearDown() throws Exception {
        quitDriver();
    }


    @Test
    @Description("Testing Samsung models")
    @Severity(SeverityLevel.CRITICAL)
    void test1() {
        process.enterSite(OSCOMMERCE_URL);
        process.selectProduct("Samsung");
        ScreenshotUtils.screenshot(driver);
        process.addToCart();
        process.updateQuantity("2");
        process.signInProcess();
        process.processOrderAndConfirm();
    }

    @Test
    @Description("Testing Beloved models")
    void test2() {
        process.enterSite(OSCOMMERCE_URL);
        process.selectProduct("Beloved");
        process.addToCart();
        process.updateQuantity("3");
        process.signInProcess();
        process.processOrderAndConfirm();
    }


}



