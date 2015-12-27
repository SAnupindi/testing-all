package guru99Project.tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class InitandExit {

	WebDriver driver;

	@BeforeMethod
	public void init() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile(Util.FIREFOXPROFILE);
		driver = new FirefoxDriver(new FirefoxBinary(new File(Util.FIREFOXPATH)), myProfile);
		driver.get(Util.PAGEURL);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void exit() {
		driver.close();
		driver.quit();
	}

}
