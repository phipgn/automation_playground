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
    private ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    private ThreadLocal<InventoryPage> _inventoryPage = new ThreadLocal<>();
    private ThreadLocal<CartPage> _cartPage = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        WebDriver driver = setUpDriverAndLogin();
        _driver.set(driver);
        _inventoryPage.set(new InventoryPage(driver));
        _cartPage.set(new CartPage(driver));
    }

    @Test
    public void test_VerifyUIElements() {
        InventoryPage inventoryPage = _inventoryPage.get();
        inventoryPage.clickShoppingCart();

        CartPage cartPage = _cartPage.get();
        Assert.assertTrue(cartPage.getPageTitle().isDisplayed());
        Assert.assertTrue(cartPage.getContinueShoppingBtn().isDisplayed());
        Assert.assertTrue(cartPage.getCheckoutBtn().isDisplayed());
    }

    @Test
    public void test_ShowCorrectSelectedItems() {
        List<String> productItemsName = new ArrayList<>();

        InventoryPage inventoryPage = _inventoryPage.get();
        productItemsName.add(inventoryPage.addProductToCart(0));
        productItemsName.add(inventoryPage.addProductToCart(2));
        inventoryPage.clickShoppingCart();

        CartPage cartPage = _cartPage.get();        
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
        InventoryPage inventoryPage = _inventoryPage.get();
        inventoryPage.clickShoppingCart();

        CartPage cartPage = _cartPage.get();
        cartPage.clickContinueShoppingBtn();
        Assert.assertTrue(inventoryPage.pageHeader().isDisplayed());
    }

    @Test
    public void test_clickCheckoutBtn() {
        InventoryPage inventoryPage = _inventoryPage.get();
        inventoryPage.clickShoppingCart();

        CartPage cartPage = _cartPage.get();
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        Assert.assertTrue(checkoutPage.getPageTitle().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        _driver.get().quit();
        _driver.remove();
        _inventoryPage.remove();
        _cartPage.remove();
    }

}
