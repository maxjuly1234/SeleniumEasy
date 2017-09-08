package com.automation.testcases.bala;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.bala.BasicRadioButtons;

public class BasicRadioButtonsTest extends TestBase{

	BasicRadioButtons brb;
	
	@Test
	public void basicradioTest(){
		
		brb=PageFactory.initElements(driver, BasicRadioButtons.class);
		
		brb.basicRadioBtn();
	}
	
}
