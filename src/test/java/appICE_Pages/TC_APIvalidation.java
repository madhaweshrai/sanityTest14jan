package appICE_Pages;

import org.testng.annotations.Test;

import appICE_PageObject_Classes.Element_APivalidation;
import baseClasses.ApiMultiBrowsers;
import baseClasses.MultiBrowsers;
import superPageObject_Classes.AppICE_Home_Login_Pages;
import superPageObject_Classes.Login_Page;

public class TC_APIvalidation extends MultiBrowsers{
	
/*	@Test(priority = 1)
	public void loginpage() throws Exception {
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("validUserName", "validPassword");
		
		Login_Page lpp = new Login_Page(wdriver);
		
		lpp.loginbutton();
		lpp.credencials("validUserName", "validPassword");
		
		
	}
*/
	@Test(priority = 1)
	public void Dashboardapi_engagement() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.Dashboard_Engagementnactiveusers();
	}
	@Test(priority = 2)
	public void Dashboardapi_cohort() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.Dashboard_cohort();
	}

	@Test(priority = 3)
	public void Dashboardapi_installUninstallsrc() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.Dashboard_instUnintsrcwise();
	}
	
	@Test(priority = 4)
	public void Dashboardapi_usersatrisk() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.Dashboard_usersatrisk();
	}
	
	@Test(priority = 5)
	public void Demographics_userinterest() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.demographics_userinterest();
	}
	
	@Test(priority = 6)
	public void Demographics_activeusers() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.demographics_activeusersngws();
	}
	
	@Test(priority = 7)
	public void Demographics_competingapps() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.demographics_usercompetingapps();
	}
	
	@Test(priority = 8)
	public void appinstalls_oslocwise() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.appinstalls_oslocdaysplitewise();
	}
	@Test(priority = 9)
	public void appinstalls_installsource() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.appinstalls_installsource();
	}
	
	@Test(priority = 10)
	public void activityusers_activeusersAvgssn() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.usases_activeusersavgssnlength();
	}
	
	@Test(priority = 11)
	public void activityusers_session() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.usase_session();
	}
	@Test(priority = 12)
	public void Event_eventlist() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.Event_eventlist();
	}
	@Test(priority = 13)
	public void Event_stats() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.Event_eventstats();
	}
	@Test(priority = 14)
	public void Event_eventsegattribute() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.eventsegattribute();
	}
	
	@Test(priority = 15)
	public void funnels() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.getfunnel();
	}
	@Test(priority = 16)
	public void uninstalls_oslocwise() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.uninstalls_oslocdtwise();
	}
	@Test(priority = 17)
	public void uninstalls_srcwiseuninstalls() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.uninstalls_srcwiseuninstalls();
	}
	@Test(priority = 18)
	public void uninstalls_regainedusers() throws Exception
	{
		System.out.println("----API validation started ----" );
		Element_APivalidation api = new Element_APivalidation(wdriver);
		api.uninstalls_regainedusers();
	}
	
	
}
