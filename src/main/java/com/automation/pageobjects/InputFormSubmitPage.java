/**
 * 
 */
package com.automation.pageobjects;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindAll;

import com.automation.base.TestBase;

/**
 * @author bbanduch
 * 
 * This is InputFormSubmitPage
 *
 */
public class InputFormSubmitPage extends TestBase{
	
	//WebDriver driver;

	public InputFormSubmitPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
	}
	
	//INPUTFORM SUBMIT -- Objects Locators
	
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/a") WebElement inputformlink;		
	@FindBy(how=How.XPATH, using="//*[@id='treemenu']/li/ul/li[1]/ul/li[5]/a") WebElement inputFormSubmit;	
	@FindBy(how=How.CSS, using="[name='first_name'][placeholder='First Name']") WebElement firstName;
	@FindBy(how=How.CSS, using="[name='last_name'][placeholder='Last Name']") WebElement lastName;
	@FindBy(how=How.CSS, using="[name='email'][placeholder='E-Mail Address']") WebElement eMail;
	@FindBy(how=How.CSS, using="[name='phone'][data-bv-field='phone']") WebElement phoneNumber;
	@FindBy(how=How.CSS, using="[name='address'][placeholder='Address']") WebElement address;
	@FindBy(how=How.CSS, using="[name='city'][placeholder='city']") WebElement city;
	@FindBy(how=How.CSS, using=".form-control.selectpicker") WebElement state;
	@FindBy(how=How.CSS, using="[name='zip'].form-control") WebElement zipCode;
	@FindBy(how=How.CSS, using="[name='comment'][placeholder='Project Description']") WebElement projDescription;
	@FindBy(how=How.XPATH, using="//div[@class='col-md-4']/button[@type='submit']") WebElement sendButton;
	//@FindBy(how=How.CSS, using="div[class$='has-error']>div>small[data-bv-result='INVALID']") WebElement allFieldsValidationErrorMessages_Invalid; 
	//@FindBy(how=How.CSS, using="div[class$='has-error']>div>small[data-bv-result='VALID']") WebElement allFieldsValidationErrorMessages_Valid;
	
	@FindBy(css="div[class$='has-error']>div>small[data-bv-result='INVALID']") public List<WebElement> allFieldsValidationErrorMessages_Invalid;
	public void inputFormLaunch() 
	{
		inputformlink.click();
		inputFormSubmit.click();	
	}

	public AjaxFormSubmitPage enterInputFormDetails() throws Exception
	{
		String sheetName = "InputFormSubmit";
		inputformlink.click();
		inputFormSubmit.click();
		
		
		
		firstName.sendKeys(getExcelDataInString(sheetName, 1, 0));
		lastName.sendKeys(getExcelDataInString(sheetName, 1, 1));
		eMail.sendKeys(getExcelDataInString(sheetName, 1, 2));
		
		/*rawData=getExcelData(sheetName, 1, 3);
		cellValue=getStringFromCell(rawData);*/
		
		phoneNumber.sendKeys(getExcelDataInString(sheetName, 1, 3));
		address.sendKeys(getExcelDataInString(sheetName, 1, 4));
		city.sendKeys(getExcelDataInString(sheetName, 1, 5));
		
		//State Selector
		Select oneState= new Select(state);
		//oneState.selectByIndex(3);
		oneState.selectByVisibleText(getExcelDataInString(sheetName, 1, 6));
		
		zipCode.sendKeys(getExcelDataInString(sheetName, 1, 7));
		projDescription.sendKeys(getExcelDataInString(sheetName, 1, 8));
		sendButton.click();
		
		
		APP_LOGS.info("*****************InputFormSubmit Button is clicked*****************");
		
		return PageFactory.initElements(driver, AjaxFormSubmitPage.class);
		
		
	}

	public void enterInputFormDetails(	String string1,
										String string2,
										String string3,
										String string4,
										String string5,
										String string6,
										String string7,
										String string8,
										String string9) throws Exception
	{
		
		inputformlink.click();
		inputFormSubmit.click();
		firstName.sendKeys(string1);
		lastName.sendKeys(string2);
		eMail.sendKeys(string3);
		phoneNumber.sendKeys(string4);
		address.sendKeys(string5);
		city.sendKeys(string6);
		Select oneState= new Select(state);
		oneState.selectByVisibleText(string7);
		
		zipCode.sendKeys(string8);
		projDescription.sendKeys(string9);
		sendButton.click();
		
		
		APP_LOGS.info("*****************InputFormSubmit Button is clicked Using DataProvider*****************");
		
		
		
		
	}

	public void inputFormSubmitInValidValidations()
	{
		sendButton.click();
		
		APP_LOGS.info("*****************InputFormSubmit Button is clicked in Validation Screen*****************");
		
		for(int i=0;i<allFieldsValidationErrorMessages_Invalid.size();i++)
		{
			System.out.print(allFieldsValidationErrorMessages_Invalid.get(i).getText()+"-->");
			String displayMessage= allFieldsValidationErrorMessages_Invalid.get(i).getText();
			
			if (displayMessage.equals("Please supply your first name"))
			{
				System.out.println("Error Message Displayed for FirstName is Correct");
			}else if (displayMessage.equals("Please supply your last name"))
			{
				System.out.println("Error Message Displayed for LastName is Correct");
			}else if (displayMessage.equals("Please supply your email address"))
			{
				System.out.println("Error Message Displayed for Email is Correct");
			}else if (displayMessage.equals("Please supply your phone number"))
			{
				System.out.println("Error Message Displayed for PhoneNumber is Correct");
			}else if (displayMessage.equals("Please supply your street address"))
			{
				System.out.println("Error Message Displayed for Street Address is Correct");
			}else if (displayMessage.equals("Please supply your city"))
			{
				System.out.println("Error Message Displayed for City is Correct");
			}else if (displayMessage.equals("Please supply your state"))
			{
				System.out.println("Error Message Displayed for state is Correct");
			}else if (displayMessage.equals("Please supply your zip code"))
			{
				System.out.println("Error Message Displayed for zip code is Correct");
			}else if (displayMessage.equals("Please supply a description of your project"))
			{
				System.out.println("Error Message Displayed for Description is Correct");
			}
		}
		
		APP_LOGS.info("*****************InputFormSubmit Button Error Validation is Completed*****************");
		
		
	}


}
