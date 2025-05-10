package com.coverFox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage 
{
	@FindBy(xpath = "//div[contains(text(),'matching')]") private WebElement planResult;
	@FindBy(className = "plan-card-container") private List<WebElement>planCards;

	public CoverFoxResultPage(WebDriver driver)
	{
	   PageFactory.initElements(driver, this);
	}

	public void validatePlans() throws InterruptedException
	{
	   String result = planResult.getText();
	   String[] result1 = result.split(" ");
	
	//48 matching Health Insurance Plans
	
	int resultInNumber = Integer.parseInt(result1[0]);
	Thread.sleep(8000);
	int totalPlans = planCards.size();
	
	if(totalPlans==resultInNumber)
	{
	System.out.println("TC is passed");
	}
	else {
	System.out.println("TC is failed");
	}
}
	
	public int getPlanNumberFromText()
  	{
                 	Reporter.log("getting plan number from text", true);
                 	String result = planResult.getText();
                 	String[] result1 = result.split(" ");
                 	int planNumber = Integer.parseInt(result1[0]);
                 	return planNumber;
  	}
  	
  	public int getPlanNumberFromPlanCards()
  	{
                 	Reporter.log("getting plan number from plan cards", true);
                 	int planNumberFromCards = planCards.size();
                 	return planNumberFromCards;
  	}
  	
}

	

