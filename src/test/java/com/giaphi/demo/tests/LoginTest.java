package com.giaphi.demo.tests;

import com.giaphi.demo.pages.DashboardPage;
import com.giaphi.demo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final LoginPage loginPage;

    public LoginTest() {
        super();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.inputUsername("404_automation_seller");
        loginPage.inputPassword("hBfpQ$yk&a$nX6qj");
        loginPage.signInButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.pageHeader().isDisplayed());
    }
}
