package com.automation.testcases;

import org.apache.log4j.Logger;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pageobjects.MainClass;
import com.automation.pageobjects.MultipleSelectDropdownListDemoPage;

public class MultipleSelectDropdownListPageTest extends MultipleSelectDropdownListDemoPage{
	public static final Logger APP_LOGS=Logger.getLogger(MultipleSelectDropdownListPageTest.class.getName());
	
  @Test
  public void selectMultipleOption() throws InterruptedException {
	  System.out.println();
	  APP_LOGS.info("*******************************MULTIPLE SELECT DROPDOWN LIST******************************");
	 // System.out.println();
	  MainClass.inputForm();
	  MainClass.selectDropdownListMenu();
	  MultipleSelectDropdownListDemoPage.firstlySelected();
	  APP_LOGS.info("===============================End of selectMultipleOption TestCase============================");
	  System.out.println();
  }
  @Test(priority=1)
  public void getAllOptionsInlistBox()
  {
	  System.out.println();
	  MainClass.inputForm();
	  MainClass.selectDropdownListMenu();
	  MultipleSelectDropdownListDemoPage.getAllOptions();
	  APP_LOGS.info("===============================End of getAllOptionsInlistBox TestCase============================");
	  System.out.println();
  }

  @Test(priority=2)
  public void getAllSelectedOptions() throws InterruptedException
  {
	  System.out.println();
	  MainClass.inputForm();
	  MainClass.selectDropdownListMenu();
	  MultipleSelectDropdownListDemoPage.firstlySelected();
	  APP_LOGS.info("===============================End of getAllSelectedOptions TestCase============================");
	  System.out.println();

  }
  /* @BeforeClass
  public static void before() throws Throwable
  {
	  TestBase.initialization();
  }

@AfterClass
	public static void after()
	{
		TestBase.destroy();
	}*/
}
