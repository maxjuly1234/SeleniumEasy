package com.automation.pageobjects;
//import com.automation.base.*;

//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
//import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.TestBase;

public class MainClass extends TestBase{
	
	//public static WebDriver driver=null;
	public static Select sel=null;
	public static final Logger APP_LOGS=Logger.getLogger(MainClass.class.getName());
	//public static WebElement cBoxValue=singleSelectCheckbox();
//---------------------------------------CheckBoxDemo Methods-------------------------------------------------------
	
	

	public static void destroyBrowser()
	{
		System.out.println("Close the Active Browser");
		driver.quit();
		
	}
	public static void inputForm()
	{
		//System.out.println("click on InputFormlink");
		driver.findElement(By.xpath(prop.getProperty("inputformlink"))).click();
		APP_LOGS.info("InputFormLInk is clicked");
	}
	public static void checkboxDemo()
	{
		//System.out.println("click on Checkbox Demo");
		driver.findElement(By.xpath(prop.getProperty("checkboxdemolink"))).click();
		APP_LOGS.info("CheckBox Demo Link is clicked");

	}


	//-----------------------------------ListBox Methods--------------------------------------------------

public static void selectDropdownListMenu()
{

	driver.findElement(By.xpath(prop.getProperty("selectdropdownlist_link"))).click();
	APP_LOGS.info("Select Dropdown List Menu selected");
}
//-------------------------------------Bootstrap Alerts--------------------------------------

public static void alertsAndModelsMenu()
{
	driver.findElement(By.xpath(prop.getProperty("alertandmodelsmenu_link"))).click();
	APP_LOGS.info("Alert and Models Menu options opened");
}
public static void bootstrapAlert()
{
	driver.findElement(By.xpath(prop.getProperty("bootstrapalert_link"))).click();
	APP_LOGS.info("Navigated to Bootstrap Alert Page");
	String s=driver.getTitle();
	APP_LOGS.info(s);
}

//---------------------------------Javascript Alerts-----------------------------------

	
public static void javascriptAlert()
{
	
	driver.findElement(By.xpath(prop.getProperty("javascriptalertmenu"))).click();
	//String s1=driver.getTitle();
	APP_LOGS.info("Navigateed to Javascript Alerts menu page");
//System.out.println(s1);
}
//----------------------------Window Pop Up Model-------------------------------------
public static void windowPopupModel()
{
	driver.findElement(By.xpath(prop.getProperty("windowpopupmodel_link"))).click();
	APP_LOGS.info("Clicked and Navigated to Window Pop Up Model");
}
//-------------------------------------------DragAndDrop------------------------------
	public static void otherMenu()
	{
		driver.findElement(By.xpath(prop.getProperty("other_link"))).click();
		APP_LOGS.info("Others menu clicked");
	}
	public static void dragAndDropMenu(){
		driver.findElement(By.xpath(prop.getProperty("draganddrop_link"))).click();
		APP_LOGS.info("drag and drop menu clicked");
	}
	}
	
	






