/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.common;

import java.util.List;

import framework.cucumberContext.TestContext;

import framework.enums.GenericContext;
import framework.enums.RegistrationContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pages.common.HomePage;

public class HomePageSteps {
	HomePage homePageActions;
	TestContext testContext;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePageActions = new HomePage(testContext);
	}

	@Given("^enter registration flow$")
	public void enter_registration_flow() {
		homePageActions.is_loaded();
		String type = (String) testContext.scenarioContext.getContext(RegistrationContext.REG_TYPE);
		homePageActions.go_to_registration_flow(type);
	}

	@Given("enter {string} registration flow")
	public void enter_registration_flow(String type) {
		homePageActions.go_to_registration_flow(type);
	}

	@When("search with {string} msisdn")
	public void user_searches_with(String status, DataTable msisdnData) {
		List<List<String>> data = msisdnData.asLists();
		String msisdn = data.get(0).get(1);
		testContext.scenarioContext.setContext(GenericContext.MSISDN, msisdn);
		homePageActions.search_by_msisdn(msisdn, status);
	}

	@Then("^registration cancelled successfully$")
	public void assert_homepage() {
		homePageActions.is_loaded();
	}

	@When("^start credit vetting$")
	public void start_credit_vetting() {
		homePageActions.start_vetting();
	}
}