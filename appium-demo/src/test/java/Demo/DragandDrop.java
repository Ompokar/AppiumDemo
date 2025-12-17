package Demo;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DragandDrop {

    public static void main(String[] args) throws Exception {

        // 1. Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("RZCYA0A7VCA");           // USB device id
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setNoReset(true);

        // 2. Start driver (Appium server must already be running on 4723)
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Navigate: Views -> Drag and Drop
        driver.findElements(By.id("android:id/text1")).get(11).click(); // Views
        driver.findElements(By.id("android:id/text1")).get(7).click();  // Drag and Drop

        Thread.sleep(1000);

        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);

        dragNDrop.addAction(
                finger.createPointerMove(Duration.ZERO,
                        PointerInput.Origin.viewport(), 0, 414));      // start
        dragNDrop.addAction(
                finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(
                finger.createPointerMove(Duration.ofMillis(800),
                        PointerInput.Origin.viewport(), 474, 414));    // end
        dragNDrop.addAction(
                finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(java.util.Collections.singletonList(dragNDrop));
        Thread.sleep(2000);
        
        System.out.println(source.getLocation());
        System.out.println(target.getLocation());
        driver.quit();
    }
}
