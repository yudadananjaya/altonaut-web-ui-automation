package com.altonaut.modules.login.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.altonaut.modules.login.actions.LoginPageActions;
import com.altonaut.modules.login.assertions.LoginAssertions;
import com.altonaut.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void vesselCrewCannotLoginWithInvalidCredential() throws IOException, SQLException {
        String testCaseId = "LVS0001";

        setUp(testCaseId);

        String username = getAccountValue("username");
        String password = getAccountValue("password");
        String expectedErrorMsg = getExpectedResultValue("error_message");

        // Perform login using the test data
        loginPageActions.performLogin(driver, username, password);

        // Perform assertion using the expected error message
        loginAssertions.assertLoginFailed(driver, expectedErrorMsg);

        System.out.println("Test executed successfully for TestCase ID: " + testCaseId);
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
