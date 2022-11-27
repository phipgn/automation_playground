package com.giaphi.demo.tests;

import com.giaphi.demo.pages.InventoryPage;
import com.giaphi.demo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final LoginPage loginPage;

    public LoginTest() {
        super();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.signInButton().click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.pageHeader().isDisplayed());
    }
}
