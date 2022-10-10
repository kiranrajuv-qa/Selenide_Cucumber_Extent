package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.PostpaidToHybrid;


public class PostpaidToHybridSteps {
	PostpaidToHybrid PostpaidToHybridActions;
	CorpCustomer customer;
	TestContext testContext;

	public PostpaidToHybridSteps(TestContext context) {
		testContext = context;
		PostpaidToHybridActions = new PostpaidToHybrid(testContext);
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}
	@When("Postpaid to Hybrid")
	public void postpaid_hybrid(DataTable vasData)  {
		List<List<String>> data = vasData.asLists();
		PostpaidToHybridActions.postpaid_hybrid(customer, data.get(0).get(1));
	}
}