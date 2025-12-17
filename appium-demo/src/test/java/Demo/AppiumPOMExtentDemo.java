package Demo;

import org.testng.annotations.Test;

public class AppiumPOMExtentDemo extends BaseTest {

    @Test
    public void controlsFlowTest() throws Exception {

        ControlsPage controls = new ControlsPage(driver);

        test.info("Opening Views -> Controls -> Light Theme screen");
        controls.openLightThemeControls();

        test.info("Entering text into textbox");
        controls.enterName("Om Pokar");

        test.info("Toggling checkbox");
        controls.toggleCheckbox();

        test.info("Selecting radio button");
        controls.selectRadio();

        test.info("Selecting planet 'Neptune' from dropdown");
        controls.selectPlanet("Neptune");

        Thread.sleep(2000);
    }
}
