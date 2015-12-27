package ebay.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ebay.Home;
import ebay.SignInorRegister;

public class Login extends InitandExit {
	@Test(priority=1)
	public void LoginWithCorrectCredentials() {

		/*
		 * Home homeDriver = new Home(fDriver); homeDriver.clickSignInLink();
		 */

		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.clickSignInLink();

		// SignInorRegister signInpageDriver = new SignInorRegister(fDriver);
		SignInorRegister signInPage = PageFactory.initElements(driver,
				SignInorRegister.class);

		signInPage.enterEmail("sweety.user12@gmail.com");
		signInPage.enterPassword("sirisha12#");
		signInPage.clickSignInButton();

		String userName = homePage.getUserName();
		Assert.assertTrue(userName.equals("Sweety"));
		
		homePage.clickSignOut();
		
	}
}
