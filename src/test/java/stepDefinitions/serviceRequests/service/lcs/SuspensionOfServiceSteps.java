/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.serviceRequests.service.lcs;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.lcs.SuspensionOfService;

public class SuspensionOfServiceSteps {
	SuspensionOfService suspPageActions;
	TestContext testContext;

	public SuspensionOfServiceSteps(TestContext context) {
		testContext = context;
		suspPageActions = new SuspensionOfService(testContext);
	}

	@When("^choose suspension type$")
	public void do_suspension(DataTable suspData) {
		List<List<String>> data = suspData.asLists();
		suspPageActions.choose_susp_type(data.get(0).get(1));
	}
}