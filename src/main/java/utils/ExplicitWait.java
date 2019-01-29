package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.MultiBrowsers;


public class ExplicitWait extends MultiBrowsers {
	public static void explicitWaitStatement(WebElement element){
		WebDriverWait wait = new WebDriverWait(wdriver, 60);
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOf(element));
		ele1.click();
		}
	
	
}
