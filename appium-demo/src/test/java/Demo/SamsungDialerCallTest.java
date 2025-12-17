package Demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;

public class SamsungDialerCallTest {
    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("192.168.1.15:5555");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.dialer");
        options.setAppActivity("com.samsung.android.dialer.DialtactsActivity");
        options.setNoReset(true);

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // helper to tap a digit on Samsung dialer
        // from Inspector: class = android.widget.TextView, id = com.samsung.android.dialer:id/dialpad_key_number, text = digit
        java.util.function.Consumer<String> tapDigit = digit -> {
            WebElement el = driver.findElement(By.xpath(
                    "//android.widget.TextView[@resource-id='com.samsung.android.dialer:id/dialpad_key_number' and @text='"
                            + digit + "']"));
            el.click();
        };

        String phoneNumber = "9998336510";

        for (char c : phoneNumber.toCharArray()) {
            tapDigit.accept(String.valueOf(c));
        }

        // Call button – inspect once and adjust locator if needed
        // Try by content-desc first (Phone / Call icon)
        WebElement callButton = driver.findElement(
                By.id("com.samsung.android.dialer:id/dialButtonImage")
        );
        callButton.click();

        // wait few seconds so call actually starts
        Thread.sleep(5000);

        driver.quit();
    }
}
