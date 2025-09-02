	package utility;
	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.net.URL;
	import java.time.Duration;
	import java.util.HashMap;
	import java.util.Properties;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
	
//	import com.aventstack.extentreports.ExtentReports;
//	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//	import io.appium.java_client.AppiumDriver;
//	import io.appium.java_client.android.AndroidDriver;
//	import io.appium.java_client.android.options.UiAutomator2Options;
//	import io.appium.java_client.ios.IOSDriver;
//	import io.appium.java_client.ios.options.XCUITestOptions;
//	import io.appium.java_client.service.local.AppiumDriverLocalService;
//	import io.appium.java_client.service.local.AppiumServiceBuilder;
	//import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class TestBase {
		public Properties prop;
//		public AppiumDriverLocalService service;
//		public AppiumDriver appdriver;
		public WebDriver webdriver;
		//public UiAutomator2Options androidoptions;
		//public XCUITestOptions iosoptions;
		
		public Properties ConfigProperties() throws IOException {
			try (FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//config.properties")) {
				prop = new Properties();
				prop.load(fis);
				return prop;
			} catch (IOException e) {
				System.err.println("Failed to load config properties: " + e.getMessage());
				
				throw e;
			}
		}
		
		
		public WebDriver ConfigureWebDriver() throws IOException {
			try {
				ConfigProperties();
				String driverType = System.getProperty("driverType", System.getenv("driverType"));
	
				if (driverType.equals("chrome")) {
					WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().setup();
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--remote-allow-origins=*");
					chromeOptions.addArguments("--disable-gpu");
	
					webdriver = new ChromeDriver(chromeOptions);
					webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					webdriver.manage().window().maximize();
					webdriver.manage().deleteAllCookies();
					System.out.println("Launching browser on thread: " + Thread.currentThread().getId());
	
					return webdriver;
	
				}
				return webdriver;
			} catch (Exception e) {
				System.err.println("Failed to configure WebDriver: " + e.getMessage());
				e.printStackTrace();
				
				return null;
			}
		}
	
	}
