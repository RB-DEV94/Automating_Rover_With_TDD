package PageObjects;

import Base.BaseDriver;
import Utilities.DriverCommon;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage
{
    public SignInPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }


    @FindBy(name="username")
    public static WebElement Username;


    @FindBy(css="input[data-qa-id='sign-in-input-password-password']")
    public static WebElement password;


    @FindBy(xpath="//button[contains(text(),'Sign In')]")
    public static WebElement SignInButton;



    public static void doSignIn() throws InterruptedException {
       RoverLandingPage rp=new RoverLandingPage();
        WebElement signinlink=rp.getSingInLink();
        DriverCommon.click(signinlink);
        DriverCommon.TypeText(Username,"bhagwat.rahul557@gmail.com");
        DriverCommon.TypeText(password,"Suppu34$");
       DriverCommon.clickOnlyIfElementPresent(SignInButton);
       DriverCommon.ThreadSleep(6);

    }
}
