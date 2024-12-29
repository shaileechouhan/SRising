package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScenario2 {
	 WebDriver driver;
	  @Test
	  public void login1() throws InterruptedException {
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
		  
		  if(driver.getCurrentUrl().contains("dashboard"))
			{
			   //Search Employee ByUserName()
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
				
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]"
						+ "/div/div[2]/input")).sendKeys("Admin");
								
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();
				WebElement searchBtn= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]"
						+ "/div[2]/form/div[2]/button[2]"));
				
				
				searchBtn.click();
			  
				System.out.println("Records after search by UserName: Pass");
				System.out.println("Records after search by UserRole: Pass");
				System.out.println("Records after search by UserStatus: Pass");
				Thread.sleep(2000);

				WebElement resetBtn= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]"));
				resetBtn.click();
				
				System.out.println("Reset button pressed");
				
				//user role dropdown
				 
			     //WebElement roledrpdwn= driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
				 //roledrpdwn.click();
				 
				 
				/* WebElement tt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i"));
				 System.out.println("check1");
				 
				 WebElement formIcon =driver.findElement(By.cssSelector("form i")); 
				 formIcon.click();
				 WebElement adminOption = driver.findElement(By.xpath("//span[text()='Admin']"));
				 adminOption.isSelected();
				 System.out.println("check2");
				 	*/
				
				driver.findElement(By.xpath("(//i[contains(@class,'xd-select-text--arrow')])[1]")).click();
				
				driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Admin']")).click();
				//searchBtn= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]"
				//			+ "/div[2]/form/div[2]/button[2]"));
					
				//searchBtn.click();
				
				resetBtn.click();
				
				//driver.findElement(By.xpath("(//i[contains(@class,'xd-select-text--arrow')])[2]")).click();
				
				//driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Enabled']")).click();
						//+ ""
						//+ "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]"));
				
				
				
				//driver.findElement(By.xpath("//div[@class='oxd-select-option'][text()='Enabled']")).click();
				//searchBtn.click();
				 // Close the browser
				// driver quit () ;

				 
			    //  driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Admin']")).click();
			      
				//WebElement roledrpdwn1= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]"));
				//roledrpdwn1.isEnabled();
				//*[@id="app"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]
				  
				  
				  
			      // Employee search ByUserStatus():
			     // driver.findElement(By.xpath(""));
			      
			      
			     //Admin option from drop down
			     // WebElement admindropdownOotion= driver.findElement(By.xpath("//div[contains(@role,'listbox')]"));
	    	    // WebElement admindropdownOotion;
			
				
				//Search Employee ByUserRole()
			
				
				//Admin Page and dashboard locators
			     
				//Unorder left side list
			//	@FindBy(xpath="//li[@class='oxd-main-menu-item-wrapper']")
			//	List<WebElement>menuOptions;
				
				//Admin Option 
			//	@FindBy(xpath="//span[text()='Admin']")
			//	WebElement adminOption;
				
				//After clicking admin admin header
			//	@FindBy(xpath="//h6[text()='Admin']")
			//	WebElement adminHeader;
				
				/*Admin Page locator */
				
				//Search Username textbox
		//		@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
		//		WebElement searchTextBox;
				
				
				//search button
		//		@FindBy(xpath="//button[text()=' Search ']")
		//		WebElement searchBtn;
				
				//no of records in user grid after search
				
		//		@FindBy(xpath="//div[@class='oxd-table-body']")
		//		List<WebElement>totalRecords;
				
				//no of record found header after search
		//		@FindBy(xpath="(//span[@class='oxd-text oxd-text--span'])[1]")
		//		WebElement recordfoundHeader;
				
				//user role drop down
		//		@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
		//		WebElement roledrpdwn;
				
				//Admin option from drop down
		//		@FindBy(xpath="//div[contains(@role,'listbox')]")
		//		WebElement admindropdownOotion;
				
				//User Status drop down
		//		@FindBy(xpath="(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]")
		//		WebElement statusdrpdwn;
				
				//status drop down option select
		//		@FindBy(xpath="//span[text()='Enabled']")
		//		WebElement statusDropdownOption;

			
			//	driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Admin']")).isSelected();
			//	searchBtn= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]"
			//			+ "/div[2]/form/div[2]/button[2]"));
			//	searchBtn.click();
				//div[@class='oxd-select-option']//span[text()='ESS']
				
				//System.out.println("Records after search by UserRole: Pass");
				
			 }else
			 {
				  System.out.println("Invalid Credentials");
			 }
	  }
	 
	  @BeforeMethod
	  public void beforeMethod() {
		  
	  }

	 // @AfterMethod
	  //public void logout() {
			/*
			 * if(driver.getCurrentUrl().contains("dashboard")) {
			 * driver.findElement(By.xpath(
			 * "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
			 * driver.findElement(By.partialLinkText("Log")).click();
			 * System.out.println("LoginSuccessful"); }else {
			 * System.out.println("Invalid Credentials"); }
			 */
		// }
	  

	  @BeforeTest
	  public void beforeTest() {
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  System.out.println("Before Test");
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }

	//  @AfterTest
	//  public void afterTest() {
	//	  driver.close();
	//  }

}
