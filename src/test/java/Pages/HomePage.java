package Pages;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends BaseClass {
WebDriver driver;
        @FindBy(xpath="//div[@id=\"menuToggle\"]//input")
    WebElement toggle;
        @FindBy(xpath="//ul[@id=\"menu\"]//a[2]//li")
    WebElement sign_inBtn;
    @FindBy(id="usr")
    WebElement username;
    @FindBy(id = "pwd")
    WebElement password;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement login;
    @FindBy(id="NewRegistration")
    WebElement NewRegistrationBtn;
        public HomePage() throws IOException {
            this.driver=BaseClass.driver;
            PageFactory.initElements(driver,this);
        }
        public void toggleSignClick() throws InterruptedException {
            this.toggle.click();
            Thread.sleep(2000);
            Actions actions=new Actions(driver);
            actions.moveToElement(sign_inBtn).click().perform();
        }
    public void login_details()
    {
        username.sendKeys("sa");
        password.sendKeys("sa");
        login.click();
    }
    public New_RegistrationPage BtnClick()
    {
        NewRegistrationBtn.click();
        return new New_RegistrationPage();
    }

}
