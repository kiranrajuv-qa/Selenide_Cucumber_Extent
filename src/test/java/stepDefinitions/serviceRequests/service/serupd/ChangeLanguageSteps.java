package stepDefinitions.serviceRequests.service.serupd;

import java.util.List;

import framework.cucumberContext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.serviceRequests.service.serupd.ChangeLanguage;

public class ChangeLanguageSteps {
	ChangeLanguage ChangeLanguageActions;
	TestContext testContext;

	public ChangeLanguageSteps(TestContext context) {
		testContext = context;
		ChangeLanguageActions = new ChangeLanguage(testContext);
	}

	@When("Modify Preferred Language")
	public void change_language(DataTable langData) {
		List<List<String>> data = langData.asLists();
		ChangeLanguageActions.change_language(data.get(0).get(1));
	}
}