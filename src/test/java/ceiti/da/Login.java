package ceiti.da;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public static WebDriver driver;

    @FindBy(id = "user-name")
    WebElement loginNameEl;

    @FindBy(id = "password")
    WebElement passwordEl;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement sendEl;

    @FindBy(xpath = "//*[text()='Products']")
    WebElement titleEl;

    public void clickSend(){
        sendEl.click();
    }

    public Login(WebDriver driver) {
        Login.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitleText(){
        return titleEl.getText();
    }

    public void setPassword(String passwordParam){
        passwordEl.sendKeys(passwordParam);
    }

    public void setUserName(String userNameParam) {
        loginNameEl.sendKeys(userNameParam);
    }
}
