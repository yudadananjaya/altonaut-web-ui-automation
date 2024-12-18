package com.altonaut.function;

import com.altonaut.config.Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class altonautWeb {
    // Add more configuration values as needed
    // Wait for an element to be visible (using Config's LONG_WAIT_DURATION)
    public static void waitForElementVisible(WebDriver driver, By by) {
        new org.openqa.selenium.support.ui.WebDriverWait(driver, Config.LONG_WAIT_DURATION)
            .until(webDriver -> webDriver.findElement(by).isDisplayed());
    }
}
