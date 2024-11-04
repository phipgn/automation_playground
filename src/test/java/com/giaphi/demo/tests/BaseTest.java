package com.giaphi.demo.tests;

import com.giaphi.demo.helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class BaseTest {
    public BaseTest() { }

    protected WebDriver setUpDriver() {
        WebDriver driver = DriverHelper.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        return driver;
    }
}
