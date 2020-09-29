package com.freecrm.qa.testbase;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.qa.util.TestUtil;
import com.freecrm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
		
	
	public TestBase() {
		
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Nishanth\\TestAutomation_Selenium\\freecrmtest\\src\\main"
				+"\\java\\com\\freecrm\\qa\\confg\\config.properties");
		
		prop.load(ip);
		
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e) {
		e.printStackTrace();
	}
		
	}
	public static void initialization() {
		String browserName = prop.getProperty("browser"); 
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Nishanth\\TestAutomation_Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Nishanth\\TestAutomation_Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
		

}

