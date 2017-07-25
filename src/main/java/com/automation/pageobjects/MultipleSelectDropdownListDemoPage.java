package com.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectDropdownListDemoPage extends MainClass {
	public static void firstlySelected() throws InterruptedException
	{

	sel=new Select(driver.findElement(By.xpath(prop.getProperty("multiselect_listbox"))));
	List<WebElement> options=sel.getOptions();
	int listSize=options.size();
	//APP_LOGS.info("The listbox options are:");
	for(int i=3;i<listSize;i++)
	{
		//String oValue=sel.getOptions().get(i).getText();
		//APP_LOGS.info(oValue);
		sel.selectByIndex(i);
		Thread.sleep(2000);
	}
	APP_LOGS.info("Multiple optios are selected");
	WebElement firstOption=(sel.getFirstSelectedOption());
	APP_LOGS.info("First Selcted option is "+firstOption.getText());
	getAllSelected(sel);
	}
	public static void getAllSelected(Select sel)
	{
		APP_LOGS.info("All selected option are:");
		List<WebElement> allOptions=sel.getAllSelectedOptions();
		for(WebElement e1:allOptions)
		{
			if(e1.isSelected())
			{
				APP_LOGS.info(e1.getText());
			}
		}
	}
	public static void getAllOptions()
	{
		sel=new Select(driver.findElement(By.xpath(prop.getProperty("multiselect_listbox"))));
		List<WebElement> options=sel.getOptions();
		int listSize=options.size();
		APP_LOGS.info("The options available in list box are:");
		for(int i=0;i<listSize;i++)
		{
			String oValue=sel.getOptions().get(i).getText();
			APP_LOGS.info(oValue);
	}
	}




}
