package Base;

import Utilities.ReadConfig;
import Utilities.ExtentManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.IOException;


public class BaseDriver
{
    public static WebDriver driver;
    public Logger logger;

    ReadConfig config=new ReadConfig();
    String baseURL=config.getAppURL();
    String browserName= config.getBrowser();


    @BeforeClass
    public void BrowserSetUp() throws IOException {

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chromedriver.driver", "/Users/rahulbhagwat/Downloads/RoverWebAutomation/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equals("mozilla")) {
            System.setProperty("webdriver.chromedriver.driver", "/Users/rahulbhagwat/Downloads/RoverWebAutomation/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equals("gecko")) {
            System.setProperty("webdriver.chromedriver.driver", "/Users/rahulbhagwat/Downloads/RoverWebAutomation/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equals("IE")) {
            System.setProperty("webdriver.chromedriver.driver", "/Users/rahulbhagwat/Downloads/RoverWebAutomation/chromedriver.exe");
            driver = new ChromeDriver();
        }


        driver.get(baseURL);
        driver.manage().window().maximize();
        logger=Logger.getLogger("ROVER AUTOMATION");
        PropertyConfigurator.configure("/Users/rahulbhagwat/Downloads/RoverWebAutomation/Log4j.properties");


    }

    @BeforeSuite
    public void loadConfig() {
        ExtentManager.setExtent();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentManager.endReport();
    }

    @AfterTest
    public void Cleanup()
    {

        driver.quit();


    }

}
