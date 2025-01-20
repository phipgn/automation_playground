package com.saucedemo.tests;

import com.saucedemo.helpers.DriverHelper;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    private final String BASE_URL = "https://www.saucedemo.com/";
    private final String CORRECT_USERNAME = "standard_user";
    private final String CORRECT_PASSWORD = "secret_sauce";

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
        var driver = DriverHelper.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return driver;
    }

    protected void login() {
        var loginPage = new LoginPage(getDriver());
        loginPage.login(CORRECT_USERNAME, CORRECT_PASSWORD);
    }
}
