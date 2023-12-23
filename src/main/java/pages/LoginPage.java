package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class LoginPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);

	}

	@FindBy(id = "input-email")
	private WebElement emailfield;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMassage;

	public void enterEmailAdress(String emailText) {

		elementsUtils.typetextIntoElement(emailfield, emailText, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void enterPassword(String passwordText) {

		elementsUtils.typetextIntoElement(passwordField, passwordText, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public AccountPage clickOnLoginButton() {

		elementsUtils.clickOnElement(loginButton, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

		return new AccountPage(driver);

	}

	public String getWarningMassagetext() {
		return elementsUtils.gettextFromElement(warningMassage, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

}
