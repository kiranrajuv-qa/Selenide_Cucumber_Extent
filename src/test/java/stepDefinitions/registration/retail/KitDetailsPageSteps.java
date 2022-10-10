/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.registration.retail;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.enums.RegistrationContext;
import framework.testDataTypes.retail.Customer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.registration.retail.KitDetailsPage;

public class KitDetailsPageSteps {
	KitDetailsPage kitDetailsPageActions;
	Customer customer;
	TestContext testContext;

	public KitDetailsPageSteps(TestContext context) {
		testContext = context;
		kitDetailsPageActions = new KitDetailsPage(testContext);
		customer = FileReaderUtils.getInstance().getRetailRegistrationJsonReader().getRetailCustomer();
	}

	@When("^select number$")
	public void enter_kit_details(DataTable kitDetails) {
		List<List<String>> data = kitDetails.asLists();
		String msisdnSelection = (String) testContext.scenarioContext.getContext(RegistrationContext.MSISDN_SELECTION);
		String msisdn = data.get(0).get(1);
		String simNumber = data.get(1).get(1);
		String imsiNumber = data.get(2).get(1);
		testContext.scenarioContext.setContext(GenericContext.MSISDN, msisdn);
		kitDetailsPageActions.choose_msisdn(customer, msisdnSelection, msisdn);
		kitDetailsPageActions.enter_sim(simNumber, imsiNumber);
		kitDetailsPageActions.go_to_next_page();
	}

	@When("^enter starter kit details$")
	public void enter_starter_kit_details(DataTable kitDetails) {
		List<List<String>> data = kitDetails.asLists();
		String kitNumber = data.get(0).get(1);
		String msisdn = data.get(1).get(1);
		String simNumber = data.get(2).get(1);
		String imsiNumber = data.get(3).get(1);
		testContext.scenarioContext.setContext(GenericContext.MSISDN, msisdn);
		kitDetailsPageActions.enter_starter_kit(kitNumber, msisdn, simNumber, imsiNumber);
	}

	@When("select MSISDN {string} and SIM {string}")
	public void select_offering(String msisdn, String simNumber, String imsiNumber) {
		kitDetailsPageActions.choose_msisdn(customer, "Manual", msisdn);
		kitDetailsPageActions.enter_sim(simNumber, imsiNumber);
		kitDetailsPageActions.go_to_next_page();
	}
}