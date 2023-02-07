package com.qa.eaglvu.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.eaglevu.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	Logger log = Logger.getLogger(LoginPageTest.class)

@Test (priority = 1)	
public void loginPageOfEaglvu() {
			
		String actTitle = loginPage.getEaglvuPageTitle();
		System.out.println("Page title : " + actTitle);
		Assert.assertEquals(actTitle,Constants.LOGIN_PAGE_TITLE);
		}

@Test (priority = 2)
public void loginPageURLTest() {
	Assert.assertTrue(loginPage.getLoginPageUrl());
}
	
@Test (priority = 3)
	public void loginTest() {
	loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
}