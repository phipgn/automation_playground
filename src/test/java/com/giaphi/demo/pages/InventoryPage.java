package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byPageHeader = By.xpath("//span[text()='Products']");

    // Elements
    public WebElement pageHeader() { return getElement(byPageHeader); }

    public boolean isLoadedSuccessfully() {
        return pageHeader().isDisplayed();
    }
}
