package Demo;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LongPress {

    static AndroidDriver driver;

    public static void main(String[] args) throws Exception {

        // 1. Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("192.168.1.12:5555");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.dialer");
        options.setAppActivity("com.samsung.android.dialer.DialtactsActivity");
        options.setNoReset(true);

        // 2. Start driver
        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // dial number
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

        // find delete button and long‑press on it
        WebElement deleteBtn = driver.findElement(
                By.id("com.samsung.android.dialer:id/delete_button_image"));
        longPress(deleteBtn);

        driver.quit();
    }

    // W3C long‑press helper
    static void longPress(WebElement el) {
        Point location = el.getLocation();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longpress = new Sequence(finger, 1);

        longpress.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), location.x, location.y));
        longpress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longpress.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(1)));
        longpress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(longpress));
    }
}
