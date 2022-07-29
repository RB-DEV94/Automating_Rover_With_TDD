package TestCases;

import PageObjects.RoverResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ServiceTypeValidation
{
    @Test
    public void ServiceTypeValidate()
    {

        RoverResultsPage rp=new RoverResultsPage();

        String matchedString=rp.getMatchedString();
        System.out.println(matchedString);
        if(matchedString.contains("House Sitting"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Results not displayed according to service type");
            Assert.assertTrue(false);
        }


    }

}
