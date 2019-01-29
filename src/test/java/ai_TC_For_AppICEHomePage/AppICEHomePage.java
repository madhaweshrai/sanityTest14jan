package ai_TC_For_AppICEHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClasses.MultiBrowsers;
import superPageObject_Classes.AppICE_Home_Login_Pages;
import utils.AssertAndWindowHandles;

public class AppICEHomePage extends MultiBrowsers {

	@Test(groups = "HeaderMenus", priority = 1)
	public void HomePageEle_Home() {

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		String homeValidation = wdriver.findElement(By.cssSelector("a[class='btn btn-theme']")).getText();
		AssertAndWindowHandles.validation(homeValidation, "Get a Live Demo");
	}

	@Test(groups = "HeaderMenus", priority = 2)
	public void HomePageEle_Product() {

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
        lp.homeBtnClick();
		lp.productClick();

	}

/*	@Test(groups = "HeaderMenus", priority = 3)
	public void HomePageEle_AboutUs() {

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.productClick();

	}*/

/*	@Test(groups = "HeaderMenus", priority = 4)
	public void HomePageEle_Blog() {

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.blog();
		System.out.println("                                                           ");
	}*/

		@Test(groups = "LoginPage", priority = 5)
	public void loginpage_ValidUnAndValidPw() {

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("validUserName", "validPassword");
		lp.logoutpage();
		System.out.println("Test1 case passed");
		lp.homeBtnClick();
		System.out.println("Test case passed");
	}

	@Test(groups = "LoginPage", priority = 10)
	public void loginpage_EmtUnAndValidPw() {

		System.out.println("********** Verifying the error msg of Login Page by Invalid Credencials **********");

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("invalidEmptyPassword", "validPassword");
		WebElement msg = wdriver.findElement(By.cssSelector("li[class*='parsley-required']"));
		String Actual_msg = msg.getText();
		System.out.println(Actual_msg);
		String Excepted_msg = "This value is required.";
		Assert.assertEquals(Actual_msg, Excepted_msg);
		System.out.println("Strings are equal");
		lp.homeBtnClick();
	}

	@Test(groups = "LoginPage", priority = 7)
	public void loginpage_ValidUnAndEmptPw() {

		System.out.println("********** Verifying the error msg of Login Page by Invalid Credencials **********");

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("validUserName", "invalidEmtpyUsername");
		WebElement msg = wdriver.findElement(By.cssSelector("li[class*='parsley-required']"));
		String Actual_msg = msg.getText();
		System.out.println(Actual_msg);
		String Excepted_msg = "This value is required.";
		Assert.assertEquals(Actual_msg, Excepted_msg);
		System.out.println("Strings are equal");
		lp.homeBtnClick();
	}

	@Test(groups = "LoginPage", priority = 8)
	public void loginpage_ValidUnAndInvalidPw() {

		System.out.println("********** Verifying the error msg of Login Page by Invalid Credencials **********");

		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("validUserName", "invalidPassword");
		WebElement msg = wdriver.findElement(By.cssSelector("strong#messagebox"));
		String Actual_msg = msg.getText();
		wdriver.findElement(By.cssSelector("span[class*='close']")).click();
		System.out.println(Actual_msg);
		String Excepted_msg = "Wrong Username or password";
		Assert.assertEquals(Actual_msg, Excepted_msg);
		System.out.println("Strings are equal");
	
	}

	@Test(groups = "LoginPage", priority = 9)
	public void loginpage_InValidUnAndValidPw() {
		System.out.println("********** Verifying the error msg of Login Page by Invalid Credencials **********");
	
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		lp.homeBtnClick();
		lp.loginbutton();
		lp.credencials("invalidUserName", "validPassword");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		WebElement msg = wdriver.findElement(By.cssSelector("strong#messagebox"));
		String Actual_msg = msg.getText();
		wdriver.findElement(By.cssSelector("span[class*='close']")).click();
		System.out.println(Actual_msg);
		String Excepted_msg = "Wrong Username or password";
		Assert.assertEquals(Actual_msg, Excepted_msg);
		System.out.println("Strings are equal");
		//lp.homeBtnClick();
	}

	@Test(groups = "LoginPage", priority = 6)
	public void loginpage_InValidRandAndvalid() {
	//	System.out.println("enter1");
		System.out.println("********** Verifying the error msg of Login Page by Invalid Credencials **********");
	//	System.out.println("enter2");
		 wdriver.navigate().refresh(); 
	//		System.out.println("enter3");
		AppICE_Home_Login_Pages lp = new AppICE_Home_Login_Pages(wdriver);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
	//	System.out.println("enter4");
		lp.homeBtnClick();
		
	//	System.out.println("enter5");
		lp.loginbutton();
	//	System.out.println("enter6");
		lp.credencials("invalidRandomUserName", "validPassword");
	//	System.out.println("enter7");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	//	System.out.println("enter8");
		WebElement msg = wdriver.findElement(By.cssSelector(".parsley-type"));
		String Actual_msg = msg.getText();
		System.out.println(msg.getText()+"  hi value is");
		// wdriver.findElement(By.cssSelector("span[class*='close']")).click();
		String Excepted_msg = "This value should be a valid email.";
		Assert.assertEquals(Actual_msg, Excepted_msg);
		
		
		System.out.println("Test case 2 passed");
		
		
	}

	/*
	 * @Test(groups = "LoginPage", priority = 11) public void
	 * Homeloginpage_ValidAndInvalid_TestCase5() { System.out.
	 * println("********** Verifying the error msg of Login Page by Invalid Credencials **********"
	 * ); Login_Page lp = new Login_Page(wdriver); lp.homeBtnClick();
	 * lp.loginbutton(); lp.credencials("validUserName", "invalidPassword");
	 * 
	 * }
	 */

}
