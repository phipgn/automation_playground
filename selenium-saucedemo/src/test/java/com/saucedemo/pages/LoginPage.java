package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    // Actions
    public void inputUsername(String username) {
        inputText(getElement(byUsernameInput), username);
    }

    public void inputPassword(String password) {
        inputText(getElement(byPasswordInput), password);
    }

    public InventoryPage clickSignInBtn() {
        getElement(bySignInButton).click();
        return new InventoryPage(driver);
    }

    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickSignInBtn();
    }

    public String getErrorMessage() {
        try {
            var err = getElement(byErrorMessage);
            return err.getText();
        } catch (Exception ex) {
            return "";
        }
    }
}
