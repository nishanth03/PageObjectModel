package com.freecrm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.testbase.TestBase;
import com.freecrm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() throws IOException {
		String actualloginTitle = loginPage.validateLoginPageTitile();
		TestUtil.takeScreenshot("loginTitle");
		Assert.assertEquals(actualloginTitle, "My Store");
	}

	@Test(priority = 2)
	public void loginLogoTest() {
		boolean flag = loginPage.validateLoginImage();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void login() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void teaDown() {
		driver.quit();

	}

}
