package com.biblio.automationpractice.pageobject;

import org.openqa.selenium.By;

import com.biblio.automationpractice.libraries.Element;
import com.github.javafaker.Faker;

public class AuthenticationPage {
	
	By txtEmailID = By.xpath("//input[@id='email_create']");
	By btnCreateAnAccount = By.xpath("//button[@id='SubmitCreate']");
	
	public void createAccount() {
		Faker faker = new Faker();
		Element element = new Element();
		
		element.enterText(txtEmailID, faker.name().firstName()+"@"+ faker.name().firstName()+".com");
		element.click(btnCreateAnAccount);
		
	}

}
