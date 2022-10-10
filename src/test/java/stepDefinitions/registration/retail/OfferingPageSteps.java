/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.registration.retail;

import java.io.IOException;
import java.util.List;

import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.testDataTypes.retail.Customer;
import framework.utils.FileReaderUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import pages.registration.retail.OfferingPage;

public class OfferingPageSteps {
	OfferingPage offeringPageActions;
	Customer customer;
	TestContext testContext;

	public OfferingPageSteps(TestContext context) {
		testContext = context;
		offeringPageActions = new OfferingPage(testContext);
		customer = FileReaderUtils.getInstance().getRetailRegistrationJsonReader().getRetailCustomer();
	}

	@When("select {string} with plan {string}")
	public void select_offering(String businessType, String offeringName) throws InterruptedException, IOException {
		offeringPageActions.search_offering(customer, businessType, offeringName);
	}

	@When("^select offering$")
	public void select_offering(DataTable offeringData) throws InterruptedException, IOException {
		List<List<String>> data = offeringData.asLists();
		String businessType = (String) testContext.scenarioContext.getContext(GenericContext.BUSINESS_TYPE);
		String offeringName = data.get(0).get(1);
		offeringPageActions.search_offering(customer, businessType, offeringName);
		offeringPageActions.go_to_next_page();
	}

	@When("^select VAS$")
	public void select_vas(DataTable vasData) throws InterruptedException, IOException {
		List<List<String>> data = vasData.asLists();
		String vasName = data.get(0).get(1);
		offeringPageActions.search_vas(vasName);
		offeringPageActions.go_to_next_page();
	}
}