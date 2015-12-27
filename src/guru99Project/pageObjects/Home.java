package guru99Project.pageObjects;

import lib.ReadExcelData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.DataProvider;

public class Home {

	@FindBy(how = How.CSS, using = "table[class='layout']>tbody>tr>td>table>tbody>tr:nth-of-type(3)>td")
	WebElement userName;

	public String getUserName() {
	String managerID= userName.getText().substring(userName.getText().lastIndexOf(':')+2).trim();
	
	return managerID;
	}


}
