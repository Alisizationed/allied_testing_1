package ceiti.da;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsCart {
    public static WebDriver driver;

    @FindBy(xpath = "//*[@class='inventory_item']")
    private List<WebElement> productsEl;

    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
    private List<WebElement> addToCartEl;

    public ProductsCart(WebDriver driver) {
        Login.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getProductNumbers() {
        return productsEl.size();
    }

    public void addToCart() {

    }
}
