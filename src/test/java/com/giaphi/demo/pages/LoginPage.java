package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byUsernameInput = By.id("user-name");
    By byPasswordInput = By.id("password");
    By bySignInButton = By.id("login-button");

    // Elements
    public WebElement usernameInput() { return getElement(byUsernameInput); }
    public WebElement passwordInput() { return getElement(byPasswordInput); }
    public WebElement signInButton() { return getElement(bySignInButton); }

    // Actions
    public void inputUsername(String username) {
        inputText(usernameInput(), username);
    }

    public void inputPassword(String password) {
        inputText(passwordInput(), password);
    }
}
