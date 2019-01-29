package baseClasses;
//package com.AppICE_BaseClasses;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//
//public class TakeScreenShot {
//	  private static WebDriver driver;
//	  
//	  public static void init(WebDriver d) {
//	      driver = d;
//	  }
//	  
//	  public static void takeSnapShot(String methodName) {
//	      String folderBaseDriver = null;
//	      if (driver instanceof InternetExplorerDriver) {
//	          folderBaseDriver = "Internet Explore";
//	      } else if (driver instanceof ChromeDriver) {
//	          folderBaseDriver = "Chrome";
//	      } else if (driver instanceof FirefoxDriver) {
//	          folderBaseDriver = "Firefox";
//	      }
//	      String screenshootDir = "path to your folder you want to save the screenshot"+File.separator + folderBaseDriver;
//	      File f = new File(screenshootDir);
//	      if (!f.exists() || !f.isDirectory()) {
//	          f.mkdirs();
//	      }
//	      File output = null;
//	      File file;
//	      if (folderBaseDriver.equalsIgnoreCase("Internet Explore")) {
//	          ScreenRegion s = new DesktopScreenRegion();
//	          try {
//	              ImageIO.write(s.capture(), "png", new File(screenshootDir
//	                      + File.separator + methodName + ".png"));
//	          } catch (IOException e) {
//	              e.printStackTrace();
//	          }
//	      }else{
//	          output = ((TakesScreenshot) driver)
//	                  .getScreenshotAs(OutputType.FILE);
//	          file = new File(screenshootDir, methodName + ".png");
//	          try {
//	              FileUtils.copyFile(output, file);
//	          } catch (IOException e) {
//	              e.printStackTrace();
//	          }
//	      }
//
//	  }
//	  }