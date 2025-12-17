package Demo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.URL;

public class SamsungCalculatorTest {
    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("192.168.1.19:5555"); // or USB UDID
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity("com.sec.android.app.popupcalculator.Calculator");
        options.setNoReset(true);

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        // 10 + 8 =
        WebElement one = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01"));
        WebElement zero = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00"));
        WebElement eight = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_08"));
        WebElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
        WebElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
        WebElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
        WebElement Minus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub"));
        WebElement Multiplication = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul"));
        WebElement Division = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div"));

     // 10 + 8 =
        one.click();
        zero.click();
        plus.click();
        eight.click();
        equal.click();            // 18
        

        // × 3 =
        Multiplication.click();
        three.click();
        equal.click();            // 54
        

        // - 2 =
        Minus.click();
        two.click();
        equal.click();            // 52
        

        // ÷ 2 =
        Division.click();
        two.click();
        equal.click();            // 26
   

        driver.quit();
    }
}
