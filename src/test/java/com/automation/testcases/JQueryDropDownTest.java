package com.automation.testcases;
//package com.test.automation.SeleniumEasy;


import java.util.List;

import com.automation.base.TestBase;
import com.automation.pageobjects.JQueryDropDownPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class JQueryDropDownTest extends TestBase{
	
		
	public static final Logger APP_LOGS=Logger.getLogger(JQueryDropDownTest.class.getName());
	
	JQueryDropDownPage mainjquerydropdown;
	
	@BeforeClass
	public void setUp() throws Throwable{
			
	//initialization();
	mainjquerydropdown = PageFactory.initElements(driver, JQueryDropDownPage.class);
	System.out.println("Objects are created");
	mainjquerydropdown.NavigateToSeleniumEasyTest();
	}
	
	// ******* Navigating to JQuery Select Drop down Page and validate you are in the correct page ******* //
	
	@Test
	public  void ValidateJQuerySelectDropdownPage(){
		
		//mainjquerydropdown = new JQueryDropDownPage(driver);
		//mainjquerydropdown.NavigateToSeleniumEasyTest();
		
		mainjquerydropdown.NavigateToJQuerySelectDropdown();
	
		String a = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/h2")).getText();
		boolean PageTitle = a.equals("Single Select - Search and Select country");
		
		if (PageTitle=true){
			System.out.println("You are in JQuery Select Dropdown page");
		}
		else{
			System.out.println("You are not in JQuery Select Dropdown Page");
		}
		
	}
	
	// ******* Search for a country and Select drop down item then validate correct country is selected ******* //
	
	@Test
	public void VerifySearchAndSelectCountry(){
		
		//mainjquerydropdown = new JQueryDropDownPage(driver);
		mainjquerydropdown.NavigateToJQuerySelectDropdown();
		
		mainjquerydropdown.SearchAndSelectCountry();
		
		String a = driver.findElement(By.xpath(".//*[@id='select2-country-container']")).getText();
		APP_LOGS.info(a);
		boolean SelectedItem = a.equals("Hong Kong");
		if (SelectedItem = true){
			APP_LOGS.info("Selected Country is: "+a);
		}
		else{
			APP_LOGS.info("Selected Country is not: "+a);
		}
		
		APP_LOGS.info("======= Finished Verifying Country Selected =======");
		
	}
	
	@Test
	public void MultiSelectStates() throws Exception{
		
		
		//mainjquerydropdown = new JQueryDropDownPage(driver);
		mainjquerydropdown.NavigateToJQuerySelectDropdown();
		
		APP_LOGS.info("======= Start Multi Select State TestCase Execution =======");
		
		WebElement states=driver.findElement(By.cssSelector("input[type='search']"));
		states.sendKeys("Arizona");
		states.sendKeys(Keys.ENTER);
		
		states.sendKeys("Colorado");
		states.sendKeys(Keys.ENTER);
		
		
		String selectedStates = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul")).getText();
		
		boolean StatesSelected = selectedStates.equals("Arizona");
		
		if (StatesSelected = true){
			System.out.println("Selected States are: "+selectedStates);
		}
		else{
			System.out.println("Selected States are not: "+selectedStates);
		}
		
		APP_LOGS.info("======= Multi Select State TestCase Execution =======");
		
	}
	
	@Test
	public void DropDownWithTerritoryEnabled() throws InterruptedException{
		
		//mainjquerydropdown = new JQueryDropDownPage(driver);
		mainjquerydropdown.NavigateToJQuerySelectDropdown();
		APP_LOGS.info("======= Start Execution of DropDownWithDisabledValues test case =======");
		System.out.println("******************************");
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@class='js-example-disabled-results select2-hidden-accessible']")));
		sel.selectByVisibleText("Puerto Rico");
		//Thread.sleep(5000);
		String selectedTerritory=driver.findElement(By.xpath("//select[@class='js-example-disabled-results select2-hidden-accessible']")).getAttribute("value");
		System.out.println(selectedTerritory);
		System.out.println("######################");
		String expectedTerritory="PR";
		
		
		if (selectedTerritory.equalsIgnoreCase(expectedTerritory)){
			System.out.println("Selected Territory is enabled in the given list: "+selectedTerritory);
			
		}
		else{
			System.out.println("Selected Territory is not enabled in the given list: "+selectedTerritory);
		}
		
		APP_LOGS.info("======= Finished Execution of DropDownWithDisabledValues test case =======");
	}
	
	@Test
	public void VerifyTerritoryDisabled(){
		
		//mainjquerydropdown = new JQueryDropDownPage(driver);
		mainjquerydropdown.NavigateToJQuerySelectDropdown();
		APP_LOGS.info("======= Start Execution of DropDownWithDisabledValues test case =======");
		
		WebElement MyTerritory = driver.findElement(By.xpath("//select[@class='js-example-disabled-results select2-hidden-accessible']"));
		Select dropdown = new Select(MyTerritory);
		
		List <WebElement> options = dropdown.getOptions();
				
		for (WebElement option : options) {
			
			String territory=option.getText();
			Boolean var=option.isEnabled();
			System.out.println(var);
			if(var==true){
				System.out.println("Selected Terriroy is "+territory+" and is enabled"); //Prints "Option", followed by "Not Option"
			}
			else{
				System.out.println("Selected Terriroy is "+territory+" and is disabled"); //Prints "Option", followed by "Not Option"	
			}
		}
				
	}
	
	@Test
	public void VerifyDropdownWithCategoryRelatedOptions() throws InterruptedException{
		
		//mainjquerydropdown = new JQueryDropDownPage(driver);
		
		APP_LOGS.info("****** Start Executing VerifyDropdownWithCategoryRelatedOptions *****");
		mainjquerydropdown.NavigateToJQuerySelectDropdown();
		
		System.out.println("Select Dropdown With Category Related Options Test Case executes");
		Select sel = new Select(driver.findElement(By.xpath("//*[@id='files']")));
		List<WebElement> options=sel.getOptions();
		int listSize=options.size();
		
		System.out.println("Size of the dropdownitems is "+listSize);
		
		for(int i=0;i<listSize;i++)
		{
			//String oValue=sel.getOptions().get(i).getText();
			String dropdownitem = sel.getOptions().get(i).getText();
			System.out.println("Selecting Dropdown item is "+dropdownitem);
			
			sel.selectByIndex(i);
					
			
			Thread.sleep(2000);
		}
		APP_LOGS.info("****** Completed Executing VerifyDropdownWithCategoryRelatedOptions *****");
	}
	
	@AfterClass
	public void endTest(){
		driver.quit();
	}
}
