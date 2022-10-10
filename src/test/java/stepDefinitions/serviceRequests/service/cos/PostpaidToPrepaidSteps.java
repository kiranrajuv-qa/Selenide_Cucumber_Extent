package stepDefinitions.serviceRequests.service.cos;

import java.util.List;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import framework.utils.FileReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.cos.PostpaidtoPrepaid;


public class PostpaidToPrepaidSteps {
	PostpaidtoPrepaid PostpaidtoPrepaidActions;
	CorpCustomer customer;
	TestContext testContext;

	public PostpaidToPrepaidSteps(TestContext context) {
		testContext = context;
		PostpaidtoPrepaidActions = new PostpaidtoPrepaid(testContext);
		customer = FileReaderUtils.getInstance().getCorporateRegistrationJsonReader().getCorpCustomer();
	}
	@When("Postpaid to Prepaid")
	public void postpaid_hybrid(DataTable vasData)  {
		List<List<String>> data = vasData.asLists();
		PostpaidtoPrepaidActions.postpaid_prepaid(customer, data.get(0).get(1));
	}
}