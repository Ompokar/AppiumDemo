package Demo;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwitchHandling {


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
	    
	    //scroll to switch
	    String mobElementToScroll = "Switches";
	    
	    WebElement switchesElement = driver.findElement(
	    		AppiumBy.androidUIAutomator(
	    				"new UiScrollable(new UiSelector().scrollable(true))" +
	    				".scrollIntoView(new UiSelector().text(\"" +
	    mobElementToScroll+"\"))"
	    				)
	    );
	    
	    switchesElement.click();
	    
	    WebElement monitoredSwitch = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
	    
	    if(monitoredSwitch.isSelected()==true)
	    {
	    	System.out.println("Monitoried Switch is ON");
	    }
	    else
	    {
	    	System.out.println("Monitoried Switch is OFF, turning it ON");
	    	monitoredSwitch.click();
	    }
	    
		driver.quit();

		}	

	}


