package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInorRegister {

	WebDriver driver;

	public SignInorRegister(WebDriver driver) {
		this.driver = driver;
	}

	// Web elements

	/*
	 * By ebayLogo = By.id(PageAttributes.SignInPage.EbayLogoId); By signInLink
	 * = By.linkText(PageAttributes.SignInPage.SignInLinkText); By commentsLink
	 * = By.id(PageAttributes.SignInPage.CommentsLinkId); By emailTextbox =
	 * By.id(PageAttributes.SignInPage.EmailTextboxId); By passwordTextBox =
	 * By.id(PageAttributes.SignInPage.PasswordTextboxId); By signInButton =
	 * By.id(PageAttributes.SignInPage.SignInButtonId); By staySignedInCheckbox
	 * = By .id(PageAttributes.SignInPage.StaySignedInCheckboxId); By
	 * forgotPasswordLink = By
	 * .id(PageAttributes.SignInPage.ForgotPasswordLinkId); By learnMoreLink =
	 * By.id(PageAttributes.SignInPage.LearnMoreLinkID); /
	 */

	@FindBy(how = How.ID, using = "userid")
	WebElement emailTextbox;

	@FindBy(how = How.ID, using = "pass")
	WebElement passwordTextBox;

	@FindBy(how = How.ID, using = "sgnBt")
	WebElement submitButton;

	// Actions on web elements
	public void enterEmail(String email) {
		emailTextbox.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void clickSignInButton() {
		submitButton.click();
	}

}