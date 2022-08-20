package MavenProject.Page;

import org.openqa.selenium.By;

public class FirstPage {
	
  
	public static By username=By.xpath("//input[@name='uid']");
	public static By password=By.xpath("//input[@name='password']");
	
	
	public static By cName=By.xpath("//td[text()='Customer Name']//following-sibling::td/input");

	public static By dob=By.xpath("//td[text()='Date of Birth ']//following-sibling::td/input");
	public static By add=By.xpath("//td[text()='Address']//following-sibling::td/textarea");
	public static By city=By.xpath("//td[text()='City']//following-sibling::td/input");
	public static By state=By.xpath("//td[text()='State']//following-sibling::td/input");
	public static By pin=By.xpath("//td[text()='PIN']//following-sibling::td/input");
	public static By tele=By.xpath("//td[text()='Telephone Number']//following-sibling::td/input");
	public static By mail=By.xpath("//td[text()='E-mail']//following-sibling::td/input");
	public static By submit=By.xpath("//input[@type='submit']");
}
