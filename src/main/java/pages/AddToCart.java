package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementActions;

import java.util.Arrays;
import java.util.List;


public class AddToCart {
    WebDriver driver;
    public AddToCart(WebDriver driver){
        this.driver = driver;
    }

    public void addProductsToCart(){
        int j = 0;
        String[] productsWillBeAdded = {"iPhone","MacBook"};
        System.out.println(productsWillBeAdded.length);
        List<WebElement> names = ElementActions.findElements(driver,By.tagName("h4"));
        for (int i = 0; i <names.size() ; i++) {
            System.out.println(names.get(i).getText());
            String productName = names.get(i).getText();
            List productsArray = Arrays.asList(productsWillBeAdded);
            if (productsArray.contains(productName)){
                j++;
                driver.findElements(By.xpath("//span[text()='Add to Cart']")).get(i).click();
                if (j == productsWillBeAdded.length){
                    break;
                }
            }
        }
        ElementActions.findElement(driver,By.xpath("//span[text()='Shopping Cart']")).click();


    }

    }





