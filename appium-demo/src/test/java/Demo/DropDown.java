package Demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DropDown {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // 1. Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("192.168.1.15:5555");           // USB device id
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
        
        //click on view
        driver.findElements(By.id("android:id/text1")).get(11).click();
        
        //click on control
        driver.findElements(By.id("android:id/text1")).get(4).click();
        
        //click on light theme
        driver.findElements(By.id("android:id/text1")).get(0).click();
        
        //click on drop down list
        driver.findElements(By.id("android:id/text1")).get(0).click();
        
        Thread.sleep(5000);
        
        //click neptune 
        driver.findElements(By.id("android:id/text1")).get(7).click();

        driver.quit();
        

	}

}
 