package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class SIMSwap extends BasePage {
	public SIMSwap(TestContext context) {
		super(context);
	}
	private SelenideElement txt_sim_number = $(By.name("simNumber"));
	private SelenideElement txt_imsi_number = $(By.name("imsiNumber"));

	public void sim_swap(String simNumber, String imsiNumber) {		
		txt_sim_number.val(simNumber).pressTab();
		ExtentCucumberAdapter.addTestStepLog("Entered SIM Number");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		txt_imsi_number.shouldHave(value(imsiNumber));
		ExtentCucumberAdapter.addTestStepLog("Validated IMSI Number");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
		go_to_next_page();
	}
}
