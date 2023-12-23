package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementsUtils;

public class SearchResultPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement validHpProduct;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement messageText;

	public boolean displayStatusofValidProduct() {

		return elementsUtils.displayStatusOfElement(validHpProduct, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

	public String getMessageText() {

		return elementsUtils.gettextFromElement(messageText, CommonUtils.EXPLISIT_WAIT_BASIC_TIME);

	}

}
