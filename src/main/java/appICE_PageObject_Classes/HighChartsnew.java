package appICE_PageObject_Classes;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import utils.ExplicitWait;



public class HighChartsnew extends ExplicitWait {
	
	public HighChartsnew(WebDriver driver) {
		
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void organicCount()
	{
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * String ele1 = driver.findElement(By.cssSelector(
		 * "//tspan[class='highcharts-text-outline']")).getText();
		 * System.out.println(ele1);
		 */

	//	String x = "document.getElementsByClassName('highcharts-data-labels highcharts-series-0 highcharts-bar-series highcharts-color-0 highcharts-tracker')";
		//String y = "document.getElementsByClassName('highcharts-data-labels highcharts-series-0 highcharts-bar-series highcharts-color-0 highcharts-tracker')[i].getElementsByTagName('tspan')[1].textContent";
		//JavascriptExecutor js = (JavascriptExecutor) driver;

	/*	ArrayList<?> ele1 = (ArrayList<?>) ((JavascriptExecutor) driver).executeScript(x);

		for (int i = 0; i < ele1.size(); i++) {
	        ArrayList<?> ele2 = (ArrayList<?>) ((JavascriptExecutor) driver).executeScript(y);
			System.out.println(ele2);*/
			
			/*var outerClass = document.getElementsByClassName("highcharts-label highcharts-data-label highcharts-data-label-color-0"); 
			var valArry=[]; 
			for (var i = 0; i < outerClass.length; i += 1) { 
			  valArry.push(outerClass[i].getElementsByTagName('tspan')[1].textContent); 
			} 
			valArry;*/

		//
		
		//jQuery to return all the elements
		String c = "return $('#frame id').contents().find(\"div[id='highcharts-index']\").contents().find(\"g[class='highcharts-series-group'] > g[class='highcharts-markers highcharts-series-0 highcharts-tracker'] > path[fill='#ft5es5']\").get()";
		//jQuery to return tool-tip data
		 String tool1 = "return $('#' frame id).contents().find(\"div[id='highcharts-index']\").contents().find(\"g[class='highcharts-tooltip']>text>\").get();";

		 //Execute the jQuery to find the Path elements for all the data elements in the line chart
		 ArrayList webE = (ArrayList)((JavascriptExecutor) wdriver).executeScript(c);
		
		 wdriver.switchTo().frame("frame id");
		 //Mouse over on each path element and read the tooltip data
		 for (int i = 0; i < webE.size(); i++) {  
		  //perform Mouseover on the element
		  Actions builder=new Actions(wdriver);
		  builder.moveToElement((WebElement) webE.get(i)).click().build().perform();
		 
		//  builder.moveToElement(toElement);

		  wdriver.switchTo().defaultContent();
		   //Execute the jQuery to find the tooltip data
		   ArrayList webE2 = (ArrayList)((JavascriptExecutor) wdriver).executeScript(tool1);
		   wdriver.switchTo().frame("frame id");
		   System.out.println(webE2.get(0).toString() );
		   //+ webE2.get(0).getText()
		   System.out.println(webE2.get(1).toString());
		   System.out.println("High chart data done");
		   //.getTagName() + webE2.get(1).getText()
		//   System.out.println(webE2.get(2).getTagName() + webE2.get(2).getText());
	}
	}

}