package stepDefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;

	@Given("User navigates to regester account page")
	public void user_navigates_to_regester_account_page() {
		
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();

	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLasttName(dataMap.get("Lastname"));
		commonUtils = new CommonUtils();
		registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
		registerPage.entertelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));

	}

	@When("User enters the below fields with the duplicate email")
	public void User_enters_the_below_fields_with_the_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLasttName(dataMap.get("Lastname"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.entertelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.selectPrivacyPolicy();

	}

	@Given("User clicks on continue button")
	public void user_clicks_on_continue_button() {

		accountSuccessPage = registerPage.clickContinueButton();

	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {

		Assert.assertEquals(accountSuccessPage.getPageHeading(), "Your Account Has Been Created!");

	}

	@When("User selects yes for newslatter")
	public void user_selects_yes_for_newslatter() {

		registerPage.selectNewslatter();

	}

	@Then("User should het a proper warning about duplicate email")
	public void user_should_het_a_proper_warning_about_duplicate_email() {

		Assert.assertEquals(registerPage.getWarningMassageText(), "Warning: E-Mail Address is already registered!");

	}

	@Then("User should get proper warning massage for ebery mandatory fields")
	public void user_should_get_proper_warning_massage_for_ebery_mandatory_fields() {

		Assert.assertTrue(
				registerPage.getWarningMassageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals(registerPage.getFirstNameWarningMassageText(),
				"First Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getLastNameWarningMassageText(),
				"Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(registerPage.getEmailWarningMassageText(), "E-Mail Address does not appear to be valid!");

		Assert.assertEquals(registerPage.getTelePhoneWarningMassageText(),
				"Telephone must be between 3 and 32 characters!");

		Assert.assertEquals(registerPage.getPasswordWarningMassageText(),
				"Password must be between 4 and 20 characters!");

	}

}
