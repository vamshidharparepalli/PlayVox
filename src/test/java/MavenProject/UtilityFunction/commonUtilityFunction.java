package MavenProject.UtilityFunction;

import java.security.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MavenProject.WebDriverSetup.commonVariable;

public class commonUtilityFunction   {
 
	public static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		commonUtilityFunction.driver = driver;
	}
	public static ExtentReportSetup getReport() {
		return report;
	}
	public static void setReport(ExtentReportSetup report) {
		commonUtilityFunction.report = report;
	}
	public static ExtentReportSetup report;
	
	
	public static void elementClick(By xpath)
	{
		driver.findElement(xpath).click();
	}
	public static void elementClick(WebElement ele)
	{
		ele.click();
	}
	public static void visiblityOf(By xpath,int time)
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
		
	}
	public static Boolean scrollToElement(By xPath)
	{
		Boolean flag=false;
		Actions act=new Actions(driver);
		
		while(flag==false)
		{
			if(driver.findElement(xPath).isDisplayed())
			{
				flag=true;
				
			}
			else
			{
				act.sendKeys(Keys.ARROW_DOWN).build().perform();
				flag=false;
			}
		}
		return flag;
	}
	public static void hardWait(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	
}
