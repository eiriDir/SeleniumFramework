import org.example.core.WebDriverFactory;
import org.example.pages.*;
import org.example.steps.LoginSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.core.WebDriverInstance.driverInstance;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected LoginSteps loginSteps;
    protected ForgottenPasswordPage forgottenPasswordPage;
    protected AppliancesPage appliancesPage;
    protected AppliancesProductPage appliancesProductPage;
    protected LaptopPage laptopPage;
    protected LaptopProductPage laptopProductPage;
    protected CartPage cartPage;
    protected CheckoutFormPage checkoutFormPage;

    @BeforeEach
    public void init() {
        /* configuration by [WebDriverFactory] is placed in the driver-creator [WebDriverInstance] */
        driver = WebDriverFactory.getDriver("chrome");
        driverInstance().setDriver(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        mainPage = new MainPage();
        loginPage = new LoginPage();
        forgottenPasswordPage = new ForgottenPasswordPage();
        appliancesPage = new AppliancesPage();
        appliancesProductPage = new AppliancesProductPage();
        laptopPage = new LaptopPage();
        laptopProductPage = new LaptopProductPage();
        cartPage = new CartPage();
        checkoutFormPage = new CheckoutFormPage();

        loginSteps = new LoginSteps();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
