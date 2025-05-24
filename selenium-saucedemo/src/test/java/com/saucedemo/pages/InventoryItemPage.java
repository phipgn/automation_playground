package com.saucedemo.pages;

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

    // Elements
    public String getTitle() {
        return getElement(byTitle).getText();
    }

    public String getDescription() {
        return getElement(byDescription).getText();
    }

    public Double getPrice() {
        WebElement element = getElement(byPrice);
        String priceStr = element.getText();
        Double price = Double.parseDouble(priceStr.substring(1));
        return price;
    }

    public String getItemImage() { return getElement(byItemImage).getDomAttribute("src"); }

    public WebElement getRemoveBtn() { return getElement(byRemoveBtn); }

    // Actions
    public boolean isAddToCartBtnDisplayed() {
        return isElementDisplayed(byAddToCartBtn);
    }
    
}

