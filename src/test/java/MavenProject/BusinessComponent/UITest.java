package MavenProject.BusinessComponent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import MavenProject.Page.FirstPage;
import MavenProject.WebDriverSetup.WebDriverSetup;

public class UITest {
	
	public static void login(String userName,String password)
	{
		WebDriverSetup.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverSetup.driver.findElement(FirstPage.username).sendKeys(userName);
		WebDriverSetup.driver.findElement(FirstPage.password).sendKeys(password);
		WebDriverSetup.driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		
		
	}
	public static void editPage()
	{
		WebDriverSetup.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverSetup.driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		WebDriverSetup.driver.findElement(FirstPage.cName).sendKeys("dbnjf");
		WebDriverSetup.driver.findElement(FirstPage.dob).sendKeys("01-06-2022");
		WebDriverSetup.driver.findElement(FirstPage.add).sendKeys("jfgnjf");
		WebDriverSetup.driver.findElement(FirstPage.city).sendKeys("ijdgfjd");
		WebDriverSetup.driver.findElement(FirstPage.state).sendKeys("kjgjk");
		WebDriverSetup.driver.findElement(FirstPage.pin).sendKeys("123449");
		WebDriverSetup.driver.findElement(FirstPage.tele).sendKeys("12345566");
		WebDriverSetup.driver.findElement(FirstPage.mail).sendKeys("rks@gmail.com");
		WebDriverSetup.driver.findElement(FirstPage.submit).click();
	}

}
