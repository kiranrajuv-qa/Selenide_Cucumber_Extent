/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.registration.retail;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import java.io.IOException;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;
import pages.common.BasePage;

public class OfferingPage extends BasePage {
	public OfferingPage(TestContext context) {
		super(context);
	}

	private SelenideElement list_category = $(By.name("CustomerCategory"));
	private SelenideElement list_subCategory = $(By.name("CustomerSubCategory"));
	private SelenideElement list_businessType = $(By.name("BusinessType"));
	private SelenideElement list_subService = $(By.name("ProductType"));
	private SelenideElement list_technology = $(By.name("Technology"));
	private SelenideElement list_country = $(By.name("Country"));
	private SelenideElement list_province = $(By.name("State"));
	private SelenideElement list_city = $(By.name("City"));
	private SelenideElement btn_search = $(By.xpath("(//button[@type='button'])[3]"));
	private SelenideElement txt_search = $(By.xpath("//input[@type='search']"));
	private SelenideElement lnk_select = $(By.linkText("Select"));
	private SelenideElement lnk_unselect = $(By.linkText("Unselect"));

	public void search_offering(Customer customer, String businessType, String offeringName) throws InterruptedException, IOException {
		list_category.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Search offering page loaded");
		list_category.selectOption(customer.offering.customerCategory);
		ExtentCucumberAdapter.addTestStepLog("Selected customer category as " + customer.offering.customerCategory);
		list_subCategory.selectOption(customer.offering.customerSubCategory);
		ExtentCucumberAdapter.addTestStepLog("Selected customer sub category as " + customer.offering.customerSubCategory);
		list_businessType.selectOption(businessType);
		ExtentCucumberAdapter.addTestStepLog("Selected business type as " + businessType);
		if (customer.offering.subService != null || !customer.offering.subService.equals("")
				|| !customer.offering.subService.equals("Voice")) {
			list_subService.selectOption(customer.offering.subService);
			ExtentCucumberAdapter.addTestStepLog("Selected sub service as " + customer.offering.subService);
		}
		if (customer.offering.technology != null || !customer.offering.technology.equals("")
				|| !customer.offering.technology.equals("GSM")) {
			list_technology.selectOption(customer.offering.technology);
			ExtentCucumberAdapter.addTestStepLog("Selected technology as " + customer.offering.technology);
		}
		list_country.selectOption(customer.profileDetails.address.country);
		ExtentCucumberAdapter.addTestStepLog("Selected country as " + customer.profileDetails.address.country);
		list_province.selectOption(customer.profileDetails.address.province);
		ExtentCucumberAdapter.addTestStepLog("Selected province as " + customer.profileDetails.address.province);
		list_city.selectOption(customer.profileDetails.address.city);
		ExtentCucumberAdapter.addTestStepLog("Selected city as " + customer.profileDetails.address.city);
		btn_search.click();
		ExtentCucumberAdapter.addTestStepLog("Clicked Search button");
		txt_search.val(offeringName);
		ExtentCucumberAdapter.addTestStepLog("Entered offering name");
		lnk_select.click();
		lnk_unselect.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Selected the offering");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}

	public void search_vas(String vasName) {
		txt_search.val(vasName);
		ExtentCucumberAdapter.addTestStepLog("Entered VAS Name");
		lnk_select.click();
		lnk_unselect.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Selected VAS");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}
}