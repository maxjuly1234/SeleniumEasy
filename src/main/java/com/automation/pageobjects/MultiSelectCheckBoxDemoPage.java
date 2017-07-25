package com.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import com.automation.base.TestBase;

public class MultiSelectCheckBoxDemoPage extends MainClass{
	public static void selectAllCheckbox()
	{
		//System.out.println("Select all the checkbox");
		WebElement cBoxAll=driver.findElement(By.xpath(prop.getProperty("checkall_button")));
		cBoxAll.click();
		APP_LOGS.info("All the options selected");
		
	}
	public static void selectAllOptions() throws InterruptedException
	{
		List<WebElement> allOptions=driver.findElements(By.xpath(prop.getProperty("options")));
		//allOptions.click();
		for(WebElement e:allOptions)
		{
			if(!e.isSelected())
			{
				e.click();
				Thread.sleep(5000);
			}

		}
		APP_LOGS.info("All options selected");
		//Thread.sleep(10000);
		}
	public static void getButtonLabel()
	{
	//System.out.println("Verify if Check All button label getting changed to Uncheck all");
	String uncheck=driver.findElement(By.xpath(prop.getProperty("checkall_button"))).getAttribute("value");
	APP_LOGS.info("label is "+uncheck);
	if(uncheck.equalsIgnoreCase("Uncheck All"))
	{
		APP_LOGS.info("Button label Check All got Changed to Uncheck All.The actual value on the button is "+uncheck);
	}
	else
	{
		APP_LOGS.info("Button label Check All did not Changed to Uncheck All.The actual value on the button is "+uncheck);
	}}
	public static void deselectOneCheckbox()
	{
		
		driver.findElement(By.xpath(prop.getProperty("option3"))).click();
		APP_LOGS.info("one checkbox deselected");
		//System.out.println("Verify the button label");
		String actLabel=driver.findElement(By.xpath(prop.getProperty("checkall_button"))).getAttribute("value");
		APP_LOGS.info("actual text on the button is "+actLabel);
		if(actLabel.equalsIgnoreCase("Check All"))
		{
			APP_LOGS.info("Button label Uncheck All got Changed to Check All after deselcting one option.The actual label is "+actLabel);
		}
		else
		{
			APP_LOGS.info("Button label Uncheck All did not Changed to Check All after deselcting one option.The actual label is "+actLabel);

		}
		}


}
