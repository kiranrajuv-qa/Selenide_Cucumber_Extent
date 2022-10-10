package stepDefinitions.serviceRequests.profile.pflupd; 

import java.util.List;


import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.profile.pflupd.ModifyAddressDetails;

public class ModifyAddressDetailsSteps {
	ModifyAddressDetails ModifyAddressDetailsActions;
	TestContext testcontext;
	
	public ModifyAddressDetailsSteps(TestContext context)
	{
		testcontext=context;
		ModifyAddressDetailsActions = new ModifyAddressDetails(context);
	}
	
	@When("changed address details")
	public void modify_profile_address_details(DataTable AddData)
	{
		List<List<String>> data = AddData.asLists();
		ModifyAddressDetailsActions.modify_profile_address_details(data.get(0).get(1), data.get(1).get(1), data.get(2).get(1), data.get(3).get(1), data.get(4).get(1));
		
	}

}
