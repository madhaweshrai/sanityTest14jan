package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClasses.MultiBrowsers;

/*
 * 
 */
public class JavaScriptPageLoading extends MultiBrowsers {

	/*
	 * 
	 */
	public static void waitForPageLoadCompletely() {
		// Load web-driver with timeout of 30 seconds
		WebDriverWait wait = new WebDriverWait(wdriver, 30);

		// Load wed-driver and wait for the expected condition value
		wait.until(new ExpectedCondition<Boolean>() {

			/*
			 *
			 */
			public Boolean apply(WebDriver wdriver) {
				// Extract information related to gathering document ready state
				return (Boolean) ((JavascriptExecutor) wdriver).executeScript("return document.readyState")
						.equals("complete");
			}
		});

	}
}
