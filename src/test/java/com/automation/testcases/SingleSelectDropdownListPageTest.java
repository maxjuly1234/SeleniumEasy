package com.automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.MainClass;
import com.automation.pageobjects.SingleSelectDropdownListDemoPage;

public class SingleSelectDropdownListPageTest extends SingleSelectDropdownListDemoPage {
	public static final Logger APP_LOGS=Logger.getLogger(SingleSelectDropdownListPageTest.class.getName());
	@Test
	  public void verifySelectDropdownListDemoPage()
	  {
		System.out.println();
		  MainClass.inputForm();
		  MainClass.selectDropdownListMenu();
		  SingleSelectDropdownListDemoPage.verifySelectDropdownListPage();
		  
		  APP_LOGS.info("=====================================End of verifySelectDropdownListPage Testcase====================================");
		  System.out.println();
		  
	  }
  @Test(priority=1)
  public void SelectDay() {
	  System.out.println();
	  APP_LOGS.info("***************************************SingleSelectDropdownList related Testcase**************************");

	  MainClass.inputForm();
	  MainClass.selectDropdownListMenu();
	  SingleSelectDropdownListDemoPage.selectADay(false);
	  APP_LOGS.info("=====================================End of SelectDay Testcase====================================");
	  System.out.println();
  }
  
  @Test(priority=2)
  public void verifySuccessMessage()
  
  {
	  System.out.println();
  MainClass.inputForm();
  MainClass.selectDropdownListMenu();
  SingleSelectDropdownListDemoPage.selectADay(true);
  APP_LOGS.info("=================================End of verfy Success Message testcase===================");
  System.out.println();
  }
 /* @AfterClass
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
