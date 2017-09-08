package com.automation.pageobjects.bala;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CheckBox {
	
	WebDriver driver;
	public CheckBox(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(how=How.ID, using="isAgeSelected") WebElement boxtest;
	@FindBy(how=How.XPATH, using="//*[@id='block-block-57']/div/div/a") WebElement demowebsite;
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/a") WebElement inputformlink;	
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/ul/li[2]/a") WebElement checkboxdemo;
	@FindBy(how=How.XPATH, using="//*[@id='txtAge']") WebElement message;
	
	//Multiple checkbox elements
	
	@FindBy(how=How.ID, using="check1") WebElement checkAllBtn;
	@FindBy(how=How.XPATH, using=".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label") WebElement option1;
	@FindBy(how=How.XPATH, using=".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label") WebElement option2;
	@FindBy(how=How.XPATH, using=".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[3]/label") WebElement option3;
	@FindBy(how=How.XPATH, using=".//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[4]/label") WebElement option4;
	
	
	
	
	public void launch() throws Exception{
		String pageName= driver.getTitle();
		String mainPageTitle="Selenium Easy | Complete Automation Testing Tutorials";
		String demoWebSiteTitle="Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
	   
		
		System.out.println("This is the current page name"+pageName);
	   	 
	   	 if(pageName.equals(mainPageTitle))
	   	 {
	   		demowebsite.click();
	   		inputformlink.click();
	   		checkboxdemo.click();
	   		//Thread.sleep(20000);
	   		boxtest.click();
	   		//Assert.assertEquals(true, message.isDisplayed());
	   		
	   		if (driver.getPageSource().contains(message.getText())){
	   			System.out.println("Message is present--> and this is the message-->"+message.getText());
	   		}
	   		else
	   			System.out.println("Message not Present");
	   		
	   		//System.out.println("attribute pulling-->"+checkboxdemo.getAttribute("type"));
	   		 
	   		// Bala to check the getAttribut Method later
	   		
	   		
		   	
		   	System.out.println("Control is in this page ---->>"+driver.getTitle());
		   	
		   	//test.log(Status.INFO,"you are in Ajax page");
		   	
			}
	   	 
	   	 
		
	}
	
	public void multipleChkBox() throws InterruptedException{
		System.out.println("Control came to Multi..");
		
		//clicking on all check boxes using Check ALL Button
		checkAllBtn.click();
		
		Thread.sleep(5000);
		
		System.out.println("button name ::"+checkAllBtn.getAttribute("value"));
		if (option1.isSelected() && option2.isSelected() && option3.isSelected() && option4.isSelected()){
			System.out.println("All options are selected.");
		}else System.out.println("Something wrong with check button");
		
		
		//uncheck one option and make sure button is changed
		
		option1.click();
		Thread.sleep(5000);
		
	}
	
	
}
