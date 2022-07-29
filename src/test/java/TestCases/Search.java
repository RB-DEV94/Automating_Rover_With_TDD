package TestCases;

import Base.BaseDriver;
import PageObjects.RoverLandingPage;
import PageObjects.RoverResultsPage;
import Utilities.DriverCommon;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Search extends BaseDriver
{
    @Test
    public void SearchByZipCode() throws InterruptedException {


        List<WebElement> alllocations;
        String alltext;
        String zip;
        Boolean b;


        RoverLandingPage rover=new RoverLandingPage();
        RoverResultsPage rresults=new RoverResultsPage();
        rover.ClickDogCheckBox();
        rover.ClickHouseSittingTab();
        rover.EnterZipcode("66213");
        rover.EnterDate("07/30/2022","08/04/2022");
        rover.ClickMedium();
        rover.clickSearchButton();
        DriverCommon.ThreadSleep(4);


        alllocations=rresults.getAlllocations();

        for(int i=0;i<alllocations.size();i++)
        {
            alltext=alllocations.get(i).getText();
            zip=alltext.substring(alltext.length()-5,alltext.length()-3);
            System.out.println(zip);
            if(zip.equalsIgnoreCase("66")||zip.equalsIgnoreCase("64"))
            {

                Assert.assertTrue(true);
            }
            else
            {
                System.out.println("Zipcode starting with "+zip+" is not valid");
                Assert.assertTrue(false);

            }

        }

    }
}
