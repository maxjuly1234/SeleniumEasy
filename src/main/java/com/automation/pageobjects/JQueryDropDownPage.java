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

public class JQueryDropDownPage extends TestBase{
	
	public static Select sel=null;
	public static final Logger APP_LOGS=Logger.getLogger(JQueryDropDownPage.class.getName());
	
	@FindBy(xpath="//*[@id='block-block-57']/div/div/a")
	WebElement seleniumeasytest_link;
	
	@FindBy(xpath="//*[@id='treemenu']/li/ul/li[1]/a")
	WebElement inputformlink;
	
	@FindBy(xpath="//*[@id='treemenu']/li/ul/li[1]/ul/li[7]/a")
	WebElement jqueryselectdropdown_link;

	@FindBy(xpath="html/body/div[2]/div/div[2]/div[1]/div/div[2]/span/span[1]/span")
	WebElement selectcountry;
	
	@FindBy(xpath="html/body/span/span/span[1]/input")
	WebElement searchcountry;
	
	@FindBy(xpath="//*[@id='select2-country-results']/li")
	WebElement choosecountry;
	
	WebDriver driver;
	
	public JQueryDropDownPage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	public void NavigateToSeleniumEasyTest(){
		seleniumeasytest_link.click();
	}

	public void inputForm()
	{
		test.log(Status.INFO, "Input Form Link is clicked");
		//System.out.println("click on InputFormlink");
		inputformlink.click();
		APP_LOGS.info("InputFormLInk is clicked");
	}


	//******** JQuery Select Dropdown functions ******** 
	public void NavigateToJQuerySelectDropdown(){
	
	test.log(Status.INFO, "NavigateToJQuerySelectDropdown method started execution");
	inputformlink.click();
	
	jqueryselectdropdown_link.click();
		
	APP_LOGS.info("You are in JQuery Select Dropdown Page");
	test.log(Status.INFO, "NavigateToJQuerySelectDropdown method completed execution");
}

public void SearchAndSelectCountry(){
	
	test.log(Status.INFO, "SearchAndSelectCountry method started execution");
	selectcountry.click();
	searchcountry.sendKeys("hong");
	choosecountry.click();
	test.log(Status.INFO, "SearchAndSelectCountry method Completed execution");
}

}


