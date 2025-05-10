package com.coverFox_Listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.coverFox_Base.Base;
import com.coverFox_Utility.Utility;



public class Listener extends Base implements ITestListener
{
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("Test "+result.getName()+" is Success" , true);
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		Reporter.log("Test "+result.getName()+" is failed", true);
		try {
			Utility.takeScreenshot(driver, "FailedTCScreenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
