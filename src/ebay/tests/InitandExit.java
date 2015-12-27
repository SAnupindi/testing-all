package ebay.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ebay.Home;
import ebay.SignInorRegister;

public class InitandExit {

	WebDriver driver;

	@BeforeTest
	public void init() {
		driver = new FirefoxDriver();
		driver.get("http://www.ebay.com/");
	}

	@AfterTest
	public void exit() {
		driver.close();
		driver.quit();
	}

	public void login() {
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.clickSignInLink();

		// SignInorRegister signInpageDriver = new SignInorRegister(fDriver);
		SignInorRegister signInPage = PageFactory.initElements(driver,
				SignInorRegister.class);

		signInPage.enterEmail("sweety.user12@gmail.com");
		signInPage.enterPassword("sirisha12#");
		signInPage.clickSignInButton();
	}

	public void logOut() {
		Home homePage1 = PageFactory.initElements(driver, Home.class);
		homePage1.clickSignOut();

	}

}
