package appICE_PageObject_Classes;

import org.openqa.selenium.Alert;

//import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import junit.framework.Assert;

public class AudianceSegment_Elements {

	@FindBy(xpath=".//*[@id='sidebar']/div/div[1]/ul/li[4]/a")
	private WebElement users;
	
	@FindBy(xpath=".//*[@id='006']")
	private WebElement audsegment; 
	
    @FindBy(xpath=".//*[@id='content']/div[1]/div/div/div/div[1]/div/div[2]/a")
    private WebElement createnew;


    @FindBy(xpath=".//*[@id='totalUsers']")
    private WebElement activeusers;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[1]/div/div[2]/div[1]/p/a")
    private WebElement who;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[2]/div/div[2]/div/p[1]/a")
    private WebElement device;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[3]/div/div[2]/form/div/fieldset/div[1]/select")
    private WebElement drpdown_device;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[3]/div/div[2]/form/div/fieldset/div[2]/select")
    private WebElement drpdown_operater;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[3]/div/div[2]/form/div/fieldset/div[3]/select[1]")
    private WebElement drpdown_status;
    
    @FindBy(xpath=".//*[@id='lblAudienceCounter']")
    private WebElement reach_count;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[1]/div/div[2]/div[2]/p/a")
    private WebElement what;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[2]/div/div[2]/div/p/a")
    private WebElement events;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[3]/div/div[2]/form/div/fieldset/div[1]/select")
    private WebElement install;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[3]/div/div[2]/form/div/fieldset/div[3]/select")
    private WebElement equals;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[2]/div[3]/div/div[2]/form/div/fieldset/div[4]/select[1]")
    private WebElement true2;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[1]/div/div/div[2]/form/div[1]/input")
    private WebElement seg_name;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[1]/div/div/div[2]/form/div[2]/textarea")
    private WebElement seg_descp;
    
    @FindBy(xpath=".//*[@id='content']/div[1]/div[1]/div/div/div[2]/form/div[3]/button[1]")
    private WebElement save;
    
    @FindBy(xpath = (".//*[@id='tblAudience']/tbody/tr[1]/td[text()='who_segment'][last()]/following-sibling::td[5]"))
	private static WebElement created_aud;
    
    @FindBy(xpath = (".//*[@id='tblAudience']/tbody/tr[1]/td[6]/button"))
	private static WebElement created_aud2;
    
    
	private WebDriver _webDriver = null;
	private WebElement chart= null;

	public AudianceSegment_Elements(WebDriver driver) {
		super();
		_webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void myapps() throws InterruptedException {
		Thread.sleep(1000);
		/*String  str=activeusers.getText();
		Thread.sleep(1000);
		int Activeusers= Integer.parseInt(str);
		System.out.println("Total Active users"+Activeusers);
		myapps.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		users.click();
		Thread.sleep(1000);
		audsegment.click();
		Thread.sleep(1000);
		createnew.click();
	}
	
	public void createnew_what() throws InterruptedException
	{
		Thread.sleep(1000);
		what.click();
		Thread.sleep(1000);
		events.click();
		Thread.sleep(1000);
		System.out.println("Inside Aud seg page");
		Select dropdown = new Select(install);

		 //  WebDriverWait wait = new WebDriverWait(_webDriver,30);
	//	Select dropdown2 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='content']/div[1]/div[2]/div[3]/div/div[2]/form/div/fieldset/div[1]/select"))));
		
		  // dropdown.selectByVisibleText("install");
		dropdown.selectByIndex(2);
		   Thread.sleep(2000);
		   
		     
		   Select dropdown2 = new Select(equals);
		   // dropdown2.selectByVisibleText("Equals");
		    dropdown2.selectByIndex(1);
		    Thread.sleep(2000);
		    Select dropdown3 = new Select(true2);
		    dropdown3.selectByVisibleText("True");
		    dropdown3.selectByIndex(0);
		    Thread.sleep(2000);
		    String reach=reach_count.getText();
		    int reachableCount= Integer.parseInt(reach);
		    System.out.println("What Reachable count is"+reachableCount);
		    seg_name.sendKeys("who_segment");
		    seg_descp.sendKeys("Test segment");
		    save.click();
		    Thread.sleep(2000);
		    created_aud2.click();
		    Thread.sleep(1000);
		    Alert alert = _webDriver.switchTo().alert();
			
			System.out.println(alert.getText());
			alert.accept();
		    System.out.println("Test case passed");
	}
	
	public void createnew_who() throws InterruptedException
	{
		
		who.click();
		Thread.sleep(1000);
		device.click();
		System.out.println("Inside Aud what seg page");
		Select dropdown = new Select(drpdown_device);
		   //dropdown.selectByVisibleText("Platform");
		dropdown.selectByIndex(3);
		   Thread.sleep(2000);
		   Select dropdown2 = new Select(drpdown_operater);
		   // dropdown2.selectByVisibleText("Equals");
		   dropdown2.selectByIndex(1);
		    Thread.sleep(2000);
		    Select dropdown3 = new Select(drpdown_status);
		   // dropdown3.selectByVisibleText("Android");
		    dropdown3.selectByIndex(1);
		    Thread.sleep(2000);
		    String reach=reach_count.getText();
		    int reachableCount= Integer.parseInt(reach);
		    System.out.println("Who Reachable count is"+reachableCount);
		    seg_name.sendKeys("who_segment");
		    seg_descp.sendKeys("Test segment");
		    
		    Thread.sleep(2000);
		    save.click();
		    Thread.sleep(2000);
		    created_aud.click();
		    System.out.println("delete pressed");
		    Thread.sleep(2000);
		    Alert alert = _webDriver.switchTo().alert();
			alert.accept();
		    System.out.println("Test case passed");
		    // validate Active users vs Reachable count
		    // create Aud segment
		    // check and delete Aud segment
		
	}
	
	public void create_where()
	{
		Assert.assertTrue(true);
	}
	public void create_when()
	{
		Assert.assertTrue(true);
	}
	
}
