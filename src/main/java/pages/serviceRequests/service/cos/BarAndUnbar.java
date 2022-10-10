package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class BarAndUnbar extends BasePage {
	public BarAndUnbar(TestContext context) {
		super(context);
	}

	private SelenideElement lst_barservice = $(By.linkText("Barred Service"));
	private SelenideElement lst_unbarservice = $(By.linkText("Unbarred Service"));
	private SelenideElement txt_barName = $(By.xpath("//input[@type='text']"));
	private SelenideElement lnk_select = $(By.xpath("//span[contains(.,'SELECT')]"));
	private SelenideElement lnk_unselect = $(By.xpath("//span[contains(.,'UNSELECT')]"));

	public void bar_unbar(String servicetype, String barname) {
		if(servicetype.equals("Barred Service")) {
			lst_barservice.selectOption(servicetype);
			ExtentCucumberAdapter.addTestStepLog("service selected: " + servicetype);
		}
		else{
			lst_unbarservice.selectOption(servicetype);
			ExtentCucumberAdapter.addTestStepLog("service selected: " + servicetype);
		}
		txt_barName.val(barname);
		ExtentCucumberAdapter.addTestStepLog("Entered barunbar Name");
		lnk_select.should(appear);
		lnk_select.click();
		ExtentCucumberAdapter.addTestStepLog("Selected barunbar");
		lnk_unselect.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
	}
}
