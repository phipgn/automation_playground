package com.saucedemo.tests.functional;

import com.saucedemo.helpers.CsvHelper;
import com.saucedemo.listeners.TestListener;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.tests.BaseTest;

import java.io.IOException;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    private ThreadLocal<LoginPage> _loginPage = new ThreadLocal<>();

    @BeforeMethod
    void beforeMethod() {
        _loginPage.set(new LoginPage(getDriver()));
    }

    @AfterMethod
    void afterMethod() {
        _loginPage.remove();
    }

    @DataProvider(name="loginData")
    public Iterator<Object[]> loginData() throws IOException {
        return CsvHelper.readCsv(System.getProperty("user.dir") + "/src/test/java/com/saucedemo/data/login.csv");
    }

    @Test(dataProvider = "loginData")
    void testLogin_CorrectUsername_CorrectPassword(String username, String password) {
        var loginPage = _loginPage.get();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        var inventoryPage = loginPage.clickSignInBtn();
        Assert.assertTrue(inventoryPage.isLoadedSuccessfully());
    }

    @Test
    void testLogin_CorrectUsername_IncorrectPassword() {
        var loginPage = _loginPage.get();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(!loginPage.getErrorMessage().isEmpty());
    }

    @Test
    void testLogin_IncorrectUsername_CorrectPassword() {
        var loginPage = _loginPage.get();
        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickSignInBtn();
        Assert.assertTrue(!loginPage.getErrorMessage().isEmpty());
    }

    @Test
    void testLogin_IncorrectUsername_IncorrectPassword() {
        var loginPage = _loginPage.get();
        loginPage.inputUsername("standard_user1");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickSignInBtn();
        Assert.assertTrue(!loginPage.getErrorMessage().isEmpty());
    }
}
