package pages.serviceRequests.account.accupd;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class PromiseToPay extends BasePage {
	public PromiseToPay(TestContext context) {
		super(context);
	}

	private SelenideElement lst_pre_lan = $(By.name("promiseToPayDate"));

	public void promise_pay(String Date) {
		lst_pre_lan.should(appear);
		lst_pre_lan.selectOption(Date);
		ExtentCucumberAdapter.addTestStepLog("Enter Promise date  as " + Date);
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}