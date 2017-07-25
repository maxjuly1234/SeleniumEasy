package com.automation.testcases;

import org.apache.log4j.Logger;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pageobjects.BootstrapAlertDemoPage;
import com.automation.pageobjects.MainClass;

public class BootstrapAlertsPageTest extends BootstrapAlertDemoPage{
	public static final Logger APP_LOGS=Logger.getLogger(BootstrapAlertsPageTest.class.getName());
	
  @Test
  public void verifyBootstrapAlerts() throws InterruptedException {
	  System.out.println();
	  APP_LOGS.info("******************************************BOOTSTRAP ALERTS*********************************************");
	  //System.out.println();
	  MainClass.alertsAndModelsMenu();
	  MainClass.bootstrapAlert();
	  BootstrapAlertDemoPage.getBootstrapAlertMessage();
	 // MainClass.isAlertPresent();
	  APP_LOGS.info("==========================================End of verifyBootstrapAlerts Testcases=======================");
	  System.out.println();
  }
/*  @AfterClass
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
