package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutFormPage extends BasePage {
    private final String locPhoneNumberInput = "//input[@name='billing_telephone']";
    private final String locCityInput = "//input[@name='shipping_city']";
    private final String locNewsletterCheckbox = "//label[@for='billing_newsletter']";
    private final String locPurchaseBtn = "//span[@id='checkoutButton']";
    private final String locLoadingAlert = "//div[@id='ajaxMessages']";

    public CheckoutFormPage() {
    }

    public void inputPhoneNumberField(String phoneNumber) {
        driver.findElement(By.xpath(locPhoneNumberInput)).clear();
        driver.findElement(By.xpath(locPhoneNumberInput)).sendKeys(phoneNumber);
    }

    public void inputCityField(String city) {
        driver.findElement(By.xpath(locCityInput)).clear();
        driver.findElement(By.xpath(locCityInput)).sendKeys(city);
    }

    public void clickNewsletterCheckbox_enabledByDefault() {
        toClick(driver, driver.findElement(By.xpath(locNewsletterCheckbox)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locLoadingAlert)));
    }

    public void clickCheckoutBtn() {
        var button = driver.findElement(By.xpath(locPurchaseBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled');", button);
        js.executeScript("arguments[0].click();", button);
        js.executeScript("arguments[0].click();", button);
        wait.until(ExpectedConditions.titleIs("Ваше замовлення успішно оформлено!"));
    }
}
