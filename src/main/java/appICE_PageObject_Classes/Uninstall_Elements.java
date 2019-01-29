package appICE_PageObject_Classes;



/**
 * @author 81792
 *
 */

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import au.com.bytecode.opencsv.CSVReader;
import utils.ActionsClass;
import utils.JavaScriptApiWait;
import utils.JavaScriptPageLoading;
import utils.SelectClass;

public class Uninstall_Elements {

	int totalCount;
	Dashboard_Elements de;
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
	@FindBy(xpath = ("//span[text()='Uninstalls']"))
	private WebElement uninstalls;

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
	private WebElement unInsdownload;
	// Dashboard total installs
	// @FindBy(xpath = ("//*[@id='tblSources']/tbody/tr[1]/td[2]"))
	@FindBy(xpath = ("//*[@id='tblSources']/tbody/tr/td[text()='Organic']/preceding-sibling::td[2]"))
	private WebElement dashboardinstalls;
	
	@FindBy(xpath = ("//*[@id='tblSources']/tbody/tr/td[text()='Organic']/following-sibling::td[2]"))
	private WebElement dashboardinstalls2;
	
	

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
	@FindBy(xpath = ("//*[@id='topappversions-downloadLink']"))
	private static WebElement Appversion;
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

	private WebDriver _webDriver = null;

	public Uninstall_Elements(WebDriver driver) {
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

	public void App_uninstalls_allapp(String cusdate) throws Exception {
		   de= new Dashboard_Elements(_webDriver);

		   de.customDateIns(cusdate);
		String strins = dashboardinstalls.getText();
		int value = Integer.parseInt(strins.substring(strins.indexOf("(") + 1, strins.length() - 1));
		System.out.println("Exp value is " + value);
		uninstalls.click();
		
		   de.customDateIns(cusdate);
		// entireTable.click();

		// *[@id='tblSourceData']/tbody
		int organicValue;
		// String str = total.getText();
		// totalCount = Integer.parseInt(str);
		JavaScriptApiWait.waitForApiLoad();
	//	organicValDraogn.click();
		String str = dashboardinstalls2.getText();
		int value2 = Integer.parseInt(strins.substring(strins.indexOf("(") + 1, strins.length() - 1));
		// System.out.println(value2);
		//organicValue = Integer.parseInt(str);

		System.out.println("Actual value is " + value2);

		// Fetch App Install table data and store it to local hashmap for later
		// comparison against csv data
		// System.out.println(entireTabletr1.getText());

		// providing table name for fetching table values
		

		// asserting values
		 Assert.assertEquals(value, value2, "Expected install counts");
		// App dashboard didn't matched with Actual "+ "install page");
		System.out.println("validation check1 done successfully");

		// Download Install csv and verify total installs

		// utils.Alert.switchToAlert();
		// source-wise

	}
      public List Downloadcsv() throws Exception
          {
    	  try {
  			File file1 = new File("C:\\Users\\81792\\Downloads\\source-wise.csv");
  			File file2 = new File("C:\\Users\\81792\\Downloads\\app-version-wise.csv");
  			File file3 = new File("C:\\Users\\81792\\Downloads\\cty-wise.csv");
  			
  			if (file1.exists() || file1.exists() || file1.exists() ) {
  				 file1.delete();
  				 file2.delete();
  				 file3.delete();
  			}
  			}
  		 catch (Exception e) {
  			e.printStackTrace();

                   }
    	  unInsdownload.click();
			Thread.sleep(1000);
			Appversion.click();
			Thread.sleep(1000);
			LocDownload.click();
			Thread.sleep(1000);
			String csvFilename1 = "C:\\Users\\81792\\Downloads\\source-wise.csv";
			String csvFilename2 = "C:\\Users\\81792\\Downloads\\app-version-wise.csv";
			String csvFilename3 = "C:\\Users\\81792\\Downloads\\cty-wise.csv";
			List<String> list= new ArrayList<>();
			    list.add(csvFilename1);
			    list.add(csvFilename2);
			    list.add(csvFilename3);
			    System.out.println(list);
			    return list;
			   
    	  
          }
      
      
      
	public void UnInstallcsv_validation() throws Exception {
			
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

	public void AppVersioncsv_validation() throws Exception {
		
		
		boolean isAllDataMatched = false;

		// running code for printing all csv data
		String csvFilename = "C:\\Users\\81792\\Downloads\\app-version-wise.csv";
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

	public void Locationcsv_validation() throws Exception {
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
}
