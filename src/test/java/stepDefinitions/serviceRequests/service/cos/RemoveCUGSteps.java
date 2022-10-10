package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.RemoveCUG;

public class RemoveCUGSteps {
	RemoveCUG removeCUGActions;
	TestContext testContext;

	public RemoveCUGSteps(TestContext context) {
		testContext = context;
		removeCUGActions = new RemoveCUG(testContext);
	}

	@When("remove a CUG")
	public void add_cug(DataTable vasData) {
		List<List<String>> data = vasData.asLists();
		removeCUGActions.remove_cug(data.get(0).get(1));
	}
}