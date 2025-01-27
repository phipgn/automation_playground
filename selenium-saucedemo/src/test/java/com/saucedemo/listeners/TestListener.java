package com.saucedemo.listeners;

import java.util.logging.Logger;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.saucedemo.helpers.ScreenshotHelper;
import com.saucedemo.tests.BaseTest;

public class TestListener implements ITestListener {
    private Logger logger = Logger.getLogger(TestListener.class.getName());
    
    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test Failed: " + result.getName());
        var testInstance = result.getInstance();
        var driver = ((BaseTest) testInstance).getDriver();
        ScreenshotHelper.captureScreen(driver);
    }
}
