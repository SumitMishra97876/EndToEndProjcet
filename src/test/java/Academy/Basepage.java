package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogingPage;
import pageObjects.Resetpass;
import resources.Base;

public class Basepage extends Base {
	public static Logger log=LogManager.getLogger(Basepage.class.getName());
	public WebDriver driver;
	
	  @BeforeTest
	  
	  public void initialize() throws IOException
	  {
		  driver=initializeDriver();
		  log.info("Driver initialized");
	  }

	
	
	
	@Test(dataProvider="getData")
	
	
	public void basePagenavigation(String email,String pass) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		
		
		LandingPage lpage=new LandingPage(driver);
		
		LogingPage lp=lpage.getLogin();
		log.info("Clicked login");
		

		
		
	
		try
		{
		lp.loginEmailCredentials().sendKeys(email);
		log.info("Entered credentials");
		lp.loginPasswdCredentials().sendKeys(pass);
		lp.loginSubmit().click();
		log.info("Clicked on submit");
		
		}
		catch(Exception e)
		{
			
		}
		Resetpass fp = lp.forgotPassword();
		
		fp.forgotEmailField().sendKeys("Sumit");
		fp.sendInstruction().click();
		
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="Restricted@user";
		data[0][1]="Sabretooth";
		
		data[1][0]="NonRestricted@user";
		data[1][1]="S@bretooth";
		return data;
	}
	
	
	

	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
