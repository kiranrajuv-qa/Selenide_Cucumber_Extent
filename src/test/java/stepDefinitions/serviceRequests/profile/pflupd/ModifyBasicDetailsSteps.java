package stepDefinitions.serviceRequests.profile.pflupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.profile.pflupd.ModifyBasicDetails;

public class ModifyBasicDetailsSteps {
	ModifyBasicDetails ModifyProfileDetailsActions;
	TestContext testContext;
	
	public ModifyBasicDetailsSteps(TestContext context) {
		testContext = context;
		ModifyProfileDetailsActions = new ModifyBasicDetails(testContext);
	}
	
	@When("modify profile details")
	public void modify_Profile_details(DataTable Data){
		List<List<String>> data = Data.asLists();
		ModifyProfileDetailsActions.modify_Profile_details(data.get(0).get(1), data.get(1).get(1),data.get(2).get(1),data.get(3).get(1));	
	}

}
