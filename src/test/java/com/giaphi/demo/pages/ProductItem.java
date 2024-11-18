package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductItem extends BasePage {
    By byTitle;
    By byDesc;
    By byPrice;
    By byImage;
    By byAddCartBtn;
    By byRemoveText;
    By byShoppingCartBadge;

    public ProductItem(WebDriver _driver, int index) {
        super(_driver);
        index++;
        byTitle = By.xpath("//div[@class='inventory_item'][" + index +"]//div[@class='inventory_item_name ']");
        byDesc = By.xpath("//div[@class='inventory_item'][" + index + "]//div[@class='inventory_item_desc']");
        byPrice = By.xpath("//div[@class='inventory_item'][" + index + "]//div[@class='inventory_item_price']");
        byImage = By.xpath("//div[@class='inventory_item'][" + index + "]//img[@class='inventory_item_img']");
        byAddCartBtn = By.xpath("//div[@class='inventory_item'][" + index + "]//button[@class='btn btn_primary btn_small btn_inventory ']");
        byRemoveText = By.xpath("//div[@class='inventory_item'][" + index + "]//button[@class='btn btn_secondary btn_small btn_inventory ']");
        byShoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    }

    public String getTitle() {
        WebElement title = getElement(byTitle);
        return title.getText();
    }

    public String getDescription() {
        WebElement title = getElement(byDesc);
        return title.getText();
    }

    public String getPrice() {
        WebElement title = getElement(byPrice);
        return title.getText();
    }
    public String getImage(){
        WebElement title = getElement(byImage);
        return title.getAttribute("src");
    }
    public String getAddToCartBtnText(){
        WebElement title = getElement(byAddCartBtn);
        return title.getText();
    }
    public String getRemoveText(){
        WebElement title = getElement(byRemoveText);
        return title.getText();
    }
    public String getCartBadge(){
        WebElement cartBadge = getElement(byShoppingCartBadge);
        return cartBadge.getText();
    }

    // Actions
    public InventoryItemPage click() { // click on title item
        getElement(byTitle).click();
        return new InventoryItemPage(driver);
    }
    public InventoryItemPage clickImage() { // click on image item
        getElement(byImage).click();
        return new InventoryItemPage(driver);
    }
    public String clickOnAddToCartBtn(){ // click on Add to Cart button
        getElement(byAddCartBtn).click();
        WebElement cartBadge = getElement(byShoppingCartBadge);
        return cartBadge.getText();
    }
    public String unClickRemoveBtn(){
        getElement(byRemoveText).click();
        WebElement unClickRemoveBtn = getElement(byAddCartBtn);
        return unClickRemoveBtn.getText();
    }
    public boolean isCartBadgeDisplayed(){
        try {
            WebElement cartBadge = getElement(byShoppingCartBadge);
            return cartBadge.isDisplayed(); // Returns true if displayed
        } catch (NoSuchElementException e) {
            return false; // If not found, consider it not displayed
        }
    }

}
