package com.giaphi.demo.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
    public static WebDriver getDriver() {
        var path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}

