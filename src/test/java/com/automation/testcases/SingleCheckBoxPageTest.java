package com.automation.testcases;
import org.apache.log4j.Logger;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pageobjects.SingleCheckboxDemoPage;


public class SingleCheckBoxPageTest{
	public static final Logger APP_LOGS=Logger.getLogger(SingleCheckBoxPageTest.class.getName());
	
	
	
	@Test
  public void checkSingleSelectCheckbox()
  {
		System.out.println();
		APP_LOGS.info("************************************CHECKBOX RELATED TESTCASES-SINGLESELECTCHECKBOX**************************************");
		SingleCheckboxDemoPage.inputForm();
		SingleCheckboxDemoPage.checkboxDemo();
		SingleCheckboxDemoPage.singleSelectCheckbox();
	  APP_LOGS.info("=====================================End of checkSingleSelectCheckbox Testcase====================================");
	  System.out.println();
	  //MainClass.verifySelected();
  }
	@Test(priority=1)
	public void verifyCheckboxPage()
	{
		System.out.println();
		SingleCheckboxDemoPage.inputForm();
		SingleCheckboxDemoPage.checkboxDemo();
		SingleCheckboxDemoPage.singleSelectCheckbox();
		SingleCheckboxDemoPage.verifyCheckboxDemoPage();
		APP_LOGS.info("=====================================End of VerifyCheckbox DemoPage Testcase====================================");
		System.out.println();
	}

	@Test(priority=2)
	public void verifySucessMessage()
	{
		System.out.println();
		SingleCheckboxDemoPage.inputForm();
		SingleCheckboxDemoPage.checkboxDemo();
		SingleCheckboxDemoPage.singleSelectCheckbox();
		SingleCheckboxDemoPage.compareMessage();
		 APP_LOGS.info("=====================================End of verifySuccessMessage Testcase====================================");
		 System.out.println();
	}
	/*@AfterClass
	  public void after()
	  {
		  TestBase.destroy();
	  }
	@BeforeClass
		public void before() throws Throwable
		{
		TestBase.initialization();
		}*/
}
	

