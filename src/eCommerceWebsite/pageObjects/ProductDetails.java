package eCommerceWebsite.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetails {
	
	@FindBy(how=How.CSS, using ="span[id='product-price-1']>span")
	WebElement priceText;
	
	public String getPrice(){
		return priceText.getText();
	}

}
