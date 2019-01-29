package superPageObject_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Panel_Page {
	/*
	 * This class is already added to Login_Page. This page is deprecated from
	 * the production Make sure you are removing from every class files."
	 */
	@FindBy(xpath = ("//a[text()='LOGIN']"))
	private WebElement loginbtn;
	@FindBy(xpath = ("//a[text()='Sign Up']"))
	private WebElement signup;
	@FindBy(xpath = ("html/body/div[4]/div/div[2]/div/form/div[1]/div/input"))
	private WebElement name;
	@FindBy(xpath = (".//*[@id='page-container']/div/div[2]/div/form/div[2]/div/input"))
	private WebElement email;
	@FindBy(xpath = (".//*[@id='pass1']"))
	private WebElement pwd;
	@FindBy(xpath = (".//*[@id='pass2']"))
	private WebElement confpwd;
	@FindBy(xpath = ("//button[text()='Sign Up']"))
	private WebElement signinbtn;

	public Panel_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginbutton() {
		loginbtn.click();
	}

	public void signup() {
		signup.click();
	}

	public void register(String nm, String em, String pw, String cpw) {
		name.sendKeys(nm);
		email.sendKeys(em);
		pwd.sendKeys(pw);
		confpwd.sendKeys(cpw);
		signinbtn.click();
	}

}