package com.qa.eaglvu.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecognitionPageTest extends BaseTest {
	
	
	
	  @BeforeClass 
	  public void loginfirst() 
	  {
	  dashboardPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty(
	  "password").trim()); recognitionPage = dashboardPage.goToDashboard(); 
	  }
	 
@Test
public void recognitionPageLogin()
{
	recognitionPage.goToRecognitionPage(prop.getProperty("text").trim());

}

}
