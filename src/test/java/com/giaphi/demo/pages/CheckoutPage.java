package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver _driver) {
        super(_driver);
    }

    //Locators
    By byPageTitle = By.cssSelector("span[data-test='title']");

    //Elements
    public String getPageTitle() {
        try {
            var title = getElement(byPageTitle);
            return title.getText();
        } catch (Exception ex) {
            return "";
        }
    }
}
