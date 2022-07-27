package PageObjects;

import Base.BaseDriver;
import Utilities.DriverCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage
{
    public SignUpPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Sign Up with')]")
    public static WebElement SignUpWithLinkk;

    @FindBy(name = "first_name")
    public static WebElement Firstname;





    @FindBy(name = "last_name")
    public static WebElement Lastname;

    @FindBy(name = "zip_code")
    public static WebElement zipcode;

    @FindBy(name = "email")
    public static WebElement email;

    @FindBy(name = "password")
    public static WebElement password;


    @FindBy(css = "button[data-qa-id='button-sign-up']")
    public static WebElement SignUpButton;




    public static void doSignUp(String firstname) throws InterruptedException {


        //SignUpPage su=new SignUpPage();
        DriverCommon.clickOnlyIfElementPresent(SignUpWithLinkk);
        DriverCommon.ThreadSleep(6);
        DriverCommon.TypeText(Firstname,firstname);
        DriverCommon.TypeText(Lastname,"Bhate");
        DriverCommon.TypeText(zipcode,"60612");
        DriverCommon.TypeText(email,"ameyxxadcdcahulr09@gmail.com");
        DriverCommon.TypeText(password,"Suppu34$");
        //DriverCommon.click(SignUpButton);
        //DriverCommon.ThreadSleep(6);

    }




}
