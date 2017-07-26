package com.automation.pageobjects;
//import com.automation.base.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.TestBase;
import com.aventstack.extentreports.Status;

public class MainJQueryDatePickerPage extends TestBase{
	
	public static Select sel=null;
	public static final Logger APP_LOGS=Logger.getLogger(MainJQueryDatePickerPage.class.getName());
	
	@FindBy(xpath="//*[@id='treemenu']/li/ul/li[2]/a")
	WebElement datepickers_link;

	@FindBy(xpath="//*[@id='treemenu']/li/ul/li[2]/ul/li[2]/a")
	WebElement jquerydatepicker_link;
	
	@FindBy(xpath="html/body/div[2]/div/div[2]/h2")
	WebElement jquerydatepicker_header;
	
	@FindBy(xpath="//*[@id='from']")
	WebElement jquerydatepicker_fromdate;
	
	@FindBy(xpath="//*[@id='to']")
	WebElement jquerydatepicker_todate;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	List<WebElement> dates;
	
	WebDriver driver;
	
	public MainJQueryDatePickerPage(WebDriver driver){
		this.driver=driver;
		//super(driver);
		//PageFactory.initElements(driver, this);
		
	}

	public void NavigateToDatePickers(){
	
		datepickers_link.click();
		APP_LOGS.info("You Clicked on DatePickers Menu");
		test.log(Status.INFO, "You Clicked on DatePickers Menu");
	}



//##############JQUERY DATE PICKER FUNCTIONS ##############

	public void NavigateToJQueryDatePicker(){
		
		test.log(Status.INFO, "NavigateToJQueryDatePicker Page");
		jquerydatepicker_link.click();
		System.out.println("You Clicked on JQuery DatePickers Link");
	}


// ##### Verify if the user is in JQuery Date Picker Page #######
	public void ValidateToJQueryDatePickerPage(){
	
		test.log(Status.INFO, "JQueryDatePickerPage Validation");
		String actTitle = jquerydatepicker_header.getText();
	
		String expTitle="JQuery Date Picker Demo";
	
		if(expTitle.equalsIgnoreCase(actTitle))
		{
			APP_LOGS.info("You are in the JQuery DatePicker Page");
		}
		else
		{
			APP_LOGS.info("You are not in the JQuery DatePicker Page");
		}
	
	}

//##### Verify if the Dates before Start Date in To Date are Disabled in JQuery Date Picker Page #######
	public void VerifyDatesBeforeStartDateAreDisabled(){
	
		
		test.log(Status.INFO, "Verification of Dates Before Start Date are disabled in End Date Calendar");	
		// 	********** Finding current day in From Calendar ************* //
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		String currentdate= dateFormat.format(date);
		jquerydatepicker_fromdate.click();
	
		// ********** Selecting current day in From Calendar ************* // 
		List<WebElement> li = dates;
	
		for(WebElement day : li)
		{
			String day1 = day.getText();
		
			if(day1.equals(currentdate))
			{
			
				day.click();
				APP_LOGS.info("Selected Current Date " +day1+ " in From Calendar");
				break;
			}

		}

		//String previousdate = dateFormat.format(yesterday());
		
		// ***** Clicking on To Calendar ***********
		jquerydatepicker_todate.click();
	
		// ***** converting currentdate from String to Integer ****** 
		int Cdate =Integer.valueOf(currentdate);
		APP_LOGS.info("Converted Current date into Integer " +Cdate);
	
		// *** Finding all the dates before currentdate and verifying if the dates are disabled ******
		for(int i=1; i<Cdate;i++)
		{
			List<WebElement> Toli = dates;
		
			for(WebElement day : Toli)
			{
				String day1 = day.getText();
			
				if(day1.equals(String.valueOf(i)))
				{
				
					if (day.getAttribute("class").contains("disabled"))
						{
						APP_LOGS.info("Previous Day " + i +" is Disabled");
						test.log(Status.PASS, "Previous Day " + i +" is Disabled");
						}
				break;
				
				}	
			}

		}
		
	}

	
	//##### Verify if the Dates After To Date in Start Date are Disabled in JQuery Date Picker Page #######
	public void VerifyDatesAfterToDateAreDisabled(){
		
		test.log(Status.INFO, "Verification of Dates After End Date are disabled in Start Date Calendar");
		// 	********** Finding current day in To Calendar ************* //
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		String currentdate= dateFormat.format(date);
		jquerydatepicker_todate.click();
		
		// ********** Selecting current day in To Calendar ************* // 
		List<WebElement> li = dates;
			
		for(WebElement curday : li)
		{
			String tday = curday.getText();
			if(tday.equals(currentdate))
			{
				curday.click();
				break;
			}
		}
		
		// ****** Clicking on From Calendar ****** //
		jquerydatepicker_fromdate.click();
		
		// ***** converting currentdate from String to Integer ****** 
		int Cdate =Integer.valueOf(currentdate);
		APP_LOGS.info("Converted Current date into Integer " +Cdate);
			
		// *** Finding all the dates after currentdate and verifying if the dates are disabled ******
		for(int i=(Cdate+1); i<29; i++)
		{
			List<WebElement> Fromli = dates;
		
			for(WebElement day : Fromli)
			{
				String day1 = day.getText();
				
				if(day1.equals(String.valueOf(i)))
				{
						
					if (day.getAttribute("class").contains("disabled"))
					{
						APP_LOGS.info("Next Day " + i +" is Disabled");
						test.log(Status.PASS, "Next Day " + i +" is Disabled");
					}
					else{
						test.log(Status.FAIL, "Next Day " + i +" is not Disabled");
					}
								
					break;
						
				}	
			}

		}
		
	}	
	private static Date yesterday() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}




}


