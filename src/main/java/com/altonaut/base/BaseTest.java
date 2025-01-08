package com.altonaut.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import com.altonaut.modules.login.pageActions.LoginPageActions;
import com.altonaut.modules.login.assertions.LoginAssertions;
import com.altonaut.config.Config;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPageActions loginPageActions;
    protected LoginAssertions loginAssertions;

    public void setUp() throws IOException {
        // Fetch browser type and base URL from Config
        String browser = Config.BROWSER;
        String baseUrl = Config.BASE_URL;

        // Set up the driver based on the browser specified in the Config class
        driver = initializeDriver(browser);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        loginPageActions = new LoginPageActions();
        loginAssertions = new LoginAssertions();
    }

    private WebDriver initializeDriver(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            return new ChromeDriver(options);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            return new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}