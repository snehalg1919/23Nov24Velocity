package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage
{
  // 1.variables = WebElements
  // driver.findElement(By.xpath);
	
	//int a=10;
	
	@FindBy(xpath = "//div[text()='Male']") private WebElement gender;
	
  // 2.Constructors
	
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  // 3.Methods	
	
	public void ClickOnGender()
	{
		Reporter.log("clicking on gender", true);
		gender.click();
	}

}
