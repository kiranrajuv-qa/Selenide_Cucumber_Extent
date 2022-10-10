package pages.serviceRequests.service.cos;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class AddVAS extends BasePage {
	private SelenideElement lst_category = $("#subCategory");
	private SelenideElement txt_vasName = $("tr:nth-child(1) > th > input");
	private SelenideElement lnk_select = $(By.xpath("//span[text()='SELECT']"));
	private SelenideElement lnk_unselect = $(By.xpath("//span[text()='UNSELECT']"));
	private SelenideElement lbl_vasName = $("div.ng-scope > table > tbody.ng-scope > tr:nth-child(1) > td:nth-child(2)");

	public AddVAS(TestContext context) {
		super(context);
	}

	public void add_vas(String category, String vasName) {
		if(!category.equals("Generic")) {
			lst_category.selectOption(category);
			ExtentCucumberAdapter.addTestStepLog("VAS Category selected: " + category);
		}
		txt_vasName.val(vasName);
		ExtentCucumberAdapter.addTestStepLog("Entered VAS Name");
		lnk_select.should(appear);
		lnk_select.click();
		ExtentCucumberAdapter.addTestStepLog("Selected VAS");
		lnk_unselect.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
		lbl_vasName.should(appear);
		lbl_vasName.shouldHave(text(vasName));
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		go_to_next_page();
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
		go_to_next_page();
	}
}
