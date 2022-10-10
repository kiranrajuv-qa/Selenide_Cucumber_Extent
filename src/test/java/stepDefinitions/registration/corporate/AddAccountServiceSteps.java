package stepDefinitions.registration.corporate;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.enums.RegistrationContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.registration.corporate.AddAccountServicePage;

public class AddAccountServiceSteps {
	private AddAccountServicePage addAccountServicePageActions;
	private CorpCustomer customer;
	private TestContext testContext;
	private String accountId;

	public AddAccountServiceSteps(TestContext context) {
		testContext = context;
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}

	@When("^add new service$")
	public void add_new_service(DataTable serviceData) {
		List<List<String>> data = serviceData.asLists();
		String regType = (String) testContext.scenarioContext.getContext(RegistrationContext.REG_TYPE);
		String msisdnSelection = (String) testContext.scenarioContext.getContext(RegistrationContext.MSISDN_SELECTION);
		String kitNumber = data.get(0).get(1);
		String msisdn = data.get(1).get(1);
		String simNumber = data.get(2).get(1);
		String imsiNumber = data.get(3).get(1);

		testContext.scenarioContext.setContext(GenericContext.MSISDN, msisdn);

		if(regType.equals("Direct")) {
			addAccountServicePageActions.select_number(customer,msisdnSelection, msisdn);
			addAccountServicePageActions.enter_sim(simNumber, imsiNumber);
		}
		else {
			addAccountServicePageActions.enter_starter_kit(kitNumber, msisdn, simNumber, imsiNumber);
		}
	}

	@When("select {string} account")
	public void select_account(String accountSelection, DataTable accountData) {
		List<List<String>> data = accountData.asLists();
		if (accountSelection.equalsIgnoreCase("Existing")) {
			accountId = data.get(0).get(1);
			addAccountServicePageActions.select_existing_account(accountId);
		} else
			addAccountServicePageActions.capture_new_account(customer);
	}
}