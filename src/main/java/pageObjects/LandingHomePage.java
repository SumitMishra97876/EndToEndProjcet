package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingHomePage {
	
	
	public WebDriver driver;
	
	By home=By.xpath("//a[contains(text(),'Home')]");
	
	By headerLinks=By.xpath("//div[@class='navbar-collapse collapse clearfix']/ul/li/a");
	
	By about=By.xpath("//ul[@class='navigation clearfix']/li[9]");
	
	By aboutuslinks=By.xpath("//ul[@class='dropdown-menu']/li/a");
	
	By aboutus=By.linkText("About Us");
	
	public LandingHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getHome()
	{
		return driver.findElement(home);
	}
	
	public List<WebElement> getHeadLinks()
	{
		return driver.findElements(headerLinks);
	}
	
	public WebElement getAbout()
	{
		return driver.findElement(about);
	}
	public List<WebElement> getAboutUsLinks()
	{
		return driver.findElements(aboutuslinks);
	}
	
	public WebElement getAboutUs()
	{
		return driver.findElement(aboutus);
	}

}
