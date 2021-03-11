package com.biblio.automationpractice.pageobject;

import org.openqa.selenium.By;

import com.biblio.automationpractice.libraries.Element;
import com.biblio.automationpractice.libraries.Util;

public class CoverPage {
	
	By btn_SignIn = By.xpath("//a[@class=\"login\"]");
	By btn_SignOut = By.xpath("//a[contains(text(),'Sign out')]");
	

	public void launchPage(String browser) {
		Util util = Util.build();
		String appURL = util.getProperty("url");
		util.initalizeBrowserDriver(browser);
		util.navigateToPage(appURL);
		util.getCurrentWebDriver().manage().window().maximize();
		
	}

	public void signIn() {
		Element element = new Element();
		element.click(btn_SignIn);
	}

	public void signOut() {
		Element element = new Element(); 
		element.click(btn_SignOut);
		
	}
}
