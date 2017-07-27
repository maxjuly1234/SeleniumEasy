package com.automation.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.MainClass;
import com.automation.pageobjects.JQueryDatePickerPage;

public class JQueryDatePickerPageTest extends TestBase {

	public static final Logger APP_LOGS=Logger.getLogger(JQueryDatePickerPageTest.class.getName());
	
	String pageName = "MainJQueryDatePickerPage";
	JQueryDatePickerPage mainjquerydatepicker;
	

	@Test(priority=1)
	public void before() throws Throwable
	{
		//initialization();
		mainjquerydatepicker = PageFactory.initElements(driver, JQueryDatePickerPage.class);
		mainjquerydatepicker.NavigateToSeleniumEasyTest();
		extentReport(pageName);
		System.out.println("Page Object created");
		
	}
	
	@Test(priority=2)
	public void verifyJQueryCalendar() {
		
		APP_LOGS.info("******************************************Start verifying verifyJQueryCalendar Test Case*********************************************");
		
		
		mainjquerydatepicker.NavigateToDatePickers();
		mainjquerydatepicker.NavigateToJQueryDatePicker();
		mainjquerydatepicker.ValidateToJQueryDatePickerPage();
		
		APP_LOGS.info("==========================================Completed verifying verifyJQueryCalendar Test Case========================================");
		
	}
	
	@Test(priority=3)
	public void verifyDatesBeforeStartDateAreDisabled() throws InterruptedException {
		APP_LOGS.info("******************************************Start verifying verifyDatesBeforeStartDateAreDisabled Test Case*********************************************");
		
		mainjquerydatepicker.NavigateToDatePickers();
		mainjquerydatepicker.NavigateToJQueryDatePicker();
		mainjquerydatepicker.VerifyDatesBeforeStartDateAreDisabled();
		
		APP_LOGS.info("==========================================Completed verifying verifyDatesBeforeStartDateAreDisabled Test Case========================================");
		
	}
	
	@Test(priority=4)
	public void verifyDatesAfterToDateAreDisabled() {
		
		APP_LOGS.info("******************************************Start verifying verifyDatesAfterToDateAreDisabled Test Case*********************************************");
		
		mainjquerydatepicker.NavigateToDatePickers();
		mainjquerydatepicker.NavigateToJQueryDatePicker();
		mainjquerydatepicker.VerifyDatesAfterToDateAreDisabled();
		
		APP_LOGS.info("==========================================Completed verifying verifyDatesAfterToDateAreDisabled Test Case========================================");
		
	}
	
	@AfterClass
	public void after()
	{
		rep.flush();
		//TestBase.destroy();
	}
	
	

}
