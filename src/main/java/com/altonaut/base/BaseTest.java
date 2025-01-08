package com.altonaut.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import com.altonaut.config.Config;
import com.altonaut.db.DBConnection;
import org.json.JSONObject;
import java.sql.SQLException;

public class BaseTest {
    protected WebDriver driver;
    protected JSONObject testData;
    protected JSONObject account;
    protected JSONObject expectedResult;
    protected LoginPageActions loginPageActions;
    protected LoginAssertions loginAssertions;

    public void setUp(String testCaseId) throws IOException, SQLException {
        // Fetch browser type and base URL from Config
        String browser = Config.BROWSER;
        String baseUrl = Config.BASE_URL_PRODUCTION;

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

        driver.manage().window().maximize();
        driver.get(baseUrl);

        JSONObject data = DBConnection.getTestData(testCaseId);
        if (data != null) {
            testData = data.getJSONObject("test_data");
            account = data.getJSONObject("account");
            expectedResult = data.getJSONObject("expected_result_data");
        }

        loginPageActions = new LoginPageActions();
        loginAssertions = new LoginAssertions();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String getTestDataValue(String key) {
        return testData != null ? testData.optString(key) : null;
    }

    public String getAccountValue(String key) {
        return account != null ? account.optString(key) : null;
    }

    public String getExpectedResultValue(String key) {
        return expectedResult != null ? expectedResult.optString(key) : null;
    }
}
