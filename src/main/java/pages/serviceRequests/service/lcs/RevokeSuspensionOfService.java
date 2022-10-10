package pages.serviceRequests.service.lcs;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Selenide;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class RevokeSuspensionOfService extends BasePage {
	public RevokeSuspensionOfService(TestContext context) {
		super(context);
	}

	public void revoke_susp() {
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}