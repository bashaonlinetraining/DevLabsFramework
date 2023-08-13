package com.nopecommerce.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nopecommerce.datadrivers.ReadPropertyFile;
import com.nopecommerce.pages.HomePage;
import com.nopecommerce.pages.LoginPage;
import com.nopecommerce.seleniumdrivers.WebElementActions;
import org.testng.*;

public class LoginFeature {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = BaseTest.lauchBrowser("chrome", ReadPropertyFile.readData("url"));
	}

	@Test
	public void logintestcase_1001() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.clickLoginLink();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(ReadPropertyFile.readData("email1"), ReadPropertyFile.readData("password1"));
		Assert.assertEquals(WebElementActions.getTextOfElement(loginPage.errorMsg, ""),
				"Login was unsuccessful. Please correct the errors and try again. \nNo customer account found");
	}
	
	@Test
	public void logintestcase_1002() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.clickLoginLink();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.recoverCredentails(ReadPropertyFile.readData("email1"));
				
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
