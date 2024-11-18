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
        String expectedImage = productItem.getImage();

        // click on title item to open inventory item page
        //InventoryItemPage inventoryItemPage = productItem.click();

        // click on image item to open inventory item page
        InventoryItemPage inventoryItemPage = productItem.clickImage();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item.html"), "Did not navigate to the item detail page.");

        String actualTitle = inventoryItemPage.getTitle();
        String actualDesc = inventoryItemPage.getDescription();
        String actualPrice = inventoryItemPage.getPrice();
        String actualImage = inventoryItemPage.getItemImage();

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualDesc, expectedDesc);
        Assert.assertEquals(actualPrice, expectedPrice);
        Assert.assertEquals(actualImage, expectedImage);
    }

    @Test
    public void test_clickOnAddToCartOnProductItem(){ // On Product Item page: click on Add to Card and click on Remove
        int itemIndex = 2;

        List<ProductItem> items = inventoryPage.getProductItems();
        ProductItem productItem = items.get(itemIndex);
        String cartBadge = productItem.clickOnAddToCartBtn(); // click on Add to cart and get cart badge

        String removeText = productItem.getRemoveText();
        Assert.assertFalse(cartBadge.isEmpty());
        Assert.assertEquals(cartBadge,"1");
        Assert.assertEquals(removeText,"Remove");

        String unClickOnRemoveBtn = productItem.unClickRemoveBtn(); // click on Remove button
        Assert.assertEquals(unClickOnRemoveBtn,"Add to cart");
        Assert.assertFalse(productItem.isCartBadgeDisplayed());
    }

    @Test
    public void test_clickOnAddToCartAndClickOnTitleItem(){
        int itemIndex = 1;

        List<ProductItem> items = inventoryPage.getProductItems();
        ProductItem productItem = items.get(itemIndex);
        String cartBadgeText = productItem.clickOnAddToCartBtn();

        InventoryItemPage inventoryItemPage = productItem.click();

        String removeText = inventoryItemPage.getRemoveTxt(); // get Remove button on inventory item detail page
        Assert.assertEquals(removeText,"Remove"); //Assert item is still added on inventory item detail page
    }
    @Test
    public void test_clickOnAddToCartOnInventoryItemDetailPage(){
        int itemIndex = 1;
        List<ProductItem> items = inventoryPage.getProductItems();
        ProductItem productItem = items.get(itemIndex);
        InventoryItemPage inventoryItemPage = productItem.click();
        inventoryItemPage.clickOnAddToCart();
        String removeTxt = inventoryItemPage.getRemoveTxt();
        String cartBadge = inventoryItemPage.getCartBadge();
        Assert.assertEquals(removeTxt,"Remove");
        Assert.assertEquals(cartBadge,"1");
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
