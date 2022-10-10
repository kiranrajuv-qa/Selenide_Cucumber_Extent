package pages.serviceRequests.service.lcs;

import static com.codeborne.selenide.Condition.appear;

import com.codeborne.selenide.Selenide;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class TerminationOfService extends BasePage {
	public TerminationOfService(TestContext context) {
		super(context);
	}
	public void service_erase() {
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}