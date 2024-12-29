package com.Generic;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
//import java.text.SimpleDateFormat;

public class Utility {
	private static WebDriver driver;
	
	public Utility(WebDriver driver)
	{
		Utility.driver= driver;
	}
	
	

    public static void takeScreenshot(String fileName) {
		
		  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		  File destination = new
		  File("C:\\Users\\singh\\Desktop\\screenshot\\" + fileName + ".jpeg"); try {
		  Files.createDirectories(destination.getParentFile().toPath());
		  Files.copy(screenshot.toPath(), destination.toPath());
		  System.out.println("Screenshot saved: " + destination.getAbsolutePath()); }
		  catch (IOException e) { System.err.println("Failed to save screenshot: " +
		  e.getMessage()); }
		 
    	
			/*
			 * File screeShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 * String timestamp=new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
			 * String filepath="Screenshots/"+fileName+"_"+timestamp+".png"; try {
			 * FileUtils.copyFile(screeShot, new File(filepath));
			 * test.addScreenCaptureFromPath(filepath); }
			 * 
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
    }
}

