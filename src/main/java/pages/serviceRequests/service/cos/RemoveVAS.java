package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class RemoveVAS extends BasePage {
	public RemoveVAS(TestContext context) {
		super(context);
	}
	private SelenideElement txt_vasName =null; 
	private SelenideElement lnk_select = $(By.linkText("SELECT"));
	private SelenideElement lnk_unselect = $(By.linkText("UNSELECT"));
	public void remove_vas(String vasName) {
		lnk_select.should(appear);
		txt_vasName= $(By.xpath("//tr/td[text()='" + vasName + "']/../td/span[text()='SELECT']"));
		txt_vasName.click();
		//txt_vasName= $(By.xpath("//*[contains(text(), '" + vasName + "')]"));
		//lnk_select.click();
		ExtentCucumberAdapter.addTestStepLog("Select Remove VAS");
		lnk_unselect.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		go_to_next_page();
	}
}
