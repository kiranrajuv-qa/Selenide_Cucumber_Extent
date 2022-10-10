package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class RemoveCUG extends BasePage {
	public RemoveCUG(TestContext context) {
		super(context);
	}
	private SelenideElement txt_vasName =null; 
	private SelenideElement lnk_select = $(By.xpath("//span[text()='SELECT']"));
	private SelenideElement lnk_unselect = $(By.xpath("//span[text()='UNSELECT']"));
	public void remove_cug(String vasName) {
		lnk_select.should(appear);
		txt_vasName= $(By.xpath("//tr/td[text()='" + vasName + "']/../td/span[text()='SELECT']"));
		txt_vasName.click();
		ExtentCucumberAdapter.addTestStepLog("Select RemoveCUG");
		lnk_unselect.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}