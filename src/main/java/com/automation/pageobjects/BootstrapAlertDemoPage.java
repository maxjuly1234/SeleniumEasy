package com.automation.pageobjects;

import org.openqa.selenium.By;

public class BootstrapAlertDemoPage extends MainClass{
	public static void getBootstrapAlertMessage() throws InterruptedException
	{
		String alerts=driver.findElement(By.xpath(prop.getProperty("autoclosable_button"))).getText();
		APP_LOGS.info("The message on the bootstrap button is "+alerts);
		//WebElement alertElement=driver.findElement(By.xpath(".//*[@id='autoclosable-btn-success']"));
		driver.findElement(By.xpath(prop.getProperty("autoclosable_button"))).click();
		APP_LOGS.info("Clicked on bootstrap alert button");

		
		/*WebDriverWait wait = new WebDriverWait(driver, 2 timeout in seconds);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		    System.out.println("alert was not present");
		else
		    System.out.println("alert was present");*/
		
		
		//String alertText=alertElement.getText();
		//System.out.println(alert1.getText());	
		//Alert alert=driver.switchTo().alert();
		String alertMsg=driver.findElement(By.xpath(prop.getProperty("autoclose_alertmessage"))).getText();
		Thread.sleep(10000);
		APP_LOGS.info(alertMsg);
		
		//driver.switchTo().alert().accept();
	}
	/*public static boolean isAlertPresent() 
	{ 
		WebElement alertElement=driver.findElement(By.xpath(".//*[@id='autoclosable-btn-success']"));
		alertElement.click();
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	*/



}
