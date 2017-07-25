package com.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropDemoPage extends MainClass{
	
	public static void dragAndDropMenuPage()
	{
		String actText=driver.findElement(By.xpath(prop.getProperty("draganddroppage_title"))).getText();
		if(actText.contains("Drag and Drop Demo for"))
		{
			APP_LOGS.info("Navigated to Drag and DRop page");
		}
		else
		{
			APP_LOGS.info("You are in different page");
		}
	}
	 public static void dragAndDropFileIntoDestination() throws InterruptedException{
		 WebElement sourceElement=driver.findElement(By.xpath(prop.getProperty("sourcebox")));
		 WebElement dropElement=driver.findElement(By.xpath(prop.getProperty("dropbox")));
		 Actions act=new Actions(driver);
//act.doubleClick(sourceElement).perform();
//act.clickAndHold(sourceElement).perform();
//act.release(dropElement).perform();
		 act.dragAndDrop(sourceElement, dropElement);
		 //act.moveToElement(dropElement).perform();
		//act.dragAndDrop(sourceElement, dropElement).build().perform();
	Thread.sleep(5000);
	List<WebElement> l1=driver.findElements(By.xpath(".//*[@id='todrag']/span"));
	for(WebElement e1:l1)
	{
		//e1.getText();
		System.out.println(e1.getText());
	}
	
	 }



}
