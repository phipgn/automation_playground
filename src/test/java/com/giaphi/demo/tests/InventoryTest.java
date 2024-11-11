package com.giaphi.demo.tests;

import com.giaphi.demo.pages.InventoryItemPage;
import com.giaphi.demo.pages.InventoryPage;
import com.giaphi.demo.pages.LoginPage;
import com.giaphi.demo.pages.ProductItem;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
    private InventoryPage inventoryPage;
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver = setUpDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void test_verifyUIElements() {
        Assert.assertTrue(inventoryPage.pageHeader().isDisplayed());
        Assert.assertTrue(inventoryPage.getCartLink().isDisplayed());
        Assert.assertTrue(inventoryPage.getSortProduct().isDisplayed());
        Assert.assertTrue(inventoryPage.getBurgerButton().isDisplayed());
        Assert.assertTrue(inventoryPage.getFooter().isDisplayed());
    }

    @Test
    public void test_clickOnProductItemSuccessfully() {
        int itemIndex = 3;
        
        List<ProductItem> items = inventoryPage.getProductItems();
        ProductItem productItem = items.get(itemIndex);

        String expectedTitle = productItem.getTitle();
        String expectedDesc = productItem.getDescription();
        String expectedPrice = productItem.getPrice();

        InventoryItemPage inventoryItemPage = productItem.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item.html"), "Did not navigate to the item detail page.");

        String actualTitle = inventoryItemPage.getTitle();
        String actualDesc = inventoryItemPage.getDescription();
        String actualPrice = inventoryItemPage.getPrice();
        
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualDesc, expectedDesc);
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
