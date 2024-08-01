package org.example.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WebDriverFactory {
    private static final Logger log = LoggerFactory.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                return configChrome();
            case "firefox":
                return configFirefox();
            case "edge":
                return configEdge();
            default:
                log.debug("Unknown browser. Сhrome is selected by default.");
                return configChrome();
        }
    }

    private static ChromeDriver configChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(20));
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

    private static FirefoxDriver configFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(30));
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

    private static EdgeDriver configEdge() {
        EdgeOptions options = new EdgeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(30));
        EdgeDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }
}
