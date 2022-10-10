package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.ChangePlan;

public class ChangePlanSteps {
	ChangePlan changePlanActions;
	TestContext testContext;

	public ChangePlanSteps(TestContext context) {
		testContext = context;
		changePlanActions = new ChangePlan(testContext);
	}
	
	@When("choose a plan")
	public void change_plan(DataTable planData) {
		List<List<String>> data = planData.asLists();
		changePlanActions.choose_plan(data.get(0).get(1));
	}
}