package baseClasses;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


import superPageObject_Classes.AppICE_Home_Login_Pages;
import superPageObject_Classes.Panel_Page;

public class MultiBrowsers_BC_AC {
	public static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void getbrowser() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"./propertyFiles/dataFile.properties");
		prop.load(fis);
		if (prop.get("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (prop.get("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",".\\exeFiles\\chromedriver.exe");
//					"E:/AppICE_Data_Driven_FW/com.appICE_Maven/exeFiles/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", ".\\exeFiles\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Panel_Page pp = new Panel_Page(driver);
		pp.loginbutton();
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(driver);
		lp.credencials("admin@semusi.com", "password");
		
	}

	@AfterClass
	public void afterTest() {
		//driver.close();
	}

}
