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
    void setUp() {
        _driver.set(setUpDriver());
        _loginPage.set(new LoginPage(_driver.get()));
    }

    @Test
    void testLogin_CorrectUsername_CorrectPassword() {
        var loginPage = _loginPage.get();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickSignInBtn();
        Assert.assertTrue(inventoryPage.isLoadedSuccessfully());
    }

    @Test
    void testLogin_CorrectUsername_IncorrectPassword() {
        var loginPage = _loginPage.get();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(!loginPage.getErrorMessage().isEmpty());
    }

    @Test
    void testLogin_IncorrectUsername_CorrectPassword() {
        var loginPage = _loginPage.get();
        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickSignInBtn();
        Assert.assertTrue(!loginPage.getErrorMessage().isEmpty());
    }

    @Test
    void testLogin_IncorrectUsername_IncorrectPassword() {
        var loginPage = _loginPage.get();
        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(!loginPage.getErrorMessage().isEmpty());
    }

    @AfterMethod
    void tearDown() {
        _driver.get().quit();
        _driver.remove();
        _loginPage.remove();
    }
}
