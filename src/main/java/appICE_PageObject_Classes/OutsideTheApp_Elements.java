package appICE_PageObject_Classes;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutsideTheApp_Elements {
	
	@FindBy(css="#advance-daterange")
	private WebElement dateRangeClick;
	
	@FindBy(xpath="//input[@name='daterangepicker_start']")
	private WebElement toDate;
	
	@FindBy(css=".applyBtn")
	private WebElement submit;

	@FindBy(xpath = "//span[text()='Activities']")
	private WebElement activityClick;

	@FindBy(xpath = "//a[text()='Inside the App']")
	private WebElement insidePageClick;

	@FindBy(xpath = "//h4[text()='Competitive Apps']/../..//tr/td[1]")
	private List<WebElement> competitiveApps_AppNames;

	@FindBy(xpath = "//h4[text()='Competitive Apps']/../..//tr/td[2]")
	private List<WebElement> competitiveApps_UserCount;

	@FindBy(xpath = "//a[text()='Outside the App']")
	private WebElement outsidePageClick;

	public OutsideTheApp_Elements(WebDriver wdriver) {
		super();
		PageFactory.initElements(wdriver, this);
	}

	
	public boolean outsidePage() {
		activityClick.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		outsidePageClick.click();
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
	
	
}
