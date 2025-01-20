package com.saucedemo.tests;

import com.saucedemo.helpers.DriverHelper;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class BaseTest {
    private final String BASE_URL = "https://www.saucedemo.com/";
    private final String CORRECT_USERNAME = "standard_user";
    private final String CORRECT_PASSWORD = "secret_sauce";

    public BaseTest() { }

    protected WebDriver setUpDriver() {
        var driver = DriverHelper.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return driver;
    }

    protected WebDriver setUpDriverAndLogin() {
        var driver = setUpDriver();
        var loginPage = new LoginPage(driver);
        loginPage.login(CORRECT_USERNAME, CORRECT_PASSWORD);
        return driver;
    }
}
