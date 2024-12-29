package com.TelecomProject;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TelecomDomainAPI {
  
  ExtentSparkReporter extentSparkReporter;
  ExtentReports extentReports;
  ExtentTest extentTest;
  
  String tokenvalue;
  String logintoken;
  String id;
	
@Test(priority=1)
public void addNewUser() 
{
	 extentTest = extentReports.createTest("Add_NewUser");	
	 Response  res=given()
	  .header("Content-Type","application/json")
	  .header("Accept","application/json")
	  .body("{ \n"
	  		+ "\"firstName\": \"Shailee\", \n"
	  		+ "\"lastName\": \"Chouhan\", \n"
	  		+ "\"email\": \"Shailee"+System.currentTimeMillis()+"@gmail.com\", \n"
	  		+ "\"password\": \"test123\" \n"
	  		+ "}")
	  
	 .when().post("https://thinking-tester-contact-list.herokuapp.com/users");
	  
	  res.then().log().body();
	  
	  tokenvalue=res.jsonPath().getString("token");
	  System.out.println("New User created with status code: "+res.statusCode());
}

@Test(priority=2,dependsOnMethods ="addNewUser")
public void getProfile()
{
	  extentTest = extentReports.createTest("Get_Profile");	
	  Response res=given()
	  .header("Content-Type","application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+tokenvalue)
	  
	  .when().get("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  
	  res.then().log().body();
	  System.out.println("User Profile get createed with id: "+res.statusCode());
}

@Test(priority=3)
public void updateUser()
{
	  extentTest = extentReports.createTest("Update_User");	
	  Response res=given()
	  .header("Content-Type","application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+tokenvalue)
	  .body("{ \n"
	  		+ "\"firstN ame\": \"Shailee\", \n"
	  		+ "\"lastName\": \"Chouhan\", \n"
	  		+ "\"email\": \"ShaileeTest"+System.currentTimeMillis()+"@gmail.com.com\", \n"
	  		+ "\"password\": \"test123\" \n"
	  		+ "} ")
	  
	  .when().patch("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  
	  res.then().log().body();
	  
	  System.out.println("User updated with status code : "+res.statusCode());
}

@Test(priority=4)
public void loginUser()
{
	extentTest = extentReports.createTest("Login_User");	
	  Response res=given()
	  .header("Content-Type","application/json")
	  .header("Accept","application/json")
	  .body("{ \n"
	  		+ " \n"
	  		+ " \n"
	  		+ "\"email\": \"shailysingh@gmail.com\", \n"
	  		+ "\"password\": \"test123\" \n"
	  		+ " \n"
	  		+ "} \n"
	  		+ " ")
	  .when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
	  
	  res.then().log().body();
	  
	  logintoken=res.jsonPath().getString("token");
	  System.out.println("User login with status code: "+res.statusCode());
}

@Test(priority=5)
public void addContact()
{
	extentTest = extentReports.createTest("Add_Contact");	
	  Response res=given()
	  .header("Content-Type","application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+logintoken)
	  .body("{ \n"
	  		+ "\"firstName\": \"Shailee\", \n"
	  		+ "\"lastName\": \"Chouhan\", \n"
	  		+ "\"birthdate\": \"1990-01-01\", \n"
	  		+ "\"email\": \"ShaileeTest@gmail.com\", \n"
	  		+ "\"phone\": \"8005555555\", \n"
	  		+ "\"street1\": \"1 Main St.\", \n"
	  		+ "\"street2\": \"Apartment A\", \n"
	  		+ "\"city\": \"Anytown\", \n"
	  		+ "\"stateProvince\": \"KS\", \n"
	  		+ "\"postalCode\": \"12345\", \n"
	  		+ "\"country\": \"USA\" \n"
	  		+ "}")
	  
	  
	  .when().post("https://thinking-tester-contact-list.herokuapp.com/contacts");
	  
	  res.then().log().body();
	  id=res.jsonPath().getString("_id");
	  System.out.println("User contact created with status code: "+res.statusCode());
}



@Test(priority=6)
public void getContactList()
{
	 extentTest = extentReports.createTest("Get_Contact_List");	
	Response res=given()
			  .header("Content-Type","application/json")
			  .header("Accept","application/json")
			  .header("Authorization","Bearer "+logintoken)
			  
			  .when().get("https://thinking-tester-contact-list.herokuapp.com/contacts");
	  
	  res.then().log().body();
	  
	  System.out.println("Contact list with code: "+res.statusCode()); 
}

@Test(priority=7)
public void getContact()
{
	 extentTest = extentReports.createTest("Get_Contact");	
	  Response res=given()
.header("Content-Type","application/json")
.header("Accept","application/json")
.header("Authorization","Bearer "+logintoken)

.when().get("https://thinking-tester-contact-list.herokuapp.com/contacts"+id);
res.then().log().body();
System.out.println("Contact data with code: "+res.statusCode());	  
}

@Test(priority=8)
public void updateContact()
{
	  extentTest = extentReports.createTest("Update_Contact");	
	  Response res=given()
	  .header("Content-Type","application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+logintoken)
	  
	  .body("{ \n"
	  		+ "\"firstName\": \"Shailee\", \n"
	  		+ "\"lastName\": \"Chouhan\",\n"
	  		+ " \n"
	  		+ " \n"
	  		+ "\"birthdate\": \"1992-02-02\", \n"
	  		+ "\"email\": \"newShailee@gmail.com\", \n"
	  		+ "\"phone\": \"8005554242\", \n"
	  		+ "\"street1\": \"13 School St.\", \n"
	  		+ "\"street2\": \"Apt. 5\", \n"
	  		+ "\"city\": \"Washington\", \n"
	  		+ "\"stateProvince\": \"QC\", \n"
	  		+ "\"postalCode\": \"A1A1A1\", \n"
	  		+ "\"country\": \"Canada\" \n"
	  		+ "} ")
	  
	  .when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/"+id);
	  
	  res.then().log().body();
	  System.out.println("User updated with code: "+res.statusCode());
}


@Test(priority=9)
public void updateContactpatch()
{
	  extentTest = extentReports.createTest("Update_Contact_patch");	
	  Response res=given()
			  .header("Content-Type","application/json")
			  .header("Accept","application/json")
			  .header("Authorization","Bearer "+logintoken)
			  .body("{ \n"
			  		+ "\"firstName\": \"Shailee\", \n"
			  		+ "\"lastName\": \"Singh\"} ")
			  .when().put("https://thinking-tester-contact-list.herokuapp.com/contacts/"+id);
	  
	  res.then().log().body();
	  System.out.println("User updated with code: "+res.statusCode());
}

@Test(priority=10)
public void logoutUser()
{
	   extentTest = extentReports.createTest("Logout_Success");		   
	   Response res=given()
	  .header("Content-Type","application/json")
	  .header("Accept","application/json")
	  .header("Authorization","Bearer "+logintoken)
	  .when().post("https://thinking-tester-contact-list.herokuapp.com/users/logout");
	  
	  res.then().log().body();
	  System.out.println("User logout with code: "+res.statusCode());	
}

@AfterMethod
public void afterMethod(ITestResult result) {		
	if(result.getStatus() == ITestResult.SUCCESS)
	{
		extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}
	else if(result.getStatus() == ITestResult.FAILURE)
	{
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		extentTest.fail(result.getThrowable());		//getThrowable() will get the failure log
	}
	else if(result.getStatus() == ITestResult.SKIP)
	{
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		extentTest.skip(result.getThrowable());
	}
}
    
  @BeforeTest
	public void beforeTest() {
	  extentSparkReporter = new ExtentSparkReporter("TelecomDomainReport.html");	//Report File
		extentReports = new ExtentReports();
		//Attach report to file
		extentReports.attachReporter(extentSparkReporter);
		
		extentReports.setSystemInfo("Machine Name", "Dell");
		extentReports.setSystemInfo("OS", "Windows 11");
		extentReports.setSystemInfo("User", "Shailee");
		extentReports.setSystemInfo("Browser", "Google Chrome");
		
		extentSparkReporter.config().setDocumentTitle("Telecom Domain Report");
		extentSparkReporter.config().setReportName("My Report");
		extentSparkReporter.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");
	}

	@AfterTest
	public void afterTest() {		
		extentReports.flush();
	}
}
