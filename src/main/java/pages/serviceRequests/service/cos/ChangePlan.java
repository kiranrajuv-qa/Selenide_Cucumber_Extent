package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Condition.appear;

import com.codeborne.selenide.Selenide;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ChangePlan extends BasePage {
	public ChangePlan(TestContext context) {
		super(context);
	}
	
	public void choose_plan(String planName) {
		super.choose_plan(planName);
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		go_to_next_page();
	}
}