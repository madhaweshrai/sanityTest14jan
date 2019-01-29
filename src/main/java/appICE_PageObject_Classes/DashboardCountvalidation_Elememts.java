package appICE_PageObject_Classes;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.JavaScriptApiWait;

public class DashboardCountvalidation_Elememts {

	@FindBy(xpath = ("//span[text()='Home']"))
	private WebElement homeButton;

	// Apps Names in the Main Home Page

	// DemoApp
	@FindBy(xpath = ("//h4[text()='appICE Demo App']"))
	private WebElement demoApp;
	@FindBy(xpath = "//h4[text()='appICE Demo App']/../..//div[2]/div/button[text()='Dashboard']")
	private WebElement demoAppDashBoard;

	// Yes Pay app
	@FindBy(xpath = ("//h4[text()='Yes Pay Wallet']"))
	private WebElement yesApp;
	@FindBy(xpath = "//h4[text()='Yes Pay Wallet']/../..//div[2]/div/button[text()='Dashboard']")
	private WebElement yesAppDashboard;

	// By madhawesh
	// Acquisition find element
	@FindBy(xpath = ("//span[text()='Acquisition']"))
	private WebElement acquisition;
	// App Installs find element
	@FindBy(xpath = ("//*[@id='008']"))
	private WebElement installs;

	// total Element //*[text()='Organic']
	@FindBy(xpath = ("//*[@id='tblAllSources']/tbody//tr/td[text()='Organic'][last()]/following-sibling::td[4]"))
	// @FindBy(xpath = ("//*[@id='tblSourceData']/tbody/tr[1]/td[5]"))
	private WebElement organicTotal;

	// Adwords Element
	@FindBy(xpath = ("//*[@id='tblSourceData']/tbody/tr[2]/td[5]"))
	private WebElement Adwords;

	// os Element
	@FindBy(xpath = ("//*[@id='tblOS']/tbody/tr[1]/td[2]"))
	private WebElement os;

	// Location Element
	@FindBy(xpath = ("//*[@id='tblLocation']/tbody/tr[2]/td[2]"))
	private WebElement Location;

	// Install Download .
	@FindBy(xpath = ("//*[@id='sources-downloadLink']"))
	private WebElement Insdownload;
	// Dashboard total installs
	// @FindBy(xpath = ("//*[@id='tblSources']/tbody/tr[1]/td[2]"))
	@FindBy(xpath = ("//*[@id='tblSources']/tbody/tr/td[text()='Organic']/preceding-sibling::td[2]"))
	private WebElement dashboardinstalls;
	@FindBy(xpath = (".//*[@id='sources-downloadLink']"))
	private WebElement installcsv;
	
	
	// more button
	// @FindBy(xpath = ("(//td[text()='+more'])[1]"))
	@FindBy(xpath = ("//*[@id='tblSourceData']/tbody/tr[6]/td"))
	private static WebElement clickingOnMore1;

	@FindBy(xpath = ("//table[@id='tblSourcesAll']//tbody//tr//td[2]"))
	private static List<WebElement> afterMoreClickForInstallsValues;

	@FindBy(xpath = ("//*[@id='divSources']/div/div[1]/h4/span"))
	private static WebElement clickingOnBack;

	@FindBy(xpath = ("//*[@id='tblSourceData']//tr//td[text()='Organic'][last()]/following-sibling::td[4]"))
	private static WebElement organicValDraogn;

	// OS download
	@FindBy(xpath = ("//*[@id='topos-downloadLink']"))
	private static WebElement OsDownload;
	// Location download
	@FindBy(xpath = ("//*[@id='toplocations-downloadLink']"))
	private static WebElement LocDownload;

	// Location download
	@FindBy(xpath = ("//*[@id='tblSourceData']/tbody/tr[1]"))
	private static WebElement entireTabletr1;

	@FindBy(xpath = ("//*[@id='tblSourceData']/tbody/tr[2]"))
	private static WebElement entireTabletr2;

	@FindBy(xpath = ("//*[@id='tblSourceData']/tbody/tr[3]"))
	private static WebElement entireTabletr3;

	@FindBy(xpath = ("//*[@id='tblSourceData']/tbody/tr[4]"))
	private static WebElement entireTabletr4;
	//drop down //*[@id='installSource']
	@FindBy(xpath = ("//*[@id='installSource']"))
	private  WebElement dropdownname;
	@FindBy(xpath = (".//*[@id='ng-app']/body/div[6]/div[3]/ul/li[1]"))
	private  WebElement todayinstalls;

	@FindBy(xpath = (".//*[@id='ng-app']/body/div[6]/div[3]/ul/li[2]"))
	private  WebElement yesterdayinstalls;
	
	
	// date Range elements
	@FindBy(xpath = (".//*[@id='advance-daterange']/span"))
	private WebElement datePeriodClick;
	@FindBy(xpath = (".//*[@id='content']/div[3]/div/div/div[1]/div[3]/label/div/div/span[2]"))
	private WebElement campaign;
	
	@FindBy(xpath = (".//*[@id='installHover']/div/div[3]/a/span"))
	private WebElement viewdetail;
	@FindBy(xpath = (".//*[@id='tblSourceData']/tbody/tr[1]/td[1]/following-sibling::td[4]"))
	private WebElement organictotal;
	
	@FindBy(xpath = (".//*[@id='tblSourceData']/tbody/tr[2]/td[1]/following-sibling::td[4]"))
	private WebElement camp1total;
	
	@FindBy(xpath = (".//*[@id='lblNewInstalls']/span"))
	private WebElement dashbrdinstalls;
	@FindBy(xpath = (".//*[@id='tblSourceData']/tbody/tr[6]/td"))
	private WebElement more;


	private WebDriver _webDriver = null;
	
	public DashboardCountvalidation_Elememts(WebDriver driver) {
		super();
		_webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isElementFound( ) {
        try{
            //WebElement webElement = appiumDriver.findElement(By.xpath(text));
        	
        	WebElement webElement = 	_webDriver.findElement(By.xpath(".//*[@id='tblSourceData']/tbody/tr[6]/td"));
        	System.out.println("isElementFound : true :"+ "true");
        }catch(NoSuchElementException e){
            System.out.println("isElementFound : false :");
            return false;
        }
        return true;
    }
	
	public void Today_DBinstalls() throws InterruptedException
	{
		Thread.sleep(2000);
	datePeriodClick.click();
	Thread.sleep(1000);
	todayinstalls.click();
	Thread.sleep(2000);
	
	//de= new Dashboard_Elements(_webDriver);
	//   Getting Dashboard organic installed count
	String strins = dashbrdinstalls.getText();
	// Getting dashboard campaign count
	//code not available
	int value = Integer.parseInt(strins);
	System.out.println("Total Dashboard Installs count  " + value);
	


	Thread.sleep(1000);
	viewdetail.click();
	datePeriodClick.click();
	Thread.sleep(1000);
	todayinstalls.click();
	Thread.sleep(2000);
	
	isElementFound();
	
	/*try
	{*/
	/*if(!more.isDisplayed())
	{
		 //more.isDisplayed()
		System.out.println("Get data from shown table " );
	}
	else 
	{
		System.out.println("Get data from shown table " );
more.click();
		

		Thread.sleep(1000);
		System.out.println("More clicked " );
	}
	//}
	catch(org.openqa.selenium.NoSuchElementException e)
	{
		
		
	}
	}*/
	}
}
