package com.MyTests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

//import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
//import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginToOrangeHRM_ExtentReport{
	
	String fPath = "ExcelFiles\\LoginData.xlsx";
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	XSSFCellStyle style;
	XSSFFont font;
	int index = 1;
	
	WebDriver driver;
	
	
	//WebDriver driver;
	ExtentSparkReporter htmlReport;
	// Report file
	ExtentReports report;
	// Actual report
	ExtentTest test;
	
	
	@Test(dataProvider = "getLoginData")
	public void login(String un, String ps) {
		//Passing the data to test case
	
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
		//driver.getCurrentUrl();
		
	}
	

  @AfterMethod
  public void logout(ITestResult result ) {
	  
		//Checking the result and updating the status column in the excel file
		//row = sheet.getRow(index);
		//cell = row.getCell(2);
		cell = sheet.getRow(index).getCell(2);
		
		style = wb.createCellStyle();
		font = wb.createFont();
		
		if(driver.getCurrentUrl().contains("dashboard"))
		{
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
			driver.findElement(By.partialLinkText("Log")).click();
			System.out.println("Login successful");			
			font.setColor(HSSFColorPredefined.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
			cell.setCellValue("Pass");
			test = report.createTest("OHRM_Login_Success");			
		}
		else
		{
			System.out.println("Invalid credentials");				
			font.setColor(HSSFColorPredefined.RED.getIndex());
			font.setItalic(true);
			style.setFont(font);
			cell.setCellStyle(style);			
			cell.setCellValue("Fail");
			test = report.createTest("OHRM_Login_Fail");
		}
		index++;
		  
		//Generate Extent Report
		  if(result.getStatus() == ITestResult.SUCCESS) { test.log(Status.PASS,
		  MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN)); } else
		  if(result.getStatus() == ITestResult.FAILURE) { test.log(Status.FAIL,
		  MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		  test.fail(result.getThrowable()); //getThrowable() will get the failure log
		  } else if(result.getStatus() == ITestResult.SKIP) { test.log(Status.SKIP,
		  MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		  test.skip(result.getThrowable()); }
		  
		 
		  if(driver.getCurrentUrl().contains("dashboard"))
			{ 
			   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			   wait.until(ExpectedConditions.visibilityOfElementLocated
					   (By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[1]/a/div[2]/img")));
			   
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			   File  screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			   String timestamp=new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
			
			   File destination = new
			   File("C:\\Users\\singh\\Desktop\\shailee_study\\Shailee_SeleniumDemos\\MyMavenProject\\Screenshot\\"
+ "fileName2" +"_"+timestamp+".png"); try {
			   Files.createDirectories(destination.getParentFile().toPath());
			   Files.copy(screenshot.toPath(), destination.toPath());
			   System.out.println("Screenshot saved: " + destination.getAbsolutePath()); 
			 }
		   catch (IOException e) 
		   {
			   System.err.println("Failed to save screenshot: " + e.getMessage()); }
			}
		  else			
				
			{
			 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")));
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			  File  screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String timestamp=new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
			
			   File destination = new
			   File("C:\\Users\\singh\\Desktop\\shailee_study\\Shailee_SeleniumDemos\\MyMavenProject\\Screenshot\\" + "fileName2" +"_"+timestamp+".png"); try {
			   Files.createDirectories(destination.getParentFile().toPath());
			   Files.copy(screenshot.toPath(), destination.toPath());
			   System.out.println("Screenshot saved: " + destination.getAbsolutePath()); }
			   catch (IOException e) 
			   {
				   System.err.println("Failed to save screenshot: " + e.getMessage()); }	
			}			   
			  
	}

  @DataProvider
	public Object[][] getLoginData() {
		//Reading the data from excel file
		int rows = sheet.getPhysicalNumberOfRows();
		String[][]loginData = new String[rows-1][2];
		
		for(int i = 0; i < rows-1; i++)
		{
			row = sheet.getRow(i+1);
			for(int j = 0; j < 2; j++)
			{
				cell = row.getCell(j);
				loginData[i][j] = cell.getStringCellValue();
			}
		}
		return loginData;
	}
	
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fPath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		
		fos = new FileOutputStream(file);	//To avoid currepting the file initilize after sheet

		
		htmlReport = new ExtentSparkReporter("MyDetailedReport.html");	//Report File
		report = new ExtentReports();
		//Attach report to file
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("User", "Shailee");
		report.setSystemInfo("Browser", "Google Chrome");
		
		htmlReport.config().setDocumentTitle("My TestNG Report");
		htmlReport.config().setReportName("My Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();		
		driver.close();	
		report.flush();
	}


}
