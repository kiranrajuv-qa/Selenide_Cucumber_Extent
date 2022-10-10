package stepDefinitions.serviceRequests.account.accupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.account.accupd.ModifyBillingPreferences;

public class ModifyBillingPreferencesSteps {
	ModifyBillingPreferences modifyBillingPreferencesActions;
	TestContext testContext;

	public ModifyBillingPreferencesSteps(TestContext context) {
		testContext = context;
		modifyBillingPreferencesActions = new ModifyBillingPreferences(testContext);
	}

	@When("change email for billing")
	public void change_billing_email(DataTable EmailData) {
		List<List<String>> data = EmailData.asLists();
		modifyBillingPreferencesActions.billing_preference(data.get(0).get(1), data.get(1).get(1), data.get(2).get(1));
	}
}