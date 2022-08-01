package Listeners;
import java.io.File;
import java.io.IOException;

import Base.BaseDriver;
import Utilities.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.annotations.AfterSuite;


public class Listener  extends ExtentManager implements ITestListener
{

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
            //test.log(Status.FAIL,
        }
    }


   @AfterSuite
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {

            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL,
                 MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

                TakesScreenshot scrShot =((TakesScreenshot)BaseDriver.driver);
//Call getScreenshotAs method to create image file
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
                File imgPath=new File("/Users/rahulbhagwat/Downloads/RoverWebAutomation/src/test/ScreenShots/img.png");
//Copy file at destination
               FileUtils.copyFile(SrcFile, imgPath);
            //String imgPath = .screenShot(BaseDriver.getDriver(), result.getName());

            test.fail("Screenshot is attached");

            }
            catch (IOException e) {

             e.printStackTrace();
            }
            }
        }

    }



