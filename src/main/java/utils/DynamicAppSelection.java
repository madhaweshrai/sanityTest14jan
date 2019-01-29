package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import baseClasses.MultiBrowsers;

public class DynamicAppSelection extends MultiBrowsers {

	public static void appSelection(String AppName) {
		 WebElement eleTextClick = wdriver.findElement(By.xpath("//h4[text()=" + "'" + AppName + "'" + "]"));
		WebElement AppDashboard = wdriver
				.findElement(By.xpath("//h4[text()='" + AppName + "']/../..//div[2]/div/button[text()='Dashboard']"));
		JavaScriptPageLoading.waitForPageLoadCompletely();
		JavaScriptApiWait.waitForApiLoad();
//		AppDashboard.sendKeys("/n");
//		AppDashboard.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)wdriver;
		  executor.executeScript("arguments[0].scrollIntoView(true);", eleTextClick);
		  executor.executeScript("arguments[0].click();", AppDashboard);
		// ActionsClass.mouseOverAction(AppDashboard);
	}

}
