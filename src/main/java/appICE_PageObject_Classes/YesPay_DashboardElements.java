package appICE_PageObject_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ExplicitWait;

public class YesPay_DashboardElements {

	@FindBy (xpath=("//td[text()='October 2016']"))
    private WebElement yespay_cohortValidation;			
			
	
	public YesPay_DashboardElements(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void validationForCohort(){
		ExplicitWait.explicitWaitStatement(yespay_cohortValidation);
	}

}
