package Flipcart_page_object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;
	public Properties prop;

	public Properties locators;

	public LoginPage(WebDriver driver, Properties prop) throws FileNotFoundException, IOException {
		this.driver = driver;
		this.prop = prop;
		initLocators();

	}

	public void initLocators() throws FileNotFoundException, IOException {
		this.locators = loadLocators();
	}

	public Properties loadLocators() throws FileNotFoundException, IOException {

		String path = null;
		path = System.getProperty("user.dir") + "//src//test//java//Flipcart_page_object//loginpage.properties";
		Properties locators = new Properties();
		if (path != null) {
			try (FileInputStream fis = new FileInputStream(path)) {
				locators.load(fis);
			}
		}

		return locators;

	}

	public void navigateToApplication() {
		driver.get(prop.getProperty("testing"));

	}

	public void loginToapp() throws InterruptedException {

		String username_xpath = locators.getProperty("username");
		String password_xpath = locators.getProperty("password");
		String login_xpath = locators.getProperty("login");

		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		Thread.sleep(5000);
		driver.findElement(By.xpath(username_xpath)).sendKeys(username);
		driver.findElement(By.xpath(password_xpath)).sendKeys(password);
		driver.findElement(By.xpath(login_xpath)).click();

	}

}
