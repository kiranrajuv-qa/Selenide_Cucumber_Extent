/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.common;

import framework.cucumberContext.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.common.BasePage;

public class CommonPageSteps {
	BasePage commonPageActions;
	TestContext testContext;
	
	public CommonPageSteps(TestContext context) {
		testContext = context;
		commonPageActions = new BasePage(testContext);
	}

	@When("^submit the registration flow$")
	public void submit_flow() {
		commonPageActions.submit_reg_flow();
	}

	@When("^submit the flow$")
	public void submit_srq_flow() {
		commonPageActions.submit_srq_flow();
	}

	@When("^cancel the flow$")
	public void cancel_flow() {
		commonPageActions.cancel_flow();
	}

	@Then("^customer registered successfully$")
	public void registered_successfully() {
		commonPageActions.finish_reg_flow();
	}
}