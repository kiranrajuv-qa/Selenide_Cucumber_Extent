package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.PrepaidToPostpaid;

public class PrepaidToPostpaidSteps {
	PrepaidToPostpaid PrepaidToPostpaidActions;
	Customer customer;
	TestContext testContext;

	public PrepaidToPostpaidSteps(TestContext context) {
		testContext = context;
		PrepaidToPostpaidActions = new PrepaidToPostpaid(testContext);
		customer = FileReaderUtils.getInstance().getRetailRegistrationJsonReader().getRetailCustomer();
	}
	@When("Prepaid to Postpaid")
	public void Prepaid_postpaid(DataTable vasData) throws InterruptedException  {
		List<List<String>> data = vasData.asLists();
		PrepaidToPostpaidActions.prepaid_postpaid(customer, data.get(0).get(1));
		PrepaidToPostpaidActions.capture_vas_page();
		PrepaidToPostpaidActions.capture_customer_page(customer);
		PrepaidToPostpaidActions.capture_billing_page(customer);
	}
}