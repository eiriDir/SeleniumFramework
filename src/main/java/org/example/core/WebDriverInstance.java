package org.example.core;

import org.openqa.selenium.WebDriver;

public class WebDriverInstance {
    private static WebDriverInstance instance;
    private WebDriver driver;

    private WebDriverInstance() {
    }

    public static WebDriverInstance driverInstance() {
        if (instance == null) instance = new WebDriverInstance();
        return instance;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
