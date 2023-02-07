package com.qa.eaglevu.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.eaglevu.utils.Constants;
import com.qa.eaglevu.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecognitionPage {

	
	
	//1.Declare private Driver
		private WebDriver driver;
		private ElementUtil eleUtil;
		private WebDriverWait WebDriverWait;
		
		
		//2. Page Constructor
		public RecognitionPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}
		
		
		//3. By locator
		
		
		private By createNewBtn = By.linkText("Create New");
		private By nomineeName = By.name("EmpName");
		private By employeeid = By.xpath("/html/body/ul/li[61]");
		private By nominationLevel = By.id("NominationLevel");
		private By Personel = By.xpath("//*[@id='NominationLevel']");
		private By nominationOption = By.id("NominationOption");
		private By talent = By.xpath("//*[@id='NominationOption']");
		private By remarks = By.name("Remarks");
		private By backToList = By.linkText("Back to List");
		
		
		
		
		//4.Page Action	
		/*
		 * public String getEaglvuDashboardPageTitle() { return
		 * eleUtil.doGetTitle(Constants.DASHBOARD_PAGE_TITLE,
		 * Constants.DEFAULT_TIME_OUT); }
		 */
				public ProficiencyPage goToRecognitionPage(String text){
					
					//Click on Create New Button
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create New")));
					eleUtil.doActionClick(createNewBtn);
					
					//Click on Nominee Name Text Boc and then enter Nominee Name 
					eleUtil.doClick(nomineeName);
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ul/li[61]")));
					eleUtil.doActionClick(employeeid);
					
					
					//Click on Nomination Level
					WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("NominationLevel")));
					eleUtil.doActionClick(nominationLevel);
					// Create object of the Select class
					Select se = new Select(driver.findElement(By.xpath("//*[@id='NominationLevel']")));
					// Select the option by value
					se.selectByValue("3");
					eleUtil.doActionClick(nominationLevel);
					
					
					//Click on Nomination Option
					WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("NominationOption")));
					eleUtil.doActionClick(nominationOption);
					// Create object of the Select class
					Select se1 = new Select(driver.findElement(By.xpath("//*[@id='NominationOption']")));
					// Select the option by value
					se1.selectByVisibleText("Special Talent on Floor");
					eleUtil.doActionClick(nominationOption);
					
					
					//Click on Remark to add text 
					eleUtil.doClick(nomineeName);
					WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait4.until(ExpectedConditions.visibilityOfElementLocated(By.name("Remarks")));
					eleUtil.doActionClick(remarks);
					eleUtil.doSendKeys(remarks, text);
					
					
					//Click on back page link
					//eleUtil.doubleClick(backToList);
					
					eleUtil.doActionClick(backToList);
					
					eleUtil.doActionClick(backToList);
					
					return new ProficiencyPage(driver);
					
				}
					
}
