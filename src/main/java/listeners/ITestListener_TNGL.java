package listeners;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseClasses.MultiBrowsers;

public class ITestListener_TNGL implements ITestListener {

	WebDriver driver = null;
	String filePath = "./AppICE_Data_Driven_FW/com.appICE_Maven/screenshots";

	private static String fileSeperator = System.getProperty("file.separator");

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("This testcase execution has started " + result.getName());
		System.out.println("   ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("This testcase is passed " + result.getName());
		System.out.println("   ");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("***** Error " + result.getName() + " test has failed *****");

		driver = MultiBrowsers.wdriver;

		// String testClassName =
		// getTestClassName(result.getInstanceName()).trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + ".png";

		if (driver != null) {
			String imagePath = ".." + fileSeperator + "Screenshots" + fileSeperator + "Results"
					+ fileSeperator /* + testClassName */
					+ fileSeperator
					+ takeScreenShot(driver, screenShotName/* , testClassName */);
			System.out.println("Screenshot can be found : " + imagePath);
		}
	}

	public static String takeScreenShot(WebDriver driver,
			String screenShotName/* , String testName */) {
		try {
			File file = new File("Screenshots" + fileSeperator + "Results");
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filename = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());

			File targetFile = new File(
					"Screenshots" + fileSeperator + "Results" + fileSeperator + filename /* + testName */,
					screenShotName);

			FileUtils.copyFile(screenshotFile, targetFile);

			return screenShotName;
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			return null;
		}

		/*
		 * driver=MultiBrowsers.driver; //driver=TestBase.getDriver(); File
		 * scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * //The below method will save the screen shot in d drive with test
		 * method name try { FileUtils.copyFile(scrFile, new
		 * File(filePath+result.getName()+".PNG"));
		 * System.out.println("***Placed screen shot in "+filePath+" ***"); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("This testcase is has been skipped " + result.getName());
		System.out.println("   ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Start Of Execution(TEST)->" + context.getName());
		System.out.println("    ");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("END Of Execution(TEST)->" + context.getName());
		System.out.println("   ");
	}
}
