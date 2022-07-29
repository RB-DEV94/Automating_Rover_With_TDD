package TestCases;

import Base.BaseDriver;
import PageObjects.RoverLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TabsValidation extends BaseDriver
{

    @Test
    public void TabsValidate() throws InterruptedException {
        RoverLandingPage rp=new RoverLandingPage();
        WebElement dd1=driver.findElement(By.xpath("//input[@id='element-id-2-element-id-4']"));
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", dd1);
        rp.ClickCatCheckBox();

        List<WebElement> allradiobuttons=rp.getAllradiobuttons();


        String[] radiobuttonNames=new String[] {"Boarding", "House Sitting", "Drop-In Visits"};
        //System.out.println(allradiobuttons.get(0).getText());
        int i=0;
        for(String str:radiobuttonNames)
        {

            //System.out.println(""+str+" & "+allradiobuttons.get(i).getText()+"");
            if(allradiobuttons.get(i).getText().equalsIgnoreCase(str) && allradiobuttons.size()==3)
            {
                System.out.println(str);

                Assert.assertTrue(true);
                if(i==2)
                {
                    System.out.println("all radio buttons are displayed correctly");
                }
                i++;
            }

            else
            {
                System.out.println("Radio Buttons not displayed correctly as expected for the service of a Cat");
                Assert.assertTrue(false);
            }
        }
    }
}
