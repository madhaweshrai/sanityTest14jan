/**
 * 
 */
package appICE_Pages;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appICE_PageObject_Classes.Dashboard_Elements;
import appICE_PageObject_Classes.Install_Elements;
import baseClasses.MultiBrowsers;
import baseClasses.TestDataFromConfig;
import superPageObject_Classes.AppICE_Home_Login_Pages;
import superPageObject_Classes.Apps_HomePage;
import superPageObject_Classes.Login_Page;
import utils.DynamicAppSelection;

/**
 * @author Madhawesh
 *
 */

public class TC_AppInstall extends MultiBrowsers {

	Dashboard_Elements de;
	@DataProvider(name = "MultipleApps_appinstalls")
	public Object[][] data() throws Exception {
		HashMap<String, String[]> dataSet = new TestDataFromConfig("./propertyFiles/appinstalls.properties").getData();
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
		/*AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("validUserName", "validPassword");*/
		
		Login_Page lp = new Login_Page(wdriver);
		
		lp.loginbutton();
		lp.credencials("validUserName", "validPassword");
	}

	/*@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 2)
	public void Installs_countvalidation_Today(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		Install_Elements ai = new Install_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
        ai.Today_installs();
		
         //New UI function
       // ai.NewToday_installs();
        
	}*/
	
	@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 3)
	public void Installs_countvalidation_Yesterday(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		Install_Elements ai = new Install_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
     //  ai.Yesterday_installs();
       // New UI function
        ai.NewYesterday_installs();
        //ai.getalldata();
        
	}
	

	
		@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 3)
	public void Installs_countvalidation_custumDates(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		Install_Elements ai = new Install_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
		//ai.App_Installs_allapp(customStartDate);
		
		//New UI function
        ai.App_Installs_allapp(customStartDate);
	}
	

	
		@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 4)
	public void Installs_csvvalidation_Today(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		Install_Elements ai = new Install_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
       // ai.Today_installs();
		ai.today_click();
		//ai.App_Installs_allapp(customStartDate);
		ai.Downloadcsv();
		// Getting Install table data and validating with Install csv
	    ai.addTableDataToMap("tblSourceData");
		ai.csv_validation_InstallTable();

		 ai.addTableDataToMap("tblOS");
		ai.csv_validation_OSTable();
		
		ai.addTableDataToMap("tblLocation");
		 ai.csv_validation_LocationTable();
		

		 

	}
	
	
		@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 5)
	public void Installs_csvvalidation_Yesterday(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		Install_Elements ai = new Install_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
       
     	ai.yesterday_click();
		ai.Downloadcsv();
		// Getting Install table data and validating with Install csv
	    ai.addTableDataToMap("tblSourceData");
		ai.csv_validation_InstallTable();

		 ai.addTableDataToMap("tblOS");
		ai.csv_validation_OSTable();
		
		ai.addTableDataToMap("tblLocation");
		 ai.csv_validation_LocationTable();
		

		// Getting OS table data and validating with os csv
		
		
		 

	}
	
	@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 5)
	public void Installs_csvvalidation_CustomRange(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		Install_Elements ai = new Install_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
        //ai.Today_installs();
	//	ai.yesterday_click();
		ai.App_Installs_allapp(customStartDate);
		//ai.NewApp_Installs_allapp(customStartDate);
		
		ai.Downloadcsv();
		// Getting Install table data and validating with Install csv
	    ai.addTableDataToMap("tblSourceData");
		ai.csv_validation_InstallTable();

		 ai.addTableDataToMap("tblOS");
		ai.csv_validation_OSTable();
		
		ai.addTableDataToMap("tblLocation");
		 ai.csv_validation_LocationTable();
		

	

	}
		 

}
