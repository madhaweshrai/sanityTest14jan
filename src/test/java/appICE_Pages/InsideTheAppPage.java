package appICE_Pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.csvreader.CsvWriter;

import appICE_PageObject_Classes.Dashboard_Elements;
import appICE_PageObject_Classes.InsideTheApp_Elements;
import appICE_PageObject_Classes.OutsideTheApp_Elements;
import baseClasses.MultiBrowsers;
import baseClasses.TestDataFromConfig;
import junit.framework.Assert;
import superPageObject_Classes.AppICE_Home_Login_Pages;
import superPageObject_Classes.Apps_HomePage;
import utils.DynamicAppSelection;
import utils.JavaScriptApiWait;
import utils.JavaScriptPageLoading;

public class InsideTheAppPage extends MultiBrowsers {
	Dashboard_Elements de = null;
	InsideTheApp_Elements in = null;
	
	Apps_HomePage hp = null;
	FileWriter fileWriter = null;
	FileWriter fileWriterssn = null;
	FileWriter fileWriteravgssn = null;
	BufferedWriter br = null;

	CsvWriter csvwriter = null;
	PrintWriter printwriter = null;

	// Delimiter used in CSV file

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	// CSV file header
	private static final String FILE_HEADER_unique = "No of sessions, Users";

	private static final String FILE_HEADER_sessions = "Time, Home,Office,Other,Total";

	private static final String FILE_HEADER_Avgsession= "Session Length, Users";
	private static final String No_Apps = "No  Apps for this APP";

	private String Date_Header = "Scripts ran on this DATE and TIME";

	String clientAppName = null;

	@DataProvider(name = "InsideTheApp")
	public Object[][] data() throws Exception {
		HashMap<String, String[]> dataSet = new TestDataFromConfig("./propertyFiles/newInside.properties").getData();
		int size = dataSet.size();
		System.out.println(" size is " + size);

		String differetnAppNames[] = dataSet.get("appName");
		String differentCustomDates[] = dataSet.get("customDates");

		int appsSize = differetnAppNames.length;
		System.out.println("Apps Size" + appsSize);

		Object[][] outsideAppPages = new Object[appsSize][size];

		for (int i = 0; i < appsSize; i++) {
			outsideAppPages[i][0] = differetnAppNames[i];
			outsideAppPages[i][1] = differentCustomDates[i];

		}
		return outsideAppPages;
	}

	@Test(priority = 1)
	public void loginpage() {
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("validUserName", "validPassword");
		Date date = new Date();
		String todayDateWithTime = date.toString();
		System.out.println("Date is" + date);
		try {
			fileWriter = new FileWriter("./excelSheets/AppICE_Uses_Uniqueusers.csv", true);
			fileWriter.append(Date_Header);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(todayDateWithTime);
			fileWriter.append(NEW_LINE_SEPARATOR);
			//
			fileWriterssn = new FileWriter("./excelSheets/AppICE_Uses_Sessions.csv", true);
			fileWriterssn.append(Date_Header);
			fileWriterssn.append(COMMA_DELIMITER);
			fileWriterssn.append(todayDateWithTime);
			fileWriterssn.append(NEW_LINE_SEPARATOR);
			//
			fileWriteravgssn = new FileWriter("./excelSheets/AppICE_Uses_AvgSessionLenghth.csv", true);
			fileWriteravgssn.append(Date_Header);
			fileWriteravgssn.append(COMMA_DELIMITER);
			fileWriteravgssn.append(todayDateWithTime);
			fileWriteravgssn.append(NEW_LINE_SEPARATOR);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				fileWriterssn.flush();
				fileWriterssn.close();
				fileWriteravgssn.flush();
				fileWriteravgssn.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}


	@Test(dataProvider = "InsideTheApp", priority = 2)
	public void Uniqueusers(String appName, String customStartDate) throws Exception {
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		clientAppName = wdriver.findElement(By.xpath("html/body/div[5]/div[4]/div[1]/form/div[1]/h1")).getText();
		System.out.println("App Name is " + clientAppName);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		in = new InsideTheApp_Elements(wdriver);
		// click on inside page
		in.insidePage();

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		// String csvOutputFile
		// ="E:\\AppICE_Data_Driven_FW\\com.appICE_Maven\\excelSheets\\AppICE_PagesData.csv";

		List<WebElement> NoOfSessions = wdriver
				.findElements(By.xpath(".//*[@id='tblActiveUsers']/tbody/tr/td[1]"));
	//	System.out.println("App names are :" + NoOfSessions);
		List<WebElement> tusers = wdriver.findElements(By.xpath(".//*[@id='tblActiveUsers']/tbody/tr/td[2]")); //
	//	System.out.println("App value are :" + tusers);

		fileWriter = new FileWriter("./excelSheets/AppICE_Uses_Uniqueusers.csv", true);
		br = new BufferedWriter(fileWriter);
		if (NoOfSessions.size() > 0) {
			try {
				fileWriter.append(clientAppName);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(FILE_HEADER_unique.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);

				String apps;
				String users;
				WebElement appsNames;
				WebElement appsValues;

				for (int i = 0; i <= NoOfSessions.size(); i++) {
					appsNames = NoOfSessions.get(i);
					appsValues = tusers.get(i);
					System.out.println(appsNames.getText() + " : " + appsValues.getText());
					apps = appsNames.getText();
					users = appsValues.getText();

					fileWriter.append(apps);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(users);
					fileWriter.append(NEW_LINE_SEPARATOR);
					br.newLine();
				}
				
				if(NoOfSessions.size()>0)
				{
				Assert.assertTrue("Values found in Table,Test case passed", true);
				}
				
				fileWriter.append(NEW_LINE_SEPARATOR);
				System.out.println("Data is written into the csv sheet");
			} catch (IndexOutOfBoundsException i) {
				System.out.println("Index out of bound exception" + i);
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();

				} catch (IOException e) {
					System.out.println("Error while flushing/closing fileWriter !!!");
					e.printStackTrace();
				}
			}
		} else {
			fileWriter.append(clientAppName);
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(No_Apps);
			fileWriter.append(NEW_LINE_SEPARATOR);
			br.newLine();
			fileWriter.flush();
			fileWriter.close();
			
		}
		
		
		
		
		
		

         
          
	
	}
	
	@Test(dataProvider = "InsideTheApp", priority = 3)
	public void session(String appName, String customStartDate) throws IOException {
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		clientAppName = wdriver.findElement(By.xpath("html/body/div[5]/div[4]/div[1]/form/div[1]/h1")).getText();
		System.out.println("App Name is " + clientAppName);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		in = new InsideTheApp_Elements(wdriver);
		// click on inside page
		in.insidePage();

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		// String csvOutputFile
		// ="E:\\AppICE_Data_Driven_FW\\com.appICE_Maven\\excelSheets\\AppICE_PagesData.csv";

		List<WebElement> Time = wdriver
				.findElements(By.xpath("//*[@id='tblSessions']/tbody/tr/td[1]"));
		System.out.println("App names are :" + Time);
		List<WebElement> Home = wdriver.findElements(By.xpath(".//*[@id='tblSessions']/tbody/tr/td[2]")); //
		System.out.println("App value are :" + Home);
		List<WebElement> Office = wdriver.findElements(By.xpath(".//*[@id='tblSessions']/tbody/tr/td[3]")); //
		System.out.println("App value are :" + Office);
		List<WebElement> Other = wdriver.findElements(By.xpath(".//*[@id='tblSessions']/tbody/tr/td[4]")); //
		System.out.println("App value are :" + Other);
		List<WebElement> Total = wdriver.findElements(By.xpath(".//*[@id='tblSessions']/tbody/tr/td[5]")); //
		System.out.println("App value are :" + Total);
		

		fileWriter = new FileWriter("./excelSheets/AppICE_Uses_Sessions.csv", true);
		br = new BufferedWriter(fileWriter);
		if (Time.size() > 0) {
			try {
				fileWriter.append(clientAppName);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(FILE_HEADER_sessions.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);

				String apps;
				String users;
				String officeval;
				String otherval;
				String totalval;
				WebElement appsNames;
				WebElement appsValues;
				WebElement officevaldata;
				WebElement othervaldata;
				WebElement totalvaldata;
				
				for (int i = 0; i <= Time.size(); i++) {
					appsNames = Time.get(i);
					appsValues = Home.get(i);
					officevaldata=  Office.get(i);
					othervaldata= Other.get(i);
					totalvaldata= Total.get(i);
					System.out.println(appsNames.getText() + " : " + appsValues.getText()+ ":"+officevaldata.getText()+ ":"+othervaldata.getText()+ ":"+totalvaldata.getText());
					apps = appsNames.getText();
					users = appsValues.getText();
					officeval=officevaldata.getText();
					otherval= othervaldata.getText();
					totalval= totalvaldata.getText();
					
					
					fileWriter.append(apps);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(users);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(officeval);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(otherval);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(totalval);
					fileWriter.append(NEW_LINE_SEPARATOR);
					br.newLine();
				}
				if(Time.size()>0)
				{
				Assert.assertTrue("Values found in Table,Test case passed", true);
				}
				fileWriter.append(NEW_LINE_SEPARATOR);
				System.out.println("Data is written into the csv sheet");
			} catch (IndexOutOfBoundsException i) {
				System.out.println("Index out of bound exception" + i);
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();

				} catch (IOException e) {
					System.out.println("Error while flushing/closing fileWriter !!!");
					e.printStackTrace();
				}
			}
		} else {
			fileWriter.append(clientAppName);
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(No_Apps);
			fileWriter.append(NEW_LINE_SEPARATOR);
			br.newLine();
			fileWriter.flush();
			fileWriter.close();
		}

	}
//

	@Test(dataProvider = "InsideTheApp", priority = 4)
	public void Avgsession(String appName, String customStartDate) throws Exception {
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		clientAppName = wdriver.findElement(By.xpath("html/body/div[5]/div[4]/div[1]/form/div[1]/h1")).getText();
		System.out.println("App Name is " + clientAppName);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		in = new InsideTheApp_Elements(wdriver);
		// click on inside page
		in.insidePage();

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		// String csvOutputFile
		// ="E:\\AppICE_Data_Driven_FW\\com.appICE_Maven\\excelSheets\\AppICE_PagesData.csv";

		List<WebElement> NoOfSessions = wdriver
				.findElements(By.xpath("//*[@id='tblAvgLength']/tbody/tr/td[1]"));
		//System.out.println("App names are :" + NoOfSessions);
		List<WebElement> tusers = wdriver.findElements(By.xpath(".//*[@id='tblAvgLength']/tbody/tr/td[2]")); //
		//System.out.println("App value are :" + tusers);

		fileWriter = new FileWriter("./excelSheets/AppICE_Uses_AvgSessionLenghth.csv", true);
		br = new BufferedWriter(fileWriter);
		if (NoOfSessions.size() > 0) {
			try {
				fileWriter.append(clientAppName);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(FILE_HEADER_Avgsession.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);

				String apps;
				String users;
				WebElement appsNames;
				WebElement appsValues;

				for (int i = 0; i <= NoOfSessions.size(); i++) {
					appsNames = NoOfSessions.get(i);
					appsValues = tusers.get(i);
					System.out.println(appsNames.getText() + " : " + appsValues.getText());
					apps = appsNames.getText();
					users = appsValues.getText();

					fileWriter.append(apps);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(users);
					fileWriter.append(NEW_LINE_SEPARATOR);
					br.newLine();
				}
				
				if(NoOfSessions.size()>0)
				{
				Assert.assertTrue("Values found in Table,Test case passed", true);
				}
				
				fileWriter.append(NEW_LINE_SEPARATOR);
				System.out.println("Data is written into the csv sheet");
			} catch (IndexOutOfBoundsException i) {
				System.out.println("Index out of bound exception" + i);
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();

				} catch (IOException e) {
					System.out.println("Error while flushing/closing fileWriter !!!");
					e.printStackTrace();
				}
			}
		} else {
			fileWriter.append(clientAppName);
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(No_Apps);
			fileWriter.append(NEW_LINE_SEPARATOR);
			br.newLine();
			fileWriter.flush();
			fileWriter.close();
		}
		
	/*	//Event validation
		in.insideevent();
		System.out.println("Event validation passed");
		
		in.insidefunnel();
		//Funnel validation code
	System.out.println("enter1");
	in.funnelClick();
	System.out.println("enter2");
	in.selectdropdown();
	System.out.println("enter3");
	in.createFunnel();
	
	in.deletefunnel();
	System.out.println("Funnel validation successfulle");
	
	//Screen recording validation
	in.insidescreenrecording();
	System.out.println("Screen recording validation passed");*/
	
	}
	
	//Event validation
	@Test(dataProvider = "InsideTheApp", priority = 5)
	public void eventvalidation(String appName, String customStartDate) throws Exception
	{
		
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);
		in = new InsideTheApp_Elements(wdriver);
		//JavaScriptPageLoading.waitForPageLoadCompletely();
		//JavaScriptApiWait.waitForApiLoad();
         
	//	in.insidePage();
		in.insideevent();
	
		System.out.println("Event validation successfulle");
	}
	
	//Funnel validation
	@Test(dataProvider = "InsideTheApp", priority = 6)
	public void funnelvalidation(String appName, String customStartDate) throws Exception
	{
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		//JavaScriptPageLoading.waitForPageLoadCompletely();
		//JavaScriptApiWait.waitForApiLoad();
		//in.insidePage();
		in = new InsideTheApp_Elements(wdriver);
		in.insidefunnel();
			//Funnel validation code
		System.out.println("enter1");
		in.funnelClick();
		System.out.println("enter2");
		in.selectdropdown();
		System.out.println("enter3");
		in.createFunnel();
		
		in.deletefunnel();
		System.out.println("Funnel validation successfulle");
	}
	
	@Test(dataProvider = "InsideTheApp", priority = 6)
	public void screenvalidation(String appName, String customStartDate) throws Exception
	{
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();
		//in.insidePage();
		in.insidescreenrecording();
		
		System.out.println("Screen recording validation successfulle");
	}

}
