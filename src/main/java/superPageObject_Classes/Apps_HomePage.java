package superPageObject_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ActionsClass;
import utils.JavaScriptApiWait;
import utils.JavaScriptPageLoading;

public class Apps_HomePage {

	@FindBy(xpath = ("//div[@id='sidebar']"))
	private WebElement menu;

	@FindBy(xpath = ("//h4[@class='panel-title']"))
	private WebElement allTexts;

	@FindBy(xpath = "html/body/div[5]/div[2]/div/div[1]/ul/li[1]/a/span")
	private WebElement dbText; // Dashboard

	@FindBy(xpath = "html/body/div[5]/div[2]/div/div[1]/ul/li[2]/a/span")
	private WebElement maText; // My Apps

	@FindBy(id = "002")
	private WebElement snaText;
	@FindBy(id = "appnameStore")
	private WebElement iPhoneAppName;
	@FindBy(id = "appnameGoogle")
	private WebElement androidAppName;
	@FindBy(xpath = "//a[text()='Next']")
	private WebElement nextButton;
	@FindBy(xpath = "(//a[text()='Download'])[1]")
	private WebElement androidSDK;
	@FindBy(xpath = "(//a[text()='Download'])[2]")
	private WebElement iosSDK;

	@FindBy(xpath = "//span[text()='Who are our users?']")
	private WebElement wruText; // Who are our users?
	@FindBy(id = ("005"))
	private WebElement demoText; // Demographics
	@FindBy(id = ("006"))
	private WebElement asText; // Audience segments
	@FindBy(id = ("007"))
	private WebElement hdwgtText; // How did we get them?
	@FindBy(id = ("008"))
	private WebElement aiText; // App Installs
	@FindBy(id = ("009"))
	private WebElement updText; // Upload Past Data
	@FindBy(id = ("0010"))
	private WebElement wdudText; // What do users do?
	@FindBy(id = ("0011"))
	private WebElement itaText; // Inside the App
	@FindBy(id = ("0012"))
	private WebElement otaText; // Outside the App
	@FindBy(id = ("0013"))
	private WebElement hcweText; // How can we engage?
	@FindBy(id = ("0014"))
	private WebElement cText; // Campaigns
	@FindBy(id = ("0015"))
	private WebElement whwlText; // Who have we lost?
	@FindBy(id = ("0016"))
	private WebElement uiText; // Un-Installs
	@FindBy(id = ("0017"))
	private WebElement apsText; // AppICE Settings
	@FindBy(id = ("0018"))
	private WebElement mmText; // Manage Modules
	@FindBy(id = ("0019"))
	private WebElement umText; // User Management
	@FindBy(id = ("0020"))
	private WebElement utdText; // Upload Test Data
	@FindBy(id = ("0021"))
	private WebElement dText; // Documentation
	@FindBy(id = ("0022"))
	private WebElement aeiText; // Android Eclipse Integration
	@FindBy(id = ("0023"))
	private WebElement asiText; // Android Studio Integration
	@FindBy(id = ("0024"))
	private WebElement iosiText; // iOS Integration

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

	public Apps_HomePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void Menutexts() {
		String ele1 = menu.getText();
		System.out.println(ele1);

	}

	public void allAppTexts() {
		String ele1 = allTexts.getText();
		System.out.println(ele1);
	}

	public void demoApp(WebDriver driver) throws InterruptedException {
		demoApp.click();
		demoAppDashBoard.sendKeys("/n");
		demoAppDashBoard.click();
	}

	public void yesPayApp() {
		JavaScriptApiWait.waitForApiLoad();
		yesApp.click();
		yesAppDashboard.sendKeys("/n");
		yesAppDashboard.click();
	}

	/*
	 * public void anyAppClick(){
	 * 
	 * JavaScriptWait.waitForLoad(); yesApp.click();
	 * yesAppDashboard.sendKeys("/n"); yesAppDashboard.click(); }
	 */
	public void homeButtonClick() {
		JavaScriptPageLoading.waitForPageLoadCompletely();

		// homeButton.click();

		ActionsClass.mouseOverAction(homeButton);
	}

	public void MyAppsPage() {
		snaText.click();
	}

	public void iPhoneApp(String iStoreAppName) {
		iPhoneAppName.sendKeys(iStoreAppName);
	}

	public void androidAppName(String androidStoreAppName) {
		androidAppName.sendKeys(androidStoreAppName);
	}

	public void verifyButton() {
		nextButton.click();
	}

	public void androidSDK() {
		androidSDK.click();
	}

	public void iosSDK() {
		iosSDK.click();
	}

}
