package stepDefinitions.serviceRequests.service.lcs;

import framework.cucumberContext.TestContext;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.lcs.RevokeSuspensionOfService;

public class RevokeSuspensionOfServiceSteps {
	RevokeSuspensionOfService RevokeSuspensionOfServiceActions;
	TestContext testContext;

	public RevokeSuspensionOfServiceSteps(TestContext context) {
		testContext = context;
		RevokeSuspensionOfServiceActions = new RevokeSuspensionOfService(testContext);
	}

	@When("^revoke suspension of service$")
	public void revoke_susp() {
		RevokeSuspensionOfServiceActions.revoke_susp();
	}
}