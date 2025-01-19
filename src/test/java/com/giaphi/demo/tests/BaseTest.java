package com.giaphi.demo.tests;

import com.giaphi.demo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {
    private final String BASE_URL = "https://www.saucedemo.com/";
    private final String CORRECT_USERNAME = "standard_user";
    private final String CORRECT_PASSWORD = "secret_sauce";

    public BaseTest() { }

    protected WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver();
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
