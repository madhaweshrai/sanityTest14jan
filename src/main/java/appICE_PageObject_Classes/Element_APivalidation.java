package appICE_PageObject_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import baseClasses.ApiMultiBrowsers;

public class Element_APivalidation extends ApiMultiBrowsers {
	private WebDriver _webDriver = null;
	@FindBy(xpath = (".//*[@id='urlvalue']"))
	private WebElement enterurl;
	
	@FindBy(xpath = (".//*[@id='submitajax']"))
	private WebElement submitAjax;
	
	@FindBy(xpath = (".//*[@id='statuspre']"))
	private WebElement response;
	
	
	public Element_APivalidation(WebDriver driver) {
		super();
		_webDriver = driver;
		PageFactory.initElements(driver, this);
	}


	public void Dashboard_Engagementnactiveusers () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
	Thread.sleep(2000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	
	//cohort
	
	public void Dashboard_cohort () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	//Install uninstall sourcewise
	public void Dashboard_instUnintsrcwise () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getTotalStats?callback=jQuery1910441753701947204_1516784448829&args=%7B%22startDate_C%22%3A1514226600%2C%22endDate_C%22%3A1516818599.999%2C%22startDate_P%22%3A1511634600%2C%22endDate_P%22%3A1514226599.999%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448830");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	//users at risk
	
	public void Dashboard_usersatrisk () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getUsersAtRisk?callback=jQuery1910441753701947204_1516784448831&args=%7B%22startDate_C%22%3A1514226600%2C%22endDate_C%22%3A1516818599.999%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448832");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	// Demographics user interest
	
	public void demographics_userinterest () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserInterests?callback=jQuery191016034854934085319_1516785107370&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516785107371");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
//Demographics Active users and Gender wise split
	
	public void demographics_activeusersngws () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserDemographics?callback=jQuery191016034854934085319_1516785107372&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516785107373");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	//Demographics user competing apps
	
	public void demographics_usercompetingapps () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserCompetingAppStats?callback=jQuery191016034854934085319_1516785107372&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516785107374");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	//App installs os/loc/day split wise
	public void appinstalls_oslocdaysplitewise () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getInstallUnistallStatsByParam?callback=jQuery19109153550285108891_1516785302874&args=%7B%22startDate_C%22%3A1514226600%2C%22endDate_C%22%3A1516818599.999%2C%22startDate_P%22%3A1511634600%2C%22endDate_P%22%3A1514226599.999%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%2C%22type%22%3A%22I%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516785302875");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	//App install source
	public void appinstalls_installsource () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getInstallUnistallStatsBySource?callback=jQuery19109153550285108891_1516785302872&args=%7B%22startDate_C%22%3A1514226600%2C%22endDate_C%22%3A1516818599.999%2C%22startDate_P%22%3A1511634600%2C%22endDate_P%22%3A1514226599.999%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%2C%22type%22%3A%22I%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516785302876");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	//Activity users - Active users/ Avg session lenght
	public void usases_activeusersavgssnlength () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserSessionStats?api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&args=%7B%22startDate_C%22:1514226600,%22endDate_C%22:1516818599.999,%22startDate_P%22:1511634600,%22endDate_P%22:1514226599.999,%22startDate_CNew%22:%222017-12-26%22,%22endDate_CNew%22:%222018-01-24%22,%22startDate_PNew%22:%222017-11-26%22,%22endDate_PNew%22:%222017-12-25%22%7D&platfrom=all");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	//session
	public void usase_session () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&args=%7B%22startDate_C%22:1514246400,%22endDate_C%22:1516838399,%22startDate_P%22:1511654400,%22endDate_P%22:1514246399,%22startDate_CNew%22:%222017-12-26%22,%22endDate_CNew%22:%222018-01-24%22,%22startDate_PNew%22:%222017-11-26%22,%22endDate_PNew%22:%222017-12-25%22%7D");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	//Event- Event list
	
	public void Event_eventlist () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getEventList?api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&d=1516786800044");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	//Event stats
	public void Event_eventstats () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getEventsStats?api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&args=%7B%22startDate%22:1514226600,%22endDate%22:1516818599.999,%22startDateNew%22:%222017-12-26%22,%22endDateNew%22:%222018-01-24%22%7D");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	//Event segment attribute
	public void eventsegattribute () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getEventAttributeStats?api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&args=%7B%22startDate%22:1514226600,%22endDate%22:1516818599.999,%22startDateNew%22:%222017-12-26%22,%22endDateNew%22:%222018-01-24%22,%22eventName%22:%22FM_Tuned%22,%22attributeName%22:%22Station%22%7D&d=1516786923782");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	//Funnels
	public void getfunnel () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/funnels/getEventFunnels?api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&d=1516786973148");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	//uninstalls-OS/Location/Day Wise/Time Wise
	public void uninstalls_regainedusers () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getRegainedUsers?callback=jQuery191043920970335252973_1516787154186&args=%7B%22startDate_C%22%3A1514226600%2C%22endDate_C%22%3A1516818599.999%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516787154187");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	//Source wise uninstall
	public void uninstalls_oslocdtwise () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getInstallUnistallStatsByParam?callback=jQuery191043920970335252973_1516787154184&args=%7B%22startDate_C%22%3A1514226600%2C%22endDate_C%22%3A1516818599.999%2C%22startDate_P%22%3A1511634600%2C%22endDate_P%22%3A1514226599.999%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%2C%22type%22%3A%22U%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516787154185");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	//Re-gained Users
	public void uninstalls_srcwiseuninstalls () throws Exception
	{
		_webDriver.get("https://resttesttest.com/");
		//enterutl.sendkeys("https://panel.appice.io/o/metrices/getCohortDataForInstalls?callback=jQuery1910441753701947204_1516784448824&args=%7B%22startDate%22%3A1514745000%2C%22endDate%22%3A1516818599.999%2C%22startDateNew%22%3A%222018-01-01%22%2C%22endDateNew%22%3A%222018-01-24%22%2C%22periodtype%22%3A%22m%22%2C%22metrices%22%3A%5B%7B%7D%5D%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448828");
		enterurl.clear();
		enterurl.sendKeys("https://panel.appice.io/o/metrices/getInstallUnistallStatsBySource?callback=jQuery191043920970335252973_1516787154182&args=%7B%22startDate_C%22%3A1514226600%2C%22endDate_C%22%3A1516818599.999%2C%22startDate_P%22%3A1511634600%2C%22endDate_P%22%3A1514226599.999%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%2C%22type%22%3A%22BOTH%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516787154188");
		//enterutl.sendKeys("https://panel.appice.io/o/metrices/getActiveUserTimelySessions?callback=jQuery1910441753701947204_1516784448826&args=%7B%22startDate_C%22%3A1514246400%2C%22endDate_C%22%3A1516838399%2C%22startDate_P%22%3A1511654400%2C%22endDate_P%22%3A1514246399%2C%22startDate_CNew%22%3A%222017-12-26%22%2C%22endDate_CNew%22%3A%222018-01-24%22%2C%22startDate_PNew%22%3A%222017-11-26%22%2C%22endDate_PNew%22%3A%222017-12-25%22%7D&api_key=d985715d1bb48942d36d5d08de3b6a8c&app_id=5a5dfef0d2651fac0b6e98bb&_=1516784448827");
		//Thread.sleep(2000);
		submitAjax.click();
		//WebElement element=wait.until(ExpectedConditions);
	Thread.sleep(3000);
		String str= response.getText();
		
		System.out.println(str);
		
		if(str.contains("200"))
		{
			System.out.println(" API validation passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			System.out.println(" API validation failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	
}
