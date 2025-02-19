package ceiti.da.testng;

import ceiti.da.Login;
import ceiti.da.utils.SeleniumJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;

public class SwagTest {
    public static WebDriver driver;
    public static String URL_TEST = "https://www.saucedemo.com/";
    public static String USERNAME = "standard_user";
    public static String PASSWORD = "secret_sauce";
    public static String TITLE = "Products";

    @BeforeClass
    public void startTest() {
        SwagTest.driver = SeleniumJava.setLocalDriver();
    }

    @Test
    public void firstTest() {
        driver.get(URL_TEST);
        driver.manage().window().minimize();

        Login login = new Login(driver);
        login.setUserName(USERNAME);
        login.setPassword(PASSWORD);
        login.clickSend();

//        String actualResult = login.getTitle();

        Assert.assertEquals(login.getTitleText(), TITLE);

        System.out.println();
    }

    @AfterClass
    public void stopTest() {
        driver.quit();
    }
}
