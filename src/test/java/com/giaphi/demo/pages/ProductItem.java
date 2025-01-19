package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductItem extends BasePage {
    By byTitle;
    By byDesc;
    By byPrice;
    By byImage;
    By byAddCartBtn;
    By byRemoveBtn;

    public ProductItem(WebDriver _driver, int index) {
        super(_driver);
        index++;
        byTitle = By.xpath("//div[@class='inventory_item'][" + index + "]//div[@class='inventory_item_name ']");
        byDesc = By.xpath("//div[@class='inventory_item'][" + index + "]//div[@class='inventory_item_desc']");
        byPrice = By.xpath("//div[@class='inventory_item'][" + index + "]//div[@class='inventory_item_price']");
        byImage = By.xpath("//div[@class='inventory_item'][" + index + "]//img[@class='inventory_item_img']");
        byAddCartBtn = By.xpath(String.format("//div[@class='inventory_item'][%d]//button[text()='Add to cart']", index));
        byRemoveBtn = By.xpath(String.format("//div[@class='inventory_item'][%d]//button[text()='Remove']", index));
    }

    // Actions
    public String getTitle() {
        WebElement title = getElement(byTitle);
        return title.getText();
    }

    public String getDescription() {
        WebElement title = getElement(byDesc);
        return title.getText();
    }

    public double getPrice() {
        WebElement element = getElement(byPrice);
        String priceStr = element.getText();
        Double price = Double.parseDouble(priceStr.substring(1));
        return price;
    }

    public String getImage() {
        WebElement title = getElement(byImage);
        return title.getDomAttribute("src");
    }

    public InventoryItemPage click() { // click on title item
        getElement(byTitle).click();
        return new InventoryItemPage(driver);
    }

    public InventoryItemPage clickImage() { // click on image item
        getElement(byImage).click();
        return new InventoryItemPage(driver);
    }

    public void clickAddToCartBtn() {
        getElement(byAddCartBtn).click();
    }

    public void clickRemoveBtn() {
        getElement(byRemoveBtn).click();
    }
}