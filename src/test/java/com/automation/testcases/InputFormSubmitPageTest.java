/**
 * 
 */
package com.automation.testcases;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.AjaxFormSubmitPage;
import com.automation.pageobjects.InputFormSubmitPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author bbanduch
 *
 */
public class InputFormSubmitPageTest extends TestBase {

	String pageName = "InputFormSubmit";
	InputFormSubmitPage inputformSubmit;

	@Test(priority=1)
	public void inputFormSubmitLaunch() {
		try {
			//initialization();
			inputformSubmit = PageFactory.initElements(driver,InputFormSubmitPage.class);
			extentReport(pageName);
			inputformSubmit.inputFormLaunch();

		} catch (Throwable e) {

			e.printStackTrace();
			System.out.println("Some Error occured.. " + e.getMessage());
			System.out.println(e.getStackTrace());
			// ScreenShotCreator(driver,"AjaxSubmitError");
			screenShotCreator("InputFormSubmit Error");
			//rep.endTest(test);
			rep.flush();
		}
	}

	@Test(priority=2)
	public void validatingFieldsData() {
		inputformSubmit.inputFormSubmitInValidValidations();
	}

	@Test(priority=2,dataProvider = "DataSupply")
	public void enterInputFormDetails(String string1, String string2,
			String string3, String string4, String string5, String string6,
			String string7, String string8, String string9) throws Throwable {

		inputformSubmit.enterInputFormDetails(string1, string2, string3,
				string4, string5, string6, string7, string8, string9); // With
																		// Data
																		// Provider
																		// set

	}

	@DataProvider(name = "DataSupply")
	public Object[][] getData() {
		Object[][] data = new Object[2][9];

		try {

			data[0][0] = (getExcelDataInString(pageName, 0, 0));
			data[0][1] = (getExcelDataInString(pageName, 0, 1));
			data[0][2] = (getExcelDataInString(pageName, 0, 2));
			data[0][3] = (getExcelDataInString(pageName, 0, 3));
			data[0][4] = (getExcelDataInString(pageName, 0, 4));
			data[0][5] = (getExcelDataInString(pageName, 0, 5));
			data[0][6] = (getExcelDataInString(pageName, 0, 6));
			data[0][7] = (getExcelDataInString(pageName, 0, 7));
			data[0][8] = (getExcelDataInString(pageName, 0, 8));

			data[1][0] = (getExcelDataInString(pageName, 1, 0));
			data[1][1] = (getExcelDataInString(pageName, 1, 1));
			data[1][2] = (getExcelDataInString(pageName, 1, 2));
			data[1][3] = (getExcelDataInString(pageName, 1, 3));
			data[1][4] = (getExcelDataInString(pageName, 1, 4));
			data[1][5] = (getExcelDataInString(pageName, 1, 5));
			data[1][6] = (getExcelDataInString(pageName, 1, 6));
			data[1][7] = (getExcelDataInString(pageName, 1, 7));
			data[1][8] = (getExcelDataInString(pageName, 1, 8));

			/*
			 * data[2][0]=(getExcelData1(pageName, 2, 0));
			 * data[2][1]=(getExcelData1(pageName, 2, 1));
			 * data[2][2]=(getExcelData1(pageName, 2, 2));
			 * data[2][3]=(getExcelData1(pageName, 2, 3));
			 * data[2][4]=(getExcelData1(pageName, 2, 4));
			 * data[2][5]=(getExcelData1(pageName, 2, 5));
			 * data[2][6]=(getExcelData1(pageName, 2, 6));
			 * data[2][7]=(getExcelData1(pageName, 2, 7));
			 * data[2][8]=(getExcelData1(pageName, 2, 8));
			 */

			return data;

		} catch (Exception e) {

			e.printStackTrace();
			return data;
		}

	}

	@AfterTest
	public void inputFormTearDown() {
		//rep.endTest(test);
		rep.flush();
	}
	
	  @AfterMethod
	    public void getResult(ITestResult result) throws Exception
	    {
	        if (result.getStatus() == ITestResult.FAILURE)
	        {
	            String screenShotPath = screenShotCreator(driver, "MyFullPageScreenshot");
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	            test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	        }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	        rep.flush();
	    }
}
