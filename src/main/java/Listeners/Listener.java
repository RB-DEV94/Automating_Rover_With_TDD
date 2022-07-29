package Listeners;
import java.io.File;
import java.io.IOException;

import Utilities.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


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

    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            //try {
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            //test.log(Status.FAIL,
            //      MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            //String imgPath = action.screenShot(BaseClass.getDriver(), result.getName());

            //test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

            //} catch (IOException e) {
            // TODO Auto-generated catch block
            //  e.printStackTrace();
            // }
            //}
        }

    }
}


