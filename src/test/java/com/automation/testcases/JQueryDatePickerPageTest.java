package com.automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.MainClass;
import com.automation.pageobjects.MainJQueryDatePickerPage;

public class JQueryDatePickerPageTest extends TestBase {

	public static final Logger APP_LOGS=Logger.getLogger(JQueryDatePickerPageTest.class.getName());
	
	MainJQueryDatePickerPage mainjquerydatepicker;
	

	/*@BeforeClass
	public void before() throws Throwable
	{
		TestBase.initialization();
	}*/
	
	@Test
	public void verifyJQueryCalendar() {
		APP_LOGS.info("******************************************Start verifying verifyJQueryCalendar Test Case*********************************************");
		mainjquerydatepicker = new MainJQueryDatePickerPage(driver);
		
		mainjquerydatepicker.NavigateToDatePickers();
		mainjquerydatepicker.NavigateToJQueryDatePicker();
		mainjquerydatepicker.ValidateToJQueryDatePickerPage();
		
		APP_LOGS.info("==========================================Completed verifying verifyJQueryCalendar Test Case========================================");
		
	}
	
	@Test
	public void verifyJQueryCalendarStartAndEndDates() throws InterruptedException {
		APP_LOGS.info("******************************************Start verifying verifyJQueryCalendarStartAndEndDates Test Case*********************************************");
		
		mainjquerydatepicker.NavigateToDatePickers();
		mainjquerydatepicker.NavigateToJQueryDatePicker();
		mainjquerydatepicker.VerifyDatesBeforeStartDateAreDisabled();
		
		Thread.sleep(2000);
		APP_LOGS.info("==========================================Completed verifying verifyJQueryCalendarStartAndEndDates Test Case========================================");
		
	}
	
	
	/*@AfterClass
	public void after()
	{
	  TestBase.destroy();
	}*/
	
	

}
