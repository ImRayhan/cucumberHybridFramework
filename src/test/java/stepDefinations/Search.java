package stepDefinations;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private DriverFactory driverFactory;

	@Given("User opens application")
	public void user_opens_application() {

		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();

	}

	@When("User enters valid product {string} into search box fiueld")
	public void user_enters_valid_product_into_search_box_fiueld(String validProductText) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProductText);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {

		searchResultPage = homePage.clickOnSearchButton();
	}

	@Then("User should get valid product displayed ins earch result")
	public void user_should_get_valid_product_displayed_ins_earch_result() {

		assertTrue(searchResultPage.displayStatusofValidProduct());

	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {

		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProductText);

	}

	@Then("User should get a massage about no product matching")
	public void user_should_get_a_massage_about_no_product_matching() {

		Assert.assertEquals(searchResultPage.getMessageText(), "There is no product that matches the search criteria.");

	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {

		homePage = new HomePage(driver);

	}

}
