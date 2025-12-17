package Demo;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Appmanagement {

    public static void main(String[] args) throws Exception {

        // 1. Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Samsung SM-S931B");
        options.setUdid("192.168.1.15:5555");  // device id (Wi‑Fi)
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");

        // 2. Start driver (Appium server must be running)
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        // 3. Install ApiDemos APK
        driver.installApp("/home/cloudmate-pc-23/Downloads/ApiDemos-debug.apk");

        // 4. Activate (bring to foreground) ApiDemos
        String apiDemosPkg = "io.appium.android.apis";
        driver.activateApp(apiDemosPkg);

        // ... do something in the app if needed ...

        // 5. Remove another app (example: Dmart)
        String dmartPkg = "in.dmart";
        driver.removeApp(dmartPkg);

        // 6. Terminate ApiDemos (close but keep installed)
        driver.terminateApp(apiDemosPkg);

        driver.quit();
    }
}
