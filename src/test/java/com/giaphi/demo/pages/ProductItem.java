package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductItem extends BasePage {
    By byTitle;
    By byDesc;
    By byPrice;

    public ProductItem(WebDriver _driver, int index) {
        super(_driver);
        index++;
        byTitle = By.xpath("//div[@class='inventory_item'][" + index +"]//div[@class='inventory_item_name ']");
        byDesc = By.xpath("//div[@class='inventory_item'][" + index + "]//div[@class='inventory_item_desc']");
        byPrice = By.xpath("//div[@class='inventory_item'][" + index + "]//div[@class='inventory_item_price']");
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

    // Actions
    public InventoryItemPage click() {
        getElement(byTitle).click();
        return new InventoryItemPage(driver);
    }
}
