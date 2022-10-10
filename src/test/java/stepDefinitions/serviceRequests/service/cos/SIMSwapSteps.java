package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.SIMSwap;

public class SIMSwapSteps {
	SIMSwap simSwapActions;
	TestContext testContext;

	public SIMSwapSteps(TestContext context) {
		testContext = context;
		simSwapActions = new SIMSwap(testContext);
	}

	@When("sim swap")
	public void sim_swap(DataTable newSIMData) {
		List<List<String>> data = newSIMData.asLists();
		simSwapActions.sim_swap(data.get(0).get(1), data.get(1).get(1));
	}
}