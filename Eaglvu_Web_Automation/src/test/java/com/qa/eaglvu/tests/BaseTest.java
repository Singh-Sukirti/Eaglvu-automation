package com.qa.eaglvu.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.eaglevu.factory.DriverFactory;
import com.qa.eaglevu.pages.DashboardPage;
import com.qa.eaglevu.pages.LoginPage;
import com.qa.eaglevu.pages.ProficiencyPage;
import com.qa.eaglevu.pages.RecognitionPage;

public class BaseTest {

	DriverFactory df;
	Properties prop;
	WebDriver driver;
	WebDriverWait WebDriverWait;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	RecognitionPage recognitionPage;
	ProficiencyPage proficiencyPage;
   

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		recognitionPage = new RecognitionPage(driver);
		proficiencyPage = new ProficiencyPage(driver);
		driver.manage().window().maximize();
	}

	
	  @AfterTest public void tearDown() { 
		  driver.quit(); 
		  }
	 
	 

}
