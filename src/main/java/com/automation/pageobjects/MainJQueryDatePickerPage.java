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
	
	WebDriver driver;
	
	public MainJQueryDatePickerPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

public void NavigateToDatePickers(){
	
	datepickers_link.click();
	APP_LOGS.info("You Clicked on DatePickers Menu");
}



//##############JQUERY DATE PICKER FUNCTIONS ##############

public void NavigateToJQueryDatePicker(){
	
	jquerydatepicker_link.click();
	System.out.println("You Clicked on JQuery DatePickers Link");
}

public void ValidateToJQueryDatePickerPage(){
	
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

public void VerifyDatesBeforeStartDateAreDisabled(){
	
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
	String currentdate= dateFormat.format(date);
	jquerydatepicker_fromdate.sendKeys(currentdate);
	jquerydatepicker_todate.click();
	
	String previousdate = dateFormat.format(yesterday());
	
	System.out.println(previousdate);
	
		
}

private static Date yesterday() {
	final Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    return cal.getTime();
}


}


