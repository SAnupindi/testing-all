package ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WishList {
	
	@FindBy(how=How.CSS, using="table[id^='v4-My_'] tbody tr:nth-child(1) td:nth-child(3)>div>div:nth-of-type(1)>a")
	WebElement wishListFirstItemText;
	
	public String getWishListFirstItemLinkText()
	{
		return wishListFirstItemText.getText();
	}

}
