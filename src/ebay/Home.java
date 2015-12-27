package ebay;

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

	// Header
	By signInLink = By.linkText(PageAttributes.HomePage.SignInLinkText);
	By registerLink = By.linkText(PageAttributes.HomePage.RegisterLinkText);
	// dailyDealsLink = By.id(PageAttributes.HomePage.DailyDealsId);
	By giftCardsLink = By.id(PageAttributes.HomePage.GiftCardsLinkId);
	By sellLink = By.id(PageAttributes.HomePage.SellLinkId);
	By helpContactLink = By.id(PageAttributes.HomePage.HelpContactId);
	By userNameLink = By.id(PageAttributes.HomePage.userNameLinkId);
	
	@FindBy(how=How.CSS,using="a[id='gh-ug']>b:nth-of-type(1)")
	WebElement user;
	
	@FindBy(how=How.LINK_TEXT,using="Daily Deals")
	WebElement dailyDealsLink;
	
	@FindBy(how=How.LINK_TEXT,using="My eBay")
	WebElement myEbayLink;

	@FindBy(how=How.ID,using="gh-la")
	WebElement ebayImageLInk;
	
	@FindBy(how=How.LINK_TEXT, using="Sign out")
	WebElement signOutLink;
	
	@FindBy(how=How.LINK_TEXT,using="Wish list")
	WebElement wishListLink;
	
	public void clickSignInLink() {
		driver.findElement(signInLink).click();
	}
	
	public String getUserName(){
		return user.getText();
		
	}
	
	public void clickDailyDealsLink()
	{
		dailyDealsLink.click();
	}
	
	public void clickWishListLink()
	{
		myEbayLink.click();
		wishListLink.click();
	}
	
	public void clickEbayImage(){
		ebayImageLInk.click();
	}
	
	public void clickSignOut(){
		user.click();
		signOutLink.click();
	}

}
