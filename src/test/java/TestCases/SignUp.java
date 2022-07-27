package TestCases;

import Base.BaseDriver;
import PageObjects.RoverLandingPage;
import PageObjects.SignInPage;
import PageObjects.SignUpPage;
import Utilities.DriverCommon;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp extends BaseDriver
{
    @Test
    public void SignUpTest() throws InterruptedException {
        String firstname="Rahul";

        RoverLandingPage lp = new RoverLandingPage();
        lp.ClickSignUp();
        SignUpPage su=new SignUpPage();

        su.doSignUp(firstname);
        //String matchedString=BaseDriver.driver.findElement(By.cssSelector("#logged-in-user-dropdown-menu")).getAttribute("aria-label");

        //System.out.println(matchedString);
        //System.out.println("Logged in as "+firstname+"");
        //Assert.assertEquals(matchedString,"Logged in as "+firstname+"");




    }

}
