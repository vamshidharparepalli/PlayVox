package MavenProject.TestCaseExecution;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentTest;

import MavenProject.APIReusable.RequestMethods;
import MavenProject.BusinessComponent.UITest;
import MavenProject.UtilityFunction.ExtentReportSetup;
import MavenProject.WebDriverSetup.WebDriverSetup;


public class TestNgUI {

	static WebDriver driver;
	ExtentTest test;
	WebDriverSetup driverInitalized;
	
	@BeforeTest
	public void beforeTestCasesSetup()
	{
		ExtentReportSetup.startReport();
	}

	@BeforeMethod
   
	public void beforeTestCaseSetup()
	{
		ExtentReportSetup.startTest("Hello");
	    driverInitalized=new WebDriverSetup();
	    driver=driverInitalized.driver;
	}
	
	@Test
	public void testCaseName() {
		// Methods to Run the code
		
	
	driver.get("https://demo.guru99.com/V1/index.php");
	
	UITest.login("mngr432438", "AbEnupe");
	ExtentReportSetup.testPass("Login Successfull");
	UITest.editPage();
	ExtentReportSetup.testPass("Editted successfully");
		
		
		
	}
	@AfterMethod
	public void AfterTestCaseWrapup()
	{
		ExtentReportSetup.endTest();
		driver.quit();  
	}
	
	
	
	@AfterTest
	public void  AfterTestCasesWrapup()
	{
		ExtentReportSetup.flushReport();
	}
	

}
