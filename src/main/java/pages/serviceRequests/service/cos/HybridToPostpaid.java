package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import com.codeborne.selenide.ElementsCollection;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import pages.common.BasePage;

public class HybridToPostpaid extends BasePage {
	public HybridToPostpaid(TestContext context) {
		super(context);
	}
	//Migration Page
		private SelenideElement lst_city = $(By.id("city"));;
		private SelenideElement lst_province = $(By.id("province"));
		private SelenideElement lst_country = $(By.xpath("//select[contains(.,'Select Country')]"));
		private SelenideElement txt_vas_name = $(By.xpath("//input[@type='text']"));
		private ElementsCollection lnk_select = $$(By.linkText("Select"));
		private SelenideElement lnk_unselect = $(By.linkText("unselect"));
		private SelenideElement lbl_planName = $(By.xpath("//request-charges/div/div/div[1]/table/tbody/tr[1]/td[1]"));

		public void hybrid_postpaid(CorpCustomer customer,String planname) {
			lst_country.should(appear);
			lst_country.selectOption(customer.profileDetails.addressDetails.country);
			ExtentCucumberAdapter.addTestStepLog("Selected country as " + customer.profileDetails.addressDetails.country);
			lst_province.selectOption(customer.profileDetails.addressDetails.province);
			ExtentCucumberAdapter.addTestStepLog("Selected province as " + customer.profileDetails.addressDetails.province);
			lst_city.selectOption(customer.profileDetails.addressDetails.city);
			ExtentCucumberAdapter.addTestStepLog("Selected city as " + customer.profileDetails.addressDetails.city);
			txt_vas_name.should(appear);
			txt_vas_name.val(planname);
			lnk_select.shouldHave(size(1));
			lnk_select.get(0).click();
			ExtentCucumberAdapter.addTestStepLog("Selected Postpaid plan as" + planname);
			Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
			lnk_unselect.should(appear);
			lbl_planName.should(appear);
			lbl_planName.shouldHave(text(planname));
			ta_notes.should(appear);
			go_to_next_page();
			Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
			ta_notes.val(scenarioName + " added Successfully ");
			Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
			go_to_next_page();
		}
	}
