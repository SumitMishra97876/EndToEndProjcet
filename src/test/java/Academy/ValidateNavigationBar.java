package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base{
	public static Logger log=LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;
	
	 @BeforeTest
	  
	  public void initialize() throws IOException
	  {
		  driver=initializeDriver();
		  log.info("Driver initialized");
		  driver.get(prop.getProperty("url"));
		  log.info("Hit the url");
	  }

	
	
	
	@Test
	
	public void validateAppNavigation() throws IOException
	{
//		driver=initializeDriver();
//		driver.get(prop.getProperty("url"));
//		
		
		LandingPage lpage=new LandingPage(driver);
		
		Assert.assertTrue(lpage.getNavigation().isDisplayed());
		
	

}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
