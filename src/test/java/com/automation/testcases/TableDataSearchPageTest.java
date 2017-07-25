package com.automation.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
//import com.automation.pageobjects.MainClass;
import com.automation.pageobjects.TableDataSearchPage;

public class TableDataSearchPageTest
{
	public static final Logger APP_LOGS=Logger.getLogger(TableDataSearchPageTest.class.getName());
	//private Utility utility;
	
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
	
	@Test
	public void verifyTableDataSearchPage() throws Exception
	{
		//APP_LOGS.info("******************************************Table Data Search Page*********************************************");
		
		//TestBase.LogBefore(this.getClass().getName());
		
		//InitandDestroy.class.getName();
		//demowebsitepage = new DemoWebsitePage(driver);
		
		//Assert.assertTrue(MainClass.tableDataSearchTitleVerify(), "Table SearchData Page Title doesnt match");
		
		TableDataSearchPage.ScrollDown();
		TableDataSearchPage.tableclick();
		TableDataSearchPage.tableDataSearchclick();
		Thread.sleep(2000);
		TableDataSearchPage.enterFilterTasksTextbox();

		TableDataSearchPage.clickFiltersIcon();
		Thread.sleep(2000);
		TableDataSearchPage.ScrollDown();
		
		//for(int row=1; row < MainClass.totrows; row++)
		//{
		//	for (int col=0; col < MainClass.totcols; col++)
		//	{
		TableDataSearchPage.enterNumberFilter();
		TableDataSearchPage.usernameFilter();
		TableDataSearchPage.firstNameFilter();
		TableDataSearchPage.lastNameFilter();	
		//	}
		//}
		
/*		MainClass.enterNumberFilter();
		MainClass.usernameFilter();
		MainClass.firstNameFilter();
		MainClass.lastNameFilter();		*/
		
		//APP_LOGS.info("******************************************End of Table Data Search Page Testcases*********************************************");
		//TestBase.LogAfter(this.getClass().getName());
		}
	
	

}
