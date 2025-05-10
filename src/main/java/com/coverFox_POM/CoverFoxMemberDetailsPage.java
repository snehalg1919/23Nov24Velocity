package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage 
{

	//1.Variables-- WebElement
	
	@FindBy(name = "You") private WebElement ageDropDown;
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	//2.Constructor
	
	public CoverFoxMemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3.Methods
	
	public void HandleAgeDropDown(String age)
	{
		Reporter.log("handeling age drop down", true);
		Select selectAge=new Select(ageDropDown);
		selectAge.selectByValue(age+"y");
	}
	
	public void ClickOnNextButtonOfMemberDetailsPage()
	{
		Reporter.log("clicking On NextButton Of MemberDetails Page", true);
        nextButton.click();
	}
	
}
