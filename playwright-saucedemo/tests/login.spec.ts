import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/login.page';
import { InventoryPage } from '../pages/inventory.page';

test('Valid credentials', async ({ page }) => {
  const loginPage = new LoginPage(page)
  await loginPage.goto()
  await loginPage.inputUsername(process.env.VALID_USERNAME ?? '')
  await loginPage.inputPassword(process.env.VALID_PASSWORD ?? '')
  await loginPage.clickLoginButton()

  const inventoryPage = new InventoryPage(page)
  expect(await inventoryPage.isDisplayed()).toBeTruthy()
});
