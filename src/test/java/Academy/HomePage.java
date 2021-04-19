package Academy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingHomePage;
import resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	
	 @BeforeTest
	  
	  public void initialize() throws IOException
	  {
		  driver=initializeDriver();
		  driver.get(prop.getProperty("url"));
	  }

	

	
	
	@Test
	public void homePagenavigation() throws IOException
	{
		
//		driver=initializeDriver();
//		driver.get(prop.getProperty("url"));
//		
		LandingHomePage lp=new LandingHomePage(driver);
		
		lp.getHome().click();
		
	Actions a=new Actions(driver);
		
		//a.moveToElement(lp.getAboutUs()).build().perform();
	
		a.moveToElement(lp.getAbout()).build().perform();
		
		System.out.println(lp.getAboutUs().getText());
		
		//lp.getAboutUs().click();
		List<WebElement> hlinks=lp.getHeadLinks();
		
		//driver.switchTo().frame("google_osd_static_frame");
		
		
		try
		{
		for(int i=0;i<hlinks.size();i++)
		{
			System.out.println(hlinks.get(i).getText());
		}
		}
		catch(Exception e)
		{
			
		}
		
		
		
		
		
		
	
	

}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
