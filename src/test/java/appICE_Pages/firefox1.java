package appICE_Pages;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

public class firefox1 {

	public WebDriver driver;

  @Parameters("browser")

  @BeforeClass

  // Passing Browser parameter from TestNG xml

  public void beforeTest(String browser) {

  // If the browser is Firefox, then do this

  if(browser.equalsIgnoreCase("firefox")) {

	  driver = new FirefoxDriver();

  // If browser is IE, then do this	  

  }else if (browser.equalsIgnoreCase("chrome")) { 

	  // Here I am setting up the path for my IEDriver

	  System.setProperty("webdriver.chrome.driver", "E:\\AppICE_Data_Driven_FW\\com.appICE_Maven\\exeFiles\\chromedriver.exe");

	  driver = new InternetExplorerDriver();

  } 

  // Doesn't the browser type, lauch the Website

  driver.get("http://www.store.demoqa.com"); 

  }

  // Once Before method is completed, Test method will start

  @Test public void login() throws InterruptedException {

	System.out.println("firefox");

	}  

  @AfterClass public void afterTest() {

		//driver.quit();

	}

}