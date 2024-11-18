package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byPageHeader = By.xpath("//span[text()='Products']");
    By byCartLink = By.cssSelector("#shopping_cart_container a");
    By bySortContainer = By.cssSelector("select[data-test='product-sort-container']");
    By byBurgerButton = By.className("bm-burger-button");
    By byFooter = By.className("footer");

    // Elements
    public WebElement pageHeader() { return getElement(byPageHeader); }
    public WebElement getCartLink() { return getElement(byCartLink); }
    public WebElement getSortProduct() { return getElement(bySortContainer); }
    public WebElement getBurgerButton() { return getElement(byBurgerButton); }
    public WebElement getFooter() { return getElement(byFooter); }

    public List<ProductItem> getProductItems() {
        List<ProductItem> items = new ArrayList<>();
        
        List<WebElement> elements = getElements(By.className("inventory_item"));
        if (elements.isEmpty()) {
            return items;
        }

        for (int i = 0; i < elements.size(); i++) {
            ProductItem item = new ProductItem(driver, i);
            items.add(item);
        }

        return items;
    }

    // Actions
    public boolean isLoadedSuccessfully() {
        return pageHeader().isDisplayed();
    }

    public int getCartItemsCount() {
        String count = getCartLink().getText();
        if ("".equals(count)) {
            return 0;
        }
        return Integer.parseInt(count);
    }
}