package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class AccountPage {

	WebDriver driver;
	private ElementsUtils elementsUtils;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformation;

	public boolean displaystatusofYourAccountInformation() {

		return elementsUtils.displayStatusOfElement(editYourAccountInformation, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

}
