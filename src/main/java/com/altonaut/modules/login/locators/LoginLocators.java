package com.altonaut.modules.login.locators;

public class LoginLocators {

    public static final String USERNAME_FIELD = "//input[@type='text' and @placeholder='User Name' and @data-testid='RNE__Input__text-input']";
    public static final String PASSWORD_FIELD = "//input[@type='password' and @placeholder='Password' and @data-testid='RNE__Input__text-input']";
    public static final String LOGIN_BUTTON = "//button[@type='button' and .//div[contains(text(), 'Login')]]";
    public static final String ERROR_IVALID_CREDENTIAL = "//div[contains(text(), 'The user name and/or password that you have inputted is incorrect')]";
    
}
