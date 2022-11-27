package com.giaphi.demo.tests;

import com.giaphi.demo.helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
        driver = DriverHelper.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterTest
    public void dispose() {
        driver.quit();
    }
}
