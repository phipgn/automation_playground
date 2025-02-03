package com.saucedemo.tests;

import com.saucedemo.listeners.TestListener;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    private ThreadLocal<LoginPage> _loginPage = new ThreadLocal<>();

    @BeforeMethod
    void beforeMethod() {
        _loginPage.set(new LoginPage(getDriver()));
    }

    @AfterMethod
    void afterMethod() {
        _loginPage.remove();
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
}
