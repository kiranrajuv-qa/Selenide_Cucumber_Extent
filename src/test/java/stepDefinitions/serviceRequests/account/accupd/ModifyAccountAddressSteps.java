package stepDefinitions.serviceRequests.account.accupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.account.accupd.ModifyAccountAddress;

public class ModifyAccountAddressSteps {
	ModifyAccountAddress ModifyAccountAddressActions;
	TestContext testContext;

	public ModifyAccountAddressSteps(TestContext context) {
		testContext = context;
		ModifyAccountAddressActions = new ModifyAccountAddress(testContext);
	}

	@When("modify billing address")
	public void service_details(DataTable AddData) {
		List<List<String>> data = AddData.asLists();
		ModifyAccountAddressActions.account_address(data.get(0).get(1), data.get(1).get(1), data.get(2).get(1),
				data.get(3).get(1), data.get(4).get(1), data.get(5).get(1));
	}
}