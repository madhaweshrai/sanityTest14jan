package utils;

import java.util.Set;

import org.testng.Assert;

import baseClasses.MultiBrowsers;

public class AssertAndWindowHandles extends MultiBrowsers {

	public static void validation(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void windowHandles() {
		String mainWindow = wdriver.getWindowHandle();
		Set<String> handles = wdriver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(mainWindow)) {
				String tittle = wdriver.switchTo().window(handle).getTitle();
				System.out.println(tittle);
				break;
			}

		}
		wdriver.switchTo().window(mainWindow);
	}
	
	
	
	
}
