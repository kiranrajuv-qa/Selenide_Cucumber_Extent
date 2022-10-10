package stepDefinitions.registration.corporate;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;
import io.cucumber.java.en.When;
import pages.registration.corporate.BillingAccountPage;

public class BillingAccountPageSteps {
	BillingAccountPage billingAccountPageActions;
	CorpCustomer customer;
	TestContext testContext;

	public BillingAccountPageSteps(TestContext context) {
		testContext = context;
		billingAccountPageActions = new BillingAccountPage(testContext);
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}

	@When("define corporate billing account")
	public void define_corp_billing_account() {
		billingAccountPageActions.capture_billing_account_details(customer);
		billingAccountPageActions.assert_other_autopopulated_details(customer);
		billingAccountPageActions.capture_other_details(customer);
		billingAccountPageActions.go_to_next_page();
	}
}