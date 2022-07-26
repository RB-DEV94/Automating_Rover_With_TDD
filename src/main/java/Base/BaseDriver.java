package Base;

import Utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseDriver
{
    public static WebDriver driver;
    public Properties prop;
    public Logger logger;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;
    public ExtentReports extentReports;
    ReadConfig config=new ReadConfig();
    String baseURL=config.getAppURL();
    String browserName= config.getBrowser();


    @BeforeClass
    public void BrowserSetUp() throws IOException {


        extentHtmlReporter=new ExtentHtmlReporter("/Users/rahulbhagwat/Downloads/RoverWebAutomation/Reports/extentreport.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentTest=extentReports.createTest(getClass().getSimpleName());
        extentHtmlReporter.config().setDocumentTitle("Rover Website Automation");
        extentHtmlReporter.config().setReportName("Rover Website Test Cases Report");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Author","Rahul Bhagwat");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chromedriver.driver", "/Users/rahulbhagwat/Downloads/RoverWebAutomation/chromedriver.exe");
            driver = new ChromeDriver();
        }


        driver.get(baseURL);
        driver.manage().window().maximize();
        logger=Logger.getLogger("ROVER AUTOMATION");
        PropertyConfigurator.configure("/Users/rahulbhagwat/Downloads/RoverWebAutomation/Log4j.properties");


    }


    public void logReport(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            extentTest.log(Status.ERROR, result.getName()+"FAILED");
            extentTest.log(Status.ERROR, result.getThrowable());
            /*String screenshotpath = ScreenShotListener.class.getf
        	extentTest.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());*/
        }

        else if(result.getStatus()==ITestResult.SKIP)
        {
            extentTest.log(Status.SKIP, result.getName()+"SKIPPED");
            extentTest.log(Status.ERROR, result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            extentTest.log(Status.INFO, result.getName()+"PASSED");

        }

    }

    @AfterClass
    public void Cleanup()
    {
        driver.quit();
        extentReports.flush();
    }

}
