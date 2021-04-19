package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogingPage {
	
	public WebDriver driver;
	
	By email=By.id("user_email");
	
	By passwd=By.id("user_password");
	
	By submit=By.xpath("//input[@value='Log In']");
	
	By forgotPass=By.cssSelector("a[href*='password/new']");
	
	
	
	
	public  LogingPage(WebDriver driver)
	{
		this.driver=driver;
	} 
	
	public WebElement loginEmailCredentials()
	{
		return driver.findElement(email);
	}
	
	public WebElement loginPasswdCredentials()
	{
		return driver.findElement(passwd);
	}
	
	public WebElement loginSubmit()
	{
		return driver.findElement(submit);
	}
	public Resetpass forgotPassword()
	{
		driver.findElement(forgotPass).click();
		return new Resetpass(driver);
	}
 
}
