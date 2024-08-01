package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.enums.TextData.FORGOTTEN_PASSWORD_URL;

public class ForgottenPasswordPage extends BasePage {
    private final String locEmailInput = "//input[@type='email']";
    private final String locSubmitBtn = "//button[text()='Continue']";
    private final String locNewPasswordSuccessImg = "//img[@title='Success']";

    public ForgottenPasswordPage() {
    }

    public void clickSubmitBtn() {
        toClick(driver, driver.findElement(By.xpath(locSubmitBtn)));
        wait.until(ExpectedConditions.urlContains(FORGOTTEN_PASSWORD_URL.getText() + "?action=email_sent"));
    }

    public void inputEmailField(String email) {
        driver.findElement(By.xpath(locEmailInput)).sendKeys(email);
    }

    public boolean isNewPasswordIsSend() {
        return driver.findElement(By.xpath(locNewPasswordSuccessImg)).isDisplayed();
    }
}
