package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import com.automation.base.*;

public class SingleCheckboxDemoPage extends MainClass {
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
	public static void verifyCheckboxDemoPage()
	{
     String actText=driver.findElement(By.xpath(prop.getProperty("checkboxdemo_heading"))).getText();
     APP_LOGS.info("Actual text on the page is "+actText);
     if(actText.contains("basic example to start with checkboxes"))
     {
    	 APP_LOGS.info("Navigated to Checkbox demo page");
     }
     else
     {
    	 APP_LOGS.info("You are in different page");
     }
	}
	public static void singleSelectCheckbox()
	{
		//System.out.println("select the Single checkbox");
		WebElement cBox=driver.findElement(By.id(prop.getProperty("singleselectcheckbox")));
		cBox.click();
		APP_LOGS.info("Single select Checkbox Checked");
		verifySelected(cBox);
		//return cBox;
	}
	
public static void verifySelected(WebElement cBox)
	{
		
		//System.out.println("Verify the checkbox is selected or not");
		if(cBox.isSelected())
		{
			APP_LOGS.info("Verified and found Checkbox selected");
		}
		else
		{
			APP_LOGS.info("Verified and found Checkbox not selected");
		}

	}
public static void compareMessage()
{
	System.out.println("Verify Expected and actual are true");
	String expectedmessage="Success - Check box is checked";
	String actualmessage=driver.findElement(By.xpath(prop.getProperty("successmessage"))).getText();
	System.out.println(actualmessage);
	if(expectedmessage.equalsIgnoreCase(actualmessage))
	{
		APP_LOGS.info("The expectedmessage is same as "+actualmessage);
	}
	else
	{
		APP_LOGS.info("The expectedmessage is not same as "+actualmessage);}

}


}
