package com.GOL.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GOL.util.Utility;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Base
{
	public static WebDriver driver = null;
    //public static WebDriver driver;
    public static Properties prop;
    public static ExtentReports er;
	public static ExtentTest et;
	public static WebDriverWait wt;
	public static Actions act;
	public static Date dt;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest logger;
	public static String Report_Path = null;
	public static String platform_version;
	 
   public Base() throws IOException
   {
	   try 
	   {
		   prop = new Properties();
		   FileInputStream ip=new FileInputStream("src/main/java/com/GOL/config/config.properties");
		   prop.load(ip);
		   BasicConfigurator.configure();
	   }
	   catch(Exception ex) 
	   { 
		   System.out.println(ex.getMessage()); 
	   }   
   }
   
   

   public static void initialization() throws URISyntaxException {//here not passing value of browser so it will skip all tc in xml it will run as we have setr browser parameter 

	   	//System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
		   WebDriverManager.chromedriver().setup();
		System.out.println("Browser is launching");
		ChromeOptions chromeOptions = new ChromeOptions();
	    //chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("--window-size=1920x1080");
	    driver = new ChromeDriver(chromeOptions);
		//driver=new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	
	}

   public static void wait(WebElement element)
   {
	    WebDriverWait wt=new WebDriverWait(driver,10);
		wt.until(ExpectedConditions.visibilityOf(element));
   }
   
  
   public String failed(String testMethodName) throws IOException
   {
	   
	        String title=testMethodName;
		   TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			String dest ="Snapshot/"+testMethodName+getcurrentdateandtime()+".png";
		    File target = new File(Report_Path+"/"+dest);
			FileUtils.copyFile(src, target);
			return dest;
			
		   
			 
	      
    }
   public String appendDateTimeHostName()
	{
		
		try{
		   DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
	       Date dateobj = new Date();
	       return df.format(dateobj);
	}
		catch(Exception e){

		}
		return null;
			
	}
   
   public String pass(String testMethodName) throws IOException
   {
	   
	   String title=testMethodName;
	   TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest ="Snapshot/"+ testMethodName+getcurrentdateandtime()+".png";
		File target = new File(Report_Path+"/"+dest);
		FileUtils.copyFile(src, target);
	   return dest;
    }
   public String getcurrentdateandtime(){
		String str = null;
		try{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		Date date = new Date();
		str= dateFormat.format(date);
		str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
}
		
		
catch(Exception e){

}
		return str;
}

}
