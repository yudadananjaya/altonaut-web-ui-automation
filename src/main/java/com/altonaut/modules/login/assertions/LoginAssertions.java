package com.altonaut.modules.login.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.altonaut.function.altonautWeb; // Import altonautWeb global function
import com.altonaut.modules.login.locators.LoginLocators;

public class LoginAssertions {

    public void assertLoginFailed(WebDriver driver, String expectedErrorMsg) {
        altonautWeb.waitForElementVisible(driver, By.xpath(LoginLocators.ERROR_IVALID_CREDENTIAL));
        String actualErrorMsg = driver.findElement(By.xpath(LoginLocators.ERROR_IVALID_CREDENTIAL)).getText();
        if (!actualErrorMsg.equals(expectedErrorMsg)) {
            throw new AssertionError("Expected error message: '" + expectedErrorMsg + "' but got: '" + actualErrorMsg + "'");
        }
    }
}
