package com.giaphi.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver _driver) { // not a method, a constructor (hàm dựng)
        super(_driver);
    }

    // Locators: Id, Css Locator, Xpath
    By byHeader = By.className("login_logo");
    By byUsernameInput = By.id("user-name");
    By byPasswordInput = By.id("password");
    By bySignInButton = By.id("login-button");
    By byErrorMessage = By.cssSelector("h3[data-test='error']");

    // Elements
    public WebElement getHeader() {
        return getElement(byHeader);
    }

    public WebElement getUsernameInput() {
        return getElement(byUsernameInput);
    }

    public WebElement getPasswordInput() {
        return getElement(byPasswordInput);
    }

    public WebElement getLoginButton() {
        return getElement(bySignInButton);
    }

    public WebElement getErrorMessage() {
        return getElement(byErrorMessage);
    }

    // Actions
    public void inputUsername(String username) {
        inputText(getUsernameInput(), username);
    }

    public void inputPassword(String password) {
        inputText(getPasswordInput(), password);
    }

    public InventoryPage clickSignInBtn() {
        this.getLoginButton().click();
        return new InventoryPage(driver);
    }

    public InventoryPage login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        return clickSignInBtn();
    }
}
