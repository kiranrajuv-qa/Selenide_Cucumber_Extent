package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.AddVAS;

public class AddVASSteps {
	AddVAS addVASActions;
	TestContext testContext;

	public AddVASSteps(TestContext context) {
		testContext = context;
		addVASActions = new AddVAS(testContext);
	}

	@When("^add a VAS$")
	public void add_vas(DataTable vasData) {
		List<List<String>> data = vasData.asLists();
		addVASActions.add_vas(data.get(0).get(1), data.get(1).get(1));
	}
}