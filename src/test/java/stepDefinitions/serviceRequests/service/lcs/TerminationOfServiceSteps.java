package stepDefinitions.serviceRequests.service.lcs;

import framework.cucumberContext.TestContext;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.lcs.TerminationOfService;

public class TerminationOfServiceSteps {
	TerminationOfService TerminationOfServiceActions;
	TestContext testContext;

	public TerminationOfServiceSteps(TestContext context) {
		testContext = context;
		TerminationOfServiceActions = new TerminationOfService(testContext);
	}

	@When("terminate a service")
	public void service_erase() {
		TerminationOfServiceActions.service_erase();
	}
}