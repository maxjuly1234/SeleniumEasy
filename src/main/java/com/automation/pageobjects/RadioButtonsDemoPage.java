package com.automation.pageobjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;

import com.automation.base.TestBase;

public class RadioButtonsDemoPage extends TestBase

{
	public static final Logger APP_LOGS=Logger.getLogger(RadioButtonsDemoPage.class.getName());
	
	
	//Method to click on input form
		public static void clickInputForm()
		{
			//System.out.println("click on InputFormlink");
			driver.findElement(By.xpath(prop.getProperty("inputformlink"))).click();
			APP_LOGS.info("Input Form Link is clicked");
		}
	
	//Method to click on Radio Buttons Demo Link
		public static String clickRadioButtonsDemo()
		{
			driver.findElement(By.xpath(prop.getProperty("RadioButtonsDemoLink"))).click();
			APP_LOGS.info("Radio Buttons Demo link is clicked");
			return driver.getCurrentUrl();
		}
		
		
	//Method to verify if Radio Buttons Demo  page is loaded
		public static void verifyRadioBtnDemoNavigation(String URL,String ExpectedWelcomeTextRadBtn)
		{
			//URL = clickSimpleFormDemo();
			String ActualWelcomeTextRadBtn = driver.findElement(By.xpath(prop.getProperty("WelcomeTextRadBtn"))).getText();
			
			APP_LOGS.info("Actual Welcome Text displayed for Radio Btns Demo page Is: " +ActualWelcomeTextRadBtn );
			APP_LOGS.info("Expected Welcome Text for Radio Btns Demo page Is: " +ExpectedWelcomeTextRadBtn );
			if(ActualWelcomeTextRadBtn.equals(ExpectedWelcomeTextRadBtn))
			{
				APP_LOGS.info("Successfully Navigated To Simple Form Demo page");
			}
			else
			{
				APP_LOGS.info("Simple Form Demo link is NOT LOADED");
			}
		}
	//Method to print expected gender to select
		public static void printExpectedGenderToSelect(String GenderToSelect)
		{
			APP_LOGS.info("Expected Gender To Select Is : " +GenderToSelect );
		}
		
	//Method to select gender Male or Female
		public static String selectGender(String GenderToSelect)
		
		{
			switch(GenderToSelect)
			{
			case "Male":
				APP_LOGS.info("Selected Male radio button");
				driver.findElement(By.xpath(prop.getProperty("MaleRadioButton1"))).click();
				break;
			case "Female":
				APP_LOGS.info("Selected Female radio button");
				driver.findElement(By.xpath(prop.getProperty("FemaleRadioButton1"))).click();
				break;
			default:
				APP_LOGS.info("No Gender to Select (OR) Invalid Gender");
				break;

			}
			return GenderToSelect;
			
		}
	//Method to get the Actual Result Displayed
		public static String getActualResultOfSingleRadioBtn()
		{
			String ActualResultSingleRadBtn = driver.findElement(By.xpath(prop.getProperty("SingleRadioActualResult"))).getText();
			//APP_LOGS.info("Actual Result Displayed On click of Get Checked value Button is: "+ActualResultSingleRadBtn );
			return ActualResultSingleRadBtn;
			
		}
		
	//Method to print the Actual Result Displayed
		public static void printActualResultOfSingleRadioBtn()
		{
			String ActualResultSingleRadBtn = driver.findElement(By.xpath(prop.getProperty("SingleRadioActualResult"))).getText();
			APP_LOGS.info("Actual Result Displayed On click of Get Checked value Button is: "+ActualResultSingleRadBtn );
		
		}
		
	//Method to set Expected Result to Be displayed
		public static String setExpectedResultOfSingleRadioBtn(String GenderToSelect)
		{
			switch(GenderToSelect)
			
			{
			case "Male":
				String ExpectedResultSingleRadBtnMale ="Radio button 'Male' is checked";
				//APP_LOGS.info("Expected Result is: " +ExpectedResultSingleRadBtnMale  );
				return ExpectedResultSingleRadBtnMale;
				
			case "Female":
				String ExpectedResultSingleRadBtnFemale ="Radio button 'Female' is checked";
				//APP_LOGS.info("Expected Result is: " +ExpectedResultSingleRadBtnFemale  );
				return ExpectedResultSingleRadBtnFemale;
			default:
				String ExpectedResultSingleRadBtnNone ="Radio button is Not checked";
				//APP_LOGS.info("Expected Result is: " +ExpectedResultSingleRadBtnNone  );
				return ExpectedResultSingleRadBtnNone;

			}	
		}
	
	
		//Method to print Expected Result to Be displayed
				public static void printExpectedResultOfSingleRadioBtn(String GenderToSelect)
				{
					switch(GenderToSelect)
					
					{
					case "Male":
						String ExpectedResultSingleRadBtnMale ="Radio button 'Male' is checked";
						APP_LOGS.info("Expected Result is: " +ExpectedResultSingleRadBtnMale  );
						break;
						
					case "Female":
						String ExpectedResultSingleRadBtnFemale ="Radio button 'Female' is checked";
						APP_LOGS.info("Expected Result is: " +ExpectedResultSingleRadBtnFemale  );
						break;
						
					default:
						String ExpectedResultSingleRadBtnNone ="Radio button is Not checked";
						APP_LOGS.info("Expected Result is: " +ExpectedResultSingleRadBtnNone  );
						break;

					}	
				}
	//Method to click on Get Checked Value Button
		
		public static void clickGetCheckedValue()
		{
			driver.findElement(By.xpath(prop.getProperty("GetCheckedValueButton"))).click();
			APP_LOGS.info("Clicked on Get Check Value Button" );
		}
		
	//Method to verify actual and expected gender selected
		public static void verifyGenderSelectionResult(String GenderToSelect)
		{
			RadioButtonsDemoPage.printExpectedResultOfSingleRadioBtn(GenderToSelect);
			RadioButtonsDemoPage.printActualResultOfSingleRadioBtn();
			if(RadioButtonsDemoPage.getActualResultOfSingleRadioBtn().equals(RadioButtonsDemoPage.
					setExpectedResultOfSingleRadioBtn(GenderToSelect)))
			{
				APP_LOGS.info("The 'GET CHECKED VALUE' button is working AS EXPECTED.");
			}
			else
			{
				APP_LOGS.info("The 'GET CHECKED VALUE' button is NOT working AS EXPECTED.");
			}
		}
		
	//Method to check gender radio button with different test data
		public static void genderSelection(String FileName,String SheetName)
		{
			try
			{
				TestBase.openExcel(FileName, SheetName);
				TestBase.getTotalNoOfRows();
				TestBase.printTotalNoOfRows();
				for(int count= 1;count<=TestBase.getTotalNoOfRows();count++)
				{
				
					XSSFRow row = TestBase.currentRowNumber(count);
					
					
					if(TestBase.getTestDataName(row).equals("END"))
					{
						//System.out.println("TEST CASES ARE COMPLETED");
						break;	
					}
					else
					{
					TestBase.printTestDataName(row);
					RadioButtonsDemoPage.clickInputForm();
					RadioButtonsDemoPage.clickRadioButtonsDemo();
					RadioButtonsDemoPage.printExpectedGenderToSelect(row.getCell(1).toString());
					RadioButtonsDemoPage.selectGender(row.getCell(1).toString());
					RadioButtonsDemoPage.clickGetCheckedValue();
					RadioButtonsDemoPage.getActualResultOfSingleRadioBtn();
					RadioButtonsDemoPage.setExpectedResultOfSingleRadioBtn(row.getCell(1).toString());
					RadioButtonsDemoPage.verifyGenderSelectionResult(row.getCell(1).toString());
					}
				
				} 
				Excelfis.close();
			}
			catch (IOException e)
			{
				APP_LOGS.info("File Not Found");
			}
		}
		
	//Method to Select Gender from Group Radio Buttons
		public static String selectGenderFrmGroup(String GenderToSelect)
		
			{
				switch(GenderToSelect)
				{
				case "Male":
					APP_LOGS.info("Selected Male radio button");
					driver.findElement(By.xpath(prop.getProperty("MaleRadioButtonGroup"))).click();
					break;
				case "Female":
					APP_LOGS.info("Selected Female radio button");
					driver.findElement(By.xpath(prop.getProperty("FemaleRadioButtonGroup"))).click();
					break;
				default:
					APP_LOGS.info("No Gender to Select (OR) Invalid Gender");
					break;
				}
				return GenderToSelect;
			}
	//Method To identify Age Group
		public static String identifyAgeGroup(int Age)
		{
			String AgeGroup;
			if(Age>=0 && Age<=5)
			{
				 AgeGroup = "0-5";
			}
			else if(Age>=6 && Age<=15)
			{
				AgeGroup = "5-15";
			}
			else if(Age>=16 && Age<=50)
				
			{
				AgeGroup = "15-50";	
			}
			else
			{
				AgeGroup = String.valueOf(Age);
			}
			return AgeGroup;
		}
	//Method to Print Expected Age Group To Select
		public static void printExpectedAgeGroup(int Age,String AgeGroupToSelect)
		{
			APP_LOGS.info("The Given Age is : " +Age );
			if(Age<=50)
			{
				APP_LOGS.info("So, Expected Age Group To Be Selected is : " +AgeGroupToSelect );
			}
			else 
			{
				APP_LOGS.info("Invalid Age Group - NO AGE GROUP TO BE SELECTED");
			}
			
			
		}
		
	//Method to select Age Group
		public static void selectAgeGroup(String AgeGroupToSelect)
		{
			
			switch(AgeGroupToSelect)
			{
			case "0-5":
				
				driver.findElement(By.xpath(prop.getProperty("AgeGroup0-5"))).click();
				APP_LOGS.info("Selected Age Group is '0-5'");
				break;
				
			case "5-15": 
				driver.findElement(By.xpath(prop.getProperty("AgeGroup5-15"))).click();
				APP_LOGS.info("Selected Age Group is '5-15'");
				break;
				
			case "15-50":
				driver.findElement(By.xpath(prop.getProperty("AgeGroup15-50"))).click();
				APP_LOGS.info("Selected Age Group is '15-50'");
				break;
				
			default:
				
				APP_LOGS.info("No AGE GROUP SELECTED");
				break;
		
			}	
		}

	//Method to click on Get Values button
		public static void clickGetValuesBtn()
		
		{
			driver.findElement(By.xpath(prop.getProperty("GetValuesBtn"))).click();
			APP_LOGS.info("Clicked On GET VALUES Button");
		}

		
	//Method To set Expected Result For gender
		
		public static String expectedTextForGender(String GenderToSelect)
		{
			String expectedGenderText;
			switch(GenderToSelect)
			{
			case "Male":
				expectedGenderText ="Male";
				APP_LOGS.info("Result should contain 'Sex : Male' ");
				break;
			case "Female":
				expectedGenderText ="Female";
				APP_LOGS.info("Result should contain 'Sex : Female' ");
				break;
			default:
				expectedGenderText ="Sex:";
				APP_LOGS.info("Result should NOT contain the words Either 'Male' OR 'Female' ");
				break;
			}
			return expectedGenderText;
			
		}
		
		
	//Method To set Expected Result For Age Group
		
		public static String expectedTextForAge(String AgeGroupToSelect)
		{
			String expectedAgeText;
			switch(AgeGroupToSelect)
			{
			case "0-5":
				expectedAgeText ="0-5";
				APP_LOGS.info("And Age group should be 'Age Group : 0-5'");
				break;
			case "5-15":
				expectedAgeText ="5-15";
				APP_LOGS.info("And Age group should be 'Age Group : 5-15'");
				break;
			case "15-50":
				expectedAgeText ="15-50";
				APP_LOGS.info("And Age group should be 'Age Group : 15-50'");
				break;
			default:
				expectedAgeText = "Null";
				APP_LOGS.info("And Age Group should NOT contain any of the following: '0-5','5-15','15-50'");
				break;
				
			}
			return expectedAgeText;
		}
	//Method To get Result displayed for group radio button
		public static String getResultOfGroupRadioBtn()
		
		{
			String ActualResultGroupRadBtn = driver.findElement(By.xpath(prop.getProperty("GroupRadioActualResult"))).getText();
			return ActualResultGroupRadBtn;
		}
	
	//Verify Gender Result
		public static String verifyGenderResult(String GenderToSelect)
		{
			String GenderResult ;
			if(RadioButtonsDemoPage.getResultOfGroupRadioBtn().contains(GenderToSelect))
			{
				GenderResult = "PASS";
			}
			
			else if (RadioButtonsDemoPage.getResultOfGroupRadioBtn().contains(GenderToSelect))
			{
				GenderResult = "PASS";
			}
			
			else 
			{
				GenderResult = "PASS";
			}
			return GenderResult;
		}
	//Verify Age Group Result
		public static String verifyAgeGrpResult(int Age)
		{
			String AgeGrpResult ;
			if(RadioButtonsDemoPage.getResultOfGroupRadioBtn().contains(String.valueOf(Age)))
			{
				AgeGrpResult = "PASS";
			}
			
			else if (RadioButtonsDemoPage.getResultOfGroupRadioBtn().contains(String.valueOf(Age)))
			{
				AgeGrpResult = "PASS";
			}
			
			else if (RadioButtonsDemoPage.getResultOfGroupRadioBtn().contains(String.valueOf(Age)))
			{
				AgeGrpResult = "PASS";
			}
			else 
			{
				AgeGrpResult = "PASS";
			}
			return AgeGrpResult;
		}
		
	//Verify OverAll Result
		public static void verify(String GenderToSelect,int Age)
		{
			if(RadioButtonsDemoPage.verifyGenderResult(GenderToSelect).equals("PASS") && RadioButtonsDemoPage.verifyAgeGrpResult(Age).equals("PASS") )
			{
				APP_LOGS.info("Both Gender and Age Grp Selections Are As Expected");
			}
			else
			{
				APP_LOGS.info("Either Gender OR Age Grp failed");
			}
		}
	
	//Method to check gender radio button with different test data
		public static void groupRadioSelection(String FileName,String SheetName)
		{
			try
			{
				TestBase.openExcel(FileName, SheetName);
				TestBase.getTotalNoOfRows();
				TestBase.printTotalNoOfRows();
				for(int count= 1;count<=TestBase.getTotalNoOfRows();count++)
				{
				
					XSSFRow row = TestBase.currentRowNumber(count);
					
					
					if(TestBase.getTestDataName(row).equals("END"))
					{
						
						break;	
					}
					else
					{
					TestBase.printTestDataName(row);
					RadioButtonsDemoPage.clickInputForm();
					RadioButtonsDemoPage.clickRadioButtonsDemo();
					RadioButtonsDemoPage.printExpectedGenderToSelect(row.getCell(1).toString());
					RadioButtonsDemoPage.selectGenderFrmGroup(row.getCell(1).toString());
					RadioButtonsDemoPage.identifyAgeGroup((int)row.getCell(2).getNumericCellValue());
					String AgeGroupToSelect=RadioButtonsDemoPage.identifyAgeGroup((int)row.getCell(2).getNumericCellValue());
					RadioButtonsDemoPage.printExpectedAgeGroup((int)row.getCell(2).getNumericCellValue(),AgeGroupToSelect);
					RadioButtonsDemoPage.selectAgeGroup(AgeGroupToSelect);
					RadioButtonsDemoPage.clickGetValuesBtn();
					RadioButtonsDemoPage.expectedTextForGender(row.getCell(1).toString());
					RadioButtonsDemoPage.expectedTextForAge(AgeGroupToSelect);
					APP_LOGS.info("The Actual Result Displayed is: " +RadioButtonsDemoPage.getResultOfGroupRadioBtn());
					RadioButtonsDemoPage.getResultOfGroupRadioBtn();
					RadioButtonsDemoPage.verify(row.getCell(1).toString(),(int)row.getCell(2).getNumericCellValue());
					
					}
				
				} 
				Excelfis.close();
			}
			catch (IOException e)
			{
				APP_LOGS.info("File Not Found");
			}
		}
		
		
}
