package com.automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.util.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

import java.io.File;

//import org.testng.asserts.SoftAssert;

public class TestBase {
	public static WebDriver driver;
	public static FileInputStream fip;
	public static Properties prop;
	// public static Logger APP_LOGS=null;
	// public static SoftAssert st=null;
	public static boolean TestFail = false;
	public static int temp = 0;
	public static final Logger APP_LOGS = Logger.getLogger(TestBase.class
			.getName());

	public static FileInputStream Excelfis;
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell ExcelCell;
	public static XSSFRow ExcelRow;
	public static Sheet sheet;
	
	//public static ExtentReports report;
	public static ExtentTest test; 
	public static ExtentReports rep;
	
	
	
	public TestBase() {
	}

	public TestBase(WebDriver driver) {
		TestBase.driver = driver;

	}

	public static WebDriver initialization() throws Throwable {

		fip = new FileInputStream("./Files/or.properties");
		prop = new Properties();
		prop.load(fip);
		// APP_LOGS.debug("properties file is loaded");
		String browser = prop.getProperty("browsertype");
		// System.out.println("5");
		if (browser.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver",
					"./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			// APP_LOGS.debug("Mozilla fire fox browser started");
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			// APP_LOGS.debug("InternetExplorer browser started");
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			// APP_LOGS.debug("Chrome browser started");
		}
		driver.get(prop.getProperty("url"));
		// driver.manage().window().maximize();
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		APP_LOGS.info("Opened " + prop.getProperty("browsertype") + " browser");

		APP_LOGS.info("Navigated to Seleniumeasy.com/test");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		return driver;

	}

	public static Cell getExcelData(String SheetName, int RowNum, int ColNum) throws Exception {
		try {
			Excelfis = new FileInputStream("./Files/InputData.xlsx");
			ExcelWBook = new XSSFWorkbook(Excelfis);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			ExcelCell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			return ExcelCell;
		} catch (Exception e) {
			System.out.println("Exception has occured ---- " + e);
			return ExcelCell;
		}

	}

	public static String getExcelDataInString(String SheetName, int RowNum, int ColNum) throws Exception {
		try {
			Excelfis = new FileInputStream("./Files/InputData.xlsx");
			ExcelWBook = new XSSFWorkbook(Excelfis);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			ExcelCell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			DataFormatter formatter = new DataFormatter();
			String text = formatter.formatCellValue(ExcelCell);
			// System.out.println(" value -->"+text);
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String screenShotCreator(WebDriver driver,String screenShotName) throws IOException {

		Date d=new Date();				
		String appendDate=d.toString().replace(":", "_").replace(" ", "_");
		
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String dest = System.getProperty("user.dir") + "/ScreenShots/" + screenShotName + appendDate +".png";
        ImageIO.write(screenshot.getImage(),"PNG",new File(dest));
        return dest;

		}
	public String screenShotCreator(String screenShotName) {

		try {
				// Create reference of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				Date d=new Date();				
				String appendDate=d.toString().replace(":", "_").replace(" ", "_");
				
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source,new File("./ScreenShots/" + screenShotName + appendDate +".png"));
				APP_LOGS.info("Screenshot taken");
				String location=("./ScreenShots/" + screenShotName + appendDate + ".png");
				return location;
			} catch (Exception e) {

				APP_LOGS.info("Exception while taking screenshot "	+ e.getMessage());
				
				return "";
			}

		}	

	public void extentReport(String name)
	{
		
		rep=ExtentManager.GetExtent();
		test=rep.createTest(name); 
		
	}
	
	

	public static void destroy() {
		// driver.close();
		// APP_LOGS.debug("closed the current application");
		driver.quit();
		APP_LOGS.debug("closed browser and all driver sessions");

	}

	
	@BeforeSuite
	public void before() throws Throwable {
		initialization();
	}

	@AfterSuite
	public void after() throws Throwable {
		destroy();
	}
	
}
