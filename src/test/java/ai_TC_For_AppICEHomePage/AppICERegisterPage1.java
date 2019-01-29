package ai_TC_For_AppICEHomePage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppICERegisterPage1 {
	
	@Test
	public void fun1() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", ".\\exeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://panel.appice.io");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement ele= driver.findElement(By.xpath(".//*[@id='header-navbar']/ul/li[5]/a"));
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath(".//*[@id='header-navbar']/ul/li[5]/a")));
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath(".//*[@id='page-container']/div/div[2]/form/div[5]/a")));
	

		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("" );

		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("" );

		driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("" );

		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("" );

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Sign up']")).click();
		
		
		
		if (js.executeScript("arguments[0].click()", driver.findElements(By.xpath("//li[text()='This value is required.']"))) != null) {
			List<WebElement> emptyValues = driver.findElements(By.xpath("//li[text()='This value is required.']"));
			Iterator<WebElement> errors = emptyValues.iterator();
			while (errors.hasNext()) {
				WebElement row = errors.next();
				Assert.assertEquals("This value is required.", row.getText());
			}
		}
		
			else
			{
			System.out.println("hii");
			}
			
		//driver.close();
		
		
	}
}


