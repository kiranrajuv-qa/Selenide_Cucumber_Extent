package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.HybridToPostpaid;

public class HybridToPostpaidSteps {
	HybridToPostpaid HybridToPostpaidActions;
	CorpCustomer customer;
	TestContext testContext;

	public HybridToPostpaidSteps(TestContext context) {
		testContext = context;
		HybridToPostpaidActions = new HybridToPostpaid(testContext);
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}
	@When("Hybrid to Postpaid")
	public void hybrid_postpaid(DataTable vasData)  {
		List<List<String>> data = vasData.asLists();
		HybridToPostpaidActions.hybrid_postpaid(customer, data.get(0).get(1));
	}
}