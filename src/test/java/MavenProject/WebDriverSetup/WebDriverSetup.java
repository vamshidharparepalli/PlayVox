package MavenProject.WebDriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import MavenProject.UtilityFunction.ExtentReportSetup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {
	public static WebDriver driver;

	public  WebDriverSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		this.driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}



	

}
