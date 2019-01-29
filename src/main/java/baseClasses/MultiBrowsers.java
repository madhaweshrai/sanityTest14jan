package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import listeners.ActivityCapture_WDL;

public class MultiBrowsers {

	public static WebDriver wdriver;

	@BeforeClass
	public void beforeClass() throws Exception {  
		// Load property file to fetch default values to use for testing in browser
		Properties prop = new Properties();
		prop.load(new FileInputStream("./propertyFiles/dataFile.properties"));

		String webDriverName = "exeFiles" + System.getProperty("file.separator")
				+ (System.getProperty("os.name").contains("Mac") ? "chromedriverMac"
						: (System.getProperty("os.name").contains("Windows") ? "chromedriverWin.exe"
								: (System.getProperty("os.arch").contains("32") ? "chromedriverLin32"
										: "chromedriverLin64")));

		// Set web-driver object w.r.t browser
		String isHeadLess = (String) prop.get("isHeadLess");
		String inspectElements = (String) prop.get("inspectElements");
		String disableImages = (String) prop.get("disableImages");
		int domWaitTimeSec = Integer.parseInt((String) prop.get("domWaitTimeSec"));

		String browserToTestOn = (String) prop.get("browser");
		switch (browserToTestOn) {
		case "firefox":
			wdriver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\AppICE_Data_Driven_FW\\com.appICE_Maven\\exeFiles\\chromedriver.exe");
			
			// options.addArguments("window-size=1200x600");

			ChromeOptions options = new ChromeOptions();
			if (isHeadLess.equalsIgnoreCase("true"))
				options.addArguments("headless");
			if (inspectElements.equalsIgnoreCase("true"))
				options.addArguments("auto-open-devtools-for-tabs");
			if (disableImages.equalsIgnoreCase("true"))
				options.addExtensions(new File("./extensionFiles/Block-image_v1.0.crx"));

			wdriver = new ChromeDriver(options);
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", webDriverName);
			wdriver = new InternetExplorerDriver();
			break;

		default:
			wdriver = new HtmlUnitDriver();
			break;
		}

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(wdriver);
		eventDriver.register(new ActivityCapture_WDL());

		wdriver.get(prop.getProperty("url"));
		wdriver.manage().window().maximize();
		wdriver.manage().timeouts().implicitlyWait(domWaitTimeSec, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		wdriver.quit();
	}

}
