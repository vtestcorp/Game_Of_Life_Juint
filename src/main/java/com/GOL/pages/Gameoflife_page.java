package com.GOL.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.GOL.base.Base;
import com.GOL.util.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Gameoflife_page extends Base {
	
	@FindBy(xpath="//a[contains(text(),'New Game')]")
	public WebElement New_gamebutton;
	@FindBy(xpath="//input[@name='cell_1_0']")
	public WebElement test1_cell1;
	@FindBy(xpath="//input[@name='cell_1_1']")
	public WebElement test1_cell2;
	@FindBy(xpath="//input[@name='cell_1_2']")
	public WebElement test1_cell3;
	@FindBy(xpath="//button[@id='submit']")
	public WebElement Go_button;
	@FindBy(xpath="	//div[contains(text(),\"Press 'Next Generation' to see how this universe evolves...\")]")
	public WebElement Next_genMessage;
	@FindBy(xpath="//input[@name='cell_0_0']")
	public WebElement test2_cell1;
	@FindBy(xpath="//a[contains(text(),'home')]")
	public WebElement Home_Button;
	@FindBy(xpath="//h2[contains(text(),\"Welcome to Conway's Game Of Life!\")]")
	public WebElement Home_header;
	
	//Constructor Initialization
		public Gameoflife_page() throws IOException
		{
			PageFactory.initElements(driver,this);
		}
		
		// Methods
		
		
}

	


