package com.altonaut.tests.login;

import com.altonaut.base.BaseTest;
import com.altonaut.modules.login.assertions.LoginAssertions;
import com.altonaut.modules.login.pageActions.LoginPageActions;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPageActions loginPageActions;
    private LoginAssertions loginAssertions;

    @BeforeMethod
    public void setUpTest() throws IOException {
        setUp();
        loginPageActions = new LoginPageActions();
        loginAssertions = new LoginAssertions();
    }

    @Test
    public void testLogin() {
        loginPageActions.performLogin(driver, "invalid_username", "invalid_pass");
        loginAssertions.assertLoginFailed(driver, "The user name and/or password that you have inputted is incorrect. Please make check and try again.");
        System.out.println("Login test executed successfully.");
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
