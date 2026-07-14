package com.portfolio.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage class acts as the base class for all Page Objects in the POM architecture.
 * It encapsulates common web driver interactions and explicit waits to ensure stability.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    /**
     * Wait for an element to be visible and find it.
     */
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Click on an element after waiting for it to be clickable.
     */
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Enter text into a text field after clearing it.
     */
    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get the visible text of an element.
     */
    protected String getText(By locator) {
        return find(locator).getText();
    }

    /**
     * Wait for an element to be present in the DOM.
     */
    protected void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
