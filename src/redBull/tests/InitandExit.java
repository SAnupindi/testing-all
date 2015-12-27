package redBull.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class InitandExit {
	WebDriver driver;

	@BeforeTest
	public void init() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Search"))));
		
	}

	@AfterTest
	public void exit() {
		driver.close();
		driver.quit();
	}


}
