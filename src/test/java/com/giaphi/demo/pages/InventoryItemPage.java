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
    By byItemImage = By.xpath("//img[@class='inventory_details_img']");
    By byAddToCartBtn = By.xpath("//button[text()='Add to cart']");
    By byRemoveBtn = By.xpath("//button[text()='Remove']");
    By byCartBadge = By.cssSelector("span[data-test='shopping-cart-badge']");
    By byCartEmpty = By.cssSelector("a[data-test='shopping-cart-link']");


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

    public String getItemImage() { return getElement(byItemImage).getAttribute("src"); }

    public WebElement getAddToCartBtn() { return getElement(byAddToCartBtn); }

    public WebElement getRemoveBtn() { return getElement(byRemoveBtn); }


    // Actions
    public void clickAddToCartBtn() {
        getElement(byAddToCartBtn).click();
    }

    public void clickRemoveBtn() {
        getElement(byRemoveBtn).click();
    }

    public boolean isAddToCartBtnDisplayed() {
        return isElementDisplayed(byAddToCartBtn);
    }
    
}

