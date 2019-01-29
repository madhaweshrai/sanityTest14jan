package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClasses.MultiBrowsers;


public class JavaScriptApiWait extends MultiBrowsers {

	public static void waitForApiLoad() {

		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return	((Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0"));
				 
				
			}
		};

		WebDriverWait wait = new WebDriverWait(wdriver, 60);
		wait.until(pageLoadCondition);

	}
}