package com.automation.pageobjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.TestBase;

public class SimpleFormDemoPage extends TestBase 

{
	public static final Logger APP_LOGS=Logger.getLogger(MainClass.class.getName());
	
	//Method to click on input form
	public static void clickInputForm()
	{
		//System.out.println("click on InputFormlink");
		driver.findElement(By.xpath(prop.getProperty("inputformlink"))).click();
		APP_LOGS.info("Input Form Link is clicked");
	}
	
	
	//Method to click on Simple Form Demo Link
	public static String clickSimpleFormDemo()
	
	{
		driver.findElement(By.xpath(prop.getProperty("SimpleFormDemoLink"))).click();
		APP_LOGS.info("Simple Form Demo link is clicked");
		return driver.getCurrentUrl();
	}
	
	//Method to verify if simple input form page is loaded
	public static void verifySimpleFormNavigation(String URL,String ExpectedWelcomeText)
	{
		//URL = clickSimpleFormDemo();
		String ActualWelcomeText = driver.findElement(By.xpath(prop.getProperty("SimpleFormWelcomeText"))).getText();
		
		APP_LOGS.info("Actual Welcome Text displayed for Simple Input Form Is: " +ActualWelcomeText );
		APP_LOGS.info("Expected Welcome Text for Simple Input Form Is: " +ExpectedWelcomeText );
		if(ActualWelcomeText.equals(ExpectedWelcomeText))
		{
			APP_LOGS.info("Successfully Navigated To Simple Form Demo page");
		}
		else
		{
			APP_LOGS.info("Simple Form Demo link is NOT LOADED");
		}
	}
	
	//Method to click on Show Message button
	public static void clickShowMessageBtn()
	
	{
		driver.findElement(By.xpath(prop.getProperty("ShowMessageButton"))).click();
		APP_LOGS.info("Show Message Button is clicked on");
		
	}
	

	
	//Method to validate the message displayed and message entered
	public static void validateMsgDisplayed(String ExpectedMsgXpath,String ActualMsgXpath)
	
	{
		String ExpectedMsg = driver.findElement(By.xpath(prop.getProperty(ExpectedMsgXpath))).getAttribute("value");
		
		String ActualMsg =driver.findElement(By.xpath(prop.getProperty(ActualMsgXpath))).getText();
		
		APP_LOGS.info("MESSAGE ENTERED IS : "+ ExpectedMsg);
		
		APP_LOGS.info("Message displayed is : "+ ActualMsg);
		
		if(ActualMsg.equals(ExpectedMsg))
		{
			//System.out.println("Entered Message and Displayed Message are SAME");
			APP_LOGS.info("Entered Message and Displayed Message are SAME");
		}
		else
		{
			//System.out.println("Entered Message and Displayed Message are DIFFERENT");
			APP_LOGS.info("Entered Message and Displayed Message are DIFFERENT");
		}
	}
	


	
//Method to enter message in text box
public static void enterIntoTextBox(String PropOfTextBox,String CellNo)
{
	WebElement EnterMsgText =driver.findElement(By.xpath(prop.getProperty(PropOfTextBox)));
	EnterMsgText.sendKeys(CellNo);
	APP_LOGS.info("Message is entered into text box");	
}



//Method to verify ShowmessageBtn With Single Text Field
public static void singleInputField(String FileName,String SheetName)

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
			SimpleFormDemoPage.clickInputForm();
			SimpleFormDemoPage.clickSimpleFormDemo();
			SimpleFormDemoPage.enterIntoTextBox("EnterMsgTextBox", row.getCell(1).toString());
			SimpleFormDemoPage.clickShowMessageBtn();
			SimpleFormDemoPage.validateMsgDisplayed("EnterMsgTextBox", "YourMessageText");	
			}
		
		} 
		Excelfis.close();
	}
	
	catch (IOException e) 
	{
        System.out.println("Test data file not found");
    } 

}	

//Method to enter values into fields enter a & enter b
public static void enterAandB(String PropOfFieldA,String PropOfFieldB,double CellNoA,double CellNoB)
{
	WebElement EnterA =driver.findElement(By.xpath(prop.getProperty(PropOfFieldA)));
	EnterA.sendKeys(String.valueOf((int)CellNoA));
	APP_LOGS.info("Value Of A is Entered");	
	WebElement EnterB =driver.findElement(By.xpath(prop.getProperty(PropOfFieldB)));
	EnterB.sendKeys(String.valueOf((int)CellNoB));
	APP_LOGS.info("Value Of B is Entered");	
}

//Method to print values of A & B
public static void printAandB(String PropOfFieldA,String PropOfFieldB)
{
	APP_LOGS.info("Value Of A is : "+ driver.findElement(By.xpath(prop.getProperty(PropOfFieldA))).getAttribute("value"));	
	APP_LOGS.info("Value Of B is : "+ driver.findElement(By.xpath(prop.getProperty(PropOfFieldB))).getAttribute("value"));	
}

//Method to click on Get Total Button
public static void clickGetTotalBtn()

{
	driver.findElement(By.xpath(prop.getProperty("GetTotalButton"))).click();
	APP_LOGS.info("Get Total Button is clicked on");
}

//Method to calculate sum of two numbers manually
private static int CalcExpectedSum(int A, int B)
{
	int ExpectedSum =A+B;
	APP_LOGS.info("Expected Sum Is: "+ ExpectedSum);
	return ExpectedSum;
	
}

//Method to get Actual Sum Displayed
private static int CalcActualSum()

{
	String Total=driver.findElement(By.xpath(prop.getProperty("TotalOfAandBText"))).getText();
	int ActualSum=Integer.valueOf(Total);
	APP_LOGS.info("Actual Sum Is: "+ ActualSum);
	return ActualSum;
	
	
}


//Method to verify expected and Actual sum displayed
private static void validateGetTotal(int A, int B) 
{
if(SimpleFormDemoPage.CalcActualSum()==(SimpleFormDemoPage.CalcExpectedSum(A, B)))	
{
	APP_LOGS.info("Expected and Actual SUM are SAME");
}

else
{
	APP_LOGS.info("Expected and Actual SUM are NOT SAME");	
}
	
}

//Method to verify Get Total Button of Two input Fields
public static void twoInputFields(String FileName,String SheetName)

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
			SimpleFormDemoPage.clickInputForm();
			SimpleFormDemoPage.clickSimpleFormDemo();
			SimpleFormDemoPage.enterAandB("EnterATextBox", "EnterBTextBox", (int)row.getCell(1).getNumericCellValue(), (int)row.getCell(2).getNumericCellValue());
			SimpleFormDemoPage.printAandB("EnterATextBox", "EnterBTextBox");
			SimpleFormDemoPage.clickGetTotalBtn();
			SimpleFormDemoPage.validateGetTotal((int)row.getCell(1).getNumericCellValue(), (int)row.getCell(2).getNumericCellValue());	
			}
		
		} 
		Excelfis.close();
	}
	
	catch (IOException e) 
	{
      System.out.println("Test data file not found");
  } 

}

}
