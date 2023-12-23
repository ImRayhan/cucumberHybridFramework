package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class HomePage {

	WebDriver driver;
	private ElementsUtils elementsUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenue;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement resisterOption;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBoxField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	public void clickOnMyAccount() {
		elementsUtils.clickOnElement(myAccountDropMenue, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public LoginPage selectLoginOption() {

		elementsUtils.clickOnElement(loginOption, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);

	}

	public RegisterPage selectRegisterOption() {

		elementsUtils.clickOnElement(resisterOption, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

		return new RegisterPage(driver);

	}

	public void enterProductIntoSearchBox(String ProductText) {

		elementsUtils.typetextIntoElement(searchBoxField, ProductText, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public SearchResultPage clickOnSearchButton() {

		elementsUtils.clickOnElement(searchButton, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

		return new SearchResultPage(driver);

	}

}
