package appICE_Pages;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appICE_PageObject_Classes.AudianceSegment_Elements;
import appICE_PageObject_Classes.Dashboard_Elements;
import appICE_PageObject_Classes.Install_Elements;
import baseClasses.MultiBrowsers;
import baseClasses.TestDataFromConfig;
import superPageObject_Classes.Apps_HomePage;
import superPageObject_Classes.Login_Page;
import utils.DynamicAppSelection;

public class TC_AudianceSegment extends MultiBrowsers {


	Dashboard_Elements de;
	@DataProvider(name = "AudienceSeg")
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


	@Test(dataProvider = "AudienceSeg", groups = "Sanity", priority = 2)
	public void who_data_validation(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		//Install_Elements ai = new Install_Elements(wdriver);
		AudianceSegment_Elements ae= new AudianceSegment_Elements(wdriver);
		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
		   System.out.println("Done1");
		ae.myapps();
		ae.createnew_who();
		
        System.out.println("validation Done2");
	}
	
	/*@Test(dataProvider = "AudienceSeg", groups = "Sanity", priority = 3)
	public void what_data_validation(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		//Install_Elements ai = new Install_Elements(wdriver);
		AudianceSegment_Elements ae= new AudianceSegment_Elements(wdriver);
		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
		   System.out.println("Done1");
		ae.myapps();
		ae.createnew_what();
        System.out.println("validation Done2");
	}
	@Test(dependsOnMethods={"what_data_validation"},dataProvider = "AudienceSeg", groups = "Sanity", priority = 4)
	public void where_data_validation(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		//Install_Elements ai = new Install_Elements(wdriver);
		AudianceSegment_Elements ae= new AudianceSegment_Elements(wdriver);
		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
		   System.out.println("Done1");
		ae.myapps();
		ae.create_where();
        System.out.println("validation Done2");
	}
	
	@Test(dependsOnMethods={"what_data_validation"},dataProvider = "AudienceSeg", groups = "Sanity", priority = 5)
	public void when_data_validation(String appName,String customStartDate, String cohortCustomDate) throws Exception {

		Apps_HomePage hp = new Apps_HomePage(wdriver);
		hp.homeButtonClick();
		//Install_Elements ai = new Install_Elements(wdriver);
		AudianceSegment_Elements ae= new AudianceSegment_Elements(wdriver);
		DynamicAppSelection.appSelection(appName);
   
		System.out.println("---------Running TestCase for -------------------->" + appName);
		   System.out.println("Done1");
		ae.myapps();
		ae.create_when();
        System.out.println(" validation Done2");
	}*/
	
}
