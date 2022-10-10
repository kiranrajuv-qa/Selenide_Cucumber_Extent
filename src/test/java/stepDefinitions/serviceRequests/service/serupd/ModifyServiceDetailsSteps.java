package stepDefinitions.serviceRequests.service.serupd;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;
import framework.utils.FileReaderUtils;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.serupd.ModifyServiceDetails;

public class ModifyServiceDetailsSteps {
	ModifyServiceDetails ModifyServiceDetailsActions;
	Customer customer;
	TestContext testContext;

	public ModifyServiceDetailsSteps(TestContext context) {
		testContext = context;
		ModifyServiceDetailsActions = new ModifyServiceDetails(testContext);
		customer = FileReaderUtils.getInstance().getRetailRegistrationJsonReader().getRetailCustomer();
	}

	@When("Modify Service Details")
	public void service_details() {
		ModifyServiceDetailsActions.service_details(customer);
	}
}