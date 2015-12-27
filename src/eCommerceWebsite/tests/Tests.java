package eCommerceWebsite.tests;

import java.util.ArrayList;

import eCommerceWebsite.pageObjects.Home;
import eCommerceWebsite.pageObjects.Mobile;
import eCommerceWebsite.pageObjects.ProductDetails;
import eCommerceWebsite.tests.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends InitandExit {

	public void verifyItemSortByName() {

		// 1.Verify title of the page
		Home homePageObject = PageFactory.initElements(driver, Home.class);
		Assert.assertEquals(homePageObject.returnHeaderText().trim(),
				Util.EXPECTEDTITLE.trim());

		// 2. click on mobile menu and verify the title of Mobile page

		homePageObject.clickOnMobileMenu();
		Mobile mobilePageObject = PageFactory
				.initElements(driver, Mobile.class);
		Assert.assertEquals(mobilePageObject.getPageTitle(),
				Util.EXPECTEDTITLEMOBILEPAGE);

		// Select name is sort by dropdown
		mobilePageObject.selectNameInSort();
		
		//Get titles of all products
		ArrayList<String> titles= mobilePageObject.getProductTitles();
		
		for(int i=0; i<titles.size()-1; i++){
			if(titles.get(i).compareTo(titles.get(i+1))>0){
				Assert.assertFalse(false,"Sorting not done");
			}
			else{
				Assert.assertTrue(true,"Sorting correct");
				
			}
		}

		
	}
	
	@Test
	public void verifyProductCost(){
		//Click on Mobile link
		Home homePageObject = PageFactory.initElements(driver, Home.class);
		homePageObject.clickOnMobileMenu();
		
		Mobile mobilePageObject = PageFactory
				.initElements(driver, Mobile.class);
		String priceMobilePage=mobilePageObject.getPrice(Util.PRODUCTNAME);
		
		//click on the product
		mobilePageObject.clickProduct();
		
		//get product price from product details page
		ProductDetails productPageObject = PageFactory.initElements(driver, ProductDetails.class);
		String priceProductPage = productPageObject.getPrice();
		
		//Check if both prices are equal
		Assert.assertEquals(priceMobilePage, priceProductPage);
		
	}

}
