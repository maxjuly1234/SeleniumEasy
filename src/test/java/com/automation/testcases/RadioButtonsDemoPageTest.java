package com.automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.RadioButtonsDemoPage;

public class RadioButtonsDemoPageTest extends TestBase

{
	public static final Logger APP_LOGS=Logger.getLogger(RadioButtonsDemoPageTest.class.getName());
	
	@Test(priority=1)
	public static void validateRadioButtonsDemoPage()
	{
		System.out.println();
		APP_LOGS.info("***TEST CASE : Verify_Navigation To Radio Buttons Demo Page***");
		RadioButtonsDemoPage.clickInputForm();
		String URL = RadioButtonsDemoPage.clickRadioButtonsDemo();
		RadioButtonsDemoPage.verifyRadioBtnDemoNavigation(URL, "This is again simple example to start working with radio buttons using Selenium.");
		APP_LOGS.info("***END OF VERIFICATION OF NAVIGATION TO RADIO BUTTONS DEMO PAGE***");
		System.out.println();
	}
	
	@Test(priority=2)
	public static void validateSingleRadioBtnSelection()
	  {			
		System.out.println();
		APP_LOGS.info("***TEST CASE : Verify_GET CHECKED VALUE Button for Multiple Test data***");
		RadioButtonsDemoPage.clickInputForm();
		String URL = RadioButtonsDemoPage.clickRadioButtonsDemo();
		RadioButtonsDemoPage.verifyRadioBtnDemoNavigation(URL, "This is again simple example to start working with radio buttons using Selenium.");
		RadioButtonsDemoPage.genderSelection("./File/InputData.xlsx", "SingleRadioBtn");
		
		APP_LOGS.info("***END OF VALIDATING SINGLE RADIO BUTTON TEST CASE WITH MULTIPLE INPUTS FROM EXCEL***");
		System.out.println();
	  }
	
	@Test(priority=3)
	public static void validateGroupRadioBtnSelection()
	  {			
		System.out.println();
		APP_LOGS.info("***TEST CASE : Verify_GET VALUES Button for Multiple Test data***");
		RadioButtonsDemoPage.clickInputForm();
		String URL = RadioButtonsDemoPage.clickRadioButtonsDemo();
		RadioButtonsDemoPage.verifyRadioBtnDemoNavigation(URL, "This is again simple example to start working with radio buttons using Selenium.");
		RadioButtonsDemoPage.groupRadioSelection("./File/InputData.xlsx", "DoubleRadioBtn");
		
		APP_LOGS.info("***END OF VALIDATING GROUP RADIO BUTTON TEST CASE WITH MULTIPLE INPUTS FROM EXCEL***");
		System.out.println();
	  }
/*	@AfterClass
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
