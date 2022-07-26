package PageObjects;

import Base.BaseDriver;
import Utilities.DriverCommon;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RoverLandingPage
{

    public RoverLandingPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
    @FindBy(xpath="//a[contains(text(),'Sign Up')]")
    public static WebElement SignUpLink;

    public static void ClickSignUp()
    {
        DriverCommon.click(SignUpLink);
    }

}
