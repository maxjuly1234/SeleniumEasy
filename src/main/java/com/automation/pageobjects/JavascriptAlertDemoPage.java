package com.automation.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class JavascriptAlertDemoPage extends MainClass {
	public static void getAlert(boolean flag) throws InterruptedException
	{
		//System.out.println("Get the alertmessage");
		driver.findElement(By.xpath(prop.getProperty("clickme"))).click();
		APP_LOGS.info("Clickme button clicked");

		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		APP_LOGS.info("Alert message is-"+alertText);

		//alert.accept();
		Thread.sleep(5000);
		 if(flag)
		{
			 acceptAlert(alert);
			 }
		 else
		 {
			 alert.accept();
		 }
		
	}
	public static void acceptAlert(Alert alert) throws InterruptedException
	{
		//System.out.println("Try to accept the message");
		alert.accept();
		Thread.sleep(5000);
		APP_LOGS.info("Alert message accepted");

	}


}
