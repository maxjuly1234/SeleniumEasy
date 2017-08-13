package com.automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.MainBootstrapDatePickerPage;

public class BootstrapDatePickerPageTest extends TestBase{

	public static final Logger APP_LOGS=Logger.getLogger(BootstrapDatePickerPageTest.class.getName());
	MainBootstrapDatePickerPage mainbootstrapdatepicker;
	
	
	/*@BeforeClass
	public void before() throws Throwable
	{
		TestBase.initialization();
	}*/
	
	@Test
	public void verifyBootstrapCalendar() {
		
		mainbootstrapdatepicker = new MainBootstrapDatePickerPage(driver);
		
		APP_LOGS.info("******************************************Start verifying verifyBootstrapCalendar Test Case*********************************************");
		mainbootstrapdatepicker.NavigateToDatePickers();
		mainbootstrapdatepicker.NavigateToBootstrapDatePicker();
		mainbootstrapdatepicker.ValidateToBootstrapDatePickerPage();
		
		APP_LOGS.info("==========================================Completed verifying verifyBootstrapCalendar Test Case========================================");
	  }

	@Test
	public void verifyDaysOfWeekIsDisabled() throws InterruptedException{
		
		mainbootstrapdatepicker = new MainBootstrapDatePickerPage(driver);
		
		APP_LOGS.info("******************************************Start verifying verifyDaysOfWeekIsDisabled Test Case*********************************************");
		mainbootstrapdatepicker.NavigateToDatePickers();
		mainbootstrapdatepicker.NavigateToBootstrapDatePicker();
		mainbootstrapdatepicker.VerifyDaysOfWeekDisabled();		
		
		APP_LOGS.info("******************************************Completed verifying verifyDaysOfWeekIsDisabled Test Case*********************************************");
		
	}

	
	@Test
	public void verifyStartingWeek(){
		
		mainbootstrapdatepicker = new MainBootstrapDatePickerPage(driver);
		APP_LOGS.info("******************************************Start verifying verifyStartingWeek Test Case*********************************************");
		mainbootstrapdatepicker.NavigateToDatePickers();
		mainbootstrapdatepicker.NavigateToBootstrapDatePicker();
		mainbootstrapdatepicker.VerifyDayStartsWithMonday();
		
		APP_LOGS.info("******************************************Completed verifying verifyStartingWeek Test Case*********************************************");
		
	}
	
	@Test
	public void verifyDateCleared() throws InterruptedException{
		mainbootstrapdatepicker = new MainBootstrapDatePickerPage(driver);
		
		APP_LOGS.info("******************************************Start verifying verifyDateCleared Test Case*********************************************");
		mainbootstrapdatepicker.NavigateToDatePickers();
		mainbootstrapdatepicker.NavigateToBootstrapDatePicker();
		mainbootstrapdatepicker.VerifyToClearDateEntered();
		
		APP_LOGS.info("******************************************Completed verifying verifyDateCleared Test Case*********************************************");
		
	}
	
	@Test
	public void VerifyTodaysDate() throws InterruptedException{
		
		mainbootstrapdatepicker = new MainBootstrapDatePickerPage(driver);
		APP_LOGS.info("******************************************Start verifying verifyTodaysDate Test Case*********************************************");
		mainbootstrapdatepicker.NavigateToDatePickers();
		mainbootstrapdatepicker.NavigateToBootstrapDatePicker();
		mainbootstrapdatepicker.VerifyClickOnTodaysDate();
		
		
		APP_LOGS.info("******************************************Completed verifying verifyTodaysDate Test Case*********************************************");
		
	}
	
	/*@AfterClass
	public void after()
	{
	  TestBase.destroy();
	}
	*/
	

}
