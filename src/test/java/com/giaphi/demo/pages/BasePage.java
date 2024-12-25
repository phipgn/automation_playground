package com.giaphi.demo.pages;

import com.giaphi.demo.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected final WebDriver driver;
    protected final WaitHelper waitHelper;

    public BasePage(WebDriver _driver) {
        driver = _driver;
        waitHelper = new WaitHelper(driver);
    }

    protected WebElement getElement(By by) {
        return driver.findElement(by);
    }

    protected List<WebElement> getElements(By by) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(by);
        } catch (NoSuchElementException e) {
            elements = new ArrayList<>();
        }
        return elements;
    }

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void pressKey(CharSequence key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    protected boolean isElementDisplayed(By by) {
        return !driver.findElements(by).isEmpty() && driver.findElements(by).get(0).isDisplayed();
    }

    protected void click(WebElement e) {
        e.click();
    }

    protected void selectDropdownOption(By byDropdown, String value) {
        WebElement dropdownElement = getElement(byDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
}
