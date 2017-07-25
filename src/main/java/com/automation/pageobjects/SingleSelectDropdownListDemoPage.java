package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.automation.pageobjects.MainClass;

public class SingleSelectDropdownListDemoPage extends MainClass{
	public static void verifySelectDropdownListPage()
	{
		String actTitle=driver.findElement(By.xpath(prop.getProperty("selectdropdownpage_title"))).getText();
		APP_LOGS.info("Actula title of the page is "+actTitle);
		if(actTitle.contains("first example on select dropd down list to"))
		{
			APP_LOGS.info("Navigated to Select dropdown list demo page");
		}
		else
		{
			APP_LOGS.info("You are in different page");
		}
	}
	public static void selectADay(boolean flag)
	{
		sel=new Select(driver.findElement(By.xpath(prop.getProperty("selectaday_dropdown"))));
		sel.selectByVisibleText("Tuesday"); 
		APP_LOGS.info("Day Selected");
		String expText="Tuesday";
		String actText=driver.findElement(By.xpath(prop.getProperty("selectaday_dropdown"))).getAttribute("value");
		if(expText.equalsIgnoreCase(actText))
		{
			APP_LOGS.info("Expected Text is matching with the selected Option.The Selected Option is "+actText);
		}
		else
		{
			APP_LOGS.info("Expected Text is not matching with the selected Option.The Selected Option is "+actText);
		}
		if(flag)
		{
			displayMessage(expText);
		}
		}
	public static void displayMessage(String expText)
	{
	String successMsg=driver.findElement(By.xpath(prop.getProperty("selectdropdwon_successmsg"))).getText();
	APP_LOGS.info("success message is "+successMsg);
	if(successMsg.contains(expText))
	{
		APP_LOGS.info(expText+" got selected sucessfully");
	}
		
	}


}
