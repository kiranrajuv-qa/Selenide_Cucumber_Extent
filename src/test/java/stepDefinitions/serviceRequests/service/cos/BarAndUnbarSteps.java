package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.BarAndUnbar;

public class BarAndUnbarSteps {
	BarAndUnbar barAndUnbarActions;
	TestContext testContext;

	public BarAndUnbarSteps(TestContext context) {
		testContext = context;
		barAndUnbarActions = new BarAndUnbar(testContext);
	}
	@When("bar a service")
	public void bar_unbar(DataTable barData) {
		List<List<String>> data = barData.asLists();
		barAndUnbarActions.bar_unbar(data.get(0).get(1), data.get(1).get(1));
	}
}