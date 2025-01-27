package com.saucedemo.tests;

import com.saucedemo.helpers.ConfigHelper;
import com.saucedemo.helpers.DriverHelper;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    public BaseTest() { }

    @BeforeMethod
    void setUp() {
        _driver.set(this.setUpDriver());
    }

    @AfterMethod
    void tearDown() {
        _driver.get().quit();
        _driver.remove();
    }

    public WebDriver getDriver() {
        return _driver.get();
    }

    private WebDriver setUpDriver() {
        var config = ConfigHelper.getConfig();
        var driver = DriverHelper.getDriver(config.getHeadless());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitTimeout()));
        driver.manage().window().maximize();
        driver.get(config.getBaseUrl());
        return driver;
    }

    protected void login() {
        var config = ConfigHelper.getConfig();
        var loginPage = new LoginPage(getDriver());
        loginPage.login(config.getUsername(), config.getPassword());
    }
}
