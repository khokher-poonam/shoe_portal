package TestCases;

import Pages.HomePage;
import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseClass {
    HomePage homePage;
    public HomePageTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() throws IOException {
        initialBrowser();
        homePage=new HomePage();
    }

    @Test(priority = 1)
    public void signInPage()throws InterruptedException
    {
        homePage.toggleSignClick();

    }
    @Test(priority = 2)
    public void SignInPortal_details() throws InterruptedException {
        homePage.login_details();
        Thread.sleep(1000);
    }

@AfterClass
    public void tearDown()
{
    driver.quit();
}

}
