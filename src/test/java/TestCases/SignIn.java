package TestCases;

import Base.BaseDriver;
import PageObjects.SignInPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SignIn extends BaseDriver
{
    @Test
    public void SignInTest() throws InterruptedException {
        SignInPage signin = new SignInPage();
        signin.doSignIn();
        //String matchedString=BaseDriver.driver.findElement(By.cssSelector("#logged-in-user-dropdown-menu")).getAttribute("aria-label");

        //Assert.assertTrue(matchedString.contains("Logged in as"));

    }

}
