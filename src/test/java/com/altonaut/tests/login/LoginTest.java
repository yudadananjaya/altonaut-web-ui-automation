package com.altonaut.tests.login;

import com.altonaut.base.BaseTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUpTest() throws IOException {
        setUp();
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
