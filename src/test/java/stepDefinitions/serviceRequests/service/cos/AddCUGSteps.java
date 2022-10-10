package stepDefinitions.serviceRequests.service.cos;

import java.util.List;
import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.AddCUG;

public class AddCUGSteps {
	AddCUG addcugActions;
	TestContext testContext;

	public AddCUGSteps(TestContext context) {
		testContext = context;
		addcugActions = new AddCUG(testContext);
	}
	
	@When("add a CUG")
	public void add_cug(DataTable vasData) {
		List<List<String>> data = vasData.asLists();
		addcugActions.add_cug(data.get(0).get(1), data.get(1).get(1));
	}
}