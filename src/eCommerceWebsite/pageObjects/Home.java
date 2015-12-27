package eCommerceWebsite.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import eCommerceWebsite.tests.Util;

public class Home {

	@FindBy(how = How.CSS, using = "h2")
	WebElement header;

	@FindBy(how = How.LINK_TEXT, using = Util.EXPECTEDTITLEMOBILEPAGE)
	WebElement mobileLink;

	public String returnHeaderText() {
		return header.getText();
	}

	public void clickOnMobileMenu() {
		mobileLink.click();
	}

}
