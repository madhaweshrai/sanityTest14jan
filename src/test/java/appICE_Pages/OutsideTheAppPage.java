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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.csvreader.CsvWriter;

import appICE_PageObject_Classes.Dashboard_Elements;
import appICE_PageObject_Classes.OutsideTheApp_Elements;
import baseClasses.MultiBrowsers;
import baseClasses.TestDataFromConfig;
import superPageObject_Classes.Apps_HomePage;
import superPageObject_Classes.AppICE_Home_Login_Pages;
import utils.DynamicAppSelection;
import utils.JavaScriptApiWait;
import utils.JavaScriptPageLoading;

public class OutsideTheAppPage extends MultiBrowsers {
	Dashboard_Elements de = null;
	OutsideTheApp_Elements op = null;
	Apps_HomePage hp = null;
	FileWriter fileWriter = null;
	BufferedWriter br = null;

	CsvWriter csvwriter = null;
	PrintWriter printwriter = null;

	// Delimiter used in CSV file

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	// CSV file header
	private static final String FILE_HEADER = "Competing App Name, Users of the App";
	private static final String No_Apps = "No Competitive Apps for this APP";

	private String Date_Header = "Scripts ran on this DATE and TIME";

	String clientAppName = null;

	@DataProvider(name = "OutsideTheApp")
	public Object[][] data() throws Exception {
		HashMap<String, String[]> dataSet = new TestDataFromConfig("./propertyFiles/OutsideTheApp_config.properties")
				.getData();
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
			fileWriter = new FileWriter("./excelSheets/AppICE_AvgSessionLengthData.csv", true);
			fileWriter.append(Date_Header);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(todayDateWithTime);
			fileWriter.append(NEW_LINE_SEPARATOR);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}

	@Test(dataProvider = "OutsideTheApp", priority = 2)
	public void competingApps(String appName, String customStartDate) throws IOException {
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
		op = new OutsideTheApp_Elements(wdriver);
		op.outsidePage();

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		// String csvOutputFile
		// ="E:\\AppICE_Data_Driven_FW\\com.appICE_Maven\\excelSheets\\AppICE_PagesData.csv";

		List<WebElement> diffAppName = wdriver
				.findElements(By.xpath("//h4[text()='Competitive Apps']/../..//tr/td[1]"));
		System.out.println("App names are :" + appName);
		List<WebElement> appValue = wdriver.findElements(By.xpath("//h4[text()='Competitive Apps']/../..//tr/td[2]")); //
		System.out.println("App value are :" + appValue);

		fileWriter = new FileWriter("./excelSheets/AppICE_CompetingAppsData.csv", true);
		br = new BufferedWriter(fileWriter);
		if (diffAppName.size() > 0) {
			try {
				fileWriter.append(clientAppName);
				fileWriter.append(NEW_LINE_SEPARATOR);
				fileWriter.append(FILE_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);

				String apps;
				String users;
				WebElement appsNames;
				WebElement appsValues;

				for (int i = 0; i <= diffAppName.size(); i++) {
					appsNames = diffAppName.get(i);
					appsValues = appValue.get(i);
					System.out.println(appsNames.getText() + " : " + appsValues.getText());
					apps = appsNames.getText();
					users = appsValues.getText();

					fileWriter.append(apps);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(users);
					fileWriter.append(NEW_LINE_SEPARATOR);
					br.newLine();
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

	@Test(dataProvider = "OutsideTheApp", priority = 3)
	public void avgSessionLength(String appName, String customStartDate) {
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);
		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();
		//clientAppName = wdriver.findElement(By.xpath("html/body/div[5]/div[4]/div[1]/form/div[1]/h1")).getText();

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		clientAppName = wdriver.findElement(By.xpath("html/body/div[5]/div[4]/div[1]/form/div[1]/h1")).getText();
		System.out.println("App Name is " + clientAppName);

		op = new OutsideTheApp_Elements(wdriver);
		op.outsidePage();
		op.dateRangeSelection(customStartDate);

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// The below is for all the rows
		List<WebElement> rows = wdriver.findElements(By.xpath("//h4[text()='Avg. Session Length']/../..//tr"));
		int NoOfRowsSize = rows.size();
		System.out.println("NoOfRowsSize " + NoOfRowsSize);

		// The below is for Column headers only
		List<WebElement> columnHeaders = wdriver
				.findElements(By.xpath("//h4[text()='Avg. Session Length']/../..//tr//th"));
		int columnHeadersSize = columnHeaders.size();
		System.out.println("columnHeadersSize " + columnHeadersSize);

		// The below is for Rows after the Headers
		List<WebElement> rowsValues = wdriver
				.findElements(By.xpath("//h4[text()='Avg. Session Length']/../..//tr//td"));
		int rowsValuesSize = rowsValues.size();
		System.out.println("rowsValuesSize " + rowsValuesSize);

		Date date = new Date();
		String todayDateWithTime = date.toString();
		System.out.println("Date is" + date);

		try {
			fileWriter = new FileWriter("./excelSheets/AppICE_AvgSessionLengthData.csv", true);
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(todayDateWithTime);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(clientAppName);
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (WebElement column : columnHeaders) {
				String columnTexts = column.getText();
				fileWriter.write(columnTexts);
				fileWriter.append(COMMA_DELIMITER);
			}
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (WebElement row : rowsValues) {
				String rowTexts = row.getText();
				fileWriter.write(rowTexts);
				fileWriter.append(COMMA_DELIMITER);
			}
			fileWriter.append(NEW_LINE_SEPARATOR);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		} catch (StaleElementReferenceException se) {
			se.printStackTrace();
		} finally {
		}
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Data got written into CSV and closed the file and flushed the data");
		}
	}
	
/*	@Test(dataProvider = "OutsideTheApp", priority = 4)
	public void apivalidation(String appName, String customStartDate)
	{
		
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);
		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();
		//clientAppName = wdriver.findElement(By.xpath("html/body/div[5]/div[4]/div[1]/form/div[1]/h1")).getText();

		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();

		clientAppName = wdriver.findElement(By.xpath("html/body/div[5]/div[4]/div[1]/form/div[1]/h1")).getText();
		System.out.println("App Name is " + clientAppName);

		op = new OutsideTheApp_Elements(wdriver);
		op.outsidePage();
		op.dateRangeSelection(customStartDate);
         System.out.println("Start API validation");
         
         

	}*/
}
