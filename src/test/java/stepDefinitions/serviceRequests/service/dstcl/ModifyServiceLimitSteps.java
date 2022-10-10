package stepDefinitions.serviceRequests.service.dstcl;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.dstcl.ModifyServiceLimit;

public class ModifyServiceLimitSteps {
	ModifyServiceLimit ModifyServiceLimitActions;
	TestContext testContext;

	public ModifyServiceLimitSteps(TestContext context) {
		testContext = context;
		ModifyServiceLimitActions = new ModifyServiceLimit(testContext);
	}

	@When("modify service limit")
	public void service_limit(DataTable limitData) {
		List<List<String>> data = limitData.asLists();
		ModifyServiceLimitActions.service_limit(data.get(0).get(1), data.get(1).get(1));
	}
}