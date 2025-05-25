package com.saucedemo.helpers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverHelper {

    /*
     * Run tests remotely against a selenium/standalone-chrome Docker
     */
   public static WebDriver getRemoteDriver() {
       RemoteWebDriver driver;
       var capabilities = new DesiredCapabilities();
       capabilities.setBrowserName("chrome");
       try {
            // if you run tests from your laptop against the selenium/standalone-chrome docker container
            // driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
            // if you run tests from your container against the selenium-hub container
            driver = new RemoteWebDriver(new URL("http://selenium-hub:4444"), capabilities);
       } catch (MalformedURLException e) {
           e.printStackTrace();
           return null;
       }
       return driver;
   }

    public static WebDriver getDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        
        var path = System.getProperty("user.dir");
        var options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }

        var logFile = new File(path + "/chromedriver.log");
        var service = new ChromeDriverService.Builder()
            // .usingDriverExecutable(new File(path + "/drivers/chromedriver.exe"))
            .withVerbose(true)
            .withLogFile(logFile)
            .build();

        return new ChromeDriver(service, options);
    }
}

