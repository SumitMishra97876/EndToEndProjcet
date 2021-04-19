package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Resetpass {
	public WebDriver driver;
	public Resetpass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	By email=By.id("user_email");
	
	By sendInst=By.xpath("//input[@name='commit' and @value='Send Me Instruction']");
	
	
	public WebElement forgotEmailField()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendInstruction()
	{
		return driver.findElement(sendInst);
	}

}
