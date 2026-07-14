package com.portfolio.qa.tests;

import com.portfolio.qa.pages.LoginPage;
import com.portfolio.qa.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify login is successful with valid credentials")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();

        // Perform login
        loginPage.login("tomsmith", "SuperSecretPassword!");

        // Verify flash message
        String flashMsg = loginPage.getFlashMessageText();
        Assert.assertTrue(flashMsg.contains("You logged into a secure area!"),
                "Flash message does not indicate a successful login. Actual: " + flashMsg);

        // Verify secure area content
        SecureAreaPage securePage = new SecureAreaPage(driver);
        String subHeader = securePage.getSubHeader();
        Assert.assertTrue(subHeader.contains("Welcome to the Secure Area"),
                "Secure area sub-header is incorrect. Actual: " + subHeader);
    }

    @Test(description = "Verify login fails with invalid credentials")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();

        // Perform login with bad credentials
        loginPage.login("invalidUser", "invalidPassword");

        // Verify failure flash message
        String flashMsg = loginPage.getFlashMessageText();
        Assert.assertTrue(flashMsg.contains("Your username is invalid!"),
                "Flash message does not indicate invalid username. Actual: " + flashMsg);
    }
}
