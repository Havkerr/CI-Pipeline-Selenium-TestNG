package com.portfolio.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage class represents the login screen of the target application.
 * It provides locators and actions for logging in.
 */
public class LoginPage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/login";

    // Locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the login page.
     */
    public LoginPage navigateTo() {
        driver.get(URL);
        return this;
    }

    /**
     * Performs standard login with credentials.
     */
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    /**
     * Returns the flash message text displayed on the page.
     */
    public String getFlashMessageText() {
        return getText(flashMessage);
    }
}
