package pages.serviceRequests.service.serinf;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Selenide;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class PINPUKRequest extends BasePage {
	public PINPUKRequest(TestContext context) {
		super(context);
	}

	public void pin_puk() {
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}