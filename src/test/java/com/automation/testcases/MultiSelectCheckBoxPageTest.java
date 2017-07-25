package com.automation.testcases;

import org.apache.log4j.Logger;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.automation.pageobjects.MainClass;
import com.automation.pageobjects.MultiSelectCheckBoxDemoPage;

public class MultiSelectCheckBoxPageTest {
	public static final Logger APP_LOGS=Logger.getLogger(MultiSelectCheckBoxPageTest.class.getName());
	

	@Test
  public void verifyCheckAllButtonCLick()
  {
		System.out.println();
		APP_LOGS.info("********************************CHECKBOXDEMO-MULTISELECTCHECKBOX*****************************");
		//System.out.println();
		MainClass.inputForm();
		MainClass.checkboxDemo();
		MultiSelectCheckBoxDemoPage.selectAllCheckbox();
	  APP_LOGS.info("=============================End Of verifyCheckAllButtonClick TestCase===========================");
  }
	@Test(priority=1)
	public void verifyButtonLabel()
	{
		System.out.println();
		MainClass.inputForm();
	     MainClass.checkboxDemo();
	     MultiSelectCheckBoxDemoPage.selectAllCheckbox();
	     MultiSelectCheckBoxDemoPage.getButtonLabel();
	     APP_LOGS.info("=============================End Of verifyButtonLabel TestCase-Button Label Changed to Uncheck All after selecting all options===========================");
	     System.out.println();
	}
	@Test(priority=2)
	public void verifyBUttonLabelAfterDeselectOneOption()
	{
		System.out.println();
		 MainClass.inputForm();
	     MainClass.checkboxDemo();
	     MultiSelectCheckBoxDemoPage.selectAllCheckbox();
	     MultiSelectCheckBoxDemoPage.deselectOneCheckbox();
	     APP_LOGS.info("=============================End Of verifyBUttonLabelAfterDeselectOneOption TestCase-Button Label Changed to Check All after selecting all options=======");
	     System.out.println();

	}
	@Test(priority=3)
	public void verifyAllOptionSelect() throws InterruptedException
	{
		System.out.println();
		 MainClass.inputForm();
	     MainClass.checkboxDemo();
	     MultiSelectCheckBoxDemoPage.selectAllOptions();
	     MultiSelectCheckBoxDemoPage.getButtonLabel();//need to c this once again..when i select option3 the button label changing to checkAll again
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
