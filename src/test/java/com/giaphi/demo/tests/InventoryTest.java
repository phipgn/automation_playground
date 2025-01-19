package com.giaphi.demo.tests;

import com.giaphi.demo.pages.InventoryPage;
import com.giaphi.demo.pages.ProductItem;

import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
    ThreadLocal<InventoryPage> _inventoryPage = new ThreadLocal<>();
    ThreadLocal<WebDriver> _driver = new ThreadLocal<>();

    @BeforeMethod
    void setUp() {
        _driver.set(setUpDriverAndLogin());
        _inventoryPage.set(new InventoryPage(_driver.get()));
    }

    @Test
    void test_clickOnProductItemSuccessfully() {
        var inventoryPage = _inventoryPage.get();
        var itemIndex = 3;
        
        var items = inventoryPage.getProductItems();
        var productItem = items.get(itemIndex);

        var expectedTitle = productItem.getTitle();
        var expectedDesc = productItem.getDescription();
        var expectedPrice = productItem.getPrice();
        var expectedImage = productItem.getImage();

        // click on image item to open inventory item page
        var inventoryItemPage = productItem.clickImage();

        var actualTitle = inventoryItemPage.getTitle();
        var actualDesc = inventoryItemPage.getDescription();
        var actualPrice = inventoryItemPage.getPrice();
        var actualImage = inventoryItemPage.getItemImage();

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualDesc, expectedDesc);
        Assert.assertEquals(actualPrice, expectedPrice);
        Assert.assertTrue(actualImage.contains(expectedImage));
    }

    @Test
    void test_clickOnAddToCartOnProductItem_001() {
        var inventoryPage = _inventoryPage.get();
        Assert.assertEquals(0, inventoryPage.getCartItemsCount());
        
        var items = inventoryPage.getProductItems();
        var productItem_2 = items.get(2);
        productItem_2.clickAddToCartBtn();
        Assert.assertEquals(1, inventoryPage.getCartItemsCount());

        var productItem_4 = items.get(4);
        productItem_4.clickAddToCartBtn();
        Assert.assertEquals(2, inventoryPage.getCartItemsCount());
    
        productItem_2.clickRemoveBtn();
        Assert.assertEquals(1, inventoryPage.getCartItemsCount());

        productItem_4.clickRemoveBtn();
        Assert.assertEquals(0, inventoryPage.getCartItemsCount());
    }

    @Test
    void test_clickOnAddToCartOnProductItem_002() {
        var inventoryPage = _inventoryPage.get();
        Assert.assertEquals(0, inventoryPage.getCartItemsCount());
        var items = inventoryPage.getProductItems();

        var count = 0;
        for (ProductItem item : items) {
            item.clickAddToCartBtn();
            count++;
            Assert.assertEquals(count, inventoryPage.getCartItemsCount());
        }

        for(ProductItem item : items) {
            item.clickRemoveBtn();
            count--;
            Assert.assertEquals(count, inventoryPage.getCartItemsCount());
        }

        Assert.assertEquals(0, inventoryPage.getCartItemsCount());
    }

    @Test
    void test_clickOnAddToCartAndClickOnTitleItem() {
        var inventoryPage = _inventoryPage.get();
        var itemIndex = 1;

        var items = inventoryPage.getProductItems();
        var productItem = items.get(itemIndex);
        productItem.clickAddToCartBtn();

        var inventoryItemPage = productItem.click();
        Assert.assertTrue(inventoryItemPage.getRemoveBtn().isDisplayed());
        Assert.assertFalse(inventoryItemPage.isAddToCartBtnDisplayed());
    }

    @Test
    void test_sortPrice_LowToHigh() {
        var inventoryPage = _inventoryPage.get();
        var productItems = inventoryPage.getProductItems();
        var expectedPrices = new ArrayList<>(productItems.stream().map(ProductItem::getPrice).toList());

        inventoryPage.sortProductsByPrice_LowToHigh();
        var actualPrices = productItems.stream().map(ProductItem::getPrice).toList();
        
        Assert.assertFalse(expectedPrices.equals(actualPrices));
        Collections.sort(expectedPrices);
        Assert.assertTrue(expectedPrices.equals(actualPrices));
    }

    @AfterMethod
    void tearDown() {
        _driver.get().quit();
        _driver.remove();
        _inventoryPage.remove();
    }
}
