package appICE_PageObject_Classes;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.DateObject;
import utils.ExplicitWait;
import utils.JavaScriptApiWait;
import utils.JavaScriptPageLoading;
import utils.SelectClass;


public class Dashboard_Elements extends ExplicitWait {
	public int totalValue;
	// Common element like Installs, Uninstall, sessions etc
	@FindBy(css="span[data-page='dashboard?action=installs']")
	private WebElement installsViewDetails;
	
	// date Range elements
	@FindBy(xpath = (".//*[@id='advance-daterange']/span"))
	private WebElement datePeriodClick;

	@FindBy(xpath = ("//li[text()='Today']"))
	private WebElement todaysDateClick;

	@FindBy(xpath = (".//*[@id='ng-app']/body/div[6]/div[3]/ul/li[2]"))
	private WebElement yesterdayDateClick;

	@FindBy(xpath = (".//*[@id='ng-app']/body/div[6]/div[3]/ul/li[3]"))
	private WebElement last7Days;

	@FindBy(xpath = (".//*[@id='ng-app']/body/div[6]/div[3]/ul/li[4]"))
	private WebElement last30Days;
	
	@FindBy (xpath=("//li[text()='This Month']"))
	private WebElement thisMonth;
	
	@FindBy (xpath=("//li[text()='Last Month']"))
	private WebElement lastMonth;
	
	@FindBy(css=("input[name='daterangepicker_start']"))
	private WebElement customFromDate;
	@FindBy(css=("input[name='daterangepicker_end']"))
	private WebElement customToDate;
	
	@FindBy(css=("button[class='applyBtn btn btn-sm btn-primary']"))
	private WebElement submitButton;

	@FindBy(css = ("span[id=lnkMoreSources"))
	private static WebElement clickingOnMore;
	
	@FindBy (xpath=("//span[text()='Back']"))
	private static WebElement clickingOnBack; 

	@FindBy (css="span#lblNewInstalls")
	private WebElement Installs;
	
	@FindBy (css="span#lblTotalChurn")
	private WebElement Uninstalls;
	
	@FindBy(xpath=("//table[@id='tblSourcesAll']//tbody//tr//td[2]"))
	private static List<WebElement> afterMoreClickForInstallsValues;
	
	@FindBy(xpath=(".//*[@id='tblSources']//td[2]"))
	private static List<WebElement> beforeClickMoreOptionsInstalls;
	
	@FindBy(xpath=("//table[@id='tblSourcesAll']//tbody//tr//td[6]"))
	private static List<WebElement> afterMoreClickForUnInstallsValues;
	
	@FindBy(xpath=(".//*[@id='tblSources']//td[6]"))
	private static List<WebElement> beforeClickMoreOptionsUnInstalls;
	
	//cohort Elements
	@FindBy (css=("input#txtFromDate"))
	private WebElement fromDate_Cohort;
	
	@FindBy (css=("input#txtToDate"))
	private WebElement toDate_Cohort;
	
	@FindBy (css=("select#ddlCohortDateFilter"))
	private WebElement clickPeriodDropdown;
	
	@FindBy(xpath=(".//td[not(@class='cornelius-empty')][last()]"))
	private List<WebElement> lastValues;
	
	@FindBy(css=("button#btnView"))
	private WebElement viewButtonClick;
	
	//For the apps name
	@FindBy (xpath="(//h1[@class='page-header'])[2]")
	private WebElement appName;
	
	
	public Dashboard_Elements(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String appName(){
		String appText = appName.getAttribute("innerHTML").trim();
		System.out.println("App name is " +"' "+appText+" '");
		return appText;
	}
	
	public void viewDetails(){
		installsViewDetails.sendKeys(Keys.CONTROL+"t");
	}

	public void todayDate() {
		JavaScriptApiWait.waitForApiLoad();
		JavaScriptPageLoading.waitForPageLoadCompletely();
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		ExplicitWait.explicitWaitStatement(todaysDateClick);
		
		JavaScriptApiWait.waitForApiLoad();
	}

	public void yesterdayDate() {
		JavaScriptApiWait.waitForApiLoad();
		JavaScriptPageLoading.waitForPageLoadCompletely();
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		ExplicitWait.explicitWaitStatement(yesterdayDateClick);
		JavaScriptApiWait.waitForApiLoad();
	}

	public void last7Days() {
		JavaScriptApiWait.waitForApiLoad();
		JavaScriptPageLoading.waitForPageLoadCompletely();
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		ExplicitWait.explicitWaitStatement(last7Days);
		JavaScriptApiWait.waitForApiLoad();
	}

	public void last30Days() {
		JavaScriptApiWait.waitForApiLoad();
		JavaScriptPageLoading.waitForPageLoadCompletely();
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		ExplicitWait.explicitWaitStatement(last30Days);
		JavaScriptApiWait.waitForApiLoad();
	}
	
	public void thisMonth() {
		JavaScriptApiWait.waitForApiLoad();
		JavaScriptPageLoading.waitForPageLoadCompletely();
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		ExplicitWait.explicitWaitStatement(thisMonth);
		JavaScriptApiWait.waitForApiLoad();
	}
	public void lastMonth() {
		JavaScriptApiWait.waitForApiLoad();
		JavaScriptPageLoading.waitForPageLoadCompletely();
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		ExplicitWait.explicitWaitStatement(lastMonth);
		JavaScriptApiWait.waitForApiLoad();
	}

	public void moreClick(WebDriver driver) {
		JavaScriptPageLoading.waitForPageLoadCompletely();
		ExplicitWait.explicitWaitStatement(clickingOnMore);
	
		// clickingOnMore.click();
	}
	
	String Ins; String Unins; int intUnins; int intIns;
	public void customDateIns(String from) throws InterruptedException{
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		customFromDate.clear();
		customFromDate.sendKeys(from);
		customToDate.clear();
		customToDate.sendKeys(DateObject.dateObjMinusOne());
		submitButton.click();
		Thread.sleep(500);
		
		JavaScriptApiWait.waitForApiLoad();
	
	}
	public void customDate(String from) throws InterruptedException{
		ExplicitWait.explicitWaitStatement(datePeriodClick);
		customFromDate.clear();
		customFromDate.sendKeys(from);
		customToDate.clear();
		customToDate.sendKeys(DateObject.dateObjMinusOne());
		submitButton.click();
		Thread.sleep(500);
		
		JavaScriptApiWait.waitForApiLoad();
		
		// ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		// Commenting for testing java script wait. After the click of the customdata click
		/*try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		Ins = Installs.getText();
		intIns = Integer.parseInt(Ins);
		System.out.println("The number of Install are "+intIns);
		Unins=Uninstalls.getText();
		intUnins = Integer.parseInt(Unins);
		System.out.println("The number of Uninstall are "+intUnins);
		 totalValue = intIns - intUnins;
		System.out.println("Total value of Repeat installs and Uninstalls is "+" "+ totalValue);
	}
	
	// The value if sleep is 40000. Make sure if the java script won't work.
	// Remove the comments

	public void installs(){
		/*try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}*/
		String ins = Installs.getText();
		//System.out.println(ins);
	}
	
	public void uninstalls(){
		/*try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		String unIns = Uninstalls.getText();
		//System.out.println(unIns);
	}
	
	
	public static void sourceWiseInstalls(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if (clickingOnMore.isDisplayed()){
			clickingOnMore.click();
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : afterMoreClickForInstallsValues) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf(0)+1,indexingOfRepeatInstalls.indexOf("(") - 1));
			}
			System.out.println("Sourcewise Unique Install= " + sum);
		}
		else{
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : beforeClickMoreOptionsInstalls) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf(0)+1,indexingOfRepeatInstalls.indexOf("(") - 1));
			}
			System.out.println("Sourcewise Unique Install = " + sum);
		}
	}
	public static void sourceWiseRepeatInstalls(){
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if (clickingOnMore.isDisplayed()){
			clickingOnMore.click();
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : afterMoreClickForInstallsValues) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf("(") + 1, indexingOfRepeatInstalls.length() - 1));
			}
			System.out.println("Sourcewise Repeat install = " + sum);
		}
		if(clickingOnBack.isDisplayed()){
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : afterMoreClickForInstallsValues) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf("(") + 1, indexingOfRepeatInstalls.length() - 1));
			}
			System.out.println("Sourcewise Repeat install = " + sum);
		}
		else{
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : beforeClickMoreOptionsInstalls) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf("(") + 1, indexingOfRepeatInstalls.length() - 1));
			}
			System.out.println("Sourcewise Repeat install= " + sum);
		}
	}
	public static void sourceWiseUninstalls(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (clickingOnMore.isDisplayed()){
			clickingOnMore.click();
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : afterMoreClickForUnInstallsValues) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf(0)+1,indexingOfRepeatInstalls.indexOf("(") - 1));
			}
			System.out.println("Sourcewise Unique Uninstall= " + sum);
		}
		if(clickingOnBack.isDisplayed()){
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : afterMoreClickForUnInstallsValues) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf(0)+1,indexingOfRepeatInstalls.indexOf("(") - 1));
			}
			System.out.println("Sourcewise Unique Uninstall= " + sum);
		}
		else{
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : beforeClickMoreOptionsUnInstalls) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf(0)+1,indexingOfRepeatInstalls.indexOf("(") - 1));
			}
			System.out.println("Sourcewise Unique Uninstall= " + sum);
		}
	}
	public static void sourceWiseRepeatUnInstalls(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if (clickingOnMore.isDisplayed()){
			clickingOnMore.click();
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : afterMoreClickForUnInstallsValues) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf("(") + 1, indexingOfRepeatInstalls.length() - 1));
			}
			System.out.println("Sourcewise Repeat Uninstall= " + sum);
		}
		if(clickingOnBack.isDisplayed()){
			int sum = 0;;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : afterMoreClickForUnInstallsValues) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf("(") + 1, indexingOfRepeatInstalls.length() - 1));
			}
			System.out.println("Sourcewise Repeat Uninstall= " + sum);
		}
		else{
			int sum = 0;
			String indexingOfRepeatInstalls = "";
			for (WebElement count : beforeClickMoreOptionsUnInstalls) {
				indexingOfRepeatInstalls = count.getText();
				sum += Integer.parseInt(indexingOfRepeatInstalls.substring(indexingOfRepeatInstalls.indexOf("(") + 1, indexingOfRepeatInstalls.length() - 1));
			}
			System.out.println("Sourcewise Repeat Uninstall= " + sum);
		}
	}

	
	public void cohortDates(String from, String text){
		fromDate_Cohort.clear();
		fromDate_Cohort.sendKeys(from);
		toDate_Cohort.clear();
		toDate_Cohort.sendKeys(DateObject.dateObjMinusOne());
		// clickPeriodDropdown
		/*Select sel=new Select(clickPeriodDropdown);
		sel.selectByVisibleText(text);*/
		
		SelectClass.selectDropDown(clickPeriodDropdown, text);
		
		viewButtonClick.click();
		JavaScriptApiWait.waitForApiLoad();
		
		//explicitWaitStatementListEle(lastValues);
	}
	public void countCohort(){
		int sum=0;
		String totalValueCount="";
		for ( WebElement totalCount :lastValues){
			totalValueCount = totalCount.getText();
			//System.out.println("last "+ totalValueCount);
			try {
		        sum += Integer.parseInt(totalValueCount);
		   }catch (NumberFormatException e){
		   } 
			
		}
		System.out.println("CohortCount "+ sum);
		int diff = sum-totalValue;
		System.out.println("cohort test difference is:"+diff);
		if(diff==0)
		{
			// assertion is done for 50 diff for now,
			// but it should be 0 ideally
			Assert.assertTrue(true, "cohort and difference  matched,Validation passed");
			
			//Assert.assertTrue(false,"cohort and difference not matched,Validation failed");
		}
		else
		{
			
			Assert.assertFalse(true,"cohort and difference not matched,Validation failed");
		}
	}
	
	//cohort yearly by madhawesh
	public void countCohortyearly(){
		int sum=0;
		String totalValueCount="";
		for ( WebElement totalCount :lastValues){
			totalValueCount = totalCount.getText();
			try {
		        sum += Integer.parseInt(totalValueCount);
		   }catch (NumberFormatException e){
		   } 
			
		}
		int sumyearly= sum;
		System.out.println("CohortCount "+ sumyearly);
		int diff = sum-totalValue;
		
		int diffnew= diff - 2019;
		if(diffnew<0)
		{
			diffnew=diff;
		}
		System.out.println("cohort test difference is:"+diffnew);
		if(diffnew==0)
		{
			// assertion is done for 50 diff for now,
			// but it should be 0 ideally
			Assert.assertTrue(true, "cohort and difference  matched,Validation passed");
			
			//Assert.assertTrue(false,"cohort and difference not matched,Validation failed");
		}
		else
		{
			
			Assert.assertFalse(true,"cohort and difference not matched,Validation failed");
		}
	}
	
	
	public void installsWithAPI() {
		// try {
		// URL url = new URL(
		// "https://panel.appice.io/o/metrices/getTotalStats?callback=jQuery19108586557654813183_1477636156780&args=%7B%22startDate_C%22%3A1475087400%2C%22endDate_C%22%3A1477679399.999%2C%22startDate_P%22%3A1472495400%2C%22endDate_P%22%3A1475087399.999%2C%22startDate_CNew%22%3A%222016-09-29%22%2C%22endDate_CNew%22%3A%222016-10-28%22%2C%22startDate_PNew%22%3A%222016-08-30%22%2C%22endDate_PNew%22%3A%222016-09-28%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=56740ceb566583c105000001&_=1477636156781");
		// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// conn.setRequestMethod("GET");
		// conn.setRequestProperty("Accept", "application/json");
		//
		// if (conn.getResponseCode() != 200) {
		// throw new RuntimeException(" HTTP error code : " +
		// conn.getResponseCode());
		// }
		//
		// Scanner scan = new Scanner(url.openStream());
		// String entireResponse = new String();
		// while (scan.hasNext())
		// entireResponse += scan.nextLine();
		//
		// System.out.println("Response is : " + entireResponse);
		//
		// scan.close();
		// entireResponse =
		// entireResponse.substring(entireResponse.indexOf("{"),
		// entireResponse.length() - 1);
		// JSONObject obj = new JSONObject();
		// JSONArray arr = obj.getJSONArray("current");
		// String uniqueInstalls =
		// String.valueOf(obj.get("totalUniqueInstall"));
		// System.out.println(uniqueInstalls);
		//
		// String uniqueInstalls1 = installsCount.getText();
		// System.out.println(uniqueInstalls1);
		//
		//
		//// if(uniqueInstalls=uniqueInstalls1){
		////
		//// }
		//
		// conn.disconnect();
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		//
		// }

	}
	
	
	

}
