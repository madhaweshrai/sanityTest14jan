package baseClasses;

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
import utils.ConfigReader;

public class ApiMultiBrowsers {

	private static String lsp = System.getProperty("file.separator");
	public static WebDriver wdriver;
	public static ConfigReader config = new ConfigReader();

	@BeforeClass
	public void getbrowser() throws Exception {
		Properties prop = new Properties();
		// ("./propertyFiles/dataFile.properties");
		FileInputStream fis = new FileInputStream("./propertyFiles/dataFile.properties");

		prop.load(fis);
		if (prop.get("browser").equals("firefox")) {
			wdriver = new FirefoxDriver();
		} else if (prop.get("browser").equals("chrome")) {
			String path = "." + lsp + "exeFiles" + lsp + "chromedriver.exe";
			System.out.println("sp : " + path);
			System.setProperty("webdriver.chrome.driver", path);
			/*
			 * The below is where the chrome driver installed in Linux machine
			 * /usr/bin/chromedriver and the below is the local place
			 * .\\exeFiles\\chromedriver.exe
			 */
			
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("headless");
			  options.addArguments("window-size=1200x600");
			  wdriver = new ChromeDriver(options);
			 
			//wdriver = new ChromeDriver();

		} else if (prop.get("browser").equals("firefox")) {
			System.setProperty("webdriver.ie.driver", "." + lsp + "exeFiles" + lsp + "MicrosoftWebDriver.exe");
			wdriver = new InternetExplorerDriver();
		} else {
			wdriver = new HtmlUnitDriver();
		}

		/*
		 * eventListener=new ActivityCapture_WDL(); driver.register(eventListener);
		 */

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(wdriver);

		ActivityCapture_WDL driver = new ActivityCapture_WDL();
		eventDriver.register(driver);

		wdriver.get(prop.getProperty("Apiurl"));
		wdriver.manage().window().maximize();

		wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterTest() {
		wdriver.quit();
	}
}
