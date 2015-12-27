package ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuyItem {

	@FindBy(how = How.CSS, using = "span[id='atl_arr']")
	WebElement addToWishListDropdown;

	@FindBy(how = How.ID, using = "itemTitle")
	WebElement titleLink;

	@FindBy(how = How.CSS, using = "div#atl_drpdwnListId>ul>li:nth-of-type(2)")
	WebElement addToWishListLink;
	
	@FindBy(how=How.LINK_TEXT, using ="Add to Wish list")
	WebElement addToListLink;

	public void clickAddToWishListLink() {
		addToWishListDropdown.click();
		addToListLink.click();
	}

	public String getTitle() {
		return titleLink.getText();

	}
}
