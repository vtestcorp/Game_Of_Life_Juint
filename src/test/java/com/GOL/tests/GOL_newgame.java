	package com.GOL.tests;
	


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.remote.CapabilityType;
		import org.openqa.selenium.remote.DesiredCapabilities;
		
		
		import com.relevantcodes.extentreports.LogStatus;

import com.GOL.base.Base;
import com.GOL.pages.Gameoflife_page;
import com.GOL.util.Utility;


		
		public class GOL_newgame extends Base
		{	
			Gameoflife_page Gol;
			
			
			public GOL_newgame() throws IOException
			{
				super();
			}
			
			
			
			
			
			@Before
			public void setup() throws URISyntaxException, IOException {
				initialization();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Gol	 = new Gameoflife_page();
			
					
			}
			
			@Test
			public void Game1() throws Throwable
			{
		    	// create_ext_Test("Check Next Generation for second rowlivecell");
		    	 Gol.New_gamebutton.click();
		    	 Gol.test1_cell1.click();
		    	 Gol.test1_cell2.click();
		    	 Gol.test1_cell3.click();
		    	 Gol.Go_button.click();
		    	 String Message=Gol.Next_genMessage.getText();
		    	
		    	 Assert.assertEquals("Game Started to Next Generation page","Press 'Next Generation' to see how this universe evolves...",Message);
			
			Gol.Home_Button.click();
			String Header_text=Gol.Home_header.getText();
			 Assert.assertEquals("Navigated to Home Page",Header_text,"Welcome to Conway's Game Of Life!"); 
			
			}
			
			
			@Test
			public void Game2() throws Throwable
			{
		    	 Gol.New_gamebutton.click();
		    	 Gol.test2_cell1.click();
		    	 Gol.Go_button.click();
		    	 
		    	 String Message=Gol.Next_genMessage.getText();
			    	
		    	 Assert.assertEquals("Game Started to Next Generation page","Press 'Next Generation' to see how this universe evolves...",Message);
			
		    	 
				
					List<WebElement> count=driver.findElements(By.xpath("//table//tbody//tr//td//input[@type=\"hidden\"]"));
					int Count=count.size();
			    	 Assert.assertEquals("Selected Cells are live",1,Count);

				
				Gol.Go_button.click();
				List<WebElement> count1=driver.findElements(By.xpath("//table//tbody//tr//td//input[@type=\"hidden\"]"));
				int Count1=count1.size();
		    	 Assert.assertEquals("Selected Cells are died in next generation",0,Count1);

				
				}
			
			
					
			@After
			public void tearDown()
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.close();
			}
			
		

		}




