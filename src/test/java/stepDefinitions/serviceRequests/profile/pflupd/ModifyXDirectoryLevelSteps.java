package stepDefinitions.serviceRequests.profile.pflupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.profile.pflupd.ModifyXDirectoryLevel;

public class ModifyXDirectoryLevelSteps {
	ModifyXDirectoryLevel modifyxdirectorylevelAction;
	TestContext testContext;
	
	public ModifyXDirectoryLevelSteps(TestContext context)
	{
		testContext=context;
		modifyxdirectorylevelAction = new ModifyXDirectoryLevel(context);
	}
	
	@When("modify x directory level")
	public void modify_directory(DataTable Dlevel) {
		List<List<String>> data = Dlevel.asLists();
		modifyxdirectorylevelAction.modify_xdirectory(data.get(0).get(1));
	}
	

}
