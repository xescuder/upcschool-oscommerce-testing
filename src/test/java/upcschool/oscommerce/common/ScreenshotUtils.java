package upcschool.oscommerce.common;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    @Attachment(type = "image/png")
    public static byte[] screenshot(WebDriver driver)/* throws IOException */ {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}