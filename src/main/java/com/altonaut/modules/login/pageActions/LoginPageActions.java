package com.altonaut.modules.login.pageActions;

import org.openqa.selenium.WebDriver;
import com.altonaut.modules.login.actions.LoginActions;

import com.altonaut.config.Config;

public class LoginPageActions {

    /**
     * Perform login by entering username, password, and clicking the login button.
     *
     * @param driver WebDriver instance
     * @param username Username to be entered
     * @param password Password to be entered
     */
    public void performLogin(WebDriver driver, String username, String password) {
        try {
            // Enter username
            LoginActions.fillUsername(driver, username);
            Thread.sleep(Config.SHORT_DELAY_MS); // Delay for 1 second to wait for UI response
    
            // Enter password
            LoginActions.fillPassword(driver, password);
            Thread.sleep(Config.SHORT_DELAY_MS); // Delay for 1 second to wait for UI response
    
            // Click login button
            LoginActions.clickLoginButton(driver);
            Thread.sleep(Config.MEDIUM_DELAY_MS); // Delay for 15 seconds to allow the page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
