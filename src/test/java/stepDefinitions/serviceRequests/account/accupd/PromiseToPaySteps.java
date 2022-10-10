package stepDefinitions.serviceRequests.account.accupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.account.accupd.PromiseToPay;

public class PromiseToPaySteps {
	PromiseToPay PromiseToPayActions;
	TestContext testContext;

	public PromiseToPaySteps(TestContext context) {
		testContext = context;
		PromiseToPayActions = new PromiseToPay(testContext);
	}

	@When("choose promise to pay date")
	public void promise_pay(DataTable Data) {
		List<List<String>> data = Data.asLists();
		PromiseToPayActions.promise_pay(data.get(0).get(1));
	}
}