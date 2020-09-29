package com.freecrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.testbase.TestBase;
import com.freecrm.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Nish C')]")
	WebElement accountNameLabel;

	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement womenLink;

	@FindBy(linkText = "Dresses")
	WebElement dressesLink;

	@FindBy(linkText = "T-shirts")
	WebElement tshirstLink;
	
	@FindBy(xpath="//span[contains(text(),'My addresses')]")
	WebElement myAddressBtn;
	
	@FindBy(xpath="//span[contains(text(),'Add a new address')]")
	WebElement addNewAddressBtn;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement postalCode;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement homePhoneNo;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobNo;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement aliasAddress;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement saveBtn;
	
	
	
	
		public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return driver.getTitle();
	}

	public boolean validateAccountNameLabel() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return accountNameLabel.isDisplayed();
	}

	public WomensPage clickOnWomenLink() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		womenLink.click();
		return new WomensPage();
	}

	public DressesPage clickOnDressesLink() {
		dressesLink.click();
		return new DressesPage();
	}

	public TShirtsPage clickOnTShirtsLink() {
		tshirstLink.click();
		return new TShirtsPage();
	}

	
	public void clickOnAccountNameLink() {
		accountNameLabel.click();
	}
	
	public void clickOnMyAddress() {
		myAddressBtn.click();
	}
	
	public void clickOnAddNewAddress(String ftName, String ltName, String add, String cityName, String postCode, String homNo, String moNo, String addReference) {
		addNewAddressBtn.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		address.sendKeys(add);
		city.sendKeys(cityName);
		Select select=new Select(driver.findElement(By.name("State")));
		select.selectByVisibleText("Alabama");
		postalCode.sendKeys(postCode);
		homePhoneNo.sendKeys(homNo);
		mobNo.sendKeys(moNo);
		aliasAddress.sendKeys(addReference);
		saveBtn.click();
			
		
	}
	
}
