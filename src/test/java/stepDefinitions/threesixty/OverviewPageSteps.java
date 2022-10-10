/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.threesixty;

import framework.cucumberContext.TestContext;
import io.cucumber.java.en.When;
import pages.threesixty.OverviewPage;

public class OverviewPageSteps {
	OverviewPage overviewPageActions;
	TestContext testContext;

	public OverviewPageSteps(TestContext context) {
		testContext = context;
		overviewPageActions = new OverviewPage(testContext);
	}

	@When("^go to service request page$")
	public void go_to_service_request_page() {
		overviewPageActions.open_service_request_page();
	}
	
	@When("^add new account service$")
	public void add_new_account_service() {
		overviewPageActions.go_to_add_account_service_page();
	}
}