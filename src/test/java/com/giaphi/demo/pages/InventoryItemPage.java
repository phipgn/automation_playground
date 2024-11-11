package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemPage extends BasePage {
    public InventoryItemPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byTitle = By.cssSelector("[data-test='inventory-item-name']");
    By byDescription = By.cssSelector("[data-test='inventory-item-desc']");
    By byPrice = By.cssSelector("[data-test='inventory-item-price']");
    By byItemImage = By.cssSelector("img.inventory_details_img");

    // Elements
    public String getTitle() {
        return getElement(byTitle).getText();
    }

    public String getDescription() {
        return getElement(byDescription).getText();
    }

    public String getPrice() {
        return getElement(byPrice).getText();
    }

    public WebElement getItemImage() { return getElement(byItemImage); }

    // Actions
    
}

