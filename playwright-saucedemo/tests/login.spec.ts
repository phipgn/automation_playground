import { expect } from '@playwright/test';
import test from './baseTest';

test.describe('Login page tests', () => {
  [
    { username:'standard_user', password: 'secret_sauce' },
    { username:'problem_user', password: 'secret_sauce' },
    { username:'visual_user', password: 'secret_sauce' },
  ].forEach(( { username, password } ) => {
    test(`Valid login: ${username}`, async ({ loginPage, inventoryPage }) => {
      await loginPage.goto()
      await loginPage.inputUsername(`${username}`)
      await loginPage.inputPassword(`${password}`)
      await loginPage.clickLoginButton()    
      expect(await inventoryPage.isDisplayed()).toBeTruthy()
    });  
  });
  
  test('Correct username, incorrect password', async ({ loginPage }) => {
    await loginPage.goto()
    await loginPage.inputUsername(process.env.VALID_USERNAME ?? '')
    await loginPage.inputPassword('secret_sauce2')
    await loginPage.clickLoginButton()
    expect(await loginPage.getErrorMessage()).toContain('Username and password do not match any user')
  });

  test('Incorrect username, correct password', async ({ loginPage }) => {
    await loginPage.goto()
    await loginPage.inputUsername('standard_user2')
    await loginPage.inputPassword(process.env.VALID_PASSWORD ?? '')
    await loginPage.clickLoginButton()
    expect(await loginPage.getErrorMessage()).toContain('Username and password do not match any user')
  });

  test('Incorrect username, incorrect password', async ({ loginPage }) => {
    await loginPage.goto()
    await loginPage.inputUsername('standard_user2')
    await loginPage.inputPassword('secret_sauce2')
    await loginPage.clickLoginButton()
    expect(await loginPage.getErrorMessage()).toContain('Username and password do not match any user')
  });
});
