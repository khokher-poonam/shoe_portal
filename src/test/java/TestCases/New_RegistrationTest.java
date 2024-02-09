package TestCases;
import Data.ExcelData;
import Pages.HomePage;
import Pages.New_RegistrationPage;
import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class New_RegistrationTest extends BaseClass {
    WebDriver driver;
    New_RegistrationPage new_RegistrationPage=new New_RegistrationPage();
HomePage homePage;
    public New_RegistrationTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        initialBrowser();
        homePage=new HomePage();
        homePage.toggleSignClick();
    }

    @Test(dataProvider = "ShoePortal_dataProvider", dataProviderClass = ExcelData.class)
    public void insertDetails(Object[] data) throws InterruptedException {
        homePage.BtnClick();
        new_RegistrationPage.scrollPage();

        new_RegistrationPage.selectSalutation();
new_RegistrationPage.firstName((String) data[1]);
new_RegistrationPage.lastName((String) data[2]);
new_RegistrationPage.emailId((String) data[2]);
        new_RegistrationPage.contactNumber((String) data[3]);
        new_RegistrationPage.username((String) data[4]);
        new_RegistrationPage.password((String) data[5]);
        new_RegistrationPage.submitBtnClick();
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}