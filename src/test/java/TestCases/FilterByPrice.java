package TestCases;

import Base.BaseDriver;
import PageObjects.RoverLandingPage;
import PageObjects.RoverResultsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FilterByPrice
{
    @Test
    public void FilterByThePrice() throws InterruptedException {

        RoverResultsPage rp=new RoverResultsPage();

        rp.MoveSlider();

        WebElement slider=rp.getSlider();
        int maxval= Integer.parseInt(slider.getAttribute("aria-valuenow"));
        System.out.println(maxval);

        List<WebElement> prices= rp.getPrices();


        Integer priceArray[] = new Integer[prices.size()];

        for (int i = 0; i < prices.size(); i++) {
            String strNew = prices.get(i).getText().replace("$", "");
            priceArray[i] = Integer.parseInt(strNew);
            System.out.println( priceArray[i]);
        }

        for(int price: priceArray)
        {
            if(price<=maxval)
            {
                Assert.assertTrue(true);
            }
            else
            {
                System.out.println("Price filter not applied correctly");
                Assert.assertTrue(false);
            }
        }

    }
}
