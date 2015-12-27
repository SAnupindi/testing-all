package ebay.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import ebay.BuyItem;
import ebay.DailyDeals;
import ebay.Home;
import ebay.WishList;

public class CreateWishList extends InitandExit {

	@Test
	public void addItemToWishList() {

		String titleOfPickOfTheday, wishListFirstItemTitle;

		driver.manage().window().maximize();

		login();

		// Click on daily deals link
		Home homePageObject = PageFactory.initElements(driver, Home.class);
		homePageObject.clickDailyDealsLink();

		// Click on the pick of the day title
		DailyDeals dailyDealsPageObject = PageFactory.initElements(driver,
				DailyDeals.class);
		dailyDealsPageObject.clickPickOfTheDayTitle();

		// add pick of the day to wish list
		BuyItem buyItemObject = PageFactory.initElements(driver, BuyItem.class);
		titleOfPickOfTheday = buyItemObject.getTitle();
		buyItemObject.clickAddToWishListLink();

		// Click on ebay image to go to home page
		homePageObject.clickEbayImage();

		// click on myEbay link -> wishlist
		homePageObject.clickWishListLink();

		// Check if item is added to link list
		WishList wishListPageObject = PageFactory.initElements(driver,
				WishList.class);
		wishListFirstItemTitle = wishListPageObject
				.getWishListFirstItemLinkText();

		Assert.assertEquals(titleOfPickOfTheday.trim(),
				wishListFirstItemTitle.trim());

		logOut();

	}

}
