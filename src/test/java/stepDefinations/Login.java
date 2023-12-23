package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;

	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@When("User entered valid email adress {string} into email field")
	public void User_entered_valid_email_adress_into_email_field(String emailText) {
		loginPage.enterEmailAdress(emailText);

	}

	@And("User has entered valid password {string} into password field")
	public void user_has_entered_valid_password_into_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);

	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickOnLoginButton();

	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(accountPage.displaystatusofYourAccountInformation());

	}

	@When("User enters invalid email adress into email field")
	public void user_enters_invalid_email_adress_into_email_field() {

		commonUtils = new CommonUtils();
		loginPage.enterEmailAdress(commonUtils.getEmailWithTimeStamp());

	}

	@And("User enters invalid password {string} into passwrod field")
	public void user_enters_invalid_password_into_passwrod_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);

	}

	@Then("User should get a proper warning massage about credintials mismatch")
	public void user_should_get_a_proper_warning_massage_about_credintials_mismatch() {

		Assert.assertEquals(loginPage.getWarningMassagetext(), "Warning: No match for E-Mail Address and/or Password.");
		

	}

	@When("User dont enter email adress into email field")
	public void user_dont_enter_email_adress_into_email_field() {

		loginPage.enterEmailAdress("");

	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginPage.enterPassword("");

	}

}
