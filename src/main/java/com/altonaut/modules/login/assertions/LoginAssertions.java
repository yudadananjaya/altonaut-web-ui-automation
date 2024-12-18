package com.altonaut.modules.login.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.altonaut.function.altonautWeb; // Import altonautWeb global function
import com.altonaut.modules.login.locators.LoginLocators;

public class LoginAssertions {

    // public static void assertLoginSuccess(WebDriver driver) {
    //     Config.waitForElementVisible(driver, By.xpath(LoginLocators.DASHBOARD_ELEMENT));
    //     boolean isDisplayed = driver.findElement(By.xpath(LoginLocators.DASHBOARD_ELEMENT)).isDisplayed();
    //     if (!isDisplayed) {
    //         throw new AssertionError("Dashboard element is not displayed. Login may have failed.");
    //     }
    // }

    public void assertLoginFailed(WebDriver driver, String expectedErrorMsg) {
        altonautWeb.waitForElementVisible(driver, By.xpath(LoginLocators.ERROR_IVALID_CREDENTIAL));
        String actualErrorMsg = driver.findElement(By.xpath(LoginLocators.ERROR_IVALID_CREDENTIAL)).getText();
        if (!actualErrorMsg.equals(expectedErrorMsg)) {
            throw new AssertionError("Expected error message: '" + expectedErrorMsg + "' but got: '" + actualErrorMsg + "'");
        }
    }
}
