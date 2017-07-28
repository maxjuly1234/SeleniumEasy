package com.automation.pageobjects;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.TestBase;

public class TableDataSearchPage extends TestBase
{
	//Elements declaration
	@FindBy(xpath="//ul[@id='treemenu']/li/ul/li[3]/a") WebElement TableElement;
	@FindBy(xpath="//ul[@id='treemenu']/li/ul/li[3]/ul/li[2]/a") WebElement TableDataSearchElement;
	@FindBy(xpath="//input[@id='task-table-filter']") WebElement FilterTasksTextboxid;
	@FindBy(xpath="//div[@class=\"pull-right\"]/button") WebElement FiltersIconXpath;
	@FindBy(xpath="//input[@placeholder=\"#\"]") WebElement NumberFiltersElement;
	@FindBy(xpath="//input[@placeholder=\"Username\"]")	WebElement UsernameFiltersElement;	
	@FindBy(xpath="//input[@placeholder=\"First Name\"]") WebElement FirstnameFiltersElement;
	@FindBy(xpath="//input[@placeholder=\"Last Name\"]") WebElement LastnameFiltersElement;
			

	//scrolls down the current page
	public static void ScrollDown() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)", "");
		APP_LOGS.info("Scrolled Down");
	}

	//returns the Table DataSearch page Title
	public static String getTableDataSearchTitle()
	{
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	//returns true /false comparing the expected and actual titles
	public static boolean tableDataSearchTitleVerify() throws Exception
	{
		String expectedTitle = prop.getProperty("TableDataSearchTitle").toString();
		return getTableDataSearchTitle().contains(expectedTitle);
	}

	//clicks on the 'Table' link
	public static void tableclick() throws Exception
	{
		driver.findElement(By.xpath("TableElement")).click();;
		//if (tableElement.isDisplayed())
			//tableElement.click();
			APP_LOGS.info("Table clicked");
	}

	//clicks on the 'Table Data Search' link
	public static void tableDataSearchclick() throws Exception
	{
		driver.findElement(By.xpath("TableDataSearchElement")).click();
		//if (tableDataSearchElement.isDisplayed())
			//tableDataSearchElement.click();
			APP_LOGS.info("Table Search Data Clicked");
	}

	//Enters data in the first filter text box
	public static void enterFilterTasksTextbox() throws Exception
	{
			
		//reading data from excel
			Cell FiltersTextBox = getExcelData(prop.getProperty("TableDataSearchSheetName"),1, 0);
			String TextBoxtoString = FiltersTextBox.getStringCellValue();
			driver.findElement(By.xpath("FilterTasksTextboxid")).sendKeys(TextBoxtoString);
			Thread.sleep(2000);
			APP_LOGS.info("Entered data in the first search text box");
	}

	/*public static boolean verifyFiltersEnabled() throws Exception
	{
		WebElement filtersEnabled = driver.findElement(By.xpath(prop.getProperty("NumberFiltersElement")));
		return filtersEnabled.isEnabled();
	}*/

	//clicking on the Filters Icon in the Table Search Data page
	public static void clickFiltersIcon() throws Exception
	{
		driver.findElement(By.xpath("FiltersIconXpath")).click();
			APP_LOGS.info("Filters Icon clicking");
	}

	//Enter data in the Numbers Filter Textbox, in the Table Search Data page
	public static void enterNumberFilter()  throws Exception
	{	
		//formatter = new DataFormatter();
		driver.findElement(By.xpath("UsernameFiltersElement")).clear();
		driver.findElement(By.xpath("FirstnameFiltersElement")).clear();
		driver.findElement(By.xpath("LastnameFiltersElement")).clear();
		
		Cell EnterNumberFilter = getExcelData(prop.getProperty("TableDataSearchSheetName"),1, 1);
		EnterNumberFilter.setCellType(Cell.CELL_TYPE_STRING);
		String NumberFilterToString = EnterNumberFilter.toString();
		//System.out.println("Enter NumberFilter value as --- " +EnterNumberFilter);
		driver.findElement(By.xpath("NumberFiltersElement")).sendKeys(NumberFilterToString);
		Thread.sleep(2000);
		APP_LOGS.info("enter the number to filter");
	}

	//Enter data in the Username Filter Textbox, in the Table Search Data page
	public static void usernameFilter()  throws Exception
	{
		driver.findElement(By.xpath("NumberFiltersElement")).clear();
		driver.findElement(By.xpath("FirstnameFiltersElement")).clear();
		driver.findElement(By.xpath("LastnameFiltersElement")).clear();
		
		Cell EnterUserNameFilter = getExcelData(prop.getProperty("TableDataSearchSheetName"),1, 2);
		
		String UsernameToString = EnterUserNameFilter.getStringCellValue();
		//System.out.println("Enter Username as ----- " +EnterUserNameFilter);
		driver.findElement(By.xpath("UsernameFiltersElement")).sendKeys(UsernameToString);
		Thread.sleep(2000);
		APP_LOGS.info("Enter username filter");
	}

	//Enter data in the FirstName Filter Textbox, in the Table Search Data page
	public static void firstNameFilter()  throws Exception
	{
		driver.findElement(By.xpath("NumberFiltersElement")).clear();
		driver.findElement(By.xpath("UsernameFiltersElement")).clear();
		driver.findElement(By.xpath("LastnameFiltersElement")).clear();
		
		Cell EnterFirstNameFilter = getExcelData(prop.getProperty("TableDataSearchSheetName"),1, 3);
		
		String FirstNametoString = EnterFirstNameFilter.getStringCellValue();
		//System.out.println("Enter First name as ------ " +EnterFirstNameFilter);
		driver.findElement(By.xpath("FirstnameFiltersElement")).sendKeys(FirstNametoString);
		Thread.sleep(2000);
		APP_LOGS.info("Enter first name filter");
	}

	////Enter data in the Lastname Filter Textbox, in the Table Search Data page
	public static void lastNameFilter() throws Exception
	{
		driver.findElement(By.xpath("NumberFiltersElement")).clear();
		driver.findElement(By.xpath("UsernameFiltersElement")).clear();
		driver.findElement(By.xpath("FirstnameFiltersElement")).clear();
		
		Cell EnterLastNameFilter = getExcelData(prop.getProperty("TableDataSearchSheetName"),1, 4);
		
		String LastNameToString = EnterLastNameFilter.getStringCellValue();
		//System.out.println("Enter Last Name as ------ " +EnterLastNameFilter);
		driver.findElement(By.xpath("LastnameFiltersElement")).sendKeys(LastNameToString);
		Thread.sleep(2000);
		APP_LOGS.info("Enter last name filter");
	}

	/*@AfterSuite
	public void after()
	{
		  TestBase.destroy();
	}
	@BeforeSuite
		public void before() throws Throwable
		{
		TestBase.initialization();
	}*/


}
