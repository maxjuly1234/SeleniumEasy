package com.automation.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.AjaxFormSubmitPage;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Status;

public class AjaxFormSubmitPageTest extends TestBase {

	// ExtentReports rep=ExtentManager.getInstance();
	String sheetName = "AjaxFormSubmitPageTest";
	AjaxFormSubmitPage ajaxFormSbumit;

	@Test(priority = 1)
	public void ajaxSubmitPageLaunch() {
		try {
			 //initialization();
			ajaxFormSbumit = PageFactory.initElements(driver,AjaxFormSubmitPage.class);
			APP_LOGS.info("PageObject created");

			extentReport(sheetName);
			ajaxFormSbumit.ajaxFormLaunc();
			//test.log(Status.INFO, "Ajax Form page appeared on Screen");   ------> OLD extent Report 2.X Reports
			test.log(Status.INFO, "Ajax Form page appeared on Screen");

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ----> Comment this if you running in Batch Mode<----
	}

	@Test(priority = 2)
	public void validatingFieldsData() {
		try {
			ajaxFormSbumit.ajaxFormSubmitInValidValidations();
			test.log(Status.INFO, "Ajax Form page validation completed");
			//extentReport(sheetName);

		} catch (Throwable t) {
			//System.out.println("Some Error occured.. " + e.getMessage());
			//System.out.println(e.getStackTrace());
			// ScreenShotCreator(driver,"AjaxSubmitError");
			//screenShotCreator("AjaxSubmitError");
			//rep.endTest(test);
			t.printStackTrace();
			test.log(Status.FAIL, "Ajax Form page Validation Couldn't happen");
			// rep.flush();
		}

	}

	@Test(priority = 3)
	public void submitAjaxForm() {
		try {
			ajaxFormSbumit.enterAjaxFormDetails();
			test.log(Status.PASS, "Ajax Form page submitted");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.FAIL, "Ajax Form page Submit Couldn't happen");
		}

	}

	@AfterTest
	public void closeReport() {
		//rep.endTest(test);
		rep.flush();
		
		

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenShotPath = screenShotCreator(result.getName());
			
			//test.log(Status.INFO, "This is path"+screenShotPath);

			test.log(Status.FAIL, result.getThrowable());

			test.log(Status.INFO, "This is path"+screenShotPath);
			
			
			//try {
				test.log(Status.FAIL,"Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
				
				test.fail("SnapShot Below", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				
				test.fail("error").addScreenCaptureFromPath(screenShotPath);
				
			
				
			/*} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			

		}

		//rep.endTest(test);
		
		rep.flush();

	}
}