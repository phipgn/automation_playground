import { test, expect } from '@playwright/test';

test('Validate e-KYC from webcam', async ({ page }) => {
  const btn_takePhoto1 = page.locator("//div[@class='main-content'][1]//span[text()='Chụp ảnh']");
  const btn_approvePhoto1 = page.locator("//div[@class='main-content'][1]//div[@class='modal-body']//button[1]");
  const btn_next1 = page.locator("//div[@class='main-content'][1]//span[text()='Tiếp Theo']");

  const btn_takePhoto2 = page.locator("//div[@class='main-content'][2]//span[text()='Chụp ảnh']");
  const btn_approvePhoto2 = page.locator("//div[@class='main-content'][2]//div[@class='modal-body']//button[1]");
  const btn_next2 = page.locator("//div[@class='main-content'][2]//span[text()='Tiếp Theo']");

  const txt_result = page.locator("//div[contains(@class, 'result-step')]//table//td[2]");

  await page.goto('https://ekyc.mdcsoftware.com.vn/trai-nghiem/so-sanh-khuon-mat');
  await btn_takePhoto1.click();
  await btn_approvePhoto1.click();
  await btn_next1.click();

  await btn_takePhoto2.click();
  await btn_approvePhoto2.click();
  await btn_next2.click();

  expect((await txt_result.textContent())?.trim()).toBe('Trùng Khớp');
});
