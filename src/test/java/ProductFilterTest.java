import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.example.enums.ErrorMessages.FILTERING_FAILED;
import static org.example.enums.TextData.BASE_URL;

public class ProductFilterTest extends BaseTest {

    @Test
    public void filterTest() {
        // arrange
        String minPrice = "1000";
        String maxPrice = "1400";

        // act
        driver.get(BASE_URL.getText());
        mainPage.clickLaptopMenuLink();

        laptopPage.inputMinPriceField(minPrice);
        laptopPage.inputMaxPriceField(maxPrice);
        laptopPage.clickAcerCheckbox();

        // assert
        Assertions.assertTrue(laptopPage.firstProductByFilterName().contains("Acer Nitro 5"), FILTERING_FAILED.getMessage());
    }

    @Test
    public void checkingFilterResults() {
        // arrange
        String minPrice = "1500";
        String maxPrice = "1900";

        // act
        driver.get(BASE_URL.getText());
        mainPage.clickLaptopMenuLink();

        laptopPage.inputMinPriceField(minPrice);
        laptopPage.inputMaxPriceField(maxPrice);

        // assert
        for (WebElement element : laptopPage.elementsListByFilter()) {
            String elementText = element.getText().replaceAll("[^0-9]", "");
            int elementInt = Integer.parseInt(elementText);
            int min = Integer.parseInt(minPrice);
            int max = Integer.parseInt(maxPrice);

            try {
                Assertions.assertTrue(elementInt >= min && elementInt <= max);
            } catch (AssertionError | NoSuchElementException e) {
                mainPage.takeScreenshot(driver,
                        "src/test/resources/Screenshots",
                        "error_product_filter");
                throw e;
            }
        }
    }
}
