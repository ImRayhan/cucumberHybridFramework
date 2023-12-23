package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement teliphoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement slectPrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueOption;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement newslatterOption;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMassage;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNamewarningMassage;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement laststNamewarningMassage;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMassage;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement teliphoneWarningMassage;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMassage;

	public void enterFirstName(String firstNameText) {

		elementsUtils.typetextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void enterLasttName(String lastNameText) {

		elementsUtils.typetextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void enterEmail(String emailtext) {

		elementsUtils.typetextIntoElement(emailField, emailtext, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void entertelephoneNumber(String telephonetext) {

		elementsUtils.typetextIntoElement(teliphoneField, telephonetext, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void enterPassword(String passwordtext) {

		elementsUtils.typetextIntoElement(passwordField, passwordtext, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void enterConfirmPassword(String confirmPasswordtext) {

		elementsUtils.typetextIntoElement(confirmPasswordField, confirmPasswordtext,
				CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public void selectPrivacyPolicy() {

		elementsUtils.clickOnElement(slectPrivacyPolicy, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public AccountSuccessPage clickContinueButton() {

		elementsUtils.clickOnElement(continueOption, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

		return new AccountSuccessPage(driver);

	}

	public void selectNewslatter() {

		elementsUtils.clickOnElement(newslatterOption, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getWarningMassageText() {

		return elementsUtils.gettextFromElement(warningMassage, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getFirstNameWarningMassageText() {

		return elementsUtils.gettextFromElement(firstNamewarningMassage, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getLastNameWarningMassageText() {

		return elementsUtils.gettextFromElement(laststNamewarningMassage, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getEmailWarningMassageText() {

		return elementsUtils.gettextFromElement(emailWarningMassage, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getTelePhoneWarningMassageText() {

		return elementsUtils.gettextFromElement(teliphoneWarningMassage, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getPasswordWarningMassageText() {

		return elementsUtils.gettextFromElement(passwordWarningMassage, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

}
