package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemPage extends BasePage {
    public InventoryItemPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byItemDescription = By.className("inventory_details_desc");
    By byItemImage = By.cssSelector("img.inventory_details_img");

    //
    public WebElement getItemDesc() { return getElement(byItemDescription); }
    public WebElement getItemImage() { return getElement(byItemImage); }
}

