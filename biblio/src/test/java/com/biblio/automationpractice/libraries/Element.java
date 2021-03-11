package com.biblio.automationpractice.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Element {

	public void click(By byElement) {
		Util.build().getCurrentWebDriver().findElement(byElement).click();
	}

	public void enterText(By byElement, String text) {
		Util.build().getCurrentWebDriver().findElement(byElement).sendKeys(text);
		
	}

	public void selectDropdownByValue(By select_Address_State, String value) {
		Select select = new Select(Util.build().getCurrentWebDriver().findElement(select_Address_State));
		select.selectByValue(value);
		
	}
	
	public String getText(By byElement) {
		return Util.build().getCurrentWebDriver().findElement(byElement).getText().trim();
		
	}
}
