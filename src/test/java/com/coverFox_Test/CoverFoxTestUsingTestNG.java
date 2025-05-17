package com.coverFox_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.coverFox_Base.Base;
import com.coverFox_POM.CoverFoxAddressDetailsPage;
import com.coverFox_POM.CoverFoxHealthPlanPage;
import com.coverFox_POM.CoverFoxHomePage;
import com.coverFox_POM.CoverFoxMemberDetailsPage;
import com.coverFox_POM.CoverFoxResultPage;
import com.coverFox_Utility.Utility;


//@Listeners(com.coverFox_Listener.Listener.class)
public class CoverFoxTestUsingTestNG extends Base{
	
	public static Logger logger;
	
	CoverFoxHomePage coverFoxHomePage;
	CoverFoxHealthPlanPage coverFoxHealthPlanPage;
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage;
	CoverFoxAddressDetailsPage coverFoxAddressDetailsPage;
	CoverFoxResultPage coverFoxResultPage;
	
  @BeforeClass
  public void launchBrowser() throws EncryptedDocumentException, IOException
  {
	  logger= Logger.getLogger("23rdNov24_CoverFox");
	  PropertyConfigurator.configure("log4j.properties");
	  logger.info("Welcome to the CoverFox");
	  
	  openBrowser();
	  logger.warn("launching browser");
	  coverFoxHomePage = new CoverFoxHomePage(driver);
	  coverFoxHealthPlanPage = new CoverFoxHealthPlanPage(driver);
	  coverFoxMemberDetailsPage = new CoverFoxMemberDetailsPage(driver);
	  coverFoxAddressDetailsPage = new CoverFoxAddressDetailsPage(driver);
	  coverFoxResultPage = new CoverFoxResultPage(driver);
  }
  
  @BeforeMethod
  public void coverFoxPreconditions() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  coverFoxHomePage.ClickOnGender();
	  logger.info("Clicking on Gender");
	  coverFoxHealthPlanPage.ClickOnNextButtonHealthPlanPage();
	  logger.info("Clicking on Next Button of Health Plan Page");
	  coverFoxMemberDetailsPage.HandleAgeDropDown(Utility.readDataFromExcel("Sheet1", 1, 0));
	  logger.info("Handleing Age DropDown");
	  coverFoxMemberDetailsPage.ClickOnNextButtonOfMemberDetailsPage();
	  logger.info("Clicking on Next Button of Members Details Page");
	  coverFoxAddressDetailsPage.enterPinCode(Utility.readDataFromExcel("Sheet1", 1, 1));
	  logger.info("Entering PinCode");
	  coverFoxAddressDetailsPage.enterMobileNumber(Utility.readDataFromExcel("Sheet1", 1, 2));
	  logger.info("Entering Mobile_No.");
	  coverFoxAddressDetailsPage.ClickOnContinueButtonOnAddressDetailsPage();
	  logger.info("Clicking on Next Button of Address Details Page");
	  
	  Thread.sleep(5000);
  }
  @Test
  public void validateCoverFoxPlans() throws IOException 
  {
	  
	 // Assert.fail();
	  int planNumberFromText = coverFoxResultPage.getPlanNumberFromText();
	  int planNumberFromCards = coverFoxResultPage.getPlanNumberFromPlanCards();
	 
	  Assert.assertEquals(planNumberFromText, planNumberFromCards,"TC failed,numbers are not matching");
	  Reporter.log("Plan numbers are matching TC passed", true);
	 // Utility.takeScreenshot(driver, "validateCoverFoxPlans");
	  
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException
  {
	 closeBrowserWindow();
	 logger.info("Closing Browser");
  }
  
}
