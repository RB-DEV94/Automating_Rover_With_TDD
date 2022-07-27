package TestCases;

import Base.BaseDriver;
import PageObjects.RoverLandingPage;
import PageObjects.SignUpPage;
import org.testng.annotations.Test;

public class SignUp extends BaseDriver
{
    @Test
    public void SignUpTest() throws InterruptedException {
        RoverLandingPage lp = new RoverLandingPage();
        lp.ClickSignUp();
        SignUpPage su=new SignUpPage();
        su.doSignUp();

    }
}
