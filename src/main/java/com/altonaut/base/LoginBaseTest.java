package com.altonaut.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import com.altonaut.modules.login.pageActions.LoginPageActions;
import com.altonaut.modules.login.assertions.LoginAssertions;
import com.altonaut.config.Config;

public class LoginBaseTest {
    protected WebDriver driver;
    protected LoginPageActions loginPageActions;
    protected LoginAssertions loginAssertions;

    public void setUp() throws IOException{
        // Fetch browser type and base URL from Config
        String browser = Config.BROWSER;
        String baseUrl = Config.BASE_URL;

        // Set up the driver based on the browser specified in the Config class
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Maximize browser window and navigate to base URL
        driver.manage().window().maximize();
        driver.get(baseUrl);

        loginPageActions = new LoginPageActions();
        loginAssertions = new LoginAssertions();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}