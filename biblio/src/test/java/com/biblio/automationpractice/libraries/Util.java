package com.biblio.automationpractice.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Util {
	static Util util;
	WebDriver driver;
	
	private Util() {}
		
	public static Util build() {
		if(util==null) {
			util = new Util();
			return util;
		}else {
			return util;
		}
	}

	public void navigateToPage(String url) {		
		driver.get(url);		
	}

	public WebDriver getCurrentWebDriver() {
		return driver;
	}

	public void initalizeBrowserDriver(String browser) {

		WebDriverManager.chromedriver().setup();
		switch (browser.toLowerCase()) {

		case "firefox":
			driver = new FirefoxDriver();
		default:
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String getProperty(String property) {
		try (FileInputStream fis = new FileInputStream(new File("./application.properties"))){
			Properties properties = new Properties();
			properties.load(fis);
			return properties.getProperty(property);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
