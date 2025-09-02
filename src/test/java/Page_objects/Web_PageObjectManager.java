package Page_objects;

import java.io.FileNotFoundException;
import java.io.IOException;

//used to store all the methods which were declared globally
//factory design pattern
//Also used to create objects for the defined methods in pageobject files
//package utlis;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Flipcart_page_object.LoginPage;

public class Web_PageObjectManager {

	public LoginPage loginPage;

	public Properties prop;
	public UtlisManager utlisManager;

	public WebDriver webdriver;

	public Web_PageObjectManager(WebDriver webdriver, Properties prop) // constructor
	{

		this.webdriver = webdriver;
		this.prop = prop;
	}

	public LoginPage loginPageObject() throws FileNotFoundException, IOException {
		loginPage = new LoginPage(webdriver, prop);
		return loginPage;
	}

}
