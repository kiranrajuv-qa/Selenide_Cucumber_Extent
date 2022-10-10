package stepDefinitions.serviceRequests.service.cos;

import framework.cucumberContext.TestContext;
import pages.serviceRequests.service.cos.TransferOfService;

public class TransferOfServiceSteps {
	TransferOfService TransferOfServiceActions;
	TestContext testContext;

	public TransferOfServiceSteps(TestContext context) {
		testContext = context;
		TransferOfServiceActions = new TransferOfService(testContext);
	}
}