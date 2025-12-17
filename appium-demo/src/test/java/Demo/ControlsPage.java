package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ControlsPage {

    private AndroidDriver driver;

    private By listItem = By.id("android:id/text1");
    private By textBox  = By.id("io.appium.android.apis:id/edit");
    private By checkBox = By.id("io.appium.android.apis:id/check1");
    private By radioBtn = By.id("io.appium.android.apis:id/radio2");

    public ControlsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openLightThemeControls() {
        // Home -> Views
        driver.findElements(listItem).get(11).click();
        // Views -> Controls
        driver.findElements(listItem).get(4).click();
        // Controls -> Light Theme
        driver.findElements(listItem).get(0).click();
    }

    public void enterName(String name) {
        driver.findElement(textBox).sendKeys(name);
    }

    public void toggleCheckbox() {
        driver.findElement(checkBox).click();
    }

    public void selectRadio() {
        driver.findElement(radioBtn).click();
    }

    public void selectPlanet(String planetName) {
        // open spinner (first dropdown)
        driver.findElements(listItem).get(0).click();
        WebElement option = driver.findElement(
                By.xpath("//android.widget.CheckedTextView[@text='" + planetName + "']"));
        option.click();
    }
}
