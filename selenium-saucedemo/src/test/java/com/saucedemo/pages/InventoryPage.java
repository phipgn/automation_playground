package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    By byShoppingCart = By.id("shopping_cart_container");
    By bySortDropdown = By.cssSelector("select[data-test='product-sort-container']");

    // Actions    
    public List<ProductItem> getProductItems() {
        var items = new ArrayList<ProductItem>();        
        var elements = getElements(By.className("inventory_item"));
        if (elements.isEmpty()) {
            return items;
        }
        for (int i = 0; i < elements.size(); i++) {
            ProductItem item = new ProductItem(driver, i);
            items.add(item);
        }
        return items;
    }

    public boolean isLoadedSuccessfully() {
        return getElement(byPageHeader).isDisplayed();
    }

    public int getCartItemsCount() {
        var count = getElement(byCartLink).getText();
        if ("".equals(count)) {
            return 0;
        }
        return Integer.parseInt(count);
    }

    public String addProductToCart(int index) {
        ProductItem productItem = this.getProductItems().get(index);
        productItem.clickAddToCartBtn();
        return productItem.getTitle();
    }

    public CartPage clickShoppingCart(){
        getElement(byShoppingCart).click();
        return new CartPage(driver);
    }

    public void sortProductsByPrice_LowToHigh() {
        selectDropdownOption(bySortDropdown, "lohi");
    }
}
