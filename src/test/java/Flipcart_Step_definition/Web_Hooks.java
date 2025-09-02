package Flipcart_Step_definition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Page_objects.UtlisManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.TestBase;

public class Web_Hooks {
	public static WebDriver driver;
	public TestBase testbase = new TestBase();
	public UtlisManager utlisManager;

	public Web_Hooks(UtlisManager utlisManager) {
		this.utlisManager = utlisManager;
	}

	@Before
	public void browserSetup(Scenario scenario) throws Exception {
		driver = utlisManager.genericTestBase.webdriver;
		System.out.println("Thread ID: " + Thread.currentThread().getId());
	}

	@AfterStep
	public void takeScreenshoot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) utlisManager.genericTestBase.webdriver)
					.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}

	@After
	public void tearDown() {
		utlisManager.genericTestBase.webdriver.close();
		utlisManager.genericTestBase.webdriver.quit();
	}
}