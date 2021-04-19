package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
   public	Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		
		
		 prop=new Properties();
		
		FileInputStream fis=new FileInputStream("E:\\workspace\\EndToEndProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
	    String browserName=prop.getProperty("browser");
	    
	    if(browserName.equals("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	         driver = new ChromeDriver();
	    }
	    
	    else if(browserName.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
		         driver = new FirefoxDriver();
	    }
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//This will apply to all our testcases.
	    
	    return driver;    //returning driver so that driver can be used in our testcases;
		
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}


}
