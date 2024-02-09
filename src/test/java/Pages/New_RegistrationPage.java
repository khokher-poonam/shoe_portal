package Pages;

import Utilities.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_RegistrationPage {
    WebDriver driver;

    @FindBy(id="Salutation")
    WebElement salutation;
    @FindBy(id="firstname")
    WebElement fname;
    @FindBy(id="lastname")
    WebElement lname;
    @FindBy(id="emailId")
    WebElement emailId;
    @FindBy(id="contactNumber")
    WebElement contactNumber;
    @FindBy(id="usr")
    WebElement usr;
    @FindBy(id="pwd")
    WebElement pwd;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement submitBtn;
    public New_RegistrationPage()
    {
        this.driver=BaseClass.driver;
        PageFactory.initElements(driver,this);
    }
public void scrollPage()
{
    JavascriptExecutor js= (JavascriptExecutor)driver;
js.executeScript("window.scrollBy(100,0)","");


}
    public New_RegistrationPage selectSalutation() {
        salutation.click();
        return this;
    }
    public New_RegistrationPage firstName(String fn) {
        this.fname.sendKeys(fn);
        return this;
    }
    public New_RegistrationPage lastName(String ln) {
        this.lname.sendKeys(ln);
        return this;
    }
    public New_RegistrationPage emailId(String ei) {
       this.emailId.sendKeys(ei);
        return this;
    }
    public New_RegistrationPage contactNumber(String cn) {
        this.contactNumber.sendKeys(cn);
        return this;
    }
    public New_RegistrationPage username(String un) {
       this.usr.sendKeys(un);
        return this;
    }
    public New_RegistrationPage password(String pd) {
       this.pwd.sendKeys(pd);
        return this;
    }
    public void submitBtnClick() {
        submitBtn.click();
    }
}
