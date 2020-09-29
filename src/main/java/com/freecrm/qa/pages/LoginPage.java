package com.freecrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.testbase.TestBase;
import com.freecrm.qa.util.TestUtil;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInClick;

	@FindBy(xpath="//input[@id='email']")
	WebElement emailId;

	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;

	@FindBy(name = "SubmitLogin")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailCreate;

	@FindBy(name = "SubmitCreate")
	WebElement createAccount;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement yourLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitile() {
		// String loginTitle=driver.getTitle();
		// return loginTitle;
		return (driver.getTitle());

	}

	public boolean validateLoginImage() {
		// return(yourLogo.isDisplayed());
		boolean img = yourLogo.isDisplayed();
		return img;
	}

	public HomePage login(String userName, String passWord) {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		signInClick.click();
		emailId.sendKeys(userName);
		password.sendKeys(passWord);
		submitBtn.click();
		return new HomePage();

	}
}
