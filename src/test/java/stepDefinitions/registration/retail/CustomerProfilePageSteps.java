/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.registration.retail;

import framework.constants.Generic;
import framework.constants.Registration;
import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.enums.RegistrationContext;
import framework.testDataTypes.retail.Customer;
import framework.utils.FileReaderUtils;
import io.cucumber.java.en.When;
import pages.registration.retail.CustomerProfilePage;

public class CustomerProfilePageSteps {
	CustomerProfilePage customerProfilePageActions;
	Customer customer;
	TestContext testContext;

	public CustomerProfilePageSteps(TestContext context) {
		testContext = context;
		customerProfilePageActions = new CustomerProfilePage(testContext);
		customer = FileReaderUtils.getInstance().getRetailRegistrationJsonReader().getRetailCustomer();
	}

	@When("^capture customer profile$")
	public void capture_customer_profile() {
		if(testContext.getScenarioContext().getContext(GenericContext.BUSINESS_TYPE).equals(Generic.BUSINESS_TYPE_POSTPAID) ||
				testContext.getScenarioContext().getContext(GenericContext.BUSINESS_TYPE).equals(Generic.BUSINESS_TYPE_HYBRID))
			customerProfilePageActions.risk_category_should_be_derived();
		customerProfilePageActions.validations_should_be("Pending");
		customerProfilePageActions.capture_profile_basic_details(customer);
		if(testContext.getScenarioContext().getContext(RegistrationContext.REG_TYPE).equals(Registration.REG_TYPE_RETAIL_WS))
			customerProfilePageActions.assert_customer_categorization(customer);
		else if(testContext.getScenarioContext().getContext(RegistrationContext.REG_TYPE).equals(Registration.REG_TYPE_RETAIL_SP))
			customerProfilePageActions.capture_customer_categorization(customer);
		customerProfilePageActions.capture_profile_notification_details(customer);
		customerProfilePageActions.capture_profile_address_details(customer);
		customerProfilePageActions.capture_primary_contact_details(customer);
		customerProfilePageActions.capture_billing_and_payment_details(customer);
		customerProfilePageActions.capture_profile_identification_details(customer);
		customerProfilePageActions.assert_service_user_details(customer);
		customerProfilePageActions.capture_service_details(customer);
		customerProfilePageActions.validations_should_be("Done");
		customerProfilePageActions.go_to_next_page();
	}
}