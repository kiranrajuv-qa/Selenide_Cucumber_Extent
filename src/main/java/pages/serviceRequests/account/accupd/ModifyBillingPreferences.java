package pages.serviceRequests.account.accupd;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyBillingPreferences extends BasePage {
	public ModifyBillingPreferences(TestContext context) {
		super(context);
	}

	private SelenideElement lst_pre_lan = $(By.name("presentationLanguage"));
	private SelenideElement txt_email = $(By.name("email"));
	private SelenideElement lst_region = $(By.name("billingregion"));

	public void billing_preference(String language, String Email, String billingregion) {
		lst_pre_lan.should(appear);
		lst_pre_lan.selectOption(language);
		ExtentCucumberAdapter.addTestStepLog("Selected Language as " + language);
		txt_email.val(Email);
		ExtentCucumberAdapter.addTestStepLog("Enter EmailId as " + Email);
		lst_region.selectOption(billingregion);
		ExtentCucumberAdapter.addTestStepLog("selected Billing Region as " + billingregion);
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}