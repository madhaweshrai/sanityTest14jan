package appICE_PageObject_Classes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class InsideTheApp_Elements {
	private WebDriver _webDriver = null;
	
	@FindBy(css="#advance-daterange")
	private WebElement dateRangeClick;
	
	@FindBy(xpath="//input[@name='daterangepicker_start']")
	private WebElement toDate;
	
	@FindBy(css=".applyBtn")
	private WebElement submit;

	@FindBy(xpath = "//span[text()='Activities']")
	private WebElement activityClick;

	@FindBy(xpath = "//a[text()='Outside the App']")
	private WebElement outsidePageClick;

	@FindBy(xpath = "//h4[text()='Competitive Apps']/../..//tr/td[1]")
	private List<WebElement> competitiveApps_AppNames;

	@FindBy(xpath = "//h4[text()='Competitive Apps']/../..//tr/td[2]")
	private List<WebElement> competitiveApps_UserCount;
	@FindBy(xpath = "//a[text()='Inside the App']")
	private WebElement insidePageClick;
	
	@FindBy(xpath = ".//*[@id='3']")
	private WebElement funnelclk;
	@FindBy(xpath = ".//*[@id='content']/div[2]/div/div/form/div[2]/a")
	private WebElement createfunnel;
	

	@FindBy(xpath = ".//*[@id='content']/div[1]/div[2]/div[2]/div/div[2]/form/div[2]/fieldset/div[3]/button[2]")
	private WebElement btnclick1;
	
	
	@FindBy(xpath = ".//*[@id='content']/div[1]/div[2]/div[2]/div/div[2]/form/div[2]/fieldset[2]/div[3]/button[1]")
	private WebElement btnclick2;

	@FindBy(xpath = ".//*[@id='modal-dialog']/div[2]/div/div[2]/form/div[1]/div/input")
	private WebElement Enterfunnelname;


	@FindBy(xpath = ".//*[@id='content']/div[1]/div[2]/div[2]/div/div[2]/form/div[3]/button[1]")
	private WebElement savefunnel;

    @FindBy(xpath = ".//*[@id='modal-dialog']/div[2]/div/div[3]/button[1]")
	private WebElement clickok;
    
    @FindBy(xpath = ".//*[@id='tblFunnels']/tbody/tr[1]/td[text()='FunnelTesting']")
	private WebElement findfunnel;
    
    @FindBy(xpath = ".//*[@id='tblFunnels']/tbody/tr[1]/td[4]/button")
	private WebElement deletefunnelbtn;
    
    @FindBy(xpath = ".//*[@id='sidebar']/div/div[1]/ul/li[6]/ul/li[1]/ul/li[3]/a")
   	private WebElement funnelloc;
 
    @FindBy(xpath = ".//*[@id='sidebar']/div/div[1]/ul/li[6]/ul/li[1]/ul/li[2]/a")
   	private WebElement eventloc;
 
    @FindBy(xpath = ".//*[@id='sidebar']/div/div[1]/ul/li[6]/ul/li[1]/ul/li[4]/a")
   	private WebElement screenrecloc;
    
    @FindBy(xpath = ".//*[@id='sidebar']/div/div[1]/ul/li[6]/a/span")
   	private WebElement Activities;
    @FindBy(xpath = ".//*[@id='0011']")
   	private WebElement insidetheapp;
    
    
	public InsideTheApp_Elements(WebDriver wdriver) {
		super();
		PageFactory.initElements(wdriver, this);
		_webDriver = wdriver;
	}
//click on uses
	public boolean insidePage() {
		activityClick.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		insidePageClick.click();
		return true;
	}
	//click on events
	public boolean insideevent() throws Exception {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		activityClick.click();
		
		Thread.sleep(500);
		insidePageClick.click();
		Thread.sleep(1000);
		eventloc.click();
		
		return true;
	}
	
	//click on funnels
	public boolean insidefunnel() throws Exception {
	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		activityClick.click();
	
		Thread.sleep(500);
		insidePageClick.click();
		Thread.sleep(1000);
		funnelloc.click();
		return true;
	}
	public boolean insidescreenrecording() throws Exception {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		activityClick.click();
		
		Thread.sleep(500);
		insidePageClick.click();
		Thread.sleep(1000);
		screenrecloc.click();
		return true;
	}
	
	
	public void dateRangeSelection(String ToDate){
		dateRangeClick.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		toDate.clear();
		toDate.sendKeys(ToDate);
		submit.click();
	}
	
	//click on funnel
	public void funnelClick()
	{
		//funnelclk.click();
		createfunnel.click();
		}
	
	public void selectdropdown() throws Exception
	{
		//selecting value in dropdown1
		Thread.sleep(1000);
				Select drp= new Select(_webDriver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/div[2]/div/div[2]/form/div[1]/select")));
		          drp.selectByIndex(2);
		          Thread.sleep(1000);
		        //selecting value in dropdown2
		          Select drp2= new Select(_webDriver.findElement(By.xpath(" .//*[@id='content']/div[1]/div[2]/div[2]/div/div[2]/form/div[2]/fieldset/div[1]/select")));
		         drp2.selectByIndex(2);
		         Thread.sleep(1000);
	}
	
	
	//create funnel
		public void createFunnel() throws Exception
		{
		
			/*btnclick1.click();
			btnclick2.click();*/
			savefunnel.click();
			Enterfunnelname.sendKeys("FunnelTesting");
			clickok.click();
			Thread.sleep(1000);
			//_webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			}
	public void deletefunnel()
	{
		findfunnel.click();
		String funnalname= findfunnel.getText();
		System.out.println("print it  "+funnalname);
		String exp= "FunnelTesting";
	//	Assert.assertEquals(exp, funnalname," created and appeared Funnel name validated");
		deletefunnelbtn.click();
		Alert alert = _webDriver.switchTo().alert();
		alert.accept();
		
		
		
	}
	
	}
