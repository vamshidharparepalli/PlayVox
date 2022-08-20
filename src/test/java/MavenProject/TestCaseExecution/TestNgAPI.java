package MavenProject.TestCaseExecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import MavenProject.APIReusable.RequestMethods;
import MavenProject.UtilityFunction.ExtentReportSetup;
import MavenProject.WebDriverSetup.WebDriverSetup;

public class TestNgAPI {
	
	@BeforeTest
	public void beforeTestCasesSetup()
	{
		ExtentReportSetup.startReport();
	}

	@BeforeMethod
	public void beforeTestCaseSetup()
	{
		ExtentReportSetup.startTest("Hello");
	   
	}
	@Test
	public void testCaseName()
	{
		RequestMethods rm=new RequestMethods();
		System.out.println(rm.getStatusCode());
	}
	
	@AfterMethod
	public void AfterTestCaseWrapup()
	{
		ExtentReportSetup.endTest();
		  
	}
	
	@AfterTest
	public void  AfterTestCasesWrapup()
	{
		ExtentReportSetup.flushReport();
	}

}
