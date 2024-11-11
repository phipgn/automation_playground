package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byPageHeader = By.xpath("//span[text()='Products']");
    By byCartLink = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    //By bySortContainer = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By bySortContainer = By.cssSelector("select[data-test='product-sort-container']");
    By byInventoryList = By.className("inventory_item_name");
    By byBurgerButton = By.className("bm-burger-button");
    By byFooter = By.className("footer");


    // Elements
    public WebElement pageHeader() { return getElement(byPageHeader); }

    public boolean isLoadedSuccessfully() {
        return pageHeader().isDisplayed();
    }
    public WebElement getCartLink() { return getElement(byCartLink); }
    public WebElement getSortProduct() { return getElement(bySortContainer); }
    public List<WebElement> inventoryList() { return getElements(byInventoryList); }
    public WebElement getBurgerButton() { return getElement(byBurgerButton); }
    public WebElement getFooter() { return getElement(byFooter); }


    // Actions
    public InventoryItemPage clickOnProductItem(int index){
        List<WebElement> productItems = this.getElements(byInventoryList);

        // Ensure the list is not empty and index within product item size
        if (productItems != null && !productItems.isEmpty() && index >= 0 && index < productItems.size()) {
            WebElement productItem = productItems.get(index); // find by add index
            productItem.click();
            return new InventoryItemPage(driver);
        } else {
            throw new NoSuchElementException("No product items found to click.");
        }
    }

}
