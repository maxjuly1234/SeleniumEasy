/**
 * 
 */
package com.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.automation.base.TestBase;
import com.aventstack.extentreports.Status;


/**
 * @author bbanduch This is Ajax Form Submit page.
 */
public class AjaxFormSubmitPage extends TestBase{

	//WebDriver driver;

	public AjaxFormSubmitPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(how=How.XPATH, using="//*[@id='block-block-57']/div/div/a") WebElement demowebsite;
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/a") WebElement inputformlink;	
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/ul/li[6]") WebElement ajaxFormSubmit;
	@FindBy(how=How.XPATH, using="//*[@id='title' and @type='text']") WebElement name;	
	@FindBy(how=How.XPATH, using="//input[@id='btn-submit' and @value='submit']") WebElement submitButton;
	@FindBy(how=How.XPATH, using="//*[@id='description']")  WebElement comment; 
	
	@FindBy(how=How.XPATH, using="//*[@id='submit-control']")  WebElement successMsg;
	
	
	

	public void ajaxFormLaunc() {
		
		String pageName= driver.getTitle();
		String mainPageTitle="Selenium Easy | Complete Automation Testing Tutorials";
		String demoWebSiteTitle="Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
	   
	   	 
	   	 if(pageName.equals(mainPageTitle))
	   	 {
	   		demowebsite.click();
	   		inputformlink.click();
		   	ajaxFormSubmit.click();
		   	
		   	System.out.println("Control is in this page ---->>"+driver.getTitle());
		   	
		   	test.log(Status.INFO,"you are in Ajax page");
		   	
			}
	   	 else if(pageName.equals(demoWebSiteTitle)){
	   		inputformlink.click();
	   		ajaxFormSubmit.click();
	   		System.out.println("Control is in this page ---->>"+driver.getTitle());
	   		test.log(Status.INFO,"you are in Ajax page");
	   		 
	   	 }else test.log(Status.FAIL, "You are in Wrong Page");
		
			
	   	 
	   	 // Check the page here
	   	 
	   	 
	   	 
		APP_LOGS.info("************AjaxForm is launched***********");
		test.log(Status.INFO,"you are in Ajax page");

	}

	public void enterAjaxFormDetails() throws InterruptedException {
		
		
		name.sendKeys("This should be name of Ajax field");
		comment.sendKeys("A Lead QA Engineer is responsible for all of the activities in the testing of the product, including system and integration testing, test plan review, and best practice improvements. Work with Platform engineering team to plan and develop test suites for a set of products. Maintain and evaluate tests day to day and report problems discovered.  Work with developers to make hard-to-test features more testable for QA. Understand the inner workings of technologies of applications under test. Should be aware that job of a Quality Assurance Engineer is to speak up at any point in the process and test the edge cases of products, and lobby for having problems encountered to get fixed. Ensure the quality of various software products through test planning and execution, serving as a technical point of contact for a product, and assisting the QA Manager drive projects to completion through project planning and management");
		submitButton.click();
		Thread.sleep(5000);
		Assert.assertTrue(successMsg.getText().equals("Form submited Successfully!"));
		test.log(Status.PASS, "Form did Submited from Page");
		
		/*boolean msgStatus = successMsg.getText().equals("Form submited Successfully!");
		if (msgStatus) {
			System.out.println("Form submited Successfully!");
			APP_LOGS.info("*****************AJAXFormSubmit Flow is over*****************");
			logger.log(LogStatus.PASS, "Form did Submited");
		} else {
			System.out.println("Something Wrong");
			APP_LOGS.info("*****************AJAXForm Submit has some issue*****************");
			logger.log(LogStatus.FAIL, "Form didn't submited");
			
			
			
		}*/
	}

	public void ajaxFormSubmitInValidValidations() {
		APP_LOGS.info("********Inside Ajax Validation screen****************");
		
		System.out.println("***************this is page name------->"+driver.getTitle());
		submitButton.click();
		String errNameFieldValidation = name.getAttribute("style");
		if (errNameFieldValidation
				.equalsIgnoreCase("border: 1px solid rgb(255, 0, 0);")) {
			System.out.print("Name is Mandate value to Enter");
			APP_LOGS.info("*****************AJAXForm Field Validation is over*****************");
		}else
		{
			test.log(Status.FAIL, "Ajax Form page validation FAILED");
		}

	}

}
