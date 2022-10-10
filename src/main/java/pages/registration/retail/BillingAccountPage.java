/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.registration.retail;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;
import pages.common.BasePage;

public class BillingAccountPage extends BasePage {
	public BillingAccountPage(TestContext context) {
		super(context);
	}

	// BASIC DETAILS
	private SelenideElement txt_first_name = $(By.name("billingAccounts.billingAccount.accountOwnerDetails.firstName"));
	private SelenideElement txt_last_name = $(By.name("billingAccounts.billingAccount.accountOwnerDetails.lastName"));
	private SelenideElement txt_dob = $(By.name("billingAccounts.billingAccount.accountOwnerDetails.dateOfBirth"));
	// NOTIFICATION DETAILS
	private SelenideElement lst_notification_preflang = $(By.name("billingAccounts.billingAccount.notificationDetails.preferredLanguage.masterCode"));
	private SelenideElement txt_notification_email = $(By.name("billingAccounts.billingAccount.notificationDetails.preferredMedium.email"));
	// ADDRESS DETAILS
	private SelenideElement txt_poBox = $(By.name("billingAccounts.billingAccount.billingAddressDetails.poBox"));
	private SelenideElement txt_street = $(By.name("billingAccounts.billingAccount.billingAddressDetails.streetName"));
	private SelenideElement txt_address1 = $(By.name("billingAccounts.billingAccount.billingAddressDetails.address1"));
	private SelenideElement txt_address2 = $(By.name("billingAccounts.billingAccount.billingAddressDetails.address2"));
	// ACCOUNT DETAILS
	private SelenideElement lst_account_type = $(By.name("billingAccounts.billingAccount.billingDetails.accountType.masterCode"));
	private SelenideElement lst_limit_type = $(By.name("billingAccounts.billingAccount.billingDetails.serviceLimitType.masterCode"));
	private SelenideElement txt_credit_limit = $(By.name("billingAccounts.billingAccount.billingDetails.creditLimit"));
	// OPERATOR ACCOUNT MANAGER
	private SelenideElement lst_presentation_lang = $(By.name("billingAccounts.billingAccount.billingPreferenceDetails.presentationLanguage.masterCode"));
	private SelenideElement lst_bill_currency = $(By.name("billingAccounts.billingAccount.billingPreferenceDetails.prefferedCurrency.masterCode"));
	private SelenideElement lst_bill_periodicity = $(By.name("billingAccounts.billingAccount.billCycleDetails.billPeriodicity.masterCode"));
	private SelenideElement lst_bill_cycle = $(By.name("billingAccounts.billingAccount.billCycleDetails.billCycle.masterCode"));
	private SelenideElement lst_subsidiary = $(By.name("billingAccounts.billingAccount.billingDetails.subsidiary.masterCode"));
	private SelenideElement txt_bill_dispatch_email = $(By.name("billingAccounts.billingAccount.billingPreferenceDetails.billDispatchDetails.email"));
	// RELATIONSHIP MANAGER
	private SelenideElement lst_operator_acc_mgr = $(By.name("billingAccounts.billingAccount.relationshipManager.code"));
	// TAX POLICY
	private SelenideElement lst_tax_policy = $(By.name("billingAccounts.billingAccount.billingDetails.taxPolicyId.masterCode"));
	// DUNNING
	private SelenideElement lst_dunning_schedule = $(By.name("billingAccounts.billingAccount.billingDetails.dunningScheduleCode.masterCode"));

	public void assert_details_from_profile(Customer customer) {
		// BASIC DETAILS
		txt_first_name.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Entered Billing Account Details page");
		txt_first_name.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_first_name.shouldHave(value(customer.profileDetails.basicDetails.firstName));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner First Name as " + customer.profileDetails.basicDetails.firstName);
		txt_last_name.shouldHave(value(customer.profileDetails.basicDetails.lastName));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Last Name as " + customer.profileDetails.basicDetails.lastName);
		txt_dob.shouldHave(value(customer.profileDetails.basicDetails.dob));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner DOB as " + customer.profileDetails.basicDetails.dob);
		// NOTIFICATION DETAILS
		lst_notification_preflang.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_notification_preflang.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.notificationDetails.language));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Notification Preferred Language as " + customer.profileDetails.notificationDetails.language);
		txt_notification_email.shouldHave(value(customer.profileDetails.notificationDetails.email));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Notification Email as " + customer.profileDetails.notificationDetails.email);
		// ADDRESS DETAILS
		txt_poBox.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_poBox.shouldHave(value(customer.profileDetails.address.postCode));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address Post Box Number as " + customer.profileDetails.address.postCode);
		txt_street.shouldHave(value(customer.profileDetails.address.street));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address Street as " + customer.profileDetails.address.street);
		txt_address1.shouldHave(value(customer.profileDetails.address.address1));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address1 as " + customer.profileDetails.address.address1);
		txt_address2.shouldHave(value(customer.profileDetails.address.address2));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address2 as " + customer.profileDetails.address.address2);
	}

	public void assert_other_autopopulated_details(Customer customer) {
		// ACCOUNT DETAILS
		lst_account_type.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_account_type.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.accountType));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Type as " + customer.accountDetails.accountType);
		lst_limit_type.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.limitType));
		ExtentCucumberAdapter.addTestStepLog("Validated Limit Type as " + customer.accountDetails.limitType);
		txt_credit_limit.shouldHave(value(customer.accountDetails.creditLimit));
		ExtentCucumberAdapter.addTestStepLog("Validated Credit Limit as " + customer.accountDetails.creditLimit);
		// OPERATOR ACCOUNT MANAGER
		lst_presentation_lang.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_presentation_lang.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.billPresLang));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Presentation Language as " + customer.accountDetails.operatorAccountManager.billPresLang);
		lst_bill_currency.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.billCurrency));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Currency as " + customer.accountDetails.operatorAccountManager.billCurrency);
		lst_bill_periodicity.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.billPeriodicity));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Periodicity as " + customer.accountDetails.operatorAccountManager.billPeriodicity);
		lst_bill_cycle.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.billCycle));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Cycle as " + customer.accountDetails.operatorAccountManager.billCycle);
		lst_subsidiary.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.subsidiary));
		ExtentCucumberAdapter.addTestStepLog("Validated Subsidiary as " + customer.accountDetails.operatorAccountManager.subsidiary);
		txt_bill_dispatch_email.shouldHave(value(customer.profileDetails.notificationDetails.email));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Dispatch Email as " + customer.profileDetails.notificationDetails.email);
		// DUNNING
		lst_dunning_schedule.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_dunning_schedule.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.others.dunningScheduleCode));
		ExtentCucumberAdapter.addTestStepLog("Validated Dunning Schedule as " + customer.accountDetails.others.dunningScheduleCode);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}

	public void capture_other_details(Customer customer) {
		lst_operator_acc_mgr.selectOption(customer.accountDetails.operatorAccountManager.name);
		lst_tax_policy.selectOption(customer.accountDetails.others.taxPolicy);
	}
}