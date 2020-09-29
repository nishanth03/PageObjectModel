package com.freecrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.WomensPage;
import com.freecrm.qa.testbase.TestBase;
import com.freecrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	WomensPage womensPage;
	String sheetName = "addAddress";

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		womensPage = new WomensPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageTitleTest() throws Exception {
		String homePageTitle = homePage.validateHomePageTitle();
		TestUtil.takeScreenshot(homePageTitle);
		Assert.assertEquals(homePageTitle, "My account - My Store", "Home Page Title not matched");
	}

	@Test(priority = 2)
	public void AccountNameLabelTest() {
		boolean flag = homePage.validateAccountNameLabel();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void clickOnWomensLink() {
		womensPage = homePage.clickOnWomenLink();

	}

	@DataProvider
	public Object[][] getAddressTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 4, dataProvider = "getAddressTestData")
	public void addNewAddress(String firstName, String lastName, String address, String city, String postalCode,
			String homePhoneNo, String mobNo, String aliasAddress) {
		homePage.clickOnAccountNameLink();
		homePage.clickOnMyAddress();
		homePage.clickOnAddNewAddress(firstName, lastName, address, city, postalCode, homePhoneNo, mobNo, aliasAddress);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
