package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.HybridToPrepaid;
;

public class HybridToPrepaidSteps {
	HybridToPrepaid HybridToPrepaidActions;
	CorpCustomer customer;
	TestContext testContext;

	public HybridToPrepaidSteps(TestContext context) {
		testContext = context;
		HybridToPrepaidActions = new HybridToPrepaid(testContext);
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}
	@When("Hybrid to Prepaid")
	public void hybrid_prepaid(DataTable vasData)  {
		List<List<String>> data = vasData.asLists();
		HybridToPrepaidActions.hybrid_prepaid(customer, data.get(0).get(1));
	}
}