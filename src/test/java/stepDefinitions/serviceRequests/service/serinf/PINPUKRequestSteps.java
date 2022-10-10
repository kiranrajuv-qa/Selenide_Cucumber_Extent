package stepDefinitions.serviceRequests.service.serinf;

import framework.cucumberContext.TestContext;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.serinf.PINPUKRequest;

public class PINPUKRequestSteps {

	PINPUKRequest PINPUKRequestActions;
	TestContext testContext;

	public PINPUKRequestSteps(TestContext context) {
		testContext = context;
		PINPUKRequestActions = new PINPUKRequest(testContext);
	}

	@When("request for pin puk")
	public void pin_puk() {
		PINPUKRequestActions.pin_puk();
	}
}