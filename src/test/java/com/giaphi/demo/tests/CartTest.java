package com.giaphi.demo.tests;

import com.giaphi.demo.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTest extends BaseTest {
    private CartPage cartPage;
    private List<String> productItemsName = new ArrayList<>();
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver = setUpDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = loginPage.login("standard_user", "secret_sauce");
        productItemsName.add(inventoryPage.addProductToCart(0));
        productItemsName.add(inventoryPage.addProductToCart(2));
        cartPage = inventoryPage.clickShoppingCart();
    }
    @Test
    public void test_VerifyUIElements() {
        Assert.assertTrue(cartPage.getPageTitle().isDisplayed());
        Assert.assertTrue(cartPage.getContinueShoppingBtn().isDisplayed());
        Assert.assertTrue(cartPage.getCheckoutBtn().isDisplayed());
    }

    @Test
    public void test_ShowCorrectSelectedItems() {
        List<WebElement> itemsName = cartPage.getItemsName();
        Assert.assertEquals(productItemsName.size(), itemsName.size());
        for (int i = 0; i < itemsName.size(); i++) {
            Assert.assertEquals(productItemsName.get(i), itemsName.get(i).getText());
        }
    }

    @Test
    public void test_clickContinueShoppingBtn() {
        InventoryPage inventoryPage = cartPage.clickContinueShoppingBtn();
        Assert.assertTrue(inventoryPage.pageHeader().isDisplayed());
    }

    @Test
    public void test_clickCheckoutBtn() {
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        Assert.assertTrue(checkoutPage.getPageTitle().isDisplayed());
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }

}
