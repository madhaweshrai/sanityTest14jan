
package appICE_Pages;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appICE_PageObject_Classes.Dashboard_Elements;
import appICE_PageObject_Classes.Install_Elements;
import appICE_PageObject_Classes.Uninstall_Elements;
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
@Listeners(listeners.ITestListener_TNGL.class)
public class TC_AppUninstall extends MultiBrowsers {

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
		
		Login_Page lp = new Login_Page(wdriver);
		
		lp.loginbutton();
		lp.credencials("validUserName", "validPassword");
	}

	@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 2)
	public void AppInstallsvalidation(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
	//	Uninstall_Elements uni = new Uninstall_Elements(wdriver);
		Uninstall_Elements uni= new Uninstall_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
		
		System.out.println("---------Running TestCase for -------------------->" + appName);
         uni.App_uninstalls_allapp(customStartDate);

		uni.Downloadcsv();
		
		uni.addTableDataToMap("tblLocation");
		 uni.Locationcsv_validation();
		// can't validate tblSource and tblOS
		
	//	uni.addTableDataToMap("tblSources");
	//	uni.addTableDataToMap("tblOS");
		//uni.AppVersioncsv_validation();
		// Getting Install table data and validating with Install csv
		
		

	//	 uni.addTableDataToMap("tblOS");
	 // uni.AppVersioncsv_validation();

		

	}
}
