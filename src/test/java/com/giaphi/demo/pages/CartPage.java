package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byPageTitle = By.cssSelector("span[data-test='title']");
    By byContinueShoppingBtn = By.cssSelector("button[data-test='continue-shopping']");
    By byCheckoutBtn = By.cssSelector("button[data-test='checkout']");
    By byItemName = By.cssSelector("[data-test='inventory-item-name']");

    // Elements
    public WebElement getPageTitle() {
        return getElement(byPageTitle);
    }

    public WebElement getContinueShoppingBtn() {
        return getElement(byContinueShoppingBtn);
    }

    public WebElement getCheckoutBtn() {
        return getElement(byCheckoutBtn);
    }

    public List<WebElement> getItemsName() {
        return getElements(byItemName);
    }

    public InventoryPage clickContinueShoppingBtn() {
        getElement(byContinueShoppingBtn).click();
        return new InventoryPage(driver);
    }

    public CheckoutPage clickCheckoutBtn() {
        getElement(byCheckoutBtn).click();
        return new CheckoutPage(driver);
    }

}
