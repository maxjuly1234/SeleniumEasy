/**
 * 
 */
package com.automation.testcases;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pageobjects.AjaxFormSubmitPage;
import com.automation.pageobjects.InputFormSubmitPage;

/**
 * @author bbanduch
 *
 */
public class InputFormSubmitPageTest extends TestBase {

	String sheetName = "InputFormSubmit";
	InputFormSubmitPage inputformSubmit;

	@BeforeTest
	public void init() {
		try {
			//TestBase.initialization();
			inputformSubmit = PageFactory.initElements(driver,InputFormSubmitPage.class);
			inputformSubmit.inputFormLaunch();

		} catch (Throwable e) {

			e.printStackTrace();
		}
	}

	@Test
	public void validatingFieldsData() {
		inputformSubmit.inputFormSubmitInValidValidations();
	}

	@Test(dataProvider = "DataSupply")
	public void enterInputFormDetails(String string1, String string2,
			String string3, String string4, String string5, String string6,
			String string7, String string8, String string9) throws Throwable {
		// WebDriver driver=TestBase.initialization(); // this is where i am
		// starting browser
		// inputformSubmit.enterInputFormDetails(); // With no Data Provider
		inputformSubmit.enterInputFormDetails(string1, string2, string3,
				string4, string5, string6, string7, string8, string9); // With
																		// Data
																		// Provider
																		// set

	}

	@DataProvider(name = "DataSupply")
	public Object[][] getData() {
		Object[][] data = new Object[2][9];

		try {

			data[0][0] = (getExcelDataInString(sheetName, 0, 0));
			data[0][1] = (getExcelDataInString(sheetName, 0, 1));
			data[0][2] = (getExcelDataInString(sheetName, 0, 2));
			data[0][3] = (getExcelDataInString(sheetName, 0, 3));
			data[0][4] = (getExcelDataInString(sheetName, 0, 4));
			data[0][5] = (getExcelDataInString(sheetName, 0, 5));
			data[0][6] = (getExcelDataInString(sheetName, 0, 6));
			data[0][7] = (getExcelDataInString(sheetName, 0, 7));
			data[0][8] = (getExcelDataInString(sheetName, 0, 8));

			data[1][0] = (getExcelDataInString(sheetName, 1, 0));
			data[1][1] = (getExcelDataInString(sheetName, 1, 1));
			data[1][2] = (getExcelDataInString(sheetName, 1, 2));
			data[1][3] = (getExcelDataInString(sheetName, 1, 3));
			data[1][4] = (getExcelDataInString(sheetName, 1, 4));
			data[1][5] = (getExcelDataInString(sheetName, 1, 5));
			data[1][6] = (getExcelDataInString(sheetName, 1, 6));
			data[1][7] = (getExcelDataInString(sheetName, 1, 7));
			data[1][8] = (getExcelDataInString(sheetName, 1, 8));

			/*
			 * data[2][0]=(getExcelData1(sheetName, 2, 0));
			 * data[2][1]=(getExcelData1(sheetName, 2, 1));
			 * data[2][2]=(getExcelData1(sheetName, 2, 2));
			 * data[2][3]=(getExcelData1(sheetName, 2, 3));
			 * data[2][4]=(getExcelData1(sheetName, 2, 4));
			 * data[2][5]=(getExcelData1(sheetName, 2, 5));
			 * data[2][6]=(getExcelData1(sheetName, 2, 6));
			 * data[2][7]=(getExcelData1(sheetName, 2, 7));
			 * data[2][8]=(getExcelData1(sheetName, 2, 8));
			 */

			return data;

		} catch (Exception e) {

			e.printStackTrace();
			return data;
		}

	}
}
