package com.biblio.automationpractice.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.biblio.automationpractice.libraries.Util;
import com.biblio.automationpractice.pageobject.AuthenticationPage;
import com.biblio.automationpractice.pageobject.CoverPage;
import com.biblio.automationpractice.pageobject.CreateAccountPage;

public class TestUserRegistration {
	
	@Parameters({"browser"})
	@BeforeTest()
	public void setUp(String browser) {
		CoverPage coverPage = new CoverPage();
		coverPage.launchPage(browser);
	}
	
	@Test
	public void register() {
		CoverPage coverPage = new CoverPage();
		AuthenticationPage authenticationPage = new AuthenticationPage();
		CreateAccountPage createAccountPage = new CreateAccountPage();
		
		coverPage.signIn();
		authenticationPage.createAccount();
		createAccountPage.registerUserDetails();
		
	}
	
	@AfterTest
	public void tearDown() {
		CoverPage coverPage = new CoverPage();
		coverPage.signOut();
		
		Util.build().getCurrentWebDriver().close();	
		Util.build().getCurrentWebDriver().quit();
	}
}
