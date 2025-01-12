package com.giaphi.demo.tests;

import com.giaphi.demo.pages.InventoryPage;
import com.giaphi.demo.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    private ThreadLocal<LoginPage> _loginPage = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        WebDriver driver = setUpDriver();
        _driver.set(driver);
        _loginPage.set(new LoginPage(driver));
    }

    @Test
    public void test_verifyUiElements() {
        LoginPage loginPage = _loginPage.get();

        Assert.assertTrue(loginPage.getHeader().isDisplayed());
        Assert.assertTrue(loginPage.getUsernameInput().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordInput().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test
    public void testLogin_CorrectUsername_CorrectPassword() {
        LoginPage loginPage = _loginPage.get();

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickSignInBtn();
        Assert.assertTrue(inventoryPage.isLoadedSuccessfully());
    }

    @Test
    public void testLogin_CorrectUsername_IncorrectPassword() {
        LoginPage loginPage = _loginPage.get();

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void testLogin_IncorrectUsername_CorrectPassword() {
        LoginPage loginPage = _loginPage.get();

        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickSignInBtn();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void testLogin_IncorrectUsername_IncorrectPassword() {
        LoginPage loginPage = _loginPage.get();

        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        _driver.get().quit();
        _driver.remove();
        _loginPage.remove();
    }
}
