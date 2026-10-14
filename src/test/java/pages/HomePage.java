package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
    AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isAccessibilityDisplayed() {
        return driver.findElement(AppiumBy.accessibilityId("Accessibility")).isDisplayed();
    }
}