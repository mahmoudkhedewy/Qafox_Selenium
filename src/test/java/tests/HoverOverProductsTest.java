package tests;

import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.HoverOverProducts;
import utils.Validations;

public class HoverOverProductsTest extends TestBase{
    HoverOverProducts hover;

    @Test
    public void hoverOverDesktopProducts() throws InterruptedException {
        hover = new HoverOverProducts(DriverManager.getDriver());
        hover.hoverOverDesktopProducts();
        Validations.assertTrue(hover.getAssertionMessage().contains("Mac"));
    }
}
