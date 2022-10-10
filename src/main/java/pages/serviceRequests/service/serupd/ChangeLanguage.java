package pages.serviceRequests.service.serupd;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ChangeLanguage extends BasePage {
	public ChangeLanguage(TestContext context) {
		super(context);
	}
	private SelenideElement lst_lang = $(By.name("preferredLang"));

	public void change_language(String language) {	
		lst_lang.should(appear);
		lst_lang.selectOption(language);
		ExtentCucumberAdapter.addTestStepLog("Selected Language as  " + language);
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}
