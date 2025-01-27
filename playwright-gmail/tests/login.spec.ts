/// <reference types="node" />
import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/login.page';
import { TotpHelper } from '../helpers/totp.helper';

test('Login Google MFA', async ({ page }) => {
  const username = process.env.GOOGLE_USERNAME ?? ''
  const password = process.env.GOOGLE_PASSWORD ?? ''
  const secret = process.env.GOOGLE_SECRET ?? ''

  const loginPage = new LoginPage(page);
  await loginPage.loadPage()

  await loginPage.enterUsername(username)
  await loginPage.clickNextButton()
  await loginPage.enterPassword(password)
  await loginPage.clickNextButton()
  await loginPage.clickGoogleAuthenticatorOption()

  const otp = new TotpHelper().generateOtp(secret)
  await loginPage.enterOtp(otp)
  await loginPage.clickNextButton()
  await page.waitForURL("https://mail.google.com/mail/u/0/#inbox")
});
