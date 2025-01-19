package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byPageTitle = By.cssSelector("span[data-test='title']");
    By byContinueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    By byCheckoutBtn = By.xpath("//button[text()='Checkout']");
    By byItemName = By.cssSelector("[data-test='inventory-item-name']");

    // Actions
    public List<String> getItemNames() {
        var itemNames = getElements(byItemName);
        var names = new ArrayList<String>();
        for (WebElement itemName : itemNames) {
            names.add(itemName.getText());
        }
        return names;
    }

    public InventoryPage clickContinueShoppingBtn() {
        click(getElement(byContinueShoppingBtn));
        return new InventoryPage(driver);
    }

    public CheckoutPage clickCheckoutBtn() {
        click(getElement(byCheckoutBtn));
        return new CheckoutPage(driver);
    }

}
