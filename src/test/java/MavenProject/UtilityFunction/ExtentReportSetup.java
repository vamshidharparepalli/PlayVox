package MavenProject.UtilityFunction;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportSetup {
	static  ExtentTest test;
	static  ExtentReports report;
	
	
	public static void startReport()
	{
		report = new ExtentReports(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"ExtentReportResults+"+java.time.LocalDate.now()+".html");
		
	}
	public static void startTest(String testCaseName)
	{
		test = report.startTest(testCaseName);
		
	}
	public static void testPass(String message)
	{
		test.log(LogStatus.PASS, message);
	}
	public static void testFail(String message)
	{
		test.log(LogStatus.FAIL, message);
	}
	
	public static void endTest()
	{
	report.endTest(test);
	
	}
	public static void flushReport()
	{
		report.flush();
	}
	
	

}
