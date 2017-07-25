package com.automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.JavascriptAlertDemoPage;
import com.automation.pageobjects.MainClass;

public class JavaScriptAlertPageTest extends JavascriptAlertDemoPage{
	public static final Logger APP_LOGS=Logger.getLogger(JavaScriptAlertPageTest.class.getName());
	

  @Test
  public void verifyJavascriptAlertPage() throws InterruptedException {
	  System.out.println();
	  APP_LOGS.info("******************************JAVASCRIPT ALERT***************************************");
	  //System.out.println();

	  MainClass.alertsAndModelsMenu();
	  MainClass.javascriptAlert();
      APP_LOGS.info("==============================End of verifyJavaScriptAlertPage TestCase========================");
      System.out.println();
  }
  @Test(priority=1)
  public static void getAlertMessage() throws InterruptedException
  {
	  
	  System.out.println();
	  MainClass.alertsAndModelsMenu();
	  MainClass.javascriptAlert();
	  JavascriptAlertDemoPage.getAlert(false);
	  //driver.
	  APP_LOGS.info("==============================End of getAlertMessage Testcase========================");
	  System.out.println();

	 
	  //MainClass.acceptAlert();
  }
  @Test(priority=2)
  public static void acceptAlertMessage() throws InterruptedException
  {
	  System.out.println();
	  MainClass.alertsAndModelsMenu();
	  MainClass.javascriptAlert();
	  JavascriptAlertDemoPage.getAlert(true);
	  APP_LOGS.info("==============================End of acceptAlertMessage Testcase========================");
	  System.out.println();
  }

/*  @AfterClass
  public static void destroyBrowser()
  {
	TestBase.destroy();
  }
	  
  
@BeforeClass
public static void login() throws Throwable
{
		
		TestBase.initialization();
}*/}
