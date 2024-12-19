package com.altonaut.modules.login.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.altonaut.function.altonautWeb; // Import altonautWeb global function
import com.altonaut.modules.login.locators.LoginLocators;

public class LoginActions {

    public static void fillUsername(WebDriver driver, String username) {
        altonautWeb.waitForElementVisible(driver, By.xpath(LoginLocators.USERNAME_FIELD));
        WebElement usernameField = driver.findElement(By.xpath(LoginLocators.USERNAME_FIELD));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public static void fillPassword(WebDriver driver, String password) {
        altonautWeb.waitForElementVisible(driver, By.xpath(LoginLocators.PASSWORD_FIELD));
        WebElement passwordField = driver.findElement(By.xpath(LoginLocators.PASSWORD_FIELD));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) {
        altonautWeb.waitForElementVisible(driver, By.xpath(LoginLocators.LOGIN_BUTTON));
        WebElement loginButton = driver.findElement(By.xpath(LoginLocators.LOGIN_BUTTON));
        loginButton.click();
    }
}
