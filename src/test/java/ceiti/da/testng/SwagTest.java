package ceiti.da.testng;

import ceiti.da.Login;
import ceiti.da.ProductsCart;
import ceiti.da.utils.SeleniumJava;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SwagTest {
    public Logger logger = LogManager.getLogger(SwagTest.class);
    public static WebDriver driver;
    public static String URL_TEST = "https://www.saucedemo.com/";
    public static String USERNAME = "standard_user";
    public static String PASSWORD = "secret_sauce";
    public static String TITLE = "Products";
    public static int PRODUCTS_NUMBER = 6;

    @BeforeClass
    public void startTest() {
        SwagTest.driver = SeleniumJava.getRemoteDriver();
    }

    @Test
    public void firstTest() {
        logger.info("Entered first test");
        driver.get(URL_TEST);
        logger.info("Entered site " + URL_TEST);
        driver.manage().window().minimize();

        Login login = new Login(driver);
        logger.info("Initialized the driver");
        login.setUserName(USERNAME);
        login.setPassword(PASSWORD);
        logger.info("Entered username = " + USERNAME + " , password = " + PASSWORD);
        login.clickSend();
        logger.info("Clicked log in button");

//        String actualResult = login.getTitle();

        Assert.assertEquals(login.getTitleText(), TITLE);
        logger.info("Logged in");

        System.out.println();
    }

    @Test
    public void secondTest() {
        firstTest();
        ProductsCart productsCart = new ProductsCart(driver);

        Assert.assertEquals(productsCart.getProductNumbers(), PRODUCTS_NUMBER);

        System.out.println();
    }

    @AfterClass
    public void stopTest() {
        driver.quit();
    }
}
