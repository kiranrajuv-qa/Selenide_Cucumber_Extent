/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.registration.retail;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;
import framework.utils.FileReaderUtils;
import io.cucumber.java.en.When;
import pages.registration.retail.BillingAccountPage;

public class BillingAccountPageSteps {
	BillingAccountPage billingAccountPageActions;
	Customer customer;
	TestContext testContext;

	public BillingAccountPageSteps(TestContext context) {
		testContext = context;
		billingAccountPageActions = new BillingAccountPage(testContext);
		customer = FileReaderUtils.getInstance().getRetailRegistrationJsonReader().getRetailCustomer();
	}

	@When("^define billing account$")
	public void define_billing_account() {
		billingAccountPageActions.assert_details_from_profile(customer);
		billingAccountPageActions.assert_other_autopopulated_details(customer);
		billingAccountPageActions.capture_other_details(customer);
		billingAccountPageActions.go_to_next_page();
	}
}