package stepDefinitions.serviceRequests.service.cos;

import framework.cucumberContext.TestContext;
import pages.serviceRequests.service.cos.MSISDNSwap;

public class MSISDNSwapSteps {
	MSISDNSwap msisdnSwapActions;
	TestContext testContext;

	public MSISDNSwapSteps(TestContext context) {
		testContext = context;
		msisdnSwapActions = new MSISDNSwap(testContext);
	}
}