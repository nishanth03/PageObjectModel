package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.WomensPage;
import com.freecrm.qa.testbase.TestBase;


public class WomensPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	WomensPage womensPage;
	
	public WomensPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		womensPage = new WomensPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		womensPage = homePage.clickOnWomenLink();
	}
	
	
	  @Test(priority=1) 
	  public void womensPageTitleTest() { 
	  String womensTitle=womensPage.validateWomensPageTitle();
	  Assert.assertEquals(womensTitle, "Women - My Store", "Womens Page Title not matched");
	  
	  }
	 
	
	
	/*
	 * @Test(priority=2) public void womensPageLabelTest() {
	 * Assert.assertTrue(womensPage.validateWomensPagelabel()); }
	 */
	  
	/*
	 * @Test(priority=3) public void selectWomensPageCategoryByTops() {
	 * womensPage.selectWomensCategoriesByTops(); }
	 */
	  
	/*
	 * @Test(priority=4) public void selectWomensPageCategoryByDresses() {
	 * womensPage.selectWomensCategoriesByDresses(); }
	 */
	 
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
