package stepDefinitions.serviceRequests.common;

import static org.testng.Assert.assertEquals;

import framework.cucumberContext.TestContext;
import io.cucumber.java.en.Then;
import pages.common.BasePage;

public class CommonPageSteps {
	BasePage commonPageActions;
	TestContext testContext;

	public CommonPageSteps(TestContext context) {
		testContext = context;
		commonPageActions = new BasePage(testContext);
	}

	@Then("^flow submitted successfully$")
	public void flow_submitted_successfully() {
		String testStatus = commonPageActions.finish_srq_flow();
		assertEquals(testStatus, "PASSED");
	}
}