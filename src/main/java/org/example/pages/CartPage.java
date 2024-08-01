package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.example.enums.TextData.CHECKOUT_URL;

public class CartPage extends BasePage {
    private final String locCheckoutBtn = "//a[@id='checkoutButton']";
    private final String locProductPrice = "//div[@class='col-xs-3 product_price']";
    private final String locProductTotalPrice = "//div[@class='col-xs-3 product_total']";
    private final String locDeleteProductBtn = "//button[@title='Видалити із кошика']";
    private final String locDismissBtn = "//div[@class='action_btn']//button[text()='Повернутись']";

    public CartPage() {
    }

    public void clickCheckoutBtn() {
        toClick(driver, driver.findElement(By.xpath(locCheckoutBtn)));
        wait.until(ExpectedConditions.urlContains(CHECKOUT_URL.getText()));
    }

    public List<WebElement> elementsList() {
        List<WebElement> listOfElements = new ArrayList<>(4);
        listOfElements.add(driver.findElement(By.xpath(locProductPrice)));
        listOfElements.add(driver.findElement(By.xpath(locProductTotalPrice)));
        listOfElements.add(driver.findElement(By.xpath(locDeleteProductBtn)));
        listOfElements.add(driver.findElement(By.xpath(locDismissBtn)));
        return listOfElements;
    }
}
