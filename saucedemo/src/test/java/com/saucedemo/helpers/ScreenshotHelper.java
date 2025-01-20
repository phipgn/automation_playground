package com.saucedemo.helpers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
    private static final Logger logger = Logger.getLogger(ScreenshotHelper.class.getName());

    public static void captureScreen(WebDriver driver) {
        var fileName = String.format("screenshots/screenshot_%s.png", TimeHelper.getCurrentDateTime());
        var screenshot = (TakesScreenshot) driver;
        var srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        var desFile = new File(fileName);

        try {
            FileUtils.copyFile(srcFile, desFile);
        } catch (IOException ex) {
            logger.severe("Cannot copy file " + fileName + "!");
        }

    }
}
