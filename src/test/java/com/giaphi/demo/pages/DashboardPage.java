package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byPageHeader = By.xpath("//h2[text()='Dashboard']");

    // Elements
    public WebElement pageHeader() { return getElement(byPageHeader); }
}
