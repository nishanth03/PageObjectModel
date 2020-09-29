package com.freecrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.qa.testbase.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=35;
	public static long IMPLICIT_WAIT=35;
	
	public static String TEST_DATA_SHEET_PATH = "D:\\Nishanth\\TestAutomation_Selenium\\freecrmtest\\src\\main\\java\\com\\freecrm\\qa\\testdata\\AddAddressTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file = null;
		try{
			file = new FileInputStream(TEST_DATA_SHEET_PATH);
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(file);
			}
		catch(InvalidFormatException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				
				//data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				data[i][k]=new DataFormatter().formatCellValue(sheet.getRow(i+1).getCell(k));
		}
	}
		 return data;
	}
	
public static void takeScreenshot(String fileName) throws IOException
	
	{
		//1.Take screenshot and store it as file format
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Path src = srcfile.toPath();
		File destFile=new File("D:\\Nishanth\\TestAutomation_Selenium\\freecrmtest\\src\\main\\java\\com\\freecrm\\qa\\testdata\\"+fileName+".jpg");
		//Path dest = destFile.toPath();
		//2.Copy the screenshot to desired location using copyfile method
		//Files.copy(file, new File("C://Automation//AutomationWorkSpace//newTours&Travels//testData"+fileName+".pdf"));
	    //Files.copy(srcfile.toPath(), destFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
		Files.copy(srcFile, destFile);
		
	}
	
	
		
}
