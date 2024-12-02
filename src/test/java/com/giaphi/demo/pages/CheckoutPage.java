package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver _driver) {
        super(_driver);
    }

    //Locators
    By byPageTitle = By.cssSelector("span[data-test='title']");

    //Elements
    public WebElement getPageTitle() {
        return getElement(byPageTitle);
    }
}
