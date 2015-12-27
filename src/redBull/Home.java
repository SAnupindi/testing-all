package redBull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home {

	WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	WebElement calenderControlLink;

	// Get all column values
	List<WebElement> dates = driver.findElements(By
			.xpath("//div[@id='rbcal_txtOnwardCalendar']/table[1]/tbody//td"));

	public void clickDate(String month, String date) {
		// click on the calender to view it

		calenderControlLink.click();
		for (int i = 0; i < dates.size(); i++) {

			if (dates.get(i).getText().trim().equals(date)) {
				dates.get(i).click();
				break;
			}
		}

	}

}
