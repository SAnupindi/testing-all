package eCommerceWebsite.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import eCommerceWebsite.tests.Util;

public class Mobile {
	@FindBy(how = How.CSS, using = "div[class='page-title category-title']>h1")
	WebElement pageTitle;

	@FindBy(how = How.CSS, using = "div[class='category-products']>div:nth-of-type(1)>div[class='sorter']>div>select")
	WebElement sortBySelect;

	@FindBy(how = How.CSS, using = "ul[class='products-grid products-grid--max-4-col first last odd']>li>a")
	List<WebElement> productList;

	// Product info div tags; get the name of the product from here and then the
	// corresponding price
	@FindBy(how = How.CSS, using = "div[class='product-info']")
	List<WebElement> productInfoDiv;
	
	@FindBy(how=How.LINK_TEXT, using =Util.EXPECTEDTITLEMOBILEPAGE)
	WebElement productLink;

	String price;

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void selectNameInSort() {
		Select dropdown = new Select(sortBySelect);
		dropdown.selectByVisibleText("Name");
	}

	// get values of title attribute of anchor tags in the list
	public ArrayList<String> getProductTitles() {
		ArrayList<String> titles = new ArrayList<String>();
		for (WebElement anchorTag : productList) {
			titles.add(anchorTag.getAttribute("title"));
		}

		return titles;
	}

	// get price of a product
	public String getPrice(String productName) {
		for (WebElement div : productInfoDiv) {
			// get anchor tag attribute title
			String anchortagTitle = div.findElement(By.cssSelector("h2>a"))
					.getAttribute("title");
			if (anchortagTitle.equals(productName)) {
				price = div
						.findElement(
								By.cssSelector("div[class='price-box']>span[class='regular-price']>span"))
						.getText();
				break;
			}

		}

		return price;
	}

	// click on a product
	public void clickProduct() {
		
		productLink.click();
		

	}

}
