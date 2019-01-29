package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.MultiBrowsers;

public class ActionsClass extends MultiBrowsers{
	

	public static void mouseOverAction(WebElement elementToWhere){
		
		WebDriverWait wt=new WebDriverWait(wdriver,60);
		
		Actions ac=new Actions(wdriver);
		ac.moveToElement(wt.until(ExpectedConditions.visibilityOf(elementToWhere))).click().perform();
	}

	
	

}
