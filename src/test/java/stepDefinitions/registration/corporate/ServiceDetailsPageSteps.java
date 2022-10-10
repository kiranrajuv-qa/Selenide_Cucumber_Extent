package stepDefinitions.registration.corporate;

import java.io.IOException;
import java.util.List;

import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.enums.RegistrationContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.registration.corporate.ServiceDetailsPage;

public class ServiceDetailsPageSteps {
	ServiceDetailsPage serviceDetailsPageActions;
	CorpCustomer customer;
	TestContext testContext;

	public ServiceDetailsPageSteps(TestContext context) {
		testContext = context;
		serviceDetailsPageActions = new ServiceDetailsPage(testContext);
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}

	@When("capture corporate service info")
	public void capture_corporate_service_info(DataTable offeringData) throws InterruptedException, IOException {
		List<List<String>> data = offeringData.asLists();
		String msisdnSelection = (String) testContext.scenarioContext.getContext(RegistrationContext.MSISDN_SELECTION);
		System.out.println(msisdnSelection);
		String offeringName = data.get(0).get(1);
		String msisdn = data.get(1).get(1);
		String simnumber = data.get(2).get(1);

		testContext.scenarioContext.setContext(GenericContext.MSISDN, msisdn);

		serviceDetailsPageActions.capture_service_details_county(customer);
		serviceDetailsPageActions.capture_service_details(customer, offeringName);
		serviceDetailsPageActions.msisdn_selection(customer, msisdnSelection, msisdn);
		serviceDetailsPageActions.sim_number_enter(customer, simnumber);
		serviceDetailsPageActions.go_to_next_page();
	}
}