package com.biblio.automationpractice.pageobject;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.biblio.automationpractice.libraries.Element;
import com.github.javafaker.Faker;

public class CreateAccountPage {
	
	By txt_FirstName = By.xpath("//input[@name = 'customer_firstname']");
	By txt_LastName = By.xpath("//input[@name = 'customer_lastname']");
	By txt_Password = By.xpath("//input[@id = 'passwd']");
	By txt_Address_FirstName = By.xpath("//input[@id = 'firstname']");
	By txt_Address_LastName = By.xpath("//input[@id = 'lastname']");
	By txt_Address_Address = By.xpath("//input[@id = 'address1']");
	By txt_Address_City = By.xpath("//input[@id = 'city']");
	By select_Address_State = By.xpath("//select[@id = 'id_state']");
	By txt_Address_ZIPPostalCode = By.xpath("//input[@id='postcode']");
	By txt_Address_Country = By.xpath("//select[@id='id_country']");
	By txt_Address_MobilePhone = By.xpath("//input[@id='phone_mobile']");
	By select_Address_Country = By.xpath("//select[@id='id_country']");
	By btn_Register = By.xpath("//button[@id='submitAccount']");
	By lbl_UserDetail = By.xpath("//a[contains(@title, 'View my customer account')]/span");
	
	
	
	
	
	
	public void registerUserDetails() {
		Element element = new Element();
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		element.enterText(txt_FirstName, firstName);
		element.enterText(txt_LastName, lastName);
		element.enterText(txt_Password, lastName);
//		element.enterText(txt_Address_FirstName, firstName);
//		element.enterText(txt_Address_LastName, lastName);
		element.enterText(txt_Address_Address, faker.address().buildingNumber()+","+faker.address().streetName());
		element.enterText(txt_Address_City, faker.address().cityName());
		int randomStateInt = (int) (Math.random()*50);
		element.selectDropdownByValue(select_Address_State, Integer.toString(randomStateInt));
		int randomZIP = (int) (Math.random()*100000);
		element.enterText(txt_Address_ZIPPostalCode, Integer.toString(randomZIP));
		element.selectDropdownByValue(select_Address_Country, "21"); //Selecting US
		element.enterText(txt_Address_MobilePhone, faker.phoneNumber().cellPhone());
		element.click(btn_Register);
		
		//VErify Successful Account REgistration
		Assert.assertEquals(element.getText(lbl_UserDetail), firstName+" "+lastName);
		
	}

}
