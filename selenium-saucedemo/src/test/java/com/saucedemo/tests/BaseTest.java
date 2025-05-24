package com.saucedemo.tests;

import com.saucedemo.helpers.ConfigHelper;
import com.saucedemo.helpers.DriverHelper;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    
    public BaseTest() { }

    @BeforeMethod
    protected void setUp() {
        _driver.set(this.setUpDriver());
    }

    @AfterMethod
    protected void tearDown() {
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
        var sessionCookie = new Cookie.Builder("session-username", config.getUsername())
            .domain("www.saucedemo.com")
            .path("/")
            .isHttpOnly(false)
            .isSecure(false)
            .build();
        getDriver().manage().addCookie(sessionCookie);
        getDriver().navigate().to(config.getBaseUrl() + "inventory.html");
    }
}
