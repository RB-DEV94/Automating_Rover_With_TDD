package Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {

        htmlReporter= new ExtentHtmlReporter("/Users/rahulbhagwat/Downloads/RoverWebAutomation/Reports/extentreport.html");
        htmlReporter.loadXMLConfig("/Users/rahulbhagwat/Downloads/RoverWebAutomation/src/extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "Rover Website Automation");
        extent.setSystemInfo("Tester", "Hitendra");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }
    public static void endReport() {
        extent.flush();
    }
}

