package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver _driver) { // not a method, a constructor (hàm dựng)
        super(_driver);
    }

    // Locators
    By byUsernameInput = By.id("user-name");
    By byPasswordInput = By.id("password");
    By bySignInButton = By.id("login-button");

    // Elements
    private WebElement usernameInput() { return getElement(byUsernameInput); }
    private WebElement passwordInput() { return getElement(byPasswordInput); }
    private WebElement signInButton() { return getElement(bySignInButton); }

    // Actions
    public void inputUsername(String username) {
        inputText(usernameInput(), username);
    }

    public void inputPassword(String password) {
        inputText(passwordInput(), password);
    }
//    public void clickSignInBtn() {
//        this.signInButton().click();
//    }

    public InventoryPage clickSignInBtn() {
        this.signInButton().click();
        return new InventoryPage(driver);
    }
}
