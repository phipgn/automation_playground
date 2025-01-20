package com.saucedemo.tests;

import com.saucedemo.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CartTest extends BaseTest {
    ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    ThreadLocal<InventoryPage> _inventoryPage = new ThreadLocal<>();
    ThreadLocal<CartPage> _cartPage = new ThreadLocal<>();

    @BeforeMethod
    void setUp() {
        var driver = setUpDriverAndLogin();
        _driver.set(driver);
        _inventoryPage.set(new InventoryPage(driver));
        _cartPage.set(new CartPage(driver));
    }

    @Test
    void test_ShowCorrectSelectedItems() {
        var productItemsName = new ArrayList<>();

        var inventoryPage = _inventoryPage.get();
        productItemsName.add(inventoryPage.addProductToCart(0));
        productItemsName.add(inventoryPage.addProductToCart(2));
        inventoryPage.clickShoppingCart();

        var cartPage = _cartPage.get();        
        var itemNames = cartPage.getItemNames();
        Assert.assertEquals(productItemsName.size(), itemNames.size());

        var error = "";
        for (int i = 0; i < itemNames.size(); i++) {
            if (!productItemsName.get(i).equals(itemNames.get(i))) {
                error += "Mismatch found at index=" + i + "\n";
            }
        }
        Assert.assertTrue("".equals(error));
    }

    @Test
    void test_clickContinueShoppingBtn() {
        var inventoryPage = _inventoryPage.get();
        inventoryPage.clickShoppingCart();

        var cartPage = _cartPage.get();
        cartPage.clickContinueShoppingBtn();
        Assert.assertTrue(inventoryPage.isLoadedSuccessfully());
    }

    @Test
    void test_clickCheckoutBtn() {
        var inventoryPage = _inventoryPage.get();
        inventoryPage.clickShoppingCart();

        var cartPage = _cartPage.get();
        var checkoutPage = cartPage.clickCheckoutBtn();
        Assert.assertTrue(!checkoutPage.getPageTitle().isEmpty());
    }

    @AfterMethod
    public void tearDown() {
        _driver.get().quit();
        _driver.remove();
        _inventoryPage.remove();
        _cartPage.remove();
    }

}
