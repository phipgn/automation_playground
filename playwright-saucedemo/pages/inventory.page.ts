import { Locator, Page } from "@playwright/test";

export class InventoryPage {
    private readonly page: Page
    private readonly header: Locator

    constructor(page: Page) {
        this.page = page
        this.header = page.locator("//span[text()='Products']")
    }

    async isDisplayed() {
        return await this.header.isVisible()
    }
}