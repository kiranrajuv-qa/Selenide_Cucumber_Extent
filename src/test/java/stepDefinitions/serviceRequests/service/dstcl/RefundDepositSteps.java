package stepDefinitions.serviceRequests.service.dstcl;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.dstcl.RefundDeposit;

public class RefundDepositSteps {
	RefundDeposit RefundDepositActions;
	TestContext testContext;

	public RefundDepositSteps(TestContext context) {
		testContext = context;
		RefundDepositActions = new RefundDeposit(testContext);
	}

	@When("refund a deposit")
	public void add_deposit(DataTable depositData) {
		List<List<String>> data = depositData.asLists();
		RefundDepositActions.refund_deposit(data.get(0).get(1));
	}
}