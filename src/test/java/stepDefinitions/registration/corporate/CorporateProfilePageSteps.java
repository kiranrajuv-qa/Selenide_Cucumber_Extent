package stepDefinitions.registration.corporate;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;
import io.cucumber.java.en.When;
import pages.registration.corporate.CustomerProfilePage;

public class CorporateProfilePageSteps {
	CustomerProfilePage customerProfilePageActions;
	CorpCustomer customer;
	TestContext testContext;

	public CorporateProfilePageSteps(TestContext context) {
		testContext = context;
		customerProfilePageActions = new CustomerProfilePage(testContext);
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}

	@When("capture corporate customer profile")
	public void capture_customer_profile() {
		customerProfilePageActions.capture_profile_basic_details(customer);
		customerProfilePageActions.capture_customer_categorization(customer);
		customerProfilePageActions.capture_profile_identification_details(customer);
		customerProfilePageActions.capture_profile_notification_details(customer);
		customerProfilePageActions.capture_profile_address_details(customer);
		customerProfilePageActions.capture_billing_and_payment_details(customer);
		customerProfilePageActions.capture_primary_contact_details(customer);
		customerProfilePageActions.lnk_billing_account();
	}
}