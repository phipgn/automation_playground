package com.giaphi.demo.helpers;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

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
        WebDriverManager.chromedriver().setup();
        
        var path = System.getProperty("user.dir");
        var options = new ChromeOptions();
        var logFile = new File(path + "/chromedriver.log");
        var service = new ChromeDriverService.Builder()
            // .usingDriverExecutable(new File(path + "/drivers/chromedriver.exe"))
            .withVerbose(true)
            .withLogFile(logFile)
            .build();

        return new ChromeDriver(service, options);
    }
}

