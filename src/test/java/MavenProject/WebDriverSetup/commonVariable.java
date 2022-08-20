package MavenProject.WebDriverSetup;

import org.openqa.selenium.WebDriver;

import MavenProject.UtilityFunction.ExtentReportSetup;
import MavenProject.UtilityFunction.commonUtilityFunction;

public class commonVariable {
	
	public WebDriver driver;
	public ExtentReportSetup report;
	
	public commonVariable(WebDriver driver,ExtentReportSetup report)
	{
		commonUtilityFunction.setDriver(driver);
		commonUtilityFunction.setReport(report);
		
	}
	
	
	
	

}
