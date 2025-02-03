import { Locator, Page } from "@playwright/test";

export class LoginPage {
    private readonly page: Page
    private readonly inputUsername: Locator
    private readonly inputPassword: Locator
    private readonly inputOtp: Locator
    private readonly optionGoogleAuthenticator: Locator
    private readonly buttonNext: Locator

    constructor(page: Page) {
        this.page = page
        this.inputUsername = page.locator("#identifierId")
        this.inputPassword = page.locator("//input[@type='password']")
        this.inputOtp = page.locator("#totpPin")
        this.optionGoogleAuthenticator = page.locator("//strong[text()='Google Authenticator']")
        this.buttonNext = page.locator("//button/span[text()='Next']")
    }

    async loadPage() {
        await this.page.goto('https://mail.google.com')
    }

    async enterUsername(username: string) { await this.inputUsername.fill(username) }
    async enterPassword(password: string) { await this.inputPassword.fill(password) }
    async enterOtp(otp: string) { await this.inputOtp.fill(otp) }
    async clickGoogleAuthenticatorOption() { await this.optionGoogleAuthenticator.click() }
    async clickNextButton() { await this.buttonNext.click() }
}