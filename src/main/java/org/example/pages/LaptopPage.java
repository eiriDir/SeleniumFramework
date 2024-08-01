package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.example.enums.TextData.LAPTOP_PRODUCT_URL;

public class LaptopPage extends BasePage {
    private final String locMinPriceInput = "//div[@class='filter_box_in']//input[@id='range1']";
    private final String locMaxPriceInput = "//div[@class='filter_box_in']//input[@id='range2']";
    private final String locAcerCheckbox = "//div[@class='filter_box_in']//label[@for='brand_9']";
    private final String locAcerIsSelect = "//div[@class='filter_box_in']//input[@value='9' and @id='brand_9']";
    private final String locLoadingSpin = "//*[name()='svg' and @style='display: none;']";
    private final String locProductLink = "//*[text()='Apple MacBook Air']";
    private final String locFirstProductByFilterName = "//div[@id='r_spisok']//a[text()='Acer Nitro 5 Shale Black']";
    private final String locListOfElements = "//span[@class='new_price']";

    public LaptopPage() {
    }

    public void clickAcerCheckbox() {
        toClick(driver, driver.findElement(By.xpath(locAcerCheckbox)));
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(locAcerIsSelect)));
    }

    public void clickProductLink() {
        toClick(driver, driver.findElement(By.xpath(locProductLink)));
        wait.until(ExpectedConditions.urlToBe(LAPTOP_PRODUCT_URL.getText()));
    }

    public void inputMinPriceField(String minPrice) {
        driver.findElement(By.xpath(locMinPriceInput)).clear();
        driver.findElement(By.xpath(locMinPriceInput)).sendKeys(minPrice);
        wait.until(ExpectedConditions.attributeContains(By.xpath(locLoadingSpin), "style", "display: none;"));
    }

    public void inputMaxPriceField(String maxPrice) {
        driver.findElement(By.xpath(locMaxPriceInput)).clear();
        driver.findElement(By.xpath(locMaxPriceInput)).sendKeys(maxPrice);
        wait.until(ExpectedConditions.attributeContains(By.xpath(locLoadingSpin), "style", "display: none;"));
    }

    public List<WebElement> elementsListByFilter() {
        return driver.findElements(By.xpath(locListOfElements));
    }

    public String firstProductByFilterName() {
        return driver.findElement(By.xpath(locFirstProductByFilterName)).getText();
    }
}
