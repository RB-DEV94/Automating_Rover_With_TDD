package PageObjects;

import Base.BaseDriver;
import Utilities.DriverCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class RoverLandingPage extends BaseDriver
{

    public RoverLandingPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
    @FindBy(xpath="//a[contains(text(),'Sign Up')]")
    public static WebElement SignUpLink;

    @FindBy(xpath="//a[contains(text(),'Sign In')]")
    public static WebElement SingInLink;

    @FindBy(xpath="//input[@id='element-id-2-element-id-4']")
            public static WebElement Dog_Checkbox;

    @FindBy(xpath="//input[@id='element-id-1-element-id-5']")
    public static WebElement Cat_Checkbox;

    @FindBy(css="input[aria-label='House Sitting']")
    public static WebElement HouseSitting_Tab;

    @FindBy(css="input[placeholder*='Zip code']")
    public static WebElement zipcode;

    @FindBy(css="input[id='element-id-15']")
    public static WebElement DateFrom;

    @FindBy(css="input[id='element-id-16']")
    public static WebElement DateTo;

    @FindBy(css="input[aria-label='Medium (16 to 40 lbs)']")
    public static WebElement SizeofDog;

    public  String zipcodedata;

    @FindBy(css=".sc-bdfBwQ.bbwRep")
    public static WebElement SearchButton;


    List<WebElement> allradiobuttons;


    public void clickSearchButton()
    {
        DriverCommon.click(SearchButton);
    }
    public  void EnterDate(String From,String To)
    {
        DriverCommon.TypeText(DateFrom,From);
        DriverCommon.TypeText(DateTo,To+ Keys.ENTER);
    }

    public static void ClickMedium() throws InterruptedException {
        if (!DriverCommon.isSelected(SizeofDog)) {
            DriverCommon.JSClick(SizeofDog);
        }
    }

    public  void EnterZipcode(String zip)
    {
        this.zipcodedata=zip;
        DriverCommon.TypeText(zipcode,zipcodedata);
    }
    public String getZipcodedata()
    {
        return zipcodedata;
    }
    public static WebElement getSingInLink()
    {
        return SingInLink;
    }
    public static void ClickSignUp()
    {
        DriverCommon.click(SignUpLink);
    }
    public static void ClickSignIn()
    {
        DriverCommon.click(SingInLink);
    }

    public static void ClickDogCheckBox() throws InterruptedException {
        if (!DriverCommon.isSelected(Dog_Checkbox)) {
            DriverCommon.JSClick(Dog_Checkbox);
        }
    }
    public static void ClickCatCheckBox() throws InterruptedException {
        if (!DriverCommon.isSelected(Cat_Checkbox)) {
            DriverCommon.JSClick(Cat_Checkbox);
        }
    }
    public static void ClickHouseSittingTab() throws InterruptedException {
        if (!DriverCommon.isSelected(HouseSitting_Tab)) {
            DriverCommon.JSClick(HouseSitting_Tab);
        }
    }

    public List<WebElement> getAllradiobuttons()
    {
        allradiobuttons= driver.findElements(By.cssSelector(".SelectButton__Title-sc-16fa4qq-5.dVYDPn"));
        return allradiobuttons;
    }


}
