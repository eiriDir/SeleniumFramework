package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.example.core.WebDriverInstance.driverInstance;

public abstract class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        this.driver = driverInstance().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void toClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        element.click();
    }

    public void takeScreenshot(WebDriver driver, String directory, String baseFileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = directory + File.separator + baseFileName + "_" + timestamp + ".png";

        try {
            FileHandler.copy(screenshot, new File(filePath));
            log.info("Screenshot path: " + filePath);
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getMessage());
        }
    }
}
