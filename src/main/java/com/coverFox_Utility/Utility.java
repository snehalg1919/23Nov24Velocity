package com.coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	//ReadDataFromExcel
	
  public static String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
  {
	  FileInputStream myFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\23Nov2024.xlsx");
	  Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
	  String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
	  Reporter.log("reading data from excel", true);
	  return data;
	  
  }
  
  //TakeScreenShot
  
  public static void takeScreenshot(WebDriver driver, String screenShotName) throws IOException
  {
	  File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File desc=new File(System.getProperty("user.dir")+"\\screenshot"+screenShotName+".png");
	  FileHandler.copy(scr, desc);
	  Reporter.log("taking screenshot, saved at"+desc, true);
  }
  
  //ScrollIntoView
  
  public static void scrollIntoView(WebDriver driver,WebElement element)
  {
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true)", element);
	  Reporter.log("scrolling into view", true);
  }
  
  //Properties files
  public static String readDataFromPropertiesFile(String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream myFile= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\coverFox.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("reading "+key+ " from properties file", true);
		
		return value;
	}
  
  //wait for some time
  public void imlicitwait(WebDriver driver,int timeInMiliSec)
  {
	  Reporter.log("waiting for",true);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeInMiliSec));
	  
  }
  //send keys
  
  public void sendkeys(WebElement element, String text)
  {
	  element.sendKeys(text);
  }

}
