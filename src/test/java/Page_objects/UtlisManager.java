package Page_objects;

import utility.TestBase;

public class UtlisManager {

//public AndroidDriver driver; //making driver as global variable to use accross differnet classes
//public Properties prop;
//public UiAutomator2Options options;
	//public App_PageObjectManager appPageobjectManager;
	public TestBase genericTestBase;
	public Web_PageObjectManager webPageobjectManager;

	public UtlisManager() throws Exception {
		genericTestBase = new TestBase();
		//appPageobjectManager = new App_PageObjectManager(genericTestBase.ConfigureAppDriver(),genericTestBase.ConfigProperties());
		webPageobjectManager = new Web_PageObjectManager(genericTestBase.ConfigureWebDriver(),genericTestBase.ConfigProperties());

	}
}