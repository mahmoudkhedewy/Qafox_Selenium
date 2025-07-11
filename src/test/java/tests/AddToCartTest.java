package tests;

import drivers.DriverManager;
import org.testng.annotations.Test;
import pages.AddToCart;

public class AddToCartTest extends TestBase{
    AddToCart addToCart;

    @Test
    public void addToCart(){
        addToCart = new AddToCart(DriverManager.getDriver());
        addToCart.addProductsToCart();
    }
}
