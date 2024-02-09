package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
   public static WebDriver driver;
    public static Properties prop;
    public BaseClass() throws IOException {
        try {
             prop = new Properties();
            FileInputStream fip = new FileInputStream("src/test/java/Config/config.properties");
            prop.load(fip);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void initialBrowser()
    {
        String browserName=prop.getProperty("browser");
        switch(browserName) {
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case("edge"):
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }

}
