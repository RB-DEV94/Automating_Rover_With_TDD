package PageObjects;

import Base.BaseDriver;
import Utilities.DriverCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class RoverResultsPage extends BaseDriver
{


    List<WebElement> alllocations;

    List<WebElement> prices;


    public WebElement slider;

    public WebElement Sidebar;

    public String matchedString;


    public String getMatchedString()
    {
        Sidebar=driver.findElement(By.cssSelector("label[for='location-input-sidebar']"));
        matchedString= Sidebar.getText();
        return matchedString;
    }

    public WebElement getSlider()
    {
        return slider;

    }

    public List<WebElement> getAlllocations()
    {
        alllocations=driver.findElements(By.cssSelector(".InfoColumn__Location-qduboa-2.gJTzwa"));
        return alllocations;
    }
    public List<WebElement> getPrices()
    {
        prices=driver.findElements(By.cssSelector(".PriceAndFavoriteColumn__Price-sc-5y9bmw-3.hYSwMH"));
        return prices;
    }

    public void MoveSlider() throws InterruptedException {
        slider=driver.findElement(By.cssSelector("button[aria-label*='maximum']"));
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider,-40, 0).build();
        action.perform();
        DriverCommon.ThreadSleep(3);
    }
}



