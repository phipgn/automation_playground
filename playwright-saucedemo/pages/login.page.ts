import { Locator, Page } from "@playwright/test";

export class LoginPage {
    private readonly page: Page
    private readonly input_username: Locator
    private readonly input_password: Locator
    private readonly btn_login: Locator
    private readonly message_error: Locator

    constructor(page: Page) {
        this.page = page
        this.input_username = page.locator('#user-name')
        this.input_password = page.locator('#password')
        this.btn_login = page.locator("#login-button")
        this.message_error = page.locator("h3[data-test='error']")
    }
    
    async goto() {
        await this.page.goto("");
    }

    async inputUsername(username: string) {
        await this.input_username.clear()
        await this.input_username.fill(username)
    }

    async inputPassword(password: string) {
        await this.input_password.clear()
        await this.input_password.fill(password)
    }

    async clickLoginButton() {
        await this.btn_login.click()
    }

    async getErrorMessage() {
        return await this.message_error.textContent() ?? ''   
    }
}