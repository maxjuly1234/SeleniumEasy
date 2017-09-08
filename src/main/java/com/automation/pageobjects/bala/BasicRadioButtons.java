package com.automation.pageobjects.bala;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasicRadioButtons {
	
	WebDriver driver;
	public BasicRadioButtons(WebDriver driver){
		this.driver=driver;
	}
	
	// Common values for all pages
		@FindBy(how=How.XPATH, using="//*[@id='block-block-57']/div/div/a") WebElement demowebsite;
		@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/a") WebElement inputformlink;
		@FindBy(how=How.XPATH, using=".//*[@id='treemenu']/li/ul/li[1]/ul/li[3]/a") WebElement radioButton;

		
	//Radio Button specific locators
		@FindBy(xpath="//input[@value='Male' and @type='radio']") WebElement maleRadio;
		@FindBy(xpath="//input[@value='Female' and @type='radio']") WebElement femaleRadio;
		
		@FindBy(id="buttoncheck") WebElement btn;
		@FindBy(xpath="//p[@class='radiobutton']") WebElement message;
		
		public void basicRadioBtn(){
			
			demowebsite.click();
	   		inputformlink.click();
	   		radioButton.click();	   		
			
				maleRadio.click(); // male Radio clicked
				btn.click(); //button clicked
				if(driver.getPageSource().contains("Radio button 'Male' is checked")){
					System.out.println("you selected male and Correct message is displayed on Screen i.e-->"+message.getText());
				}else if(driver.getPageSource().contains("Radio button 'Female' is checked")){
					System.out.println("you selected Female and Correct message is displayed on Screen");
				}else if(driver.getPageSource().contains("Radio button is Not checked")){
					System.out.println("Nothing is selected");
				}
			
			
			
			
		}

}
