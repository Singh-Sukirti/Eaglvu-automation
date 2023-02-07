package com.qa.eaglevu.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.eaglevu.utils.Constants;
import com.qa.eaglevu.utils.ElementUtil;

public class DashboardPage {


	//1.Declare private Driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	private WebDriverWait WebDriverWait;
	
	//2. Page Constructor
			public DashboardPage(WebDriver driver) {
				this.driver = driver;
				eleUtil = new ElementUtil(driver);
			}
			
	//3. By locator	
				private By homepage = By.linkText("Home");
				private By myProgramdropdown = By.linkText("My Program");
				private By myDashboarddropdown = By.linkText("My Dashboards");
				private By toolsdropdown = By.linkText("Tools");
				private By orgDropdown = By.linkText("Org");
				private By proficiency = By.linkText("Proficiency");
				private By recognition = By.linkText("Recognition");
				
				
	//4.Page Action	
				
		public String getEaglvuDashboardPageTitle() {
		return eleUtil.doGetTitle(Constants.DASHBOARD_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		}
		
		public RecognitionPage goToDashboard(){
			
			WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait4.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
			eleUtil.doActionClick(homepage);
			
			WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Program")));			
			eleUtil.doActionClick(myProgramdropdown);


			WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait6.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Dashboards")));				
			eleUtil.doActionClick(myDashboarddropdown);

			WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait7.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tools")));	
			eleUtil.doActionClick(toolsdropdown);
						
			eleUtil.doClick(myProgramdropdown);
								
			
	        Actions actions = new Actions(driver);
	        //Retrieve WebElement 'Org' to perform mouse hover 
	    	WebElement menuOption = driver.findElement(By.linkText("Org"));
	    	//Mouse hover menuOption 'Org'
	    	actions.moveToElement(menuOption).perform();
	    	System.out.println("Done Mouse hover on 'Org' from Program Dropdown");
			
	    	//Now Select 'Recognition' from sub menu which has got displayed on mouse hover of 'Org'
	    	WebElement subMenuOption = driver.findElement(By.linkText("Recognition")); 
	    	//Mouse hover menuOption 'Recognition'
	    	actions.moveToElement(subMenuOption).perform();
	    	System.out.println("Done Mouse hover on 'Recognition' from Org");
	    	eleUtil.doClick(recognition);
	    	
	    	return new RecognitionPage(driver);

	    	
		}
			
		
}