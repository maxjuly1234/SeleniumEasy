package com.automation.util;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.util.Date;

//import com.aventstack.extentreports.DisplayOrder;
import com.aventstack.extentreports.ExtentReports;


public class ExtentManager_OLD {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			//String reportPath =FBConstants.REPORTS_PATH+fileName;
			
			String	reportPath="./extentReports/"+ fileName;
 
		//	extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			//extent.config(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));

			
			//extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional
			//extent.addSystemInfo("Selenium Version", "3.4.0").addSystemInfo(
				//	"Environement ::Bala's Laptop", "QA");
		}
		return extent;
	}
}
