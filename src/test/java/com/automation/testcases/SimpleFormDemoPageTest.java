package com.automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.SimpleFormDemoPage;

public class SimpleFormDemoPageTest 
{
	
	
	public static final Logger APP_LOGS=Logger.getLogger(SimpleFormDemoPageTest.class.getName());
	
	@Test(priority=1)
	public void validateSimpleInputFormPage()
	
	{	System.out.println();
		APP_LOGS.info("***TEST CASE : Verify_Navigation To Simple Form Demo Page***");
		SimpleFormDemoPage.clickInputForm();
		String URL = SimpleFormDemoPage.clickSimpleFormDemo();
		SimpleFormDemoPage.verifySimpleFormNavigation(URL, "This would be your first example to start with Selenium.");
		APP_LOGS.info("***END OF VERIFICATION OF NAVIGATION TO SIMPLE FORM DEMO PAGE***");
		System.out.println();
	}
	
	
	
	
	@Test(priority=2)
	public void validateSingleInputField()
	  {			
		System.out.println();
		APP_LOGS.info("***TEST CASE : Verify_Show message Button for Multiple Test data***");
		SimpleFormDemoPage.singleInputField("./Files/InputData.xlsx", "SingleEnterMessage");
		
		APP_LOGS.info("***END OF VALIDATING SINGLE INPUT FIELD TEST CASE WITH MULTIPLE INPUTS FROM EXCEL***");
		System.out.println();
	  }
	
	@Test(priority=3)
	public void validateTwoInputField()
	
	{
		System.out.println();
		APP_LOGS.info("***TEST CASE : Verify_Get Total Button for Multiple Test data***");
		SimpleFormDemoPage.twoInputFields("./Files/InputData.xlsx", "SumOfValid");
		
		APP_LOGS.info("***END OF VALIDATING TWO INPUT FIELDS TEST CASE WITH MULTIPLE INPUTS FROM EXCEL***");
		System.out.println();		
	}
	
	/*@AfterClass
	  public void after()
	  {
		  TestBase.destroy();
	  }
	
	@BeforeClass
		public void before() throws Throwable
		{
		TestBase.initialization();
		}*/
	
}
