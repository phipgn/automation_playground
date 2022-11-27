package com.giaphi.demo.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHelper {
    public static WebDriver getDriver() {
        var path = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();

        // This line for Windows
//        System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");

        // These lines for Linux
        System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");

        return new ChromeDriver(options);
    }
}

