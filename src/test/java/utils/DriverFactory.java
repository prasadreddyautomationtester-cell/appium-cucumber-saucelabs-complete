package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;

public class DriverFactory {
    public static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() throws Exception {

        String username = ConfigReader.getProperty("sauce.username");
        String accessKey = ConfigReader.getProperty("sauce.accesskey");

        System.out.println("Username = " + username);
        System.out.println("Access Key = " + accessKey);

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Samsung Galaxy S23 FE");
        options.setPlatformVersion("16");

        options.setApp("storage:8b30cf25-6f5e-407d-9ff2-eba6c52a604d");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", username);
        sauceOptions.setCapability("accessKey", accessKey);
        sauceOptions.setCapability("name", "API Demo Test");
        sauceOptions.setCapability("build", "Build-1");
        sauceOptions.setCapability("appiumVersion", "latest");

        options.setCapability("sauce:options", sauceOptions);

        System.out.println(options.asMap());

        driver = new AndroidDriver(
                new URL("https://ondemand.eu-central-1.saucelabs.com/wd/hub"),
                options);
    }

    public static void quitDriver() {
        if (driver != null) driver.quit();
    }
}