package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class AddCUG extends BasePage {
	public AddCUG(TestContext context) {
		super(context);
	}
	private SelenideElement txt_cug_name = null;
	private SelenideElement lnk_select = $(By.xpath("//span[text()='SELECT']"));
	private SelenideElement txt_search = $(By.name("search"));
	private SelenideElement lnk_search = $(By.xpath("//button[contains(.,'Search')]"));
	private SelenideElement lnk_select_group = $(By.name("cugGroup"));
	private SelenideElement lbl_CUGName = $(By.xpath("//request-charges/div/div/div[1]/table/tbody/tr[1]/td[1]"));

	public void add_cug(String cug , String group) {
		lnk_select.should(appear);
		txt_cug_name= $(By.xpath("//tr/td[text()='" + cug + "']/../td/span[text()='SELECT']"));
		txt_cug_name.click();
		ExtentCucumberAdapter.addTestStepLog("Selected Add Cug Name");
		go_to_next_page();
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		lbl_CUGName.should(appear);
		lbl_CUGName.shouldHave(text(cug));
		txt_search.val(group);
		lnk_search.click();
		lnk_select_group.selectOption(group);
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		go_to_next_page();
	}
}
