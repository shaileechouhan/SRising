package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D05NormalExtentReport {

	public static void main(String[] args) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("MyFirstReport.html");	//Report File
		ExtentReports report = new ExtentReports();		//Report
		
		report.attachReporter(htmlReport);				//Attaching the file with report
		
		ExtentTest test;								//Represents test cases
		
		//Add environment details
		report.setSystemInfo("User", "Shailee");
		report.setSystemInfo("Machine", "Dell");
		report.setSystemInfo("Operating System", "Windows 11");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("EMail", "shailee@gmail.com");
		
		//Configure Report
		htmlReport.config().setDocumentTitle("Rediff Test");
		htmlReport.config().setReportName("Report For Rediff page");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("dd-MMM-yyy");
		
		//Test
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.rediff.com/");
		
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
		
		test = report.createTest("Rediff Title");
		test.log(Status.PASS, MarkupHelper.createLabel("Rediff Title Test:Pass", ExtentColor.GREEN));
		
		report.flush();			//Will generate the report
	}

}