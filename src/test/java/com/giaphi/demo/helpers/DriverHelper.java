package com.giaphi.demo.helpers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverHelper {

    /*
     * Run tests remotely against a selenium/standalone-chrome Docker
     */
//    public static WebDriver getDriver() {
//        RemoteWebDriver driver;
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        try {
//            driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return driver;
//    }

    public static WebDriver getDriver() {
        var path = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();
        File logFile = new File(path + "/chromedriver.log");
        ChromeDriverService service = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File(path + "/drivers/chromedriver.exe"))
            .withVerbose(true)
            .withLogFile(logFile)
            .build();

        // These lines for Linux & MacOS
    //  System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver");
//         options.addArguments("--no-sandbox");
//         options.addArguments("--headless");
//         options.addArguments("--disable-dev-shm-usage");
//         options.addArguments("--window-size=1920x1080");

        return new ChromeDriver(service, options);
    }
}

