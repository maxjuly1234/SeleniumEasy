package com.automation.testcases.bala;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.bala.CheckBox;

public class CheckBoxTest extends TestBase{
	String pageName = "Checkbox";
	CheckBox checkboxPF;
	//checkboxPF = PageFactory.initElements(driver, CheckBox.class);
	
	
	@Test(priority=1)
	public void singleCheckBoxTest() throws Throwable{
		//initialization();
		checkboxPF = PageFactory.initElements(driver, CheckBox.class);
		extentReport(pageName);
		checkboxPF.launch();
		
		
	}
	
	@Test(priority=2)
	public void multiSelectBoxText() throws InterruptedException{
		checkboxPF.multipleChkBox();
		
	}

}
