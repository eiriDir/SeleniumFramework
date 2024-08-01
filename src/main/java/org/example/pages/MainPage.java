package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.enums.TextData.MENU_APPLIANCES_URL;
import static org.example.enums.TextData.MENU_LAPTOP_URL;

public class MainPage extends BasePage {
    private final String locLoginLink = "//a[text()='Log into your Account']";
    private final String locSubmitBtn = "//form[@name='login']//button[@type='submit']";
    private final String locLanguageBtn = "//div[@class='language_select']//button";
    private final String locLanguageUK = "//a[@hreflang='uk']";
    private final String locLanguageSelectIsOpen = "//div[@class='language_select open']";
    private final String locLanguageIsUK = "//button[contains(text(), 'Українська')]";
    private final String locCurrencyBtn = "//nav[@class='currency_select']";
    private final String locCurrencyUK = "//div[@class='selectize-dropdown-content']//div[@data-value='UAH']";
    private final String locCurrencySelectIsOpen = "//div[@class='option selected active']";
    private final String locCurrencyIsUAH = "//span[contains(text(), 'грн')]";
    private final String locMenuAppliancesLink = "//div[@class='block_categories']//a[text()='Appliances' or text()='Побутова техніка']";
    private final String locMenuLaptopLink = "//div[@class='block_categories']//a[text()='Laptops' or text()='Ноутбуки']";

    public MainPage() {
    }

    public void clickLoginLink() {
        toClick(driver, driver.findElement(By.xpath(locLoginLink)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locSubmitBtn)));
    }

    public void switchLanguageToUK() {
        toClick(driver, driver.findElement(By.xpath(locLanguageBtn)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locLanguageSelectIsOpen)));
        toClick(driver, driver.findElement(By.xpath(locLanguageUK)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locLanguageIsUK)));
    }

    public void switchCurrencyToUAH() {
        toClick(driver, driver.findElement(By.xpath(locCurrencyBtn)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locCurrencySelectIsOpen)));
        toClick(driver, driver.findElement(By.xpath(locCurrencyUK)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locCurrencyIsUAH)));
    }

    public void clickAppliancesLink() {
        toClick(driver, driver.findElement(By.xpath(locMenuAppliancesLink)));
        wait.until(ExpectedConditions.urlContains(MENU_APPLIANCES_URL.getText()));
    }

    public void clickLaptopMenuLink() {
        toClick(driver, driver.findElement(By.xpath(locMenuLaptopLink)));
        wait.until(ExpectedConditions.urlContains(MENU_LAPTOP_URL.getText()));
    }
}
