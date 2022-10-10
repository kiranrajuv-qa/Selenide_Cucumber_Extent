package stepDefinitions.serviceRequests.profile.pflupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.profile.pflupd.ModifyIdentificationDetails;

public class ModifyIdentificationDetailsSteps {
	ModifyIdentificationDetails modifyidentificationdetailsAction;
	TestContext testContext;
	
	
	public ModifyIdentificationDetailsSteps(TestContext context)
	{
		testContext = context;
		modifyidentificationdetailsAction = new ModifyIdentificationDetails(context);
	}
	
	@When("modify identification details")
	public void change_billing_email(DataTable IdData) {
		List<List<String>> data = IdData.asLists();
		modifyidentificationdetailsAction.modify_profile_identification_details(data.get(0).get(1), data.get(1).get(1),data.get(2).get(1));
	}

}
