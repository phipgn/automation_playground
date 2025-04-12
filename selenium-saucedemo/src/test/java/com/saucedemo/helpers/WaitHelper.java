package com.saucedemo.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v129.v129CdpInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private final WebDriver driver;

    public WaitHelper(WebDriver _driver) {
        this.driver = _driver;
    }

    private void test() {
        var explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='abc']")));
    }

    private WebDriverWait getWait(int timeOutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    }

    public void waitUntilClickable(By by, int timeOutInSeconds) {
        getWait(timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilDisplayed(By by, int timeOutInSeconds) {
        getWait(timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilNotDisplayed(By by, int timeOutInSeconds) {
        getWait(timeOutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
