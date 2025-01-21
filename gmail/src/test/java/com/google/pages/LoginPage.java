package com.google.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    By inputUsername = By.id("identifierId");
    By inputPassword = By.xpath("//input[@type='password']");
    By inputOtp = By.id("totpPin");
    By optionGoogleAuthenticator = By.xpath("//strong[text()='Google Authenticator']");
    By buttonNext = By.xpath("//button/span[text()='Next']");
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loadPage() {
        driver.get("https://mail.google.com");
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void inputOtp(String otp) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputOtp));
        driver.findElement(inputOtp).sendKeys(otp);
    }

    public void clickGoogleAuthenticatorOption() {
        wait.until(ExpectedConditions.elementToBeClickable(optionGoogleAuthenticator));
        driver.findElement(optionGoogleAuthenticator).click();
    }

    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }

    public void waitToBeLoadedSuccessfully() {
        wait.until(ExpectedConditions.urlToBe("https://mail.google.com/mail/u/0/#inbox"));
    }
}
