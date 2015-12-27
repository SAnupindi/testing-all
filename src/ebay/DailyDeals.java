package ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DailyDeals {
	
	@FindBy(how=How.CSS,using="div#w3>div:nth-of-type(1)>div>div:nth-of-type(2)>h3>a")
	WebElement pickOftheDayTitle;

	public void clickPickOfTheDayTitle()
	{
		pickOftheDayTitle.click();
	}
}
