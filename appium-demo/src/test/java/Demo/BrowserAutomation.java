package Demo;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserAutomation {

    public static void main(String[] args) throws Exception {

        // 1. Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("192.168.1.12:5555");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);
        options.setCapability("browserName", "Chrome");
        options.setCapability(
                "chromedriverExecutable",
                "/home/cloudmate-pc-23/Desktop/demo elc/appium-demo/chromedriver-linux64/chromedriver"
        );

        // 2. Start driver (Appium server must be running)
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Open Google
        driver.get("https://www.google.com/");

        // 4. Find search box and search "narendra modi"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("narendra modi");
        searchBox.sendKeys(Keys.ENTER);

        // optional small wait then quit
        Thread.sleep(5000);
        driver.quit();
    }
}
