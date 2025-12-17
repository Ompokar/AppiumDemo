package Demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Handleradiotextcheckbox {

	public static void main(String[] args) throws Exception 
	{ 
		
	UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("Android");
    options.setDeviceName("Samsung SM-S931B");
    options.setUdid("192.168.1.15:5555");
    options.setPlatformVersion("14");
    options.setAutomationName("UiAutomator2");
    options.setAppPackage("io.appium.android.apis");
    options.setAppActivity("io.appium.android.apis.ApiDemos");
    options.setNoReset(true);

    AndroidDriver driver = new AndroidDriver(
            new URL("http://127.0.0.1:4723"),
            options
    );
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    //click on view
    driver.findElements(By.id("android:id/text1")).get(11).click();
    
    //click on control
    driver.findElements(By.id("android:id/text1")).get(04).click();
    
    //click on light theme
    driver.findElements(By.id("android:id/text1")).get(00).click();
    
    //click on textbox
	driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Om pokar");
	
	//click on checkbox
	driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
	
	//click on radiobtn
	driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();
	
	driver.quit();

	}

}
