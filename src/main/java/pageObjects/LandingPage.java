package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By sign=By.cssSelector("a[href*='sign_in']");
	
	By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	By navigation=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li");
	
	
	public  LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public LogingPage getLogin()
	{
		 driver.findElement(sign).click();
		 return new LogingPage(driver);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigation()
	{
		return driver.findElement(navigation);
	}

}
