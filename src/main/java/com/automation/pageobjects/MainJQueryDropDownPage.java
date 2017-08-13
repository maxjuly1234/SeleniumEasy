package com.automation.pageobjects;
//import com.automation.base.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.TestBase;

public class MainJQueryDropDownPage extends TestBase{
	
	public static Select sel=null;
	public static final Logger APP_LOGS=Logger.getLogger(MainJQueryDropDownPage.class.getName());
	
	
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
	
	public MainJQueryDropDownPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

	public void inputForm()
	{
		//System.out.println("click on InputFormlink");
		inputformlink.click();
		APP_LOGS.info("InputFormLInk is clicked");
	}


	//******** JQuery Select Dropdown functions ******** 
	public void NavigateToJQuerySelectDropdown(){
	
	inputformlink.click();
	
	jqueryselectdropdown_link.click();
		
	APP_LOGS.info("You are in JQuery Select Dropdown Page");
}

public void SearchAndSelectCountry(){
	
	selectcountry.click();
	searchcountry.sendKeys("hong");
	choosecountry.click();
	
}

}


