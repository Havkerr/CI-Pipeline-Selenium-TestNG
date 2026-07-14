package com.portfolio.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * SecureAreaPage class represents the page loaded upon successful login.
 */
public class SecureAreaPage extends BasePage {
    // Locators
    private final By subHeader = By.className("subheader");
    private final By logoutButton = By.cssSelector("a[href='/logout']");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves the subheader text.
     */
    public String getSubHeader() {
        return getText(subHeader);
    }

    /**
     * Performs logout action.
     */
    public void logout() {
        click(logoutButton);
    }
}
