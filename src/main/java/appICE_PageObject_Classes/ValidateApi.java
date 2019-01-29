package appICE_PageObject_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateApi {
	private WebDriver _webDriver = null;
	
	@FindBy(xpath = (".//*[@id='urlvalue']"))
	private WebElement ele;
	
	public ValidateApi(WebDriver driver) {
		super();
		_webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public void initialise()
	{
		//select app
		//goto app users page
		//put did in search box
		//find row,if row tr>1 then TC pass
	}
	
}
