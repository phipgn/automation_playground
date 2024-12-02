package com.giaphi.demo.tests;

import com.giaphi.demo.pages.*;
import org.openqa.selenium.WebDriver;
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
        List<String> itemNames = cartPage.getItemNames();
        Assert.assertEquals(productItemsName.size(), itemNames.size());

        String error = "";
        for (int i = 0; i < itemNames.size(); i++) {
            if (!productItemsName.get(i).equals(itemNames.get(i))) {
                error += "Mismatch found at index=" + i + "\n";
            }
        }
        Assert.assertTrue("".equals(error));
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
