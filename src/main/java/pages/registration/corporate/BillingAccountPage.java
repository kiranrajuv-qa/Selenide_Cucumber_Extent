package pages.registration.corporate;

import static com.codeborne.selenide.Selenide.$;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import pages.common.BasePage;

public class BillingAccountPage extends BasePage {

	public BillingAccountPage(TestContext context) {
		super(context);
	}
	// BASIC DETAILS
		private SelenideElement txt_billing_name = $(By.name("billingAccountName"));
		private SelenideElement txt_fist_name = $(By.name("firstName"));
		private SelenideElement txt_last_name = $(By.name("lastName"));
		// NOTIFICATION DETAILS
		private SelenideElement lst_notification_preflang = $(By.name("preferredLang"));
		private SelenideElement txt_notification_email = $(By.name("email"));
		// ADDRESS DETAILS
		private SelenideElement txt_poBox = $(By.name("postBoxNumber"));
		private SelenideElement txt_street = $(By.name("streetName"));
		private SelenideElement txt_address1 = $(By.name("address1"));
		private SelenideElement txt_address2 = $(By.name("address2"));
		// BILLING DETAILS
		private SelenideElement lst_presentation_lang = $(By.name("presentationLanguage"));
		private SelenideElement lst_bill_cycle = $(By.name("billCycle"));
		private SelenideElement lst_bill_medium = $(By.xpath("//div[@name='billDispatchMedium']//li[normalize-space()='Email']"));
		private SelenideElement lst_bill_dispath = $(By.xpath("//div[@name='billDispatchMedium']"));
		private SelenideElement txt_bill_dispatch_email = $(By.name("dispatchEmailId"));
		private SelenideElement lst_bill_currency = $(By.name("prefferedCurrency"));
		// OPERATOR ACCOUNT MANAGER
		private SelenideElement lst_account_manager = $(By.name("relManager"));
		// ACCOUNT DETAILS
		private SelenideElement lst_account_type = $(By.name("accountType"));
		private SelenideElement lst_limit_type = $(By.name("serviceLimit"));
		//TAX POLICY
		private SelenideElement lst_tax_policy = $(By.name("taxPolicyId"));
		// DUNNING
		private SelenideElement lst_dunning_schedule = $(By.name("schedule"));

	public void capture_billing_account_details(CorpCustomer customer) {
		txt_billing_name.should(appear);
		txt_billing_name.val(customer.accountDetails.billingAccountName);
		txt_fist_name.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Entered account Details Page");
		String firstName = customer.accountDetails.accountOwner.firstName + " " + RandomStringUtils.randomAlphabetic(5);
		txt_fist_name.val(firstName);
		ExtentCucumberAdapter.addTestStepLog("Entered First Name as " + firstName);
		String lastName = customer.accountDetails.accountOwner.lastName + " " + RandomStringUtils.randomAlphabetic(5);
		txt_last_name.val(lastName);
		ExtentCucumberAdapter.addTestStepLog("Entered Last Name as " + lastName);
	}
	
	public void assert_other_autopopulated_details(CorpCustomer customer) {
		// NOTIFICATION DETAILS
		lst_notification_preflang.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_notification_preflang.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.notificationDetails.language));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Notification Preferred Language as " + customer.profileDetails.notificationDetails.language);
		txt_notification_email.shouldHave(value(customer.profileDetails.notificationDetails.email));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Notification Email as " + customer.profileDetails.notificationDetails.email);
		// ADDRESS DETAILS
		txt_poBox.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_poBox.shouldHave(value(customer.profileDetails.addressDetails.postCode));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address Post Box Number as " + customer.profileDetails.addressDetails.postCode);
		txt_street.shouldHave(value(customer.profileDetails.addressDetails.street));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address Street as " + customer.profileDetails.addressDetails.street);
		txt_address1.shouldHave(value(customer.profileDetails.addressDetails.address1));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address1 as " + customer.profileDetails.addressDetails.address1);
		txt_address2.shouldHave(value(customer.profileDetails.addressDetails.address2));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Owner Address2 as " + customer.profileDetails.addressDetails.address2);
		// BILLING DETAILS;
		lst_presentation_lang.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_presentation_lang.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.billingAndPaymentPreferences.billPresentationLanguage));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Presentation Language as " + customer.profileDetails.billingAndPaymentPreferences.billPresentationLanguage);
		lst_bill_currency.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.billingAndPaymentPreferences.billCurrency));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Currency as " + customer.profileDetails.billingAndPaymentPreferences.billCurrency);
		lst_bill_cycle.selectOption(customer.profileDetails.billingAndPaymentPreferences.billCycle);
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Cycle as " + customer.profileDetails.billingAndPaymentPreferences.billCycle);
		lst_bill_dispath.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_bill_dispath.click();
		lst_bill_medium.click();
		lst_bill_dispath.click();
		txt_bill_dispatch_email.val((customer.profileDetails.notificationDetails.email));
		ExtentCucumberAdapter.addTestStepLog("Validated Bill Dispatch Email as " + customer.profileDetails.notificationDetails.email);
		// ACCOUNT DETAILS
		lst_account_type.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_account_type.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.accountType));
		ExtentCucumberAdapter.addTestStepLog("Validated Account Type as " + customer.accountDetails.accountType);
		lst_limit_type.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.limitType));
		ExtentCucumberAdapter.addTestStepLog("Validated Limit Type as " + customer.accountDetails.limitType);
		// DUNNING
		lst_dunning_schedule.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_dunning_schedule.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.dunningScheduleCode));
		ExtentCucumberAdapter.addTestStepLog("Validated Dunning Schedule as " + customer.accountDetails.dunningScheduleCode);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}
	public void capture_other_details(CorpCustomer customer) {
		lst_account_manager.selectOption(customer.accountDetails.operatorAccountManagerName);
		lst_tax_policy.selectOption(customer.profileDetails.billingAndPaymentPreferences.taxPolicy);
	}
	}

