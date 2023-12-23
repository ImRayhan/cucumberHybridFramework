package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class AccountSuccessPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement pageHeading;

	public String getPageHeading() {

		return elementsUtils.gettextFromElement(pageHeading, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

}
