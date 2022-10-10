/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.registration.retail;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import java.time.Duration;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.constants.Generic;
import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.testDataTypes.retail.Customer;
import pages.common.BasePage;

public class CustomerProfilePage extends BasePage {
	public CustomerProfilePage(TestContext context) {
		super(context);
	}

	// BASIC DETAILS
	private SelenideElement txt_first_name = $(By.name("profileDetails.basicDetails.firstName"));
	private SelenideElement txt_last_name = $(By.name("profileDetails.basicDetails.lastName"));
	private SelenideElement txt_dob = $(By.name("profileDetails.basicDetails.dateOfBirth"));
	private SelenideElement lst_country = $(By.name("profileDetails.basicDetails.country.masterCode"));
	private SelenideElement lst_nationality = $(By.name("profileDetails.basicDetails.nationality.masterCode"));
	private SelenideElement lst_credit_vetting_type = $(By.name("profileDetails.basicDetails.registrationType.masterCode"));
	// CUSTOMER CATEGORIZATION
	private SelenideElement lst_customer_category = $(By.name("profileDetails.customerCategory.masterCode"));
	private SelenideElement lst_customer_sub_category = $(By.name("profileDetails.customerSubCategory.masterCode"));
	// NOTIFICATION DETAILS
	private SelenideElement lst_notification_preflang = $(By.name("profileDetails.notificationDetails.prefLang"));
	private SelenideElement lst_preferred_medium = $(By.xpath("//sf-decorator/div/div/div/div"));
	private SelenideElement lst_notification_email = $(By.xpath("//*[contains(text(),'Email')]"));
	private SelenideElement txt_notification_email = $(By.name("notifications.email"));
	// ADDRESS DETAILS
	private SelenideElement lst_address_type = $(By.name("profileDetails.address.addressDetails[0].addressType.masterCode"));
	private SelenideElement txt_post_box_num = $(By.name("profileDetails.address.addressDetails[0].poBox"));
	private SelenideElement txt_street = $(By.name("profileDetails.address.addressDetails[0].streetName"));
	private SelenideElement txt_address1 = $(By.name("profileDetails.address.addressDetails[0].address1"));
	private SelenideElement txt_address2 = $(By.name("profileDetails.address.addressDetails[0].address2"));
	// CONTACT PERSON DETAILS
	private SelenideElement lst_contact_type = $(By.name("primaryContactPerson[0].contactType"));
	private SelenideElement txt_cp_first_name = $(By.name("primaryContactPerson[0].firstName"));
	private SelenideElement txt_cp_last_name = $(By.name("primaryContactPerson[0].lastName"));
	private SelenideElement txt_cp_mobile = $(By.name("primaryContactPerson[0].mobileNumber"));
	// BILLING AND PAYMENT DETAILS
	private SelenideElement lst_bill_pres_lang = $(By.name("billPaymentDetails.billingPreferenceDetails.presentationLanguage.masterCode"));
	private SelenideElement lst_bill_currency = $(By.name("billPaymentDetails.billingPreferenceDetails.preferredBillCurrency.masterCode"));
	private SelenideElement lst_payment_currency = $(By.name("billPaymentDetails.billingPreferenceDetails.preferredPaymentCurrency.masterCode"));
	private SelenideElement lst_bill_region = $(By.name("billPaymentDetails.billingPreferenceDetails.billingRegion.masterCode"));
	// IDENTIFICATION DETAILS
	private SelenideElement lst_doc_purpose = $(By.name("collectDocuments.identificationDetail[0].documentPurpose.masterCode"));
	private SelenideElement lst_doc_type = $(By.name("collectDocuments.identificationDetail[0].idType.masterCode"));
	private SelenideElement txt_doc_id = $(By.name("collectDocuments.identificationDetail[0].idNumber"));
	private SelenideElement txt_doc_place_of_issue = $(By.name("collectDocuments.identificationDetail[0].placeOfIssue"));
	private SelenideElement txt_doc_date_of_issue = $(By.name("collectDocuments.identificationDetail[0].dateOfIssue"));
	private SelenideElement txt_doc_expiry_date = $(By.name("collectDocuments.identificationDetail[0].expiryDate"));
	// SERVICE USER DETAILS
	private SelenideElement txt_serviceuser_first_name = $(By.name("serviceUser.basicDetails.firstName"));
	private SelenideElement txt_serviceuser_last_name = $(By.name("serviceUser.basicDetails.lastName"));
	private SelenideElement txt_serviceuser_dob = $(By.name("serviceUser.basicDetails.dateOfBirth"));
	private SelenideElement lst_serviceuser_country = $(By.name("serviceUser.basicDetails.country.masterCode"));
	private SelenideElement lst_serviceuser_nationality = $(By.name("serviceUser.basicDetails.nationality.masterCode"));
	private SelenideElement txt_service_total_limit = $(By.name("serviceUser.limitDetails.total"));
	private SelenideElement txt_service_limit = $(By.name("serviceUser.limitDetails.allocatedLimit"));
	// VALIDATIONS
	private SelenideElement sts_blacklist_check = $("h5:nth-child(1) > span.label");
	private SelenideElement sts_duplicate_check = $("h5:nth-child(2) > span.label");
	private SelenideElement sts_id_check = $("h5:nth-child(3) > span.label");
	private SelenideElement sts_min_age_check = $("h5:nth-child(4) > span.label");
	private SelenideElement sts_max_connections_check = $("h5:nth-child(5) > span.label");
	private SelenideElement derive_risk_category = $("h5:nth-child(6) > span.label");

	public void capture_profile_basic_details(Customer customer) {
		txt_first_name.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Entered Profile Details Page");
		String firstName = customer.profileDetails.basicDetails.firstName + " " + RandomStringUtils.randomAlphabetic(5);
		txt_first_name.val(firstName);
		ExtentCucumberAdapter.addTestStepLog("Entered First Name as " + firstName);
		String lastName = customer.profileDetails.basicDetails.lastName + " " + RandomStringUtils.randomAlphabetic(5);
		txt_last_name.val(lastName);
		ExtentCucumberAdapter.addTestStepLog("Entered Last Name as " + lastName);
		txt_dob.sendKeys(customer.profileDetails.basicDetails.dob);
		ExtentCucumberAdapter.addTestStepLog("Entered DOB as " + customer.profileDetails.basicDetails.dob);
		lst_country.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.basicDetails.country));
		ExtentCucumberAdapter.addTestStepLog("Validated Country as " + customer.profileDetails.basicDetails.country);
		lst_nationality.selectOption(customer.profileDetails.basicDetails.nationality);
		ExtentCucumberAdapter.addTestStepLog("Selected Nationality as " + customer.profileDetails.basicDetails.nationality);
		if(businessType.equals(Generic.BUSINESS_TYPE_POSTPAID) || businessType.equals(Generic.BUSINESS_TYPE_HYBRID))
			lst_credit_vetting_type.selectOption(customer.profileDetails.basicDetails.creditVettingType);
	}

	public void assert_customer_categorization(Customer customer) {
		lst_customer_category.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_customer_category.getSelectedOption().shouldBe(exactOwnText(customer.offering.customerCategory));
		ExtentCucumberAdapter.addTestStepLog("Validated Customer Category as " + customer.offering.customerCategory);
		lst_customer_sub_category.getSelectedOption().shouldBe(exactOwnText(customer.offering.customerSubCategory));
		ExtentCucumberAdapter.addTestStepLog("Validated Customer Sub Category as " + customer.offering.customerSubCategory);
	}

	public void capture_customer_categorization(Customer customer) {
		lst_customer_category.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_customer_category.selectOption(customer.offering.customerCategory);
		ExtentCucumberAdapter.addTestStepLog("Selected Customer Category as " + customer.offering.customerCategory);
		lst_customer_sub_category.selectOption(customer.offering.customerSubCategory);
		ExtentCucumberAdapter.addTestStepLog("Selected Customer Sub Category as " + customer.offering.customerCategory);
	}

	public void capture_profile_notification_details(Customer customer) {
		if(opcoValue.equals("MTNC")) {
			lst_notification_preflang.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.notificationDetails.language));
			ExtentCucumberAdapter.addTestStepLog("Validated Notification Preferred Language as " + customer.profileDetails.notificationDetails.language);
		}	
		else {
			lst_notification_preflang.selectOption(customer.profileDetails.notificationDetails.language);
			ExtentCucumberAdapter.addTestStepLog("Selected Notification Preferred Language as " + customer.profileDetails.notificationDetails.language);
		}
		lst_preferred_medium.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_preferred_medium.click();
		lst_notification_email.click();
		lst_preferred_medium.click();
		ExtentCucumberAdapter.addTestStepLog("Selected Notification Preferred Medium as Email");
		txt_notification_email.val(customer.profileDetails.notificationDetails.email);
		ExtentCucumberAdapter.addTestStepLog("Entered Notification Email as " + customer.profileDetails.notificationDetails.email);
	}

	public void capture_profile_address_details(Customer customer) {
		lst_address_type.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_address_type.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.address.type));
		ExtentCucumberAdapter.addTestStepLog("Validated Address Type as " + customer.profileDetails.address.type);
		txt_post_box_num.val(customer.profileDetails.address.postCode);
		ExtentCucumberAdapter.addTestStepLog("Entered Post Box Number as " + customer.profileDetails.address.postCode);
		txt_street.val(customer.profileDetails.address.street);
		ExtentCucumberAdapter.addTestStepLog("Entered Street as " + customer.profileDetails.address.street);
		txt_address1.val(customer.profileDetails.address.address1);
		ExtentCucumberAdapter.addTestStepLog("Entered Address1 as " + customer.profileDetails.address.address1);
		txt_address2.val(customer.profileDetails.address.address2);
		ExtentCucumberAdapter.addTestStepLog("Entered Address2 as " + customer.profileDetails.address.address2);
	}

	public void capture_primary_contact_details(Customer customer) {
		lst_contact_type.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_contact_type.selectOption(customer.profileDetails.contactPerson.contactType);
		txt_cp_first_name.val(customer.profileDetails.contactPerson.firstName);
		txt_cp_last_name.val(customer.profileDetails.contactPerson.lastName);
		txt_cp_mobile.val(customer.profileDetails.contactPerson.mobileNumber);
	}

	public void capture_billing_and_payment_details(Customer customer) {
		lst_bill_pres_lang.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_bill_pres_lang.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.billPresLang));
		lst_bill_currency.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.billCurrency));
		lst_payment_currency.getSelectedOption().shouldBe(exactOwnText(customer.accountDetails.operatorAccountManager.billCurrency));
		lst_bill_region.selectOption(customer.accountDetails.operatorAccountManager.billingRegion);
	}

	public void capture_profile_identification_details(Customer customer) {
		lst_doc_purpose.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		lst_doc_purpose.selectOption(customer.profileDetails.identificationDetails.documentPurpose);
		lst_doc_purpose.pressTab();
		ExtentCucumberAdapter.addTestStepLog("Selected Doc Purpose as " + customer.profileDetails.identificationDetails.documentPurpose);
		lst_doc_type.shouldBe(enabled, Duration.ofSeconds(10));
		lst_doc_type.selectOption(customer.profileDetails.identificationDetails.documentType);
		ExtentCucumberAdapter.addTestStepLog("Selected Doc Type as " + customer.profileDetails.identificationDetails.documentType);
		txt_doc_id.val(customer.profileDetails.identificationDetails.documentID);
		ExtentCucumberAdapter.addTestStepLog("Entered Doc ID as " + customer.profileDetails.identificationDetails.documentID);
		txt_doc_place_of_issue.val(customer.profileDetails.identificationDetails.placeOfIssue);
		ExtentCucumberAdapter.addTestStepLog("Entered Place of Issue as " + customer.profileDetails.identificationDetails.placeOfIssue);
		txt_doc_date_of_issue.val(customer.profileDetails.identificationDetails.issuedDate);
		txt_doc_expiry_date.val(customer.profileDetails.identificationDetails.expiryDate);
	}

	public void assert_service_user_details(Customer customer) {
		txt_serviceuser_first_name.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_serviceuser_first_name.shouldHave(value(customer.profileDetails.basicDetails.firstName));
		ExtentCucumberAdapter.addTestStepLog("Validated Service User First Name as " + customer.profileDetails.basicDetails.firstName);
		txt_serviceuser_last_name.shouldHave(value(customer.profileDetails.basicDetails.lastName));
		ExtentCucumberAdapter.addTestStepLog("Validated Service User Last Name as " + customer.profileDetails.basicDetails.lastName);
		txt_serviceuser_dob.shouldHave(value(customer.profileDetails.basicDetails.dob));
		ExtentCucumberAdapter.addTestStepLog("Validated Service User DOB as " + customer.profileDetails.basicDetails.dob);
		lst_serviceuser_country.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.basicDetails.country));
		ExtentCucumberAdapter.addTestStepLog("Validated Service User Country as " + customer.profileDetails.basicDetails.country);
		lst_serviceuser_nationality.getSelectedOption().shouldBe(exactOwnText(customer.profileDetails.basicDetails.nationality));
		ExtentCucumberAdapter.addTestStepLog("Validated Service User Nationality as " + customer.profileDetails.basicDetails.nationality);
		if(testContext.getScenarioContext().getContext(GenericContext.BUSINESS_TYPE).equals(Generic.BUSINESS_TYPE_POSTPAID) ||
				testContext.getScenarioContext().getContext(GenericContext.BUSINESS_TYPE).equals(Generic.BUSINESS_TYPE_HYBRID)) {
			txt_service_total_limit.shouldHave(value(customer.serviceDetails.totalLimit));
			ExtentCucumberAdapter.addTestStepLog("Validated Service Total Limit as " + customer.serviceDetails.totalLimit);
		}
	}

	public void capture_service_details(Customer customer) {
		if(businessType.equals(Generic.BUSINESS_TYPE_POSTPAID) || businessType.equals(Generic.BUSINESS_TYPE_HYBRID)) {
			txt_service_limit.shouldHave(value(customer.serviceDetails.allocatedServiceLimit));
			ExtentCucumberAdapter.addTestStepLog("Validated Service Allocated Service Limit as " + customer.serviceDetails.allocatedServiceLimit);
		}
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}

	public void validations_should_be(String status) {
		sts_blacklist_check.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		sts_blacklist_check.shouldHave(exactOwnText(status));
		ExtentCucumberAdapter.addTestStepLog("Blacklist Check Status: " + status);
		sts_duplicate_check.shouldHave(exactOwnText(status));
		ExtentCucumberAdapter.addTestStepLog("Duplicate Check Status: " + status);
		sts_id_check.shouldHave(exactOwnText(status));
		ExtentCucumberAdapter.addTestStepLog("ID Check Status: " + status);
		sts_min_age_check.shouldHave(exactOwnText(status));
		ExtentCucumberAdapter.addTestStepLog("Min Age Check Status: " + status);
		sts_max_connections_check.shouldHave(exactOwnText(status));
		ExtentCucumberAdapter.addTestStepLog("Max Connections Check Status: " + status);
	}

	public void risk_category_should_be_derived() {
		derive_risk_category.shouldHave(exactOwnText("Done"));
		ExtentCucumberAdapter.addTestStepLog("Derive Risk Category: Done");
	}
}