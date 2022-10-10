package stepDefinitions.serviceRequests.service.serupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.serupd.ResetPassword;

public class ResetPasswordSteps {
	ResetPassword ResetPasswordActions;
	TestContext testContext;

	public ResetPasswordSteps(TestContext context) {
		testContext = context;
		ResetPasswordActions = new ResetPassword(testContext);
	}

	@When("^reset the password$")
	public void reset_password(DataTable resetData) {
		List<List<String>> data = resetData.asLists();
		ResetPasswordActions.reset_password(data.get(0).get(1));
	}
}