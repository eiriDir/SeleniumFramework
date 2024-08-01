package org.example.pages;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LaptopProductPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LaptopProductPage.class);

    private final String locProductLabelText = "//form[@name='cart_quantity']//h1"; //Apple MacBook Air
    private final String locProductIDTest = "//form[@name='cart_quantity']//span[@class='art_card_product']"; //78651
    private final String locProductPrice = "//form[@name='cart_quantity']//span[@class='new_price_card_product']"; //$1441.00
    private final String locDiagonalText = "//td[text()='Diagonal:']/../td[2]"; //13.3"
    private final String locProcessorText = "//td[text()='Processor:']/../td[2]"; //Intel Core i3 (1.1 - 3.2 GHz)
    private final String locScreenResolutionText = "//td[text()='Screen resolution:']/../td[2]"; //2560x1600

    public LaptopProductPage() {
    }

    public JSONObject createProductAttributesJsonFile() {
        JSONObject data = new JSONObject();
        data.put("id", driver.findElement(By.xpath(locProductIDTest)).getText());
        data.put("name", driver.findElement(By.xpath(locProductLabelText)).getText());
        data.put("price", driver.findElement(By.xpath(locProductPrice)).getText());
        data.put("diagonal", driver.findElement(By.xpath(locDiagonalText)).getText());
        data.put("processor", driver.findElement(By.xpath(locProcessorText)).getText());
        data.put("screen resolution", driver.findElement(By.xpath(locScreenResolutionText)).getText());
        log.info("Data added successfully: " + data);

        return data;
    }
}
