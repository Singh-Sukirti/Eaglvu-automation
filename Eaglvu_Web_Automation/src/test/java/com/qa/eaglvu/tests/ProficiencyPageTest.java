package com.qa.eaglvu.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProficiencyPageTest extends BaseTest {
	
	
	  @BeforeClass
	  public void loginfirst() 
	  { 
	  dashboardPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim()); 
	  recognitionPage = dashboardPage.goToDashboard();
	  proficiencyPage = recognitionPage.goToRecognitionPage(prop.getProperty("text").trim()); 
	  }
	 

@Test
public void proficiencyPageLogin()
{
	proficiencyPage.goToProficiencyPage();

}

}
