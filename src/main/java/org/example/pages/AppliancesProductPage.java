package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppliancesProductPage extends BasePage {
    private final String locProductQuantityInput = "//form[@name='cart_quantity']//input[@type='number']";
    private final String locProductBuyBtn = "//div[@class='prod_buy_btns']//button[@type='submit']";
    private final String locCartCheckoutBtn = "//a[@id='checkoutButton']";

    public AppliancesProductPage() {
    }

    public void inputProductQuantityField(String quantity) {
        driver.findElement(By.xpath(locProductQuantityInput)).clear();
        driver.findElement(By.xpath(locProductQuantityInput)).sendKeys(quantity);
    }

    public void clickProductBuyBtn() {
        toClick(driver, driver.findElement(By.xpath(locProductBuyBtn)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locCartCheckoutBtn)));
    }
}
