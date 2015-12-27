package guru99Project.tests;

import guru99Project.pageObjects.Home;
import guru99Project.pageObjects.LoginPage;
import lib.ReadExcelData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Login extends InitandExit {


    public void verifyLoginCorrectCredentials() {

        LoginPage loginPageObject = PageFactory.initElements(driver,
                LoginPage.class);
        loginPageObject.login(Util.USERNAME, Util.PASSWORD);

        Home homePageObject = PageFactory.initElements(driver, Home.class);
        String userName = homePageObject.getUserName();

        Assert.assertEquals(Util.USERNAME, userName);
    }

//Using data provider, getting data from the excel sheet and storing in a 2-D object
    @DataProvider(name = "usingExcel")
    public static Object[][] loginUsingExcel() {
        Object data[][];
        try {
            ReadExcelData excelData = new ReadExcelData(
                    "E:/Workspace/testing-all/Guru99-UsernamePassword.xlsx");
            data = excelData.readSheet(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        //return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

        return data;

    }

    @Test(dataProvider = "usingExcel", dataProviderClass = guru99Project.tests.Login.class)
    public void verifyLoginCredentialsUsingExcel(String userName,
                                                 String password) throws Exception {

        LoginPage loginPageObject = PageFactory.initElements(driver,
                LoginPage.class);
        loginPageObject.login(userName, password);
        Home homePageObject = PageFactory.initElements(driver, Home.class);

        //alert appears when credentials are incorrect.Get alert text and accept alert.
        try {
            Alert alt = driver.switchTo().alert();
            String alertText = alt.getText();

            alt.accept();

            if (alertText.contains(Util.ALERTTEXT)) {
                Assert.assertTrue(true, Util.ASSERTMESSAGEFORINCORRECTCRED);
            } else {
                Assert.assertTrue(false, Util.ASSERTNOALERTMESSAGE);

            }

        } catch (NoAlertPresentException e) {
            //when credentials are correct, verifying the username and taking screenshot.
        	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("E:\\Workspace\\testing-all\\screenshot.png"));
            String user = homePageObject.getUserName();
            Assert.assertEquals(Util.USERNAME, user);

        }


        //Assert.assertNotNull(, "Invalid Credentials");

        //Assert.assertTrue(name.equals(userName), "Invalid credentials");

    }

    

}
