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
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.TestBase;

public class MainBootstrapDatePickerPage extends TestBase{
	
	public static Select sel=null;
	public static final Logger APP_LOGS=Logger.getLogger(MainBootstrapDatePickerPage.class.getName());
	
	@FindBy(xpath="//*[@id='treemenu']/li/ul/li[2]/a")
	WebElement datepickers_link;

	@FindBy(xpath="//*[@id='treemenu']/li/ul/li[2]/ul/li[1]/a")
	WebElement bootstrapdatepicker_link;
	
	@FindBy(xpath="html/body/div[2]/div/div[2]/h1")
	WebElement bootstrapdatepicker_header;
	
	@FindBy(xpath="//*[@id='sandbox-container1']/div/span/i")
	WebElement selectdatecalendar;
	
	@FindBy(xpath="//table[@class='table-condensed']/thead/tr[3]/th")
	List<WebElement> daysofweek;
	
	@FindBy(xpath="//table[@class='table-condensed']/thead/tr[3]/th[7]")
	WebElement dayissunday;
	
	@FindBy(xpath="//table[@class='table-condensed']/tfoot/tr[1]/th")
	WebElement todaysdate;
	
	@FindBy(xpath="//table[@class='table-condensed']/tfoot/tr[2]/th")
	WebElement clearbutton;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement selectdatecheckbox;
	
	WebDriver driver;
	
	public MainBootstrapDatePickerPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

//************ Bootstrap Date Picker functions ***************
public void NavigateToDatePickers(){
	
	datepickers_link.click();
	APP_LOGS.info("You Clicked on DatePickers Menu");
}

public void NavigateToBootstrapDatePicker(){
	
	bootstrapdatepicker_link.click();
	System.out.println("You Clicked on Bootstrap DatePickers Link");
}

public void ValidateToBootstrapDatePickerPage(){
	
	String actTitle = bootstrapdatepicker_header.getText();
	
	String expTitle="Bootstrap Date Pickers Example";
	
		if(expTitle.equalsIgnoreCase(actTitle))
	{
		APP_LOGS.info("You are in the Bootstrap DatePicker Test Case Page");
	}
	else
	{
		APP_LOGS.info("You are not in the Bootstrap DatePicker Test Case Page");
	}
	
}

public void VerifyDaysOfWeekDisabled(){

	selectdatecalendar.click();
	
	String issundayeditable = dayissunday.getAttribute("isContentEditable");
	System.out.println(issundayeditable);
}


public void VerifyDayStartsWithMonday(){
	

	selectdatecalendar.click();
	List<WebElement> li = daysofweek;
	// Getting xpath from OR.properties file
	//List<WebElement> li= driver.findElements(By.xpath(prop.getProperty("daysofweek")));
	
	for (WebElement weekday : li)
	{
		String day=weekday.getText();
		
		if(day.startsWith("Mo"))
		{
			APP_LOGS.info("Week Starts from Monday, value is "+day);
			break;
		}
		else
		{
			APP_LOGS.info("Week is not started from Monday, value is "+day);
		}
	}
}

public void VerifyToClearDateEntered() throws InterruptedException{
	

	selectdatecalendar.click();
	todaysdate.click();
	
	String entereddate=selectdatecheckbox.getAttribute("value");
	
	APP_LOGS.info("Date Entered is "+entereddate);
	selectdatecalendar.click();
	clearbutton.click();
	
	String cleareddate=selectdatecheckbox.getAttribute("value");
	
	if(cleareddate.isEmpty()){
			APP_LOGS.info("Date Entered is Cleared");
		}
	else
		{
			APP_LOGS.info("Date Entered is not Cleared");
		}
}

public void VerifyClickOnTodaysDate(){
	
	
	//get current date time with Date()
	Date date = new Date();
	
	// Create object of SimpleDateFormat class and decide the format
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	// Now format the date
	String currentdate= dateFormat.format(date);
	
	// Print the Date
	System.out.println("Today's Date is (currentdate) - "+currentdate);
	
	selectdatecalendar.click();
	todaysdate.click();
	
	String entereddate=selectdatecheckbox.getAttribute("value");
	
	System.out.println("Date Entered is "+entereddate);
	
	if(entereddate.equals(currentdate)){
			System.out.println("Date Entered is Todays Date "+currentdate);
		}
	else
		{
			System.out.println("Date Entered is not Todays Date, Today's date is "+currentdate);
		}
}


}


