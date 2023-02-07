package com.qa.eaglevu.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.eaglevu.utils.ElementUtil;

public class ProficiencyPage {
	
	//1.Declare private Driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	private WebDriverWait WebDriverWait;
	
	
	//2. Page Constructor
	public ProficiencyPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	//3. By locator
	
	
	private By myProgramdropdown = By.linkText("My Program");
	private By orgDropdown = By.linkText("Org");
	private By proficiency = By.linkText("Proficiency");
	private By roleProficiency = By.id("tab-roleProficiency");
	private By focusArea = By.id("FocusArea");
	private By softwareQuality = By.xpath("//*[@id='FocusArea']");
	private By searchbtn = By.xpath("//input[@onclick='GetRoleProficiencies()']");  
	
	
	
	//4.Page Action	
	/*
	 * public String getEaglvuDashboardPageTitle() { return
	 * eleUtil.doGetTitle(Constants.DASHBOARD_PAGE_TITLE,
	 * Constants.DEFAULT_TIME_OUT); }
	 */
			public void goToProficiencyPage(){
				
				//Click on My Program dropdown list
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Program")));			
				eleUtil.doClick(myProgramdropdown);

				//Click on Org option present in dropdown list
				
				 Actions actions = new Actions(driver);
			        //Retrieve WebElement 'Org' to perform mouse hover 
			    	WebElement menuOption = driver.findElement(By.linkText("Org"));
			    	//Mouse hover menuOption 'Org'
			    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Org")));	
			    	actions.moveToElement(menuOption).perform();
			    	System.out.println("Done Mouse hover on 'Org' from Program Dropdown");
					
			    	//Now Select 'Recognition' from sub menu which has got displayed on mouse hover of 'Org'
			    	WebElement subMenuOption = driver.findElement(By.linkText("Proficiency")); 
			    	//Mouse hover menuOption 'Recognition'
			    	actions.moveToElement(subMenuOption).perform();
			    	System.out.println("Done Mouse hover on 'Proficiency' from Org");
			    	eleUtil.doClick(proficiency);
			    	
			    	//Click on Role Proficiency Tab
			    	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
					wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-roleProficiency")));			
					eleUtil.doClick(roleProficiency);
					
					//Click on Drodown to select software quality
					WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("FocusArea")));
					eleUtil.doClick(focusArea);
					// Create object of the Select class
					Select se = new Select(driver.findElement(By.xpath("//*[@id='FocusArea']")));
					// Select the option by value
					se.selectByValue("9");
					eleUtil.doClick(softwareQuality);
					
					//Click on search button
					WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='GetRoleProficiencies()']")));
					eleUtil.doClick(searchbtn);
					
					
			
					
					
				
			}
				
}