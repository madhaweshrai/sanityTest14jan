package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseClasses.MultiBrowsers;

public class SelectClass extends MultiBrowsers {
	
	public static void selectDropDown(WebElement dropdownOptionText, String text){
		Select se=new Select(dropdownOptionText);
		se.selectByVisibleText(text);
	}

}
