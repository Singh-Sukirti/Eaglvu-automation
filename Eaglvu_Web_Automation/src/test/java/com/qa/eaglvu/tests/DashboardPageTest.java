package com.qa.eaglvu.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.eaglevu.pages.DashboardPage;
import com.qa.eaglevu.pages.RecognitionPage;
import com.qa.eaglevu.utils.Constants;

public class DashboardPageTest extends BaseTest {

	
	  @BeforeClass 
	  public void loginfirst()
	  { 
      dashboardPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty(
	  "password").trim()); }
	 

	@Test(priority = 1)

	public void deashboardHeader() {
		String dashTitle = dashboardPage.getEaglvuDashboardPageTitle();
		System.out.println("Dashboard page title" + dashTitle);
		Assert.assertEquals(dashTitle, Constants.DASHBOARD_PAGE_TITLE);
	}

	@Test(priority = 1)

	public void dashboardPage() {
		dashboardPage.goToDashboard();

	}

}