package appICE_Pages;

import java.util.HashMap;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appICE_PageObject_Classes.Dashboard_Elements;
import appICE_PageObject_Classes.Install_Elements;
import appICE_PageObject_Classes.SetupNewApp_Elements;
import baseClasses.MultiBrowsers;
import baseClasses.TestDataFromConfig;
import superPageObject_Classes.Apps_HomePage;
import superPageObject_Classes.Login_Page;
import utils.DynamicAppSelection;

public class SetupNewApp extends MultiBrowsers {

	@DataProvider(name = "MultipleApps_appinstalls")
	public Object[][] data() throws Exception {
		HashMap<String, String[]> dataSet = new TestDataFromConfig("./propertyFiles/appinstalls.properties").getData();
		int size = dataSet.size();
System.out.println(size);
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
	
	

	@Test(dataProvider = "MultipleApps_appinstalls", groups = "Sanity", priority = 2)
	public void setupapp(String appName ,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		SetupNewApp_Elements setup = new SetupNewApp_Elements(wdriver);

		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);

	//	setup.App_Installs_allapp(customStartDate);
	//	Dashboard_Elements de= new Dashboard_Elements(wdriver);
			//	de.customDateIns(customStartDate);
		setup.Mypage();
		setup.SetupNewApp();
	setup.tabsvalidation();
	System.out.println("clicked");
		
	}
	
	
}
