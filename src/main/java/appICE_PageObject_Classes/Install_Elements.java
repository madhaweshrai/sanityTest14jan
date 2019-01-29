package appICE_PageObject_Classes;

/**
 * 
 */



/**
 * @author 81792
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import appICE_ClarificationPoint.HighCharts;
import au.com.bytecode.opencsv.CSVReader;
import utils.ActionsClass;
import utils.JavaScriptApiWait;
import utils.JavaScriptPageLoading;
import utils.SelectClass;

public class Install_Elements {

	int totalCount;
	Dashboard_Elements de;
	HighChartsnew hc;
	HighChart1 hcnew;
	List<String> tableHeader = new ArrayList<>();
	HashMap<String, List<String>> tableDataMap = new HashMap<>();

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
	@FindBy(xpath = (".//*[@id='lblNewInstalls']/span"))
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

/*	@FindBy(xpath = (".//*[@id='tblAudience']/tbody/tr[1]/td[text()='who_segment'][last()]/following-sibling::td[5]"))
	private static WebElement clickingOnBack;*/
	
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
	@FindBy(xpath = (".//*[@id='ng-app']/body/div[7]/div[3]/ul/li[1]"))
	private  WebElement todayinstalls;

	@FindBy(xpath = ("//*[@id='ng-app']/body/div[7]/div[3]/ul/li[2]"))
	private  WebElement yesterdayinstalls;
	
	// old xpath *[@id='ng-app']/body/div[6]/div[3]/ul/li[2]
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
	@FindBy(xpath = (".//*[@id='lnkMoreSources']"))
	private WebElement more;
	
	private WebDriver _webDriver = null;
	private WebElement chart= null;

	public Install_Elements(WebDriver driver) {
		super();
		_webDriver = driver;
		PageFactory.initElements(driver, this);
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

	public void addTableDataToMap(String tableName) {
		// Fetch dynamic columns count
		WebElement colEle = _webDriver.findElement(By.xpath("//*[@id='" + tableName + "']/thead/tr[1]"));
		int columns = colEle.findElements(By.tagName("th")).size();

		// Read Header contents
		for (int i = 1; i <= columns; i++) {
			String xpath = "//*[@id='" + tableName + "']/thead/tr[1]/th[" + i + "]";
			WebElement row = _webDriver.findElement(By.xpath(xpath));
			tableHeader.add(row.getText());
		}

		// Fetch dynamic rows count
		WebElement rowEle = _webDriver.findElement(By.xpath("//*[@id='" + tableName + "']/tbody"));
		List<WebElement> rowsList = rowEle.findElements(By.tagName("tr"));
		int rows = 0;
		for (WebElement webElement : rowsList) {
			if (webElement.findElements(By.tagName("td")).size() > 1)
				rows++;
		}

		// Read Rows contents
		for (int i = 1; i <= rows; i++) {
			String firstCol = "";
			List<String> subCols = new ArrayList<>();
			for (int j = 1; j <= columns; j++) {
				String xpath = "//*[@id='" + tableName + "']/tbody/tr[" + i + "]/td[" + j + "]";
				WebElement row = _webDriver.findElement(By.xpath(xpath));
				if (row != null) {
					// Store table contents
					if (j == 1) {
						firstCol = row.getText();
						if (firstCol.equalsIgnoreCase("organic"))
								firstCol = "self";
						firstCol = firstCol.toLowerCase();
					} else {
						
						// by me if column data is null break the loop 
					      
					      if(row.getText()!=null && row.getText().length()>0)
					      {
					       
					      subCols.add(row.getText());
					      
					      }
					}
				}
			}
			tableDataMap.put(firstCol, subCols);
		}

		System.out.println("Table data for : " + tableName + " , " + tableDataMap);
	}

	public void today_click() throws InterruptedException
	{
		

		
		acquisition.click();
		installs.click();
		Thread.sleep(1000);
		datePeriodClick.click();
		
		todayinstalls.click();
		Thread.sleep(2000);
	}
	public void yesterday_click() throws InterruptedException
	{
		
		acquisition.click();
		installs.click();
		Thread.sleep(1000);
		datePeriodClick.click();
		
		yesterdayinstalls.click();
		Thread.sleep(2000);
	}
	
	public void Today_installs() throws InterruptedException
	{
		Thread.sleep(2000);
		datePeriodClick.click();
		Thread.sleep(1000);
		todayinstalls.click();
		Thread.sleep(2000);
		
		//de= new Dashboard_Elements(_webDriver);
		//   Getting Dashboard organic installed count
		String strins = dashboardinstalls.getText();
		// Getting dashboard campaign count
		//code not available
		int value = Integer.parseInt(strins.substring(strins.indexOf("(") + 1, strins.length() - 1));
		System.out.println("Exp value is " + value);
		
	/*	acquisition.click();
		installs.click();
		Thread.sleep(1000);
		datePeriodClick.click();
		
		todayinstalls.click();
		Thread.sleep(2000);*/
		Thread.sleep(1000);
		viewdetail.click();
		
		Thread.sleep(1000);
		datePeriodClick.click();
		Thread.sleep(1000);
		todayinstalls.click();
		Thread.sleep(2000);
		int organicValue;
		// String str = total.getText();
		// totalCount = Integer.parseInt(str);
		JavaScriptApiWait.waitForApiLoad();
		organicValDraogn.click();
		String str = organicValDraogn.getText();
		// System.out.println(str);
		organicValue = Integer.parseInt(str);

		System.out.println("Actual value is " + organicValue);

	
	
		// asserting values
		 Assert.assertEquals(value, organicValue, "Expected install counts");
		// App dashboard didn't matched with Actual "+ "install page");
		System.out.println("validation check1 done successfully");

	}
	
	//New UI code
	public void NewToday_installs() throws Exception
	{
		Thread.sleep(2000);
		_webDriver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
	     campaign.click();
		String installs=	dashbrdinstalls.getText();
		int Dashbordtotalinstalls = Integer.parseInt(installs);
		System.out.println("Total installs for this app " + Dashbordtotalinstalls);
		viewdetail.click();
		datePeriodClick.click();
		Thread.sleep(1000);
		todayinstalls.click();
		Thread.sleep(2000);
		de= new Dashboard_Elements(_webDriver);
		
	
		  _webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		  String strins = organictotal.getText();
			// Getting organicCount  count
			
			int organicCount = Integer.parseInt(strins);
			System.out.println("organic count is " + organicCount);
			
			 String strin2 = camp1total.getText();
			// Getting   count campaign
				int camp = Integer.parseInt(strin2);
				System.out.println("Taskbugs count is " + camp);
				int dashbrdcount= organicCount+camp;
				System.out.println("organic and campaign total is " + dashbrdcount);
				if(Dashbordtotalinstalls==dashbrdcount)
				{
				 Assert.assertTrue(true, "Dashboard count validation passed");
				}
				
					//readdbrdcsv();
				
			     	Downloadinstallcsv();
			     	addTableDataToMap("tblSourceData");
					csv_validation_InstallTable();
		
	}
	
	
	// yesterday validation
	
	public void Yesterday_installs() throws InterruptedException
	{
		Thread.sleep(2000);
		datePeriodClick.click();
		Thread.sleep(1000);
		yesterdayinstalls.click();
		Thread.sleep(2000);
		de= new Dashboard_Elements(_webDriver);
		//   Getting Dashboard organic installed count
		String strins = dashboardinstalls.getText();
		// Getting dashboard campaign count
		//code not available
		int value = Integer.parseInt(strins.substring(strins.indexOf("(") + 1, strins.length() - 1));
		System.out.println("Exp value is " + value);
		
		/*acquisition.click();
		installs.click();
		Thread.sleep(1000);
		datePeriodClick.click();
		
		yesterdayinstalls.click();
		Thread.sleep(2000);*/
		

          Thread.sleep(1000);
            viewdetail.click();

              Thread.sleep(1000);
              datePeriodClick.click();
                  Thread.sleep(1000);
                  yesterdayinstalls.click();
                    Thread.sleep(2000);
		//de.customDateIns(cusdate);
		// entireTable.click();

		// *[@id='tblSourceData']/tbody
		int organicValue;
		// String str = total.getText();
		// totalCount = Integer.parseInt(str);
		JavaScriptApiWait.waitForApiLoad();
		organicValDraogn.click();
		String str = organicValDraogn.getText();
		// System.out.println(str);
		organicValue = Integer.parseInt(str);

		System.out.println("Actual value is " + organicValue);

		// asserting values
		 Assert.assertEquals(value, organicValue, "Expected install counts");
		// App dashboard didn't matched with Actual "+ "install page");
		System.out.println("validation check1 done successfully");

		// Download Install csv and verify total installs

		// utils.Alert.switchToAlert();
		// source-wise
		
	}
	
	public void readdbrdcsv() throws Exception
	{
		
		try {
  			File file1 = new File("C:\\Users\\81792\\Downloads\\source-wise.csv");
  			//C:\Users\81792\Downloads
  			
  			if (file1.exists()  ) {
  				 file1.delete();
  				
  				// file1.renameTo(file2);
  			}
  			}
  		 catch (Exception e) {
  			e.printStackTrace();

                   }
		
		String csvFilename1 = "C:\\Users\\81792\\Downloads\\cty-wise.csv";
		List<String> list= new ArrayList<>();
		    list.add(csvFilename1);
		 
		    System.out.println(list);
		   // return list;
		installcsv.click();
		Thread.sleep(2000);
		String csvFilename = "C:\\Users\\81792\\Downloads\\source-wise.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		
		//List<String> csvHeaders = new ArrayList<String>();
		//boolean headerFetchedFlag = false;
		
		String[] currentRow = null;
		while ((currentRow = csvReader.readNext()) != null) {
			
				System.out.println("CSV data : " + Arrays.toString(currentRow));
				System.out.println("Install Dashboard csv Downloaded and Data Printed");
		}
	}
	
	
	//New UI code
	public void NewYesterday_installs() throws Exception
	{
		 System.out.println("entered");
		 Thread.sleep(2000);
		//_webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		datePeriodClick.click();
		Thread.sleep(2000);
		//_webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		yesterdayinstalls.click();
		Thread.sleep(2000);
		//de= new Dashboard_Elements(_webDriver);
		//fetching Highchart data
    // hc= new HighChartsnew(_webDriver);
     //hc.organicCount();
   //  hcnew = new HighChart1(_webDriver,chart);
      System.out.println("step1");
     _webDriver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
     campaign.click();
     System.out.println("step2 click campaign");
     _webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	//System.out.println("done");
	String installs=	dashbrdinstalls.getText();
	System.out.println("step3,dashboard count get");
	int Dashbordtotalinstalls = Integer.parseInt(installs);
	System.out.println("Total installs for this app " + Dashbordtotalinstalls);
	viewdetail.click();
	System.out.println("step4, view click");
	Thread.sleep(2000);
	datePeriodClick.click();
	Thread.sleep(1000);
	yesterdayinstalls.click();
	Thread.sleep(2000);
	  _webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	  String strins = organictotal.getText();
	  System.out.println("step5, got org value");
		// Getting organicCount  count
		
		int organicCount = Integer.parseInt(strins);
		System.out.println("organic count is " + organicCount);
		
		/* String strin2 = camp1total.getText();
		// Getting   count campaign
			int camp = Integer.parseInt(strin2);
			System.out.println("Taskbugs count is " + camp);
			int dashbrdcount= organicCount+camp;
			System.out.println("organic and campaign total is " + dashbrdcount);*/
			if(Dashbordtotalinstalls>=organicCount)
			{
			 Assert.assertTrue(true, "Dashboard count validation passed");
			 System.out.println("done");
			}
			
				//readdbrdcsv();
			/*_webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		     	Downloadinstallcsv();
		     	addTableDataToMap("tblSourceData");
				csv_validation_InstallTable();*/
		
	}
	
	
	public void App_Installs_allapp(String cusdate) throws Exception {
		de= new Dashboard_Elements(_webDriver);
		//selecting custum date
		   de.customDateIns(cusdate);

			de= new Dashboard_Elements(_webDriver);
			//   Getting Dashboard organic installed count
			String strins = dashboardinstalls.getText();
			int dashboardinstalls1 = Integer.parseInt(strins);
			// Getting dashboard campaign count
			//code not available
			//int value = Integer.parseInt(strins.substring(strins.indexOf("(") + 1, strins.length() - 1));
			System.out.println("Dashboard total count is " + dashboardinstalls1);
			

	          Thread.sleep(1000);
	            viewdetail.click();

	              Thread.sleep(1000);
	              de.customDateIns(cusdate);
	                    Thread.sleep(2000);
			//de.customDateIns(cusdate);
			// entireTable.click();

			// *[@id='tblSourceData']/tbody
			int organicValue;
			// String str = total.getText();
			// totalCount = Integer.parseInt(str);
			JavaScriptApiWait.waitForApiLoad();
			organicValDraogn.click();
			String str = organicValDraogn.getText();
			// System.out.println(str);
			organicValue = Integer.parseInt(str);

			System.out.println("Actual value is " + organicValue);

		/*	// asserting values
			if(dashboardinstalls1>=organicValue)
			{
			 Assert.assertTrue(true, "Dashboard count validation passed");
			 System.out.println("done");
			}
			// App dashboard didn't matched with Actual "+ "install page");
			System.out.println("validation check1 done successfully");*/
		
	
	}
	
	//New UI code
	public void NewApp_Installs_allapp(String cusdate) throws Exception
	{
		Thread.sleep(2000);
		datePeriodClick.click();
		Thread.sleep(1000);
		de.customDateIns(cusdate);
		//yesterdayinstalls.click();
		Thread.sleep(2000);
		de= new Dashboard_Elements(_webDriver);
		
		readdbrdcsv();
	
		
	}
	
	
      public List Downloadcsv() throws Exception
          {
    	  try {
  			File file1 = new File("C:\\Users\\81792\\Downloads\\source-wise.csv");
  			File file2 = new File("C:\\Users\\81792\\Downloads\\os-version-wise.csv");
  			File file3 = new File("C:\\Users\\81792\\Downloads\\cty-wise.csv");
  			
  			if (file1.exists() || file1.exists() || file1.exists() ) {
  				 file1.delete();
  				 file2.delete();
  				 file3.delete();
  				// file1.renameTo(file2);
  			}
  			}
  		 catch (Exception e) {
  			e.printStackTrace();

                   }
    	  Insdownload.click();
			Thread.sleep(1000);
			OsDownload.click();
			Thread.sleep(1000);
			LocDownload.click();
			Thread.sleep(1000);
			String csvFilename1 = "C:\\Users\\81792\\Downloads\\source-wise.csv";
			String csvFilename2 = "C:\\Users\\81792\\Downloads\\os-version-wise.csv";
			String csvFilename3 = "C:\\Users\\81792\\Downloads\\cty-wise.csv";
			List<String> list= new ArrayList<>();
			    list.add(csvFilename1);
			    list.add(csvFilename2);
			    list.add(csvFilename3);
			    System.out.println(list);
			    return list;
			   
    	  
          }
      // Download install csv
      public List Downloadinstallcsv() throws Exception
      {
	  try {
			File file1 = new File("C:\\Users\\81792\\Downloads\\source-wise.csv");
			
			
			if (file1.exists() || file1.exists() || file1.exists() ) {
				 file1.delete();
				 
				// file1.renameTo(file2);
			}
			}
		 catch (Exception e) {
			e.printStackTrace();

               }
	  Insdownload.click();
		Thread.sleep(1000);
		
		String csvFilename1 = "C:\\Users\\81792\\Downloads\\source-wise.csv";
		
		List<String> list= new ArrayList<>();
		    list.add(csvFilename1);
		    
		    System.out.println(list);
		    return list;
		   
	  
      }
      
      
      //methid ends herer
      
      
	public void csv_validation_InstallTable() throws Exception {
			
		boolean isAllDataMatched = false;

		// running code for printing all csv data
		String csvFilename = "C:\\Users\\81792\\Downloads\\source-wise.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		
		List<String> csvHeaders = new ArrayList<String>();
		boolean headerFetchedFlag = false;
		
		String[] currentRow = null;
		while ((currentRow = csvReader.readNext()) != null) {
			// Store header names for further usage
			if (!headerFetchedFlag) {
				for (String string : currentRow) {
					csvHeaders.add(string);
				}
				headerFetchedFlag = true;
				continue;
			}

			// Check from appInstallMap size if all matched then its zero
			if (tableDataMap.size() <= 0) {
				isAllDataMatched = true;
				break;
			}

			// Confirm source name exists in display hashmap object
			String csvRow = currentRow[0].toLowerCase();
			if (tableDataMap.containsKey(csvRow)) {
				System.out.println("CSV data : " + Arrays.toString(currentRow));
				
				boolean sourceDataMatched = false;
				
				// Compare install data points with hashmap object
				List<String> sourceData = tableDataMap.get(csvRow);
				if (sourceData != null && sourceData.size() > 0) {
					int matchCount = 0;
					for (int i = 1; i<currentRow.length; i++) {
						String string = currentRow[i];
						try {
							float val1 = Float.parseFloat(string);
							float val2 = Float.parseFloat(sourceData.get(i-1));
							if (val1 == val2)
								matchCount++;
						} catch (Exception e1) {
							e1.printStackTrace();
							
							try {
								int val1 = Integer.parseInt(string);
								int val2 = Integer.parseInt(sourceData.get(i-1));
								if (val1 == val2)
									matchCount++;
							} catch (Exception e2) {
								e2.printStackTrace();
								
								String val2 = sourceData.get(i-1);
								if (string.equals(val2))
									matchCount++;
							}
						}
					}
					
					if (sourceData.size() == matchCount) {
						sourceDataMatched = true;
					}
					else {
						System.out.println("Not matched vals : " + Arrays.toString(currentRow) + ", " + sourceData);
					}
				}
				if (sourceDataMatched) {
					// Remove object from hashmap to confirm data is same in
					// display and csv
					tableDataMap.remove(currentRow[0]);
				}
			}
		}

		csvReader.close();
		
		if (tableDataMap.size() <= 0) {
			isAllDataMatched = true;
		}

		if (isAllDataMatched)
			Assert.assertTrue(true,
					"All sources matched and all data confirmed that are matching in both csv and display");

		else
			Assert.assertFalse(true, "AppInstall data matching failed mismatched data : " + tableDataMap);

	}

	public void csv_validation_OSTable() throws Exception {
		/*try {
			File file1 = new File("C:\\Users\\81792\\Downloads\\os-version-wise.csv");
			if (file1.exists()) {
				 file1.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Click on CSV download button
		OsDownload.click();
		Thread.sleep(1000);*/

		
		boolean isAllDataMatched = false;

		// running code for printing all csv data
		String csvFilename = "C:\\Users\\81792\\Downloads\\os-version-wise.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		
		List<String> csvHeaders = new ArrayList<String>();
		boolean headerFetchedFlag = false;
		
		String[] currentRow = null;
		while ((currentRow = csvReader.readNext()) != null) {
			// Store header names for further usage
			if (!headerFetchedFlag) {
				for (String string : currentRow) {
					csvHeaders.add(string.toLowerCase());
				}
				headerFetchedFlag = true;
				continue;
			}

			// Check from appInstallMap size if all matched then its zero
			if (tableDataMap.size() <= 0) {
				isAllDataMatched = true;
				break;
			}
			String csvFirstEle = currentRow[0].toLowerCase();
			// Confirm source name exists in display hashmap object
			if (tableDataMap.containsKey(csvFirstEle)) {
				System.out.println("CSV data : " + csvFirstEle );
				// Arrays.toString(currentRow)
				boolean sourceDataMatched = false;
				
				// Compare install data points with hashmap object
				List<String> sourceData = tableDataMap.get(csvFirstEle);
				if (sourceData != null && sourceData.size() > 0) {
					int matchCount = 0;
					for (int i = 1; i<currentRow.length; i++) {
						String string = currentRow[i];
						try {
							float val1 = Float.parseFloat(string);
							float val2 = Float.parseFloat(sourceData.get(i-1));
							if (val1 == val2)
								matchCount++;
						} catch (Exception e1) {
							e1.printStackTrace();
							
							try {
								int val1 = Integer.parseInt(string);
								int val2 = Integer.parseInt(sourceData.get(i-1));
								if (val1 == val2)
									matchCount++;
							} catch (Exception e2) {
								e2.printStackTrace();
								
								String val2 = sourceData.get(i-1);
								if (string.equals(val2))
									matchCount++;
							}
						}
					}
					
					if (sourceData.size() == matchCount) {
						sourceDataMatched = true;
					}
					else {
						System.out.println("Not matched vals : " + Arrays.toString(currentRow) + ", " + sourceData);
					}
				}
				if (sourceDataMatched) {
					// Remove object from hashmap to confirm data is same in
					// display and csv
					tableDataMap.remove(csvFirstEle);
				}
			}
		}

		csvReader.close();
		
		if (tableDataMap.size() <= 0) {
			isAllDataMatched = true;
		}

		if (isAllDataMatched)
			Assert.assertTrue(true,
					"All sources matched and all data confirmed that are matching in both csv and display");

		else
			Assert.assertFalse(true, "AppInstall data matching failed mismatched data : " + tableDataMap);
	}

	public void csv_validation_LocationTable() throws Exception {
		// Check for exsisting csv fie if exists delete it
				/*try {
					File file1 = new File("C:\\Users\\81792\\Downloads\\cty.csv");
					if (file1.exists()) {
						 file1.delete();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// Click on CSV download button
				LocDownload.click();
				Thread.sleep(1000);
*/
				
				boolean isAllDataMatched = false;

				// running code for printing all csv data
				String csvFilename = "C:\\Users\\81792\\Downloads\\cty-wise.csv";
				
				CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
				
				List<String> csvHeaders = new ArrayList<String>();
				boolean headerFetchedFlag = false;
				
				String[] currentRow = null;
				while ((currentRow = csvReader.readNext()) != null) {
					// Store header names for further usage
					if (!headerFetchedFlag) {
						for (String string : currentRow) {
							csvHeaders.add(string);
						}
						headerFetchedFlag = true;
						continue;
					}

					// Check from appInstallMap size if all matched then its zero
					if (tableDataMap.size() <= 0) {
						isAllDataMatched = true;
						break;
					}

					String csvFirstEle = currentRow[0].toLowerCase();
					// Confirm source name exists in display hashmap object
					if (tableDataMap.containsKey(csvFirstEle)) {
						System.out.println("CSV data : " + csvFirstEle);
						
						boolean sourceDataMatched = false;
						
						// Compare install data points with hashmap object
						List<String> sourceData = tableDataMap.get(csvFirstEle);
						if (sourceData != null && sourceData.size() > 0) {
							int matchCount = 0;
							for (int i = 1; i<currentRow.length; i++) {
								String string = currentRow[i];
								try {
									float val1 = Float.parseFloat(string);
									float val2 = Float.parseFloat(sourceData.get(i-1));
									if (val1 == val2)
										matchCount++;
								} catch (Exception e1) {
									e1.printStackTrace();
									
									try {
										int val1 = Integer.parseInt(string);
										int val2 = Integer.parseInt(sourceData.get(i-1));
										if (val1 == val2)
											matchCount++;
									} catch (Exception e2) {
										e2.printStackTrace();
										
										String val2 = sourceData.get(i-1);
										if (string.equals(val2))
											matchCount++;
									}
								}
							}
							
							if (sourceData.size() == matchCount) {
								sourceDataMatched = true;
							}
							else {
								System.out.println("Not matched vals : " + Arrays.toString(currentRow) + ", " + sourceData);
							}
						}
						if (sourceDataMatched) {
							// Remove object from hashmap to confirm data is same in
							// display and csv
							tableDataMap.remove(csvFirstEle);
						}
					}
				}

				csvReader.close();
				
				if (tableDataMap.size() <= 0) {
					isAllDataMatched = true;
				}

				if (isAllDataMatched)
					Assert.assertTrue(true,
							"All sources matched and all data confirmed that are matching in both csv and display");

				else
					Assert.assertFalse(true, "AppInstall data matching failed mismatched data : " + tableDataMap);
	}
	
	public void getalldata()
	{
		
		viewdetail.click();
		System.out.println("step4, view click");
		_webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		datePeriodClick.click();
        _webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		yesterdayinstalls.click();
        _webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        WebElement table_element= _webDriver.findElement(By.id("tblSourceData"));
         // table.click();
          _webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
          List<WebElement> tr_collection=table_element.findElements(By.xpath(".//*[@id='tblSourceData']/tbody/tr/td[1]"));
          WebElement colEle = _webDriver.findElement(By.xpath("//*[@id='tblSourceData']/thead/tr[1]"));
          System.out.println("Got TR"+ colEle);
          System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
          int row_num,col_num;
          row_num=1;
          for(WebElement trElement : tr_collection)
          {
              List<WebElement> td_collection=trElement.findElements(By.xpath(".//*[@id='tblSourceData']/tbody/tr[1]/td"));
              System.out.println("NUMBER OF COLUMNS="+td_collection.size());
              col_num=1;
              for(WebElement tdElement : td_collection)
              {
                  System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
                  col_num++;
              }
              row_num++;
          } 
        		
		
	}
}
