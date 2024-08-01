package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.enums.TextData.APPLIANCES_PRODUCT_URL;

public class AppliancesPage extends BasePage {
    private final String locProductLink = "//a[text()='Kenwood ZJM 810']";

    public AppliancesPage() {
    }

    public void clickProductLink() {
        toClick(driver, driver.findElement(By.xpath(locProductLink)));
        wait.until(ExpectedConditions.urlContains(APPLIANCES_PRODUCT_URL.getText()));
    }
}
