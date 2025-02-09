import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/login.page';
import { InventoryPage } from '../pages/inventory.page';

test.describe('Login page tests', () => {
  [
    { username:'standard_user', password:process.env.VALID_PASSWORD },
    { username:'problem_user', password:process.env.VALID_PASSWORD },
    { username:'visual_user', password:process.env.VALID_PASSWORD },
  ].forEach(( { username, password } ) => {
    test(`Valid login: ${username}`, async ({ page }) => {
      const loginPage = new LoginPage(page)
      await loginPage.goto()
      await loginPage.inputUsername(`${username}`)
      await loginPage.inputPassword(`${password}`)
      await loginPage.clickLoginButton()
    
      const inventoryPage = new InventoryPage(page)
      expect(await inventoryPage.isDisplayed()).toBeTruthy()
    });  
  });
  
  test('Correct username, incorrect password', async ({ page }) => {
    const loginPage = new LoginPage(page)
    await loginPage.goto()
    await loginPage.inputUsername(process.env.VALID_USERNAME ?? '')
    await loginPage.inputPassword('secret_sauce2')
    await loginPage.clickLoginButton()
    expect(await loginPage.getErrorMessage()).toContain('Username and password do not match any user')
  });

  test('Incorrect username, correct password', async ({ page }) => {
    const loginPage = new LoginPage(page)
    await loginPage.goto()
    await loginPage.inputUsername('standard_user2')
    await loginPage.inputPassword(process.env.VALID_PASSWORD ?? '')
    await loginPage.clickLoginButton()
    expect(await loginPage.getErrorMessage()).toContain('Username and password do not match any user')
  });

  test('Incorrect username, incorrect password', async ({ page }) => {
    const loginPage = new LoginPage(page)
    await loginPage.goto()
    await loginPage.inputUsername('standard_user2')
    await loginPage.inputPassword('secret_sauce2')
    await loginPage.clickLoginButton()
    expect(await loginPage.getErrorMessage()).toContain('Username and password do not match any user')
  });
});
