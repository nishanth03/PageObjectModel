package com.freecrm.qa.pages;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.testbase.TestBase;
import com.freecrm.qa.util.TestUtil;

public class WomensPage extends TestBase {
	
	@FindBy(xpath="//span[@class='navigation_page']")
	WebElement womensPagelabel;
	
	@FindBy(xpath="//input[@id='layered_category_4']")
	WebElement topsCategory;
	
	@FindBy(xpath="//input[@id='layered_category_8']")
	WebElement dressesCategory;
	
	public WomensPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateWomensPageTitle() {
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return driver.getTitle();
	}
	
	public boolean validateWomensPagelabel() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return womensPagelabel.isDisplayed();
	}
	
	public void selectWomensCategoriesByTops() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		topsCategory.click();
		
	}
	
	public void selectWomensCategoriesByDresses() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		dressesCategory.click();
		
	}
	
	

}
