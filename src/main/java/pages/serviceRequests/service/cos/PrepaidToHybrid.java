package pages.serviceRequests.service.cos;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;

import pages.common.BasePage;

public class PrepaidToHybrid extends BasePage {
	public PrepaidToHybrid(TestContext context) {
		super(context);
	}

	// Migration Page
	private SelenideElement lst_city = $(By.id("city"));
	private SelenideElement lst_province = $(By.id("province"));
	private SelenideElement lst_country = $(By.xpath("//select[contains(.,'Select Country')]"));
	private SelenideElement txt_vas_name = $(By.xpath("//input[@type='text']"));
	private ElementsCollection lnk_select = $$(By.linkText("Select"));
	private SelenideElement lnk_unselect = $(By.linkText("unselect"));
	// CUSTOMER PAGE
	private SelenideElement txt_first_name = $(By.id("firstName"));
	private SelenideElement txt_last_name = $(By.name("lastName"));
	private SelenideElement txt_dob = $(By.id("dob"));
	private SelenideElement lst_pref_lang = $(By.id("preferred-language"));
	private SelenideElement txt_email = $(By.id("email"));
	private SelenideElement lst_preferred_medium = $(By.xpath("//div[2]/div[2]/div/div/div/div"));
	private SelenideElement lst_notification_email = $(By.xpath("//*[contains(text(),'Email')]"));
	// BASIC DETAILS
	private SelenideElement txt_billing_name = $(By.name("billingAccountName"));
	private SelenideElement txt_fname = $(By.id("firstName"));
	private SelenideElement txt_lname = $(By.name("lastName"));
	// ADDRESS DETAILS
	private SelenideElement txt_street = $(By.name("streetName"));
	private SelenideElement txt_postbox_num = $(By.id("postBoxNumber"));
	private SelenideElement lst_region = $(By.id("region"));
	private SelenideElement lst_locality = $(By.id("locality"));
	// RELATIONSHIP MANAGER DETAILS
	private SelenideElement lst_relation_mang = $(By.name("relationshipManager"));
	// ACCOUNT TYPE
	private SelenideElement lst_account_type = $(By.id("accounttype"));
	private SelenideElement lst_limit = $(By.id("accountlimitType"));
	private SelenideElement lst_tax_pol = $(By.id("taxPolicy"));
	// BILLING DETALS
	private SelenideElement lst_bill_cycle = $(By.name("billCycle"));
	private SelenideElement lst_bill_medium = $(
			By.xpath("//div[@name='billDispatchDetails']//li[normalize-space()='Email']"));
	private SelenideElement lst_bill_dispath = $(By.xpath("//div[@name='billDispatchDetails']"));
	private SelenideElement txt_bill_dispatch_email = $(By.xpath("(//input[@id='email'])[2]"));
	private SelenideElement lst_Region = $(By.name("billingregion"));
	private SelenideElement lst_bill_currency = $(By.id("preferred-bill-currency"));
	private SelenideElement lbl_planName = $(By.xpath("//request-charges/div/div/div[1]/table/tbody/tr[1]/td[1]"));

	public void prepaid_hybrid(Customer customer, String planname) {
		lst_country.should(appear);
		lst_country.selectOption(customer.profileDetails.address.country);
		ExtentCucumberAdapter.addTestStepLog("Selected country as " + customer.profileDetails.address.country);
		lst_province.selectOption(customer.profileDetails.address.province);
		ExtentCucumberAdapter.addTestStepLog("Selected province as " + customer.profileDetails.address.province);
		lst_city.selectOption(customer.profileDetails.address.city);
		ExtentCucumberAdapter.addTestStepLog("Selected city as " + customer.profileDetails.address.city);
		txt_vas_name.should(appear);
		txt_vas_name.val(planname);
		lnk_select.shouldHave(size(1));
		lnk_select.get(0).click();
		lbl_planName.should(appear);
		lbl_planName.shouldHave(text(planname));
		ExtentCucumberAdapter.addTestStepLog("Selected Hybrid plan as" + planname);
		lnk_unselect.should(appear);
		go_to_next_page();
	}
	public void capture_vas_page() {
		go_to_next_page();
	}

	public void capture_customer_page(Customer customer) {
		txt_first_name.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_first_name.val(customer.profileDetails.basicDetails.firstName);
		ExtentCucumberAdapter.addTestStepLog("Enter Firstname  as " + customer.profileDetails.basicDetails.firstName);
		txt_last_name.val(customer.profileDetails.basicDetails.lastName);
		ExtentCucumberAdapter.addTestStepLog("Enter Lastname  as " + customer.profileDetails.basicDetails.lastName);
		txt_dob.val(customer.profileDetails.basicDetails.dob).pressTab();
		ExtentCucumberAdapter.addTestStepLog("Select DOB as " + customer.profileDetails.basicDetails.dob);
		lst_pref_lang.selectOption(customer.profileDetails.notificationDetails.language);
		ExtentCucumberAdapter
				.addTestStepLog("Select Language as " + customer.profileDetails.notificationDetails.language);
		lst_preferred_medium.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_preferred_medium.click();
		lst_notification_email.click();
		lst_preferred_medium.click();
		ExtentCucumberAdapter.addTestStepLog("Selected Notification Preferred Medium as Email");
		txt_email.val(customer.profileDetails.notificationDetails.email);
		ExtentCucumberAdapter.addTestStepLog("Enter Emailid as " + customer.profileDetails.notificationDetails.email);
		go_to_next_page();
	}

	public void capture_billing_page(Customer customer) {
		if (txt_billing_name.exists()) {
			txt_billing_name.val(customer.profileDetails.basicDetails.firstName);
			ExtentCucumberAdapter
					.addTestStepLog("Enter Billing Name as " + customer.profileDetails.basicDetails.firstName);
		}
		txt_fname.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_fname.shouldHave(value(customer.profileDetails.basicDetails.firstName));
		ExtentCucumberAdapter
				.addTestStepLog("Validated Firstname as " + customer.profileDetails.basicDetails.firstName);
		txt_lname.shouldHave(value(customer.profileDetails.basicDetails.lastName));
		ExtentCucumberAdapter.addTestStepLog("Validated Lastname as " + customer.profileDetails.basicDetails.lastName);
		// ADDRESS DEATILS
		txt_street.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_street.should(appear);
		txt_street.val(customer.profileDetails.address.street);
		ExtentCucumberAdapter.addTestStepLog("Enter street  as " + customer.profileDetails.address.street);
		txt_postbox_num.val(customer.profileDetails.address.postCode);
		ExtentCucumberAdapter.addTestStepLog("Enter postcode  as " + customer.profileDetails.address.postCode);
		lst_region.selectOption(customer.profileDetails.address.province);
		ExtentCucumberAdapter.addTestStepLog("Enter Region  as " + customer.profileDetails.address.province);
		lst_locality.selectOption(customer.profileDetails.address.city);
		ExtentCucumberAdapter.addTestStepLog("Enter locality  as " + customer.profileDetails.address.city);
		// RELATIONSHIP MANAGER DETAILS
		lst_relation_mang.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_relation_mang.should(appear);
		lst_relation_mang.selectOption(customer.accountDetails.others.relationshipManager);
		ExtentCucumberAdapter.addTestStepLog(
				"Select Releationship Manager  as " + customer.accountDetails.others.relationshipManager);
		// ACCOUNT TYPE
		lst_account_type.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_account_type.selectOption(customer.accountDetails.accountType);
		ExtentCucumberAdapter.addTestStepLog("Select Account Type as " + customer.accountDetails.accountType);
		lst_limit.selectOption(customer.accountDetails.limitType);
		ExtentCucumberAdapter.addTestStepLog("Select account Limit as " + customer.accountDetails.limitType);
		lst_tax_pol.selectOption(customer.accountDetails.others.taxPolicy);
		ExtentCucumberAdapter.addTestStepLog("Select taxPolicy  as " + customer.accountDetails.others.taxPolicy);
		// BILLCYCLE
		lst_bill_cycle.selectOption(customer.accountDetails.operatorAccountManager.billCycle);
		ExtentCucumberAdapter
				.addTestStepLog("Selected Bill Cycle as " + customer.accountDetails.operatorAccountManager.billCycle);
		lst_bill_dispath.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_bill_dispath.click();
		lst_bill_medium.click();
		lst_bill_dispath.click();
		txt_bill_dispatch_email.val((customer.profileDetails.notificationDetails.email));
		ExtentCucumberAdapter
				.addTestStepLog("Enter Bill Dispatch Email as " + customer.profileDetails.notificationDetails.email);
		lst_Region.selectOption((customer.accountDetails.operatorAccountManager.billingRegion));
		ExtentCucumberAdapter.addTestStepLog(
				"Selected Bill Region as " + customer.accountDetails.operatorAccountManager.billingRegion);
		lst_bill_currency.selectOption((customer.accountDetails.operatorAccountManager.billCurrency));
		ExtentCucumberAdapter.addTestStepLog(
				"Selected Bill Currency as " + customer.accountDetails.operatorAccountManager.billCurrency);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
		go_to_next_page();
	}
}
