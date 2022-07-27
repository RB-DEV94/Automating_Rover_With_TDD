package TestCases;

import Base.BaseDriver;
import PageObjects.SignInPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SignIn extends BaseDriver
{
    @Test
    public void SignInTest() throws InterruptedException {
        SignInPage signin = new SignInPage();
        signin.doSignIn();
    }

}
