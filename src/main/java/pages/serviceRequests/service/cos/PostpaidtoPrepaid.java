package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import pages.common.BasePage;

public class PostpaidtoPrepaid extends BasePage {
	public PostpaidtoPrepaid(TestContext context) {
		super(context);
	}
	//Migration Page
			private SelenideElement lst_city = $(By.id("city"));;
			private SelenideElement lst_province = $(By.id("province"));
			private SelenideElement lst_country = $(By.xpath("//select[contains(.,'Select Country')]"));
			private SelenideElement txt_vas_name = $(By.xpath("//input[@type='text']"));
			private SelenideElement lnk_select = $(By.linkText("Select"));
			private SelenideElement lnk_unselect = $(By.linkText("unselect"));
			private SelenideElement lbl_planName = $(By.xpath("//request-charges/div/div/div[1]/table/tbody/tr[1]/td[1]"));

			public void postpaid_prepaid(CorpCustomer customer,String planname) {
				lst_country.should(appear);
				lst_country.selectOption(customer.profileDetails.addressDetails.country);
				ExtentCucumberAdapter.addTestStepLog("Selected country as " + customer.profileDetails.addressDetails.country);
				lst_province.selectOption(customer.profileDetails.addressDetails.province);
				ExtentCucumberAdapter.addTestStepLog("Selected province as " + customer.profileDetails.addressDetails.province);
				lst_city.selectOption(customer.profileDetails.addressDetails.city);
				ExtentCucumberAdapter.addTestStepLog("Selected city as " + customer.profileDetails.addressDetails.city);
				txt_vas_name.should(appear);
				txt_vas_name.val(planname);
				lnk_select.should(appear);
				lnk_select.click();
				ExtentCucumberAdapter.addTestStepLog("Selected Prepaid plan as" + planname);
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
				lnk_unselect.should(appear);
				lbl_planName.should(appear);
				lbl_planName.shouldHave(text(planname));
				go_to_next_page();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
				ta_notes.should(appear);
				ta_notes.val(scenarioName + " added Successfully ");
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
				go_to_next_page();
			}
}
