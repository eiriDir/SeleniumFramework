package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.enums.TextData.FORGOTTEN_PASSWORD_URL;

public class LoginPage extends BasePage {
    private final String locEmailInput = "//form[@name='login']//input[@type='email']";
    private final String locPasswordInput = "//form[@name='login']//input[@type='password']";
    private final String locSubmitBtn = "//form[@name='login']//button[@type='submit']";
    private final String locLoginIsSuccess = "//a[text()='Log off']";
    private final String locForgottenPasswordLink = "//a[@href='password_forgotten.php']";

    public LoginPage() {
    }

    public boolean isLoginSuccessful() {
        return driver.findElement(By.xpath(locLoginIsSuccess)).isDisplayed();
    }

    public void inputEmailField(String email) {
        driver.findElement(By.xpath(locEmailInput)).sendKeys(email);
    }

    public void inputPassField(String password) {
        driver.findElement(By.xpath(locPasswordInput)).sendKeys(password);
    }

    public void clickSubmitBtn() {
        toClick(driver, driver.findElement(By.xpath(locSubmitBtn)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locLoginIsSuccess)));
    }

    public void clickForgottenPasswordLink() {
        toClick(driver, driver.findElement(By.xpath(locForgottenPasswordLink)));
        wait.until(ExpectedConditions.urlContains(FORGOTTEN_PASSWORD_URL.getText()));
    }
}
