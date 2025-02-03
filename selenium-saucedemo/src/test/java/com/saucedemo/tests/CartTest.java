package com.saucedemo.tests;

import com.saucedemo.listeners.TestListener;
import com.saucedemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {
    ThreadLocal<InventoryPage> _inventoryPage = new ThreadLocal<>();
    ThreadLocal<CartPage> _cartPage = new ThreadLocal<>();

    @BeforeMethod
    void setUpTest() {
        login();
        _inventoryPage.set(new InventoryPage(getDriver()));
        _cartPage.set(new CartPage(getDriver()));
    }

    @AfterMethod
    public void tearDownTest() {
        _inventoryPage.remove();
        _cartPage.remove();
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

}
