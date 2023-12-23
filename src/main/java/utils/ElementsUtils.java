package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtils {
	WebDriver driver;

	public ElementsUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSecounds) {

		WebElement webElement = waitForelement(element, durationInSecounds);
		webElement.click();
	}

	public void typetextIntoElement(WebElement element, String textTobeTyped, long durationInSecounds) {

		WebElement webElement = waitForelement(element, durationInSecounds);
		webElement.clear();
		webElement.sendKeys(textTobeTyped);

	}

	public WebElement waitForelement(WebElement element, long durationInSecounds) {
		WebElement webElement = null;
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecounds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;

	}

	public void selectOptionInDropdown(WebElement element, String dropdownOption, long durationInSecounds) {

		WebElement webElement = waitForelement(element, durationInSecounds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropdownOption);

	}

	public void acceptAlert(long durationInSecounds) {

		Alert alert = waitForAlert(durationInSecounds);
		alert.accept();

	}

	public void dismissAlert(long durationInSecounds) {

		Alert alert = waitForAlert(durationInSecounds);
		alert.dismiss();

	}

	public Alert waitForAlert(long durationInSecounds) {

		Alert alert = null;

		try {
			WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecounds));
			alert = Wait.until(ExpectedConditions.alertIsPresent());

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;

	}

	public void mouseHoverAndClick(WebElement element, long durationInSecounds) {

		WebElement webElement = waitForVisibilityOffElement(element, durationInSecounds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();

	}

	public WebElement waitForVisibilityOffElement(WebElement element, long durationInSecounds) {
		WebElement webElement = null;

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecounds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;

	}

	public void javascriptClick(WebElement element, long durationInSecounds) {

		WebElement webElement = waitForVisibilityOffElement(element, durationInSecounds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", webElement);

	}

	public void javascriptType(WebElement element, String textTobeTyped, long durationInSecounds) {
		WebElement webElement = waitForVisibilityOffElement(element, durationInSecounds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textTobeTyped + "'", webElement);

	}

	public String gettextFromElement(WebElement element, long durationInSecounds) {
		WebElement webElement = waitForelement(element, durationInSecounds);
		return webElement.getText();

	}

	public boolean displayStatusOfElement(WebElement element, long durationInSecounds) {

		try {

			WebElement webElement = waitForVisibilityOffElement(element, durationInSecounds);
			return webElement.isDisplayed();
		} catch (Throwable e) {
			return false;
		}

	}

}
