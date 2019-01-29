package superPageObject_Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AssertAndWindowHandles;
import utils.JavaScriptApiWait;
import utils.JavaScriptPageLoading;


public class Login_Page {

	@FindBy(css = ("input[type='email']"))
	private WebElement emailadd;
	@FindBy(css = ("input#password"))
	private WebElement password;
	@FindBy(css = ("button[type='submit']"))
	private WebElement loginbtn;

	@FindBy(xpath = ("html/body/div[5]/div[1]/div/ul/li[2]/a/span"))
	private WebElement logoutdropdown;

	@FindBy(xpath = ("//a[text()='Log Out']"))
	private WebElement logoutbtn;

	@FindBy(id = ("messagebox"))
	private WebElement error_msg;

	@FindBy(id = "0026")
	private WebElement dashBoardText;
	@FindBy(id = "001")
	private WebElement appsText;

	// The below elements are of Panel page
	@FindBy(xpath = ("//a[text()='HOME']"))
	private WebElement homeBtn;
	@FindBy(css = "a[class*='btn-theme']")
	private WebElement getADemoBtn;
	@FindBy(css = "a[class*='btn-outline'][href='#service']")
	private WebElement seeProductFeaturesBtn;
	@FindBy(css = "a#subscribeLink")
	private WebElement subcribeBtn;

	@FindBy(xpath = "//a[text()='PRODUCT']")
	private WebElement productBtn;
	@FindBy(xpath = "//a[text()='ABOUT US']")
	private WebElement aboutUsBtn;
	@FindBy(xpath = "//a[text()='BLOG']")
	private WebElement blogBtn;
	@FindBy(xpath = ("//a[text()='LOGIN']"))
	private WebElement loginbten;

	@FindBy(xpath = "//a[text()='here']")
	private WebElement clickHere;
	@FindBy(xpath = ("//input[@placeholder='Full Name']"))
	private WebElement name;
	@FindBy(xpath = ("//input[@placeholder='Email Address']"))
	private WebElement email;
	@FindBy(xpath = ("//input[@placeholder='Password']"))
	private WebElement pwd;
	@FindBy(xpath = ("//input[@placeholder='Confirm Password']"))
	private WebElement confpwd;
	@FindBy(xpath = ("//button[text()='Sign up']"))
	private WebElement signinbtn;

	public Login_Page(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void homeBtnClick() {
		
		JavaScriptPageLoading.waitForPageLoadCompletely();
		homeBtn.click();
		AssertAndWindowHandles.validation(homeBtn.getText(), "HOME");
	}

	public void productClick() {
		JavaScriptPageLoading.waitForPageLoadCompletely();
		productBtn.click();
		AssertAndWindowHandles.validation(productBtn.getText(), "PRODUCT");
	}

	public void aboutUS() {
		JavaScriptPageLoading.waitForPageLoadCompletely();
		aboutUsBtn.click();
		AssertAndWindowHandles.validation(aboutUsBtn.getText(), "ABOUT US");
	}

	public void blog() {

		AssertAndWindowHandles.validation(blogBtn.getText(), "BLOG");
		blogBtn.click();
		AssertAndWindowHandles.windowHandles();

	}

	public void loginpage() {

	}

	public void credencials(String un, String pwd) {
		/*
		 * emailadd.sendKeys(un); password.sendKeys(pwd); loginbtn.click();
		 */

		File file = new File("./propertyFiles/dataFile.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		emailadd.sendKeys(prop.getProperty(un));
		password.sendKeys(prop.getProperty(pwd));
		loginbtn.click();
	}

	public void logoutpage() {
		logoutdropdown.click();
		logoutbtn.click();
	}

	public void Errormsg() {
		String msg = error_msg.getText();
		System.out.println(msg);
	}

	public void textCompare() {
		String excepted = "Dashboard     ";
		String ele1 = dashBoardText.getText();
		if (ele1.equalsIgnoreCase(excepted)) {
			System.out.println("Both are equal");
		} else {
			System.out.println("Both are not equal");
		}

		String excepted1 = "My Apps";
		String ele2 = appsText.getText();
		if (ele2.equalsIgnoreCase(excepted1)) {
			System.out.println("Both are equal");
		} else {
			System.out.println("Both are not equal");
		}

	}

	// Panel page methods
	public void loginbutton() {
		loginbten.click();
	}

	public void signup() {
		signinbtn.click();
	}

	public void register(String nm, String em, String pw, String cpw) {
		name.sendKeys(nm);
		email.sendKeys(em);
		pwd.sendKeys(pw);
		confpwd.sendKeys(cpw);
	}
	


}

// public void textcompare()
// {
// String xlpath = "d:/AppICE.ods";
// String sheet = "sheet2";
//
// int rc = RowsAndCells.getRowCount(xlpath, sheet);
//
// for(int i=1;i<=rc;i++)
// {
// for(int j=0;j<=3;j++)
// {
// String db = RowsAndCells.getcellvalue(xlpath, sheet, i, 0);
//
// String mat = RowsAndCells.getcellvalue(xlpath, sheet, i, 1);
// System.out.println(db);
// String excepted = ("Dashboard ");
// Assert.assertEquals(db, excepted);
//
// // boolean ee1 = db.equals(dashBoardText);
//// boolean ee2 = mat.equals(appsText);
//// System.out.println(ee1);
//// System.out.println(ee2);
// }
// }
