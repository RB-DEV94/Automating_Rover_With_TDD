package TestCases;

import Base.BaseDriver;
import PageObjects.SignInPage;
import Utilities.ExcelDataReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignIn extends BaseDriver
{

    @Test(dataProvider="LoginData")
    public void SignInTest(String user,String pass) throws InterruptedException {

        SignInPage signin = new SignInPage();
        signin.doSignIn(user,pass);
        String matchedString=BaseDriver.driver.findElement(By.cssSelector("#logged-in-user-dropdown-menu")).getAttribute("aria-label");

        Assert.assertTrue(matchedString.contains("Logged in as"));

    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException
    {
        String path="/Users/rahulbhagwat/Downloads/RoverWebAutomation/src/main/resources/LoginData.xlsx";

        int rownum=ExcelDataReader.getRowCount(path, "Sheet1");
        int colcount= ExcelDataReader.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=ExcelDataReader.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }
}
