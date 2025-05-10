package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage 
{

	@FindBy(className = "mp-input-text")private WebElement pinCodeField;
	@FindBy(id = "want-expert")private WebElement mobileNumberField;
	@FindBy(xpath = "//div[text()='Continue']") private WebElement continueButton;
	
	public CoverFoxAddressDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPinCode(String pincode)
	{
		Reporter.log("entering PinCode", true);
		pinCodeField.sendKeys(pincode);
	}
	
	public void enterMobileNumber(String mobileNumber)
	{
		Reporter.log("entering MobileNum", true);
		mobileNumberField.sendKeys(mobileNumber);
	}
	
	public void ClickOnContinueButtonOnAddressDetailsPage()
	{
		Reporter.log("clicking On Continue Button", true);
		continueButton.click();
	}
	
	
}
