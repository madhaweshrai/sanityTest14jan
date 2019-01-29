package appICE_PageObject_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SetupNewApp_Elements  {
	private WebDriver _webDriver = null;
	
	@FindBy(xpath=".//*[@id='sidebar']/div/div[1]/ul/li[3]/a/span")
	private WebElement setuplink;
	
	@FindBy(xpath=".//*[@id='002']")
	private WebElement setupnewapp;
	
	@FindBy(xpath=".//*[@id='setupwizard']/ol/li[1]/a[1]")
	private WebElement tab1a1;
	@FindBy(xpath=".//*[@id='setupwizard']/ol/li[1]/a[2]")
	private WebElement tab1a2;
	
	@FindBy(xpath=".//*[@id='setupwizard']/ol/li[2]/a[1]")
	private WebElement tab2a1;
	@FindBy(xpath=".//*[@id='setupwizard']/ol/li[2]/a[2]")
	private WebElement tab2a2;
	
	@FindBy(xpath=".//*[@id='setupwizard']/ol/li[3]/a[1]")
	private WebElement tab3a1;
	@FindBy(xpath=".//*[@id='setupwizard']/ol/li[3]/a[2]")
	private WebElement tab3a2;
	
	public SetupNewApp_Elements(WebDriver wdriver) {
		super();
		PageFactory.initElements(wdriver, this);
		_webDriver = wdriver;
	}
	
	public void Mypage()
	{
		setuplink.click();
		
	}
	
	public void SetupNewApp()
	{
		
		setupnewapp.click();
	}
	
	public void tabsvalidation()
	{
		String Tab1exp1= "Setup your App";
		String Tab1exp2= "Integrate With SDK";
		String Tab1exp3= "Test the Integration";
		tab1a1.click();
		String actual1= tab1a1.getText();
		tab1a2.click();
		String actual11= tab1a2.getText();
		tab2a1.click();
		String actual2= tab2a1.getText();
		tab2a2.click();
		String actual22= tab2a2.getText();
		
		tab3a1.click();
		String actual3= tab3a1.getText();
		tab3a2.click();
		String actual33= tab3a2.getText();
		
		Assert.assertEquals(actual1, Tab1exp1,"Tab1 validated successfully");
System.out.println("v1");
		Assert.assertEquals(actual2, Tab1exp2,"Tab1 validated successfully");
		System.out.println("v2");
		Assert.assertEquals(actual3, Tab1exp3,"Tab1 validated successfully");
		
		System.out.println("v3");
	}
}
