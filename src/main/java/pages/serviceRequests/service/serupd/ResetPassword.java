package pages.serviceRequests.service.serupd;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ResetPassword extends BasePage {
	public ResetPassword(TestContext context) {
		super(context);
	}
	private SelenideElement lst_rest = $(By.name("resetType"));

	public void reset_password(String type) {	
		lst_rest.should(appear);
		lst_rest.selectOption(type);
		ExtentCucumberAdapter.addTestStepLog("Selected Language as  " + lst_rest);
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}
