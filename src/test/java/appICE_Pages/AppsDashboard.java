package appICE_Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appICE_PageObject_Classes.Dashboard_Elements;
import baseClasses.MultiBrowsers;
import baseClasses.TestDataFromConfig;
import superPageObject_Classes.Apps_HomePage;
import superPageObject_Classes.AppICE_Home_Login_Pages;

import utils.DynamicAppSelection;

public class AppsDashboard extends MultiBrowsers {

	Dashboard_Elements de;
	Apps_HomePage hp;
	@DataProvider(name = "MultipleApps")
	public Object[][] data() throws Exception {
		HashMap<String, String[]> dataSet = new TestDataFromConfig("./propertyFiles/Dashboard_config.properties").getData();
		int size = dataSet.size();

		String differetnAppNames[] = dataSet.get("appNames");
		String differentCustomDates[] = dataSet.get("customDates");
		String differentcohortCustomDates[] = dataSet.get("cohortCustomDates");

		int appsSize = differetnAppNames.length;

		Object[][] apps = new Object[appsSize][size];

		for (int i = 0; i < appsSize; i++) {
			apps[i][0] = differetnAppNames[i];
			apps[i][1] = differentCustomDates[i];
			apps[i][2] = differentcohortCustomDates[i];
		}
		return apps;
	}

	@Test(priority = 1)
	public void loginpage() {
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("validUserName", "validPassword");
	}

/*	@Test(dataProvider = "MultipleApps", groups = "Sanity", priority = 2)
	public void todayDateRange(String appName, String customStartDate, String cohortCustomDate) {

		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();

		// hp.yesPayApp();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.todayDate();
		String dateRange = wdriver.findElement(By.cssSelector("div#advance-daterange")).getText();
		System.out.println("Date range selected is " + dateRange);
		de.installs();
		de.uninstalls();
		Dashboard_Elements.sourceWiseInstalls();
		Dashboard_Elements.sourceWiseRepeatInstalls();
		Dashboard_Elements.sourceWiseUninstalls();
		Dashboard_Elements.sourceWiseRepeatUnInstalls();
	}

	@Test(dataProvider = "MultipleApps", groups = "Sanity", priority = 3)
	public void yesterdayDateRange(String appName, String customStartDate, String cohortCustomDate)
			throws InterruptedException {

		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		// hp.yesPayApp();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		de.appName();

		de.yesterdayDate();
		String dateRange = wdriver.findElement(By.cssSelector("div#advance-daterange")).getText();
		System.out.println("Date range selected is " + dateRange);
		de.installs();
		de.uninstalls();
		Dashboard_Elements.sourceWiseInstalls();
		Dashboard_Elements.sourceWiseRepeatInstalls();
		Dashboard_Elements.sourceWiseUninstalls();
		Dashboard_Elements.sourceWiseRepeatUnInstalls();
	}

	@Test(dataProvider = "MultipleApps", groups = "Sanity", priority = 4)
	public void lastSevendays(String appName, String customStartDate, String cohortCustomDate)
			throws InterruptedException {

		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		// hp.yesPayApp();
		de = new Dashboard_Elements(wdriver);
		de.appName();

		de.last7Days();
		String dateRange = wdriver.findElement(By.cssSelector("div#advance-daterange")).getText();
		System.out.println("Date range selected is " + dateRange);
		de.installs();
		de.uninstalls();
		Dashboard_Elements.sourceWiseInstalls();
		Dashboard_Elements.sourceWiseRepeatInstalls();
		Dashboard_Elements.sourceWiseUninstalls();
		Dashboard_Elements.sourceWiseRepeatUnInstalls();
	}

	@Test(dataProvider = "MultipleApps", groups = "Sanity", priority = 5)
	public void last30days(String appName, String customStartDate, String cohortCustomDate)
			throws InterruptedException {

		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		// hp.yesPayApp();
		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.last30Days();
		String dateRange = wdriver.findElement(By.cssSelector("div#advance-daterange")).getText();
		System.out.println("Date range selected is " + dateRange);
		de.installs();
		de.uninstalls();
		Dashboard_Elements.sourceWiseInstalls();
		Dashboard_Elements.sourceWiseRepeatInstalls();
		Dashboard_Elements.sourceWiseUninstalls();
		Dashboard_Elements.sourceWiseRepeatUnInstalls();
	}

	@Test(dataProvider = "MultipleApps", groups = "Sanity", priority = 6)
	public void thisMonth(String appName, String customStartDate, String cohortCustomDate) throws InterruptedException {

		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		// hp.yesPayApp();
		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.thisMonth();
		String dateRange = wdriver.findElement(By.cssSelector("div#advance-daterange")).getText();
		System.out.println("Date range selected is " + dateRange);
		de.installs();
		de.uninstalls();
		Dashboard_Elements.sourceWiseInstalls();
		Dashboard_Elements.sourceWiseRepeatInstalls();
		Dashboard_Elements.sourceWiseUninstalls();
		Dashboard_Elements.sourceWiseRepeatUnInstalls();
	}

	@Test(dataProvider = "MultipleApps", groups = "Sanity", priority = 7)
	public void lastMonth(String appName, String customStartDate, String cohortCustomDate) throws InterruptedException {

		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		DynamicAppSelection.appSelection(appName);

		// hp.yesPayApp();
		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.lastMonth();
		String dateRange = wdriver.findElement(By.cssSelector("div#advance-daterange")).getText();
		System.out.println("Date range selected is " + dateRange);
		de.installs();
		de.uninstalls();
		Dashboard_Elements.sourceWiseInstalls();
		Dashboard_Elements.sourceWiseRepeatInstalls();
		Dashboard_Elements.sourceWiseUninstalls();
		Dashboard_Elements.sourceWiseRepeatUnInstalls();
	}*/
	
		@Test(dataProvider = "MultipleApps", groups = "Sanity_Cohort", priority = 8)
	public void monthlyCohort(String appName, String customStartDate, String cohortCustomDate)
			throws InterruptedException {
		
		// * Login_Page lp = new Login_Page(wdriver); lp.homeBtnClick();
		 
		
		 //* lp.loginbutton(); lp.credencials("validUserName", "validPassword");
		 

	    hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		// hp.yesPayApp();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.customDate(customStartDate);
		//changes by me
		de.installs(); 
		de.uninstalls();
	    de.cohortDates(cohortCustomDate, "D+30 (Monthly)");
		de.countCohort();
		
		// * YesPay_Elements ype=new YesPay_Elements(wdriver);
		// * RobotScrolling.scrollDown();
		 
		// Thread.sleep(1000);
		// ype.validationForCohort();

	}

	/*@Test(dataProvider = "MultipleApps", groups = "Sanity_Cohort", priority = 9)
	public void dailyCohort(String appName, String customStartDate, String cohortCustomDate)
			throws InterruptedException {
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		// hp.yesPayApp();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.customDate(customStartDate);
		 de.installs(); de.uninstalls();
		 
		de.cohortDates(cohortCustomDate, "D+1 (Daily)");
		de.countCohort();

	}

	@Test(dataProvider = "MultipleApps", groups = "Sanity_Cohort", priority = 10)
	public void weeklyCohort(String appName, String customStartDate, String cohortCustomDate)
			throws InterruptedException {

		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		// hp.yesPayApp();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.customDate(customStartDate);
		 de.installs(); de.uninstalls();
		 
		de.cohortDates(cohortCustomDate, "D+7 (Weekly)");
		de.countCohort();

	}*/

	@Test(dataProvider = "MultipleApps", groups = "Sanity_Cohort", priority = 11)
	public void yearCohort(String appName, String customStartDate, String cohortCustomDate)
			throws InterruptedException {
		hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		// hp.yesPayApp();
		DynamicAppSelection.appSelection(appName);

		de = new Dashboard_Elements(wdriver);

		de.appName();
		de.customDate(customStartDate);
		 de.installs(); de.uninstalls();
		 
		de.cohortDates(cohortCustomDate, "Yearly");
		de.countCohortyearly();
	}

	/*
	 * @Test public void installsPageInNewTab(){ Apps_HomePage hp = new
	 * Apps_HomePage(wdriver); hp.homeButtonClick(); hp.yesPayApp();
	 * Dashboard_Elements de = new Dashboard_Elements(wdriver);
	 * de.viewDetails(); }
	 */

}
