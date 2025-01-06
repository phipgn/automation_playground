package com.giaphi.demo.tests;

import com.giaphi.demo.pages.InventoryPage;
import com.giaphi.demo.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver = setUpDriver();
        loginPage = new LoginPage(driver); // object initialization
    }

//    @DataProvider(name = "loginData")
//    public static Object[][] getLoginData() {
//        return new Object[][] {
//            { "standard_user", "secret_sauce" },
//            { "visual_user", "secret_sauce" },
//            { "error_user", "secret_sauce" }
//        };
//    }

//    @Test(dataProvider = "loginData") // annotation
//    public void testLogin(String username, String password) {
//        loginPage.inputUsername(username);
//        loginPage.inputPassword(password);
//        InventoryPage inventoryPage = loginPage.clickSignInBtn();
//        Assert.assertTrue(inventoryPage.isLoadedSuccessfully());
//    }

    @Test
    public void test_verifyUiElements() {
        Assert.assertTrue(loginPage.getHeader().isDisplayed());
        Assert.assertTrue(loginPage.getUsernameInput().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordInput().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test
    public void testLogin_CorrectUsername_CorrectPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        InventoryPage inventoryPage = loginPage.clickSignInBtn();
        Assert.assertTrue(inventoryPage.isLoadedSuccessfully());
    }

    @Test
    public void testLogin_CorrectUsername_IncorrectPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void testLogin_IncorrectUsername_CorrectPassword() {
        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickSignInBtn();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void testLogin_IncorrectUsername_IncorrectPassword() {
        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
