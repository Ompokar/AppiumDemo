package Demo;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwipeandScroll {

    public static void main(String[] args) throws Exception {

        // 1. Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("192.168.1.15:5555");  // device id
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setNoReset(true);

        // 2. Start driver
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        // Open Views
        driver.findElements(By.id("android:id/text1")).get(11).click();

        // 3. Get screen size
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);   // bottom area
        int endX   = startX;
        int endY   = (int) (size.getHeight() * 0.2);   // upper area

        // 4. Build swipe sequence (finger1)
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger1, 1);
        swipe.addAction(finger1.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger1, Duration.ofMillis(200)));
        swipe.addAction(finger1.createPointerMove(Duration.ofMillis(500),
                PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // 5. Perform swipe
        driver.perform(Collections.singletonList(swipe));

        Thread.sleep(2000);
        driver.quit();
    }
}
