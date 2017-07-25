package com.automation.pageobjects;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;

public class WindowPopUpModelDemoPage extends MainClass{

	public static void verifyWindowPopUpPage()
	{
		//String expTitle="Window popup Modal Example for Automation";
		String actTitle=driver.findElement(By.xpath(prop.getProperty("windowpopuppage_title"))).getText();
		//System.out.println(actTitle);
		if(actTitle.contains("Window popup Modal Ex"))
		{
			APP_LOGS.info("Navigated to Window Popup Model Page");
		}
		else
		{
			APP_LOGS.info("Control is not in Window Pop up page");
		}
	}
	
	public static void followOnTwitterWindow() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("followontwitter_button"))).click();
		APP_LOGS.info("Clicked on Follow On Twitter button");
		//APP_LOGS.info("Clicked on Like us on Facebook button and new window got opened");
		 
		//String newWindow=driver.getWindowHandle();
		//System.out.println(newWindow);
		//driver.switchTo().window(newWindow)
		Set<String> set=driver.getWindowHandles();	
	    Iterator<String> it=set.iterator();	
	    String parentId=it.next();
	    String childId=it.next();
	    //System.out.println("parent id "+parentId);
	    //System.out.println("Child id "+childId);
	    driver.switchTo().window(childId);
	    driver.manage().window().maximize();
	    APP_LOGS.info("Control given to new window");
	    String currentUrl=driver.getCurrentUrl();
	    APP_LOGS.info("New Window url is "+currentUrl);
	    Thread.sleep(6000);
	    //String currentWindowText=driver.findElement(By.xpath(prop.getProperty("fbwindow_text"))).getText();
	    //APP_LOGS.info(currentWindowText);
	    if(currentUrl.contains("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
	    	//if()
	    {
	    	APP_LOGS.info("New Window-Twitter page opened");
	    }
	    else
	    {
	    	APP_LOGS.info("Control not given to new window-Twitter");
	    }
	
	
	}
	
	public static void likeUsOnFbWindow() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("likeusonfb_button"))).click();
		//String handle=driver.getWindowHandle();
		//System.out.println("Current window reference is "+handle);
		APP_LOGS.info("Clicked on Like us on Facebook button and new window got opened");
		 
		//String newWindow=driver.getWindowHandle();
		//System.out.println(newWindow);
		//driver.switchTo().window(newWindow)
		Set<String> set=driver.getWindowHandles();	
	    Iterator<String> it=set.iterator();	
	    String parentId=it.next();
	    String childId=it.next();
	    //System.out.println("parent id "+parentId);
	    //System.out.println("Child id "+childId);
	    driver.switchTo().window(childId);
	    driver.manage().window().maximize();
	    APP_LOGS.info("Control given to new window");
	    String currentUrl=driver.getCurrentUrl();
	    APP_LOGS.info("New Window url is "+currentUrl);
	    Thread.sleep(6000);
	    //String currentWindowText=driver.findElement(By.xpath(prop.getProperty("fbwindow_text"))).getText();
	    //APP_LOGS.info(currentWindowText);
	    if(currentUrl.contains("https://www.facebook.com/seleniumeasy"))
	    	//if()
	    {
	    	APP_LOGS.info("New Window-FB page opened");
	    }
	    else
	    {
	    	APP_LOGS.info("Control not given to new window-FB");
	    }
	    
			driver.close();
			//driver.switchTo().window(parentId);
			Thread.sleep(10000);
	    
	}
	/*public static void dateControl()
	{
		driver.findElement(By.xpath(".//*[@id='sandbox-container1']/div/span")).click();
		List<WebElement> li=driver.findElements(By.xpath("html/body/div[3]/div[1]/table/thead/tr[3]/th"));
	
	
	APP_LOGS.info("Days are");
	*/
//-----------------------------------Multilple window pop up models------------------
	public static void followTwitterAndFb() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("twitterandfb_button"))).click();
		//String handle=driver.getWindowHandle();
		//System.out.println("Current window reference is "+handle);
		APP_LOGS.info("Clicked on follow on Twitter and Facebook and new windows for Twitter and FB got opened");
		 
		//String newWindow=driver.getWindowHandle();
		//System.out.println(newWindow);
		//driver.switchTo().window(newWindow)
		Set<String> set=driver.getWindowHandles();	
	    Iterator<String> it=set.iterator();	
	    String parentId=it.next();
	    String twitId=it.next();
	    String fbId=it.next();
	    System.out.println("parent id "+parentId);
	    System.out.println("Child id "+fbId);
	    System.out.println("Child twit id "+twitId);
	    //verifyFacebookWindow(fbId);
	    //erifyTwitterNewWindow(twitId);
	    driver.switchTo().window(fbId);
	    driver.manage().window().maximize();
	    APP_LOGS.info("Control given to FB new window");
	    String currentUrl=driver.getCurrentUrl();
	    APP_LOGS.info("New Window url is "+currentUrl);
	    Thread.sleep(6000);
	    //String currentWindowText=driver.findElement(By.xpath(prop.getProperty("fbwindow_text"))).getText();
	    //APP_LOGS.info(currentWindowText);
	    if(currentUrl.contains("https://www.facebook.com/seleniumeasy"))
	    	//if()
	    {
	    	APP_LOGS.info("New Window-FB page opened");
	    }
	    else
	    {
	    	APP_LOGS.info("Control not given to new window-FB");
	    }
	    driver.close();
	    APP_LOGS.info("Facebook window closed");
	    Thread.sleep(5000);
	    driver.switchTo().window(twitId);
	    driver.manage().window().maximize();
		APP_LOGS.info("Control given to new Twitter window");
	    String currentUrl1=driver.getCurrentUrl();
	    APP_LOGS.info("New Window url is "+currentUrl1);
	    Thread.sleep(6000);
	    //String currentWindowText=driver.findElement(By.xpath(prop.getProperty("fbwindow_text"))).getText();
	    //APP_LOGS.info(currentWindowText);
	    if(currentUrl1.contains("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
	    	//if()
	    {
	    	APP_LOGS.info("New Window-Twitter page opened");
	    }
	    else
	    {
	    	APP_LOGS.info("Control not given to new window-Twitter");
	    }
	
	driver.close();
	//APP_LOGS.info("Twit window got closed");
	//Thread.sleep(5000);
	//driver.switchTo().window(parentId);
	//driver.close();
	}


}
