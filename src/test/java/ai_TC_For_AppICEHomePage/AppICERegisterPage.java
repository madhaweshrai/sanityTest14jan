package ai_TC_For_AppICEHomePage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClasses.MultiBrowsers;
import baseClasses.TestDataFromConfig;
import superPageObject_Classes.AppICE_Home_Login_Pages;
import utils.ConfigReader;

public class AppICERegisterPage extends MultiBrowsers {

	// Data is taken from property files
	@DataProvider(name = "keywords")
	public Object[][] data() throws Exception {
		HashMap<String, String[]> dataSet = new TestDataFromConfig("./propertyFiles/RegisterData_config.properties")
				.getData();
		int size = dataSet.size();
		Object[][] creds = new Object[size][size];
		String fullNameStrings[] = dataSet.get("fullName");
		String emailIDStrings[] = dataSet.get("emailID");
		String passwordStrings[] = dataSet.get("password");
		String confirmPasswordStrings[] = dataSet.get("confirmPassword");
		// String errorValidationStrings[] = dataSet.get("errorValidation");

		for (int i = 0; i < size; i++) {
			creds[i][0] = fullNameStrings[i];
			creds[i][1] = emailIDStrings[i];
			creds[i][2] = passwordStrings[i];
			creds[i][3] = confirmPasswordStrings[i];
			// creds[i][4] = errorValidationStrings[i];

		}
		return creds;
	}

	@Test(groups = "RegisterPage", priority = 2)
	public void RegisterPageValidData() {
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		wdriver.findElement(By.xpath("//a[text()='here']")).click();
	
		lp.register(ConfigReader.getData("validFullName"), ConfigReader.getData("validEmail"),
				ConfigReader.getData("validPassword"), ConfigReader.getData("validConfPassword"));
		lp.signup();

		WebElement validationError = wdriver
				.findElement(By.xpath("//div/strong[text()='Email Id already registered.']"));
		if (validationError.isDisplayed()) {
			System.out.println("User is already registered");
		} else {
			Assert.fail();
		}
		wdriver.findElement(By.xpath("html/body/div[1]/span")).click();
	}

	@Test(dataProvider = "keywords", description = "RegisterPage_InValidData", groups = "RegisterPage", priority = 1)
	public void RegisterPageInValidData(String fullName, String emailID, String password, String confirmPassword)
			throws Exception {
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();

		wdriver.findElement(By.xpath("//a[text()='here']")).click();

		wdriver.findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
		wdriver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("" + fullName);

		wdriver.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
		wdriver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("" + emailID);

		wdriver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		wdriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("" + password);

		wdriver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).clear();
		wdriver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("" + confirmPassword);

		Thread.sleep(1000);
		wdriver.findElement(By.xpath("//button[text()='Sign up']")).click();
		Thread.sleep(4000);

		if (wdriver.findElements(By.xpath("//li[text()='This value is required.']")) != null) {
			List<WebElement> emptyValues = wdriver.findElements(By.xpath("//li[text()='This value is required.']"));
			Iterator<WebElement> errors = emptyValues.iterator();
			while (errors.hasNext()) {
				WebElement row = errors.next();
				Assert.assertEquals("This value is required.", row.getText());
			}
		}

		else if (wdriver.findElement(By.xpath("//li[text()='This value should be a valid email.']")) != null) {

			String emailValidation = wdriver.findElement(By.xpath("//li[text()='This value should be a valid email.']"))
					.getText();
			Assert.assertEquals(emailValidation, "This value should be a valid email.");

		}

		else if (wdriver.findElement(By.xpath("//li[text()='Passwords do not match']")) != null) {
			String passwordValidation = wdriver.findElement(By.xpath("//li[text()='Passwords do not match']"))
					.getText();
			Assert.assertEquals(passwordValidation, "Passwords do not match");
		}

		else {
			Assert.fail();
		}

		lp.homeBtnClick();

	}
}
