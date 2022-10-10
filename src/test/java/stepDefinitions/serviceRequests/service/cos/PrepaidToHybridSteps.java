package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.PrepaidToHybrid;

public class PrepaidToHybridSteps {
	PrepaidToHybrid PrepaidToHybridActions;
	Customer customer;
	TestContext testContext;

	public PrepaidToHybridSteps(TestContext context) {
		testContext = context;
		PrepaidToHybridActions = new PrepaidToHybrid(testContext);
		customer = FileReaderUtils.getInstance().getRetailRegistrationJsonReader().getRetailCustomer();
	}
	@When("Prepaid to Hybrid")
	public void Prepaid_hybrid(DataTable vasData) throws InterruptedException  {
		List<List<String>> data = vasData.asLists();
		PrepaidToHybridActions.prepaid_hybrid(customer, data.get(0).get(1));
		PrepaidToHybridActions.capture_vas_page();
		PrepaidToHybridActions.capture_customer_page(customer);
		PrepaidToHybridActions.capture_billing_page(customer);
	}
}