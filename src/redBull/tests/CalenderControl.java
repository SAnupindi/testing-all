package redBull.tests;

import org.testng.annotations.Test;

import redBull.Home;
public class CalenderControl extends redBull.tests.InitandExit {
	
	@Test
	public void clickADate()
	{
		Home homePageObject= new Home(driver);
		homePageObject.clickDate("Dec", "20");
		
		
	}

}
