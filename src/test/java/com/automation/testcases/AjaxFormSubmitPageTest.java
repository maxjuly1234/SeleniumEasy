package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.AjaxFormSubmitPage;
import com.automation.pageobjects.InputFormSubmitPage;

public class AjaxFormSubmitPageTest  extends TestBase {

		
		@Test
		public void validatingFieldsData() throws Throwable
		{
			//WebDriver driver=TestBase.initialization(); // this is where i am starting browser
			
			//initialization(); // ----> Comment this if you running in Batch Mode<----
			
			AjaxFormSubmitPage ajaxFormSbumit=PageFactory.initElements(driver, AjaxFormSubmitPage.class);
			ajaxFormSbumit.ajaxFormLaunc();
			ajaxFormSbumit.ajaxFormSubmitInValidValidations();
			ajaxFormSbumit.enterAjaxFormDetails();
			
		}
		
}
