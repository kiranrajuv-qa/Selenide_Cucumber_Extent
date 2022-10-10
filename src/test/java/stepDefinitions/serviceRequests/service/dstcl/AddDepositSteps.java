package stepDefinitions.serviceRequests.service.dstcl;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.dstcl.AddDeposit;

public class AddDepositSteps {
	AddDeposit AddDepositActions;
	TestContext testContext;

	public AddDepositSteps(TestContext context) {
		testContext = context;
		AddDepositActions = new AddDeposit(testContext);
	}

	@When("add a deposit")
	public void add_deposit(DataTable depositData) {
		List<List<String>> data = depositData.asLists();
		AddDepositActions.add_deposit(data.get(0).get(1));
	}
}