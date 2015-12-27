package guru99Project.pageObjects;

import lib.ReadExcelData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.DataProvider;

/**
 * Created by siri on 12/12/2015.
 */
public class LoginPage {

        @FindBy(how = How.NAME, using = "uid")
        WebElement userNameTextBox;

        @FindBy(how = How.NAME, using = "password")
        WebElement passwordTextBox;

        @FindBy(how = How.NAME, using = "btnLogin")
        WebElement loginButton;

        public void login(String userName, String pass) {
            userNameTextBox.sendKeys(userName);
            passwordTextBox.sendKeys(pass);
            loginButton.click();
        }





}
