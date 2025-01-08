package com.altonaut.function;

import com.altonaut.global.GlobalVariables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class altonautWeb {

    public static void waitForElementVisible(WebDriver driver, By by) {
        new org.openqa.selenium.support.ui.WebDriverWait(driver, GlobalVariables.LONG_WAIT_DURATION)
            .until(webDriver -> webDriver.findElement(by).isDisplayed());
    }
}
