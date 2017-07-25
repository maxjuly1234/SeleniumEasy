package com.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public static FileInputStream Excelfis;
    public static XSSFSheet ExcelWSheet;
    public static XSSFWorkbook ExcelWBook;
    public static XSSFCell ExcelCell;
    public static XSSFRow ExcelRow;
    public static Sheet sheet;

	public static WebDriver driver;
	public static FileInputStream fip;
	public static Properties prop;
	//public static Logger APP_LOGS=null;
	//public static SoftAssert st=null;
	public static boolean TestFail=false;
	public static int temp=0;
	public static final Logger APP_LOGS=Logger.getLogger(TestBase.class.getName());
	
	public TestBase(){}
	public TestBase(WebDriver driver)
	{
		TestBase.driver=driver;
		
	}
	
	
	
	public static void initialization() throws Throwable{
			//System.out.println("1");
		//APP_LOGS=Logger.getLogger("devpinoyLogger");
		//APP_LOGS=Logger.getLogger(TestBase.class.getName());
		//st=new SoftAssert();
		PropertyConfigurator.configure("Log4j.properties");
		fip=new FileInputStream("./Files/or.properties");
			//System.out.println("3");
		//APP_LOGS.debug("fileinputsteam command executed ");
			//System.out.println("4");
		prop=new Properties();
		prop.load(fip);
		//APP_LOGS.debug("properties file is loaded");
		String browser=prop.getProperty("browsertype");
			//System.out.println("5");
		if(browser.equalsIgnoreCase("mozilla")){
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			//APP_LOGS.debug("Mozilla fire fox browser started");
		}
		else if (browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			//APP_LOGS.debug("InternetExplorer browser started");
		} else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			//APP_LOGS.debug("Chrome browser started");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath(prop.getProperty("demowebsite"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		APP_LOGS.info("Opened "+prop.getProperty("browsertype")+" browser");
		
		APP_LOGS.info("Navigated to Seleniumeasy.com/test");
		

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
    public static Cell getExcelData(String SheetName, int RowNum, int ColNum) throws Exception
    {
           try
           {
                  Excelfis = new FileInputStream("./Files/InputData.xlsx");
                  ExcelWBook = new XSSFWorkbook(Excelfis);
                  ExcelWSheet = ExcelWBook.getSheet(SheetName);
                  
                  ExcelCell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                  
                  return ExcelCell;
           }
           catch (Exception e)
           {
                  System.out.println("Exception has occured ---- " + e);
                  return ExcelCell;
           }
    }
  //Method to Open desired sheet from Excel file using file name and Sheet name
  	public static void openExcel(String FileName, String SheetName) 
      {
             try
             {
          	   Excelfis = new FileInputStream(FileName);
                 ExcelWBook = new XSSFWorkbook(Excelfis);
                 ExcelWSheet = ExcelWBook.getSheet(SheetName); 
             }
             catch (Exception e)
                      
             {
          	   APP_LOGS.info("File Not Found");
             }
      }
     
     //Method to get total no of rows in the current sheet opened
     public static int getTotalNoOfRows()
     {

  		int TotalRows =ExcelWSheet.getLastRowNum();
  		//System.out.println("Total Number Of Test Data are  : "+TotalRows );
  		return(TotalRows);
     }
     
     
     //Print the total number of rows as number of test data
     public static void printTotalNoOfRows()
     {
  	   System.out.println();
  	   System.out.println("Total Number Of Test Data are  : "+ TestBase.getTotalNoOfRows());  
     }
     
     
     //Method to get the Test Data Number
     public static String getTestDataName(XSSFRow row)
     {
  	   String TestDataName=row.getCell(0).toString();
  	   return TestDataName;
     }
     
     
   //Method to print the Test Data Number
     public static void printTestDataName(XSSFRow row)
     { 	
  	   	System.out.println();
  		System.out.println("Running Test Case For - " + row.getCell(0).toString());
  		System.out.println("---------------------------------");   
     }

   //Assign Row number to read through excel
     public static XSSFRow currentRowNumber(int RowNumber )

     {
     	XSSFRow row =ExcelWSheet.getRow(RowNumber);
     	return row;	
     }
  	
     public static String getExcelDataInString(String SheetName, int RowNum, int ColNum) throws Exception
     {
            try
            {
                   Excelfis = new FileInputStream("./Files/InputData.xlsx");
                   ExcelWBook = new XSSFWorkbook(Excelfis);
                   ExcelWSheet = ExcelWBook.getSheet(SheetName);
                   
                   ExcelCell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                   
                   DataFormatter formatter = new DataFormatter();
                   String text=formatter.formatCellValue(ExcelCell);
                   //System.out.println(" value -->"+text);
                   return text;
            }catch(Exception e){
         	   e.printStackTrace();
         	   return "";
            }
                   
                   
                 

  }
 	
	public static void destroy() throws Exception{
		Excelfis.close();
		driver.close();
		APP_LOGS.debug("closed the current application");
		driver.quit();
		APP_LOGS.debug("closed browser");
		
	}
	
	
	@BeforeSuite
	public void before() throws Throwable
	{
		initialization();
	}
	@AfterSuite
	public void after() throws Throwable
	{
	destroy();
	}
	
}



