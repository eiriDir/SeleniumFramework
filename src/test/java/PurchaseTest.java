import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.enums.ErrorMessages.CHECKOUT_FAILED;
import static org.example.enums.ErrorMessages.ELEMENTS_IS_NOT_DISPLAYED;
import static org.example.enums.TextData.*;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseTest() {
        // arrange
        String phoneNumber = "0936666666";
        String city = "Kharkiv";
        String checkoutIsSuccess = "Ваше замовлення успішно оформлено!";

        // act
        driver.get(BASE_URL.getText());
        loginSteps.loginBySteps(EMAIL.getText(), PASSWORD.getText());

        mainPage.switchLanguageToUK();
        mainPage.switchCurrencyToUAH();
        mainPage.clickAppliancesLink();

        appliancesPage.clickProductLink();

        appliancesProductPage.inputProductQuantityField("2");
        appliancesProductPage.clickProductBuyBtn();

        cartPage.clickCheckoutBtn();

        checkoutFormPage.inputPhoneNumberField(phoneNumber);
        checkoutFormPage.inputCityField(city);
        checkoutFormPage.clickNewsletterCheckbox_enabledByDefault();
        checkoutFormPage.clickNewsletterCheckbox_enabledByDefault();
        checkoutFormPage.clickCheckoutBtn();

        // assert
        Assertions.assertEquals(checkoutIsSuccess, driver.getTitle(), CHECKOUT_FAILED.getMessage());
    }

    @Test
    public void checkPageElements() {
        // act
        driver.get(BASE_URL.getText());
        loginSteps.loginBySteps(EMAIL.getText(), PASSWORD.getText());

        mainPage.switchLanguageToUK();
        mainPage.switchCurrencyToUAH();
        mainPage.clickAppliancesLink();

        appliancesPage.clickProductLink();

        appliancesProductPage.inputProductQuantityField("2");
        appliancesProductPage.clickProductBuyBtn();

        // assert
        List<WebElement> list = cartPage.elementsList();
        for (WebElement webElement : list) {
            Assertions.assertTrue(webElement.isDisplayed(), ELEMENTS_IS_NOT_DISPLAYED.getMessage());
        }
    }
}
