package Flipcart_Step_definition;

import java.io.FileNotFoundException;
import java.io.IOException;

import Flipcart_page_object.LoginPage;
import Page_objects.UtlisManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	public UtlisManager manager;
	public LoginPage login;

	public LoginStepDefinition(UtlisManager manager) throws FileNotFoundException, IOException {
		this.manager = manager;
		this.login = manager.webPageobjectManager.loginPageObject();

	}

	@Given("Navigate to application")
	public void navigateToApplication() {
		login.navigateToApplication();

	}

	@When("Login into application")
	public void logintoApplication() throws InterruptedException {
		login.loginToapp();

	}
}
