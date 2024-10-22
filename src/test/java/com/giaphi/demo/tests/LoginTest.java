package com.giaphi.demo.tests;

import com.giaphi.demo.pages.InventoryPage;
import com.giaphi.demo.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver = setUpDriver();
        loginPage = new LoginPage(driver); // object initialization
    }

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return new Object[][] {
            { "standard_user", "secret_sauce" },
            { "visual_user", "secret_sauce" },
            { "error_user", "secret_sauce" }
        };
    }

    @Test(dataProvider = "loginData") // annotation
    public void testLogin(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        InventoryPage inventoryPage = loginPage.clickSignInBtn();
        Assert.assertTrue(inventoryPage.isLoadedSuccessfully());
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
