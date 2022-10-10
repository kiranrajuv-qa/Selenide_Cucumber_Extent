package pages.registration.corporate;

import static com.codeborne.selenide.Selenide.$;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

import framework.constants.Generic;
import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import pages.common.BasePage;

public class CustomerProfilePage extends BasePage {

	public CustomerProfilePage(TestContext context) {
		super(context);
	}
		// BASIC DETAILS
		private SelenideElement lst_industry = $(By.id("industry"));
		private SelenideElement lst_credit_vetting_type = $(By.xpath("//select[@id='registrationType']"));
	
		// CUSTOMER CATEGORIZATION
		private SelenideElement lst_customer_category = $(By.name("category"));
		private SelenideElement lst_customer_sub_category = $(By.name("subcategory"));
		private SelenideElement txt_vat_num = $(By.name("vatNumber"));
		private SelenideElement txt_tin_num = $(By.name("tinNumber"));
		
		// IDENTIFICATION DETAILS
		private SelenideElement lst_doc_purpose = $(By.name("documentPurpose0"));
		private SelenideElement lst_doc_type = $(By.name("idType0"));
		private SelenideElement txt_doc_id = $(By.name("registrationNumber0"));
		private SelenideElement txt_doc_place_of_issue = $(By.name("placeOfIssue0"));
		private SelenideElement txt_doc_date_of_issue = $(By.name("dateOfEstablishment0"));
		private SelenideElement txt_doc_expiry_date = $(By.name("expiryDate0"));
		
		// ADDRESS DETAILS
		private SelenideElement txt_post_box_num = $(By.name("postBoxNumber"));
		private SelenideElement txt_street = $(By.name("streetName"));
		private SelenideElement txt_address1 = $(By.name("address1"));
	    private SelenideElement txt_address2 = $(By.name("address2"));
		private SelenideElement lst_province = $(By.name("province"));
		private SelenideElement lst_city = $(By.name("city"));
		
		// NOTIFICATION DETAILS
		private SelenideElement lst_notification_preflang = $(By.name("preferredLang"));
		private SelenideElement lst_preferred_medium = $(By.xpath("//div[2]/div/div/div/div"));
		private SelenideElement lst_notification_email = $(By.xpath("//li[contains(.,'Email')]"));
		private SelenideElement txt_notification_email = $(By.name("email"));
		
		// BILLING AND PAYMENT DETAILS
		private SelenideElement lst_bill_pres_lang = $(By.name("presentationLang"));
		private SelenideElement lst_bill_currency = $(By.name("billCurrency"));
		private SelenideElement lst_payment_currency = $(By.name("paymentCurrency"));
		private SelenideElement lst_bill_region = $(By.name("billingRegion"));
		
		//ADDITIONAL CONTACT
		private SelenideElement lst_contact_type = $(By.name("contactType"));
		private SelenideElement txt_cp_first_name = $(By.name("firstName"));
		private SelenideElement txt_cp_last_name = $(By.name("lastName"));
		private SelenideElement txt_cp_mobile =$(By.name("mobileNumber"));
		//BILLING LINK
		private SelenideElement lnk_billing =$(By.xpath("//button[contains(@class, \"billingBtn\")]"));
		
		public void capture_profile_basic_details(CorpCustomer customer) {
			lst_industry.selectOption(customer.profileDetails.basicDetails.industry);
			ExtentCucumberAdapter.addTestStepLog("Selected Industry " + customer.profileDetails.basicDetails.industry);
			if(businessType.equals(Generic.BUSINESS_TYPE_POSTPAID) || businessType.equals(Generic.BUSINESS_TYPE_HYBRID))
				lst_credit_vetting_type.selectOption(customer.profileDetails.basicDetails.creditVettingType);
		}
		public void capture_customer_categorization(CorpCustomer customer) {
			lst_customer_category.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
			lst_customer_category.selectOption(customer.profileDetails.customerCategorization.customerCategory);
			ExtentCucumberAdapter.addTestStepLog("Selected Customer Category as " + customer.profileDetails.customerCategorization.customerCategory);
			lst_customer_sub_category.selectOption(customer.profileDetails.customerCategorization.customerSubCategory);
			ExtentCucumberAdapter.addTestStepLog("Selected Customer Sub Category as" + customer.profileDetails.customerCategorization.customerSubCategory);
			txt_vat_num.val(customer.profileDetails.customerCategorization.companyRegistrationNumber);
			ExtentCucumberAdapter.addTestStepLog("Entered companyRegistrationNumber " + customer.profileDetails.customerCategorization.companyRegistrationNumber);
			txt_tin_num.val(customer.profileDetails.customerCategorization.tradeRegistrationNumber);
			ExtentCucumberAdapter.addTestStepLog("Entered tradeRegistrationNumber " + customer.profileDetails.customerCategorization.tradeRegistrationNumber);
		}
		public void capture_profile_identification_details(CorpCustomer customer) {
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
			txt_doc_date_of_issue.sendKeys(customer.profileDetails.identificationDetails.issuedDate);
			txt_doc_date_of_issue.pressTab();
			txt_doc_expiry_date.sendKeys(customer.profileDetails.identificationDetails.expiryDate);
			txt_doc_expiry_date.pressTab();
		}
		public void capture_profile_notification_details(CorpCustomer customer) {
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
		public void capture_profile_address_details(CorpCustomer customer) {
			txt_post_box_num.val(customer.profileDetails.addressDetails.postCode);
			ExtentCucumberAdapter.addTestStepLog("Entered Post Box Number as " + customer.profileDetails.addressDetails.postCode);
			txt_street.val(customer.profileDetails.addressDetails.street);
			ExtentCucumberAdapter.addTestStepLog("Entered Street as " + customer.profileDetails.addressDetails.street);
			txt_address1.val(customer.profileDetails.addressDetails.address1);
			ExtentCucumberAdapter.addTestStepLog("Entered Address1 as " + customer.profileDetails.addressDetails.address1);
			txt_address2.val(customer.profileDetails.addressDetails.address2);
		   ExtentCucumberAdapter.addTestStepLog("Entered Address2 as " + customer.profileDetails.addressDetails.address2);
		   lst_province.selectOption(customer.profileDetails.addressDetails.province);
		   ExtentCucumberAdapter.addTestStepLog("Enter province as " + customer.profileDetails.addressDetails.province);
		   lst_city.selectOption(customer.profileDetails.addressDetails.city);
		   ExtentCucumberAdapter.addTestStepLog("Enter city as " + customer.profileDetails.addressDetails.city);
		}
		public void capture_billing_and_payment_details(CorpCustomer customer) {
			lst_bill_pres_lang.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
			lst_bill_pres_lang.selectOption(customer.profileDetails.billingAndPaymentPreferences.billPresentationLanguage);
			lst_bill_currency.selectOption(customer.profileDetails.billingAndPaymentPreferences.billCurrency);
			lst_payment_currency.selectOption(customer.profileDetails.billingAndPaymentPreferences.paymentCurrency);
			lst_bill_region.selectOption(customer.profileDetails.billingAndPaymentPreferences.billingRegion);
		}
		public void capture_primary_contact_details(CorpCustomer customer) {
			lst_contact_type.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
			lst_contact_type.selectOption(customer.profileDetails.contactPerson.contactType);
			txt_cp_first_name.should(appear);
			ExtentCucumberAdapter.addTestStepLog("Entered Profile Details Page");
			String firstName = customer.profileDetails.contactPerson.firstName + " " + RandomStringUtils.randomAlphabetic(5);
			txt_cp_first_name.val(firstName);
			ExtentCucumberAdapter.addTestStepLog("Entered First Name as " + firstName);
			String lastName = customer.profileDetails.contactPerson.lastName + " " + RandomStringUtils.randomAlphabetic(5);
			txt_cp_last_name.val(lastName);
			ExtentCucumberAdapter.addTestStepLog("Entered Last Name as " + lastName);
			txt_cp_mobile.val(customer.profileDetails.contactPerson.mobileNumber);
			
		}
		public void lnk_billing_account() {
			lnk_billing.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
			lnk_billing.click();
		}
}