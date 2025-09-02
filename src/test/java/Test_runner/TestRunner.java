package Test_runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = "Flipcart_Step_definition", monochrome = true, plugin = {
		"pretty", "json:target/cucumberjsontestruns/samplerun.json", "junit:target/cucumberxmltestruns/samplerun.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner extends AbstractTestNGCucumberTests {

//	for parallel browser testing
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();

	}

}
