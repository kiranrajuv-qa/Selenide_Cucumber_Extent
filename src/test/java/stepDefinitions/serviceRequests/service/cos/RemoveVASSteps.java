package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.RemoveVAS;

public class RemoveVASSteps {
	RemoveVAS removeVASActions;
	TestContext testContext;

	public RemoveVASSteps(TestContext context) {
		testContext = context;
		removeVASActions = new RemoveVAS(testContext);
	}

	@When("remove a VAS")
	public void add_cug(DataTable vasData) {
		List<List<String>> data = vasData.asLists();
		removeVASActions.remove_vas(data.get(0).get(1));
	}
}