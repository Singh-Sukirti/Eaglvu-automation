package com.qa.eaglevu.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.eaglevu.utils.Constants;
import com.qa.eaglevu.utils.ElementUtil;

public class LoginPage {
	
		
		//1.Declare private Driver
		private WebDriver driver;
		private ElementUtil eleUtil;
		private WebDriverWait WebDriverWait;
		
		//2. Page Constructor
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}
		
		//3.By Locator
		private By loginIn = By.linkText("Login");
		private By signIn = By.name("loginfmt");
		private By emailId = By.name("loginfmt");
		private By nextBtn = By.id("idSIButton9");
		private By password = By.name("passwd");
		private By sumbmit1 = By.xpath("//*[@id=\"idSIButton9\"]");
		//private By sumbmit1 = By.xpath("//input[@value='Sign in\"]");
		private By yesBtn = By.cssSelector("#idSIButton9");

	   
		//4.Page Action
		
		public String getEaglvuPageTitle() {
			return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
		}
			public boolean getLoginPageUrl(){
			return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
			}
			
			/*
			 * public boolean isneedHelpLinkExist() { return
			 * driver.findElement(needHelpLink).isDisplayed(); }
			 */
 
			public DashboardPage doLogin(String email, String passwd) 
			{
					System.out.println("Login with : " + email + " " +passwd);
					
					//Login button Clicked
					eleUtil.doClick(loginIn);
					
		            //Clicked on Email ID textbox
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
					eleUtil.doClick(signIn);
					
					//Entered Email ID
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
					eleUtil.doSendKeys(emailId, email);
		
		
					//Click on Next Button 
					WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
					eleUtil.doClick(nextBtn);
					
				    //Entered Password
					WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
					wait3.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
					eleUtil.doSendKeys(password, passwd);
					
					
					//Click on Submit button 
					/*
					 * WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
					 * wait4.until(ExpectedConditions.visibilityOfElementLocated(By.
					 * xpath("//input[@value='Sign in\"]")));
					 */
					eleUtil.doClick(sumbmit1);
					
					//Click on YES button 
					
					/*
					 * WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(180));
					 * wait5.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					 * "idSIButton9")));
					 */
					
					eleUtil.doClick(yesBtn);
			
					return new DashboardPage(driver);
			
			}
			
	}
	
