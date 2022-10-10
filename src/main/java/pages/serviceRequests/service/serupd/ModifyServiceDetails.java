package pages.serviceRequests.service.serupd;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.retail.Customer;
import pages.common.BasePage;

public class ModifyServiceDetails extends BasePage {
	public ModifyServiceDetails(TestContext context) {
		super(context);
	}
	//BASIC DETAILS
	private SelenideElement txt_fname = $(By.name("firstName"));
	private SelenideElement txt_lname = $(By.name("lastName"));
	private SelenideElement txt_dob = $(By.name("dateOfBirth"));
	private SelenideElement slt_arrow = $(By.xpath("//span/em"));
	//ADDRESS
	private SelenideElement txt_postcode = $(By.name("postBoxNumber"));
	private SelenideElement lst_country = $(By.name("country"));
	private SelenideElement lst_region = $(By.name("region"));
	private SelenideElement lst_town = $(By.name("locality"));
	private SelenideElement txt_street = $(By.name("streetName"));
	private SelenideElement txt_address1 = $(By.name("address1"));
	private SelenideElement txt_address2 = $(By.name("address2"));
	//IDENTIFICATION DETAILS
	private SelenideElement lst_doc_type = $(By.name("idType0"));
	private SelenideElement txt_doc_id = $(By.name("idNumber0"));
	private SelenideElement txt_doc_place_of_issue = $(By.name("placeOfIssue0"));
	private SelenideElement txt_doc_date_of_issue = $(By.name("dateOfIssue0"));
	private SelenideElement txt_doc_expiry_date = $(By.name("expiryDate0"));
	//DEMOGRAPHICS
	private SelenideElement lst_qual = $(By.id("qualification"));
	private SelenideElement lst_range = $(By.id("income"));
	private SelenideElement lst_occupation = $(By.name("occupation"));
	private SelenideElement txt_organization = $(By.name("organizationName"));
	private SelenideElement txt_contact = $(By.name("organizationContactNumber"));
	//SALES REPRESENTATIVE
	private SelenideElement lst_sale = $(By.name("saleRepServiceLevel"));

	public void service_details(Customer customer) {
		//BASIC DETAILS
		txt_fname.should(appear);
		String firstName = customer.profileDetails.basicDetails.firstName + " " + RandomStringUtils.randomAlphabetic(5);
		txt_fname.val(firstName);
		ExtentCucumberAdapter.addTestStepLog("Entered First Name as " + firstName);
		String LastName = customer.profileDetails.basicDetails.lastName + " " + RandomStringUtils.randomAlphabetic(5);
		txt_lname.val(LastName);
		ExtentCucumberAdapter.addTestStepLog("Entered last Name as " + LastName);
		txt_dob.val(customer.profileDetails.basicDetails.dob).pressTab();
		ExtentCucumberAdapter.addTestStepLog("Entered DOB as " + customer.profileDetails.basicDetails.dob);
		slt_arrow.click();
		//ADDRESS
		txt_postcode.should(appear);
		txt_postcode.val(customer.profileDetails.address.postCode);
		ExtentCucumberAdapter.addTestStepLog("Entered postcode as " + customer.profileDetails.address.postCode);
		lst_country.selectOption(customer.profileDetails.address.country);
		ExtentCucumberAdapter.addTestStepLog("Select Country as " + customer.profileDetails.address.country);
		lst_region.selectOption(customer.profileDetails.address.province);
		ExtentCucumberAdapter.addTestStepLog("Select Region as " + customer.profileDetails.address.province);
		lst_town.selectOption(customer.profileDetails.address.city);
		ExtentCucumberAdapter.addTestStepLog("Select town as " + customer.profileDetails.address.city);
		txt_street.val(customer.profileDetails.address.street);
		ExtentCucumberAdapter.addTestStepLog("Enter Street as " + customer.profileDetails.address.street);
		txt_address1.val(customer.profileDetails.address.address1);
		ExtentCucumberAdapter.addTestStepLog("Enter address1  as " + customer.profileDetails.address.address1);
		txt_address2.val(customer.profileDetails.address.address2);
		ExtentCucumberAdapter.addTestStepLog("Select address2 as " + customer.profileDetails.address.address2);
		//IDENTIFICATION
		lst_doc_type.shouldBe(enabled, Duration.ofSeconds(10));
		lst_doc_type.selectOption(customer.profileDetails.identificationDetails.documentType);
		ExtentCucumberAdapter.addTestStepLog("Selected Doc Type as " + customer.profileDetails.identificationDetails.documentType);
		txt_doc_id.val(customer.profileDetails.identificationDetails.documentID);
		ExtentCucumberAdapter.addTestStepLog("Entered Doc ID as " + customer.profileDetails.identificationDetails.documentID);
		txt_doc_place_of_issue.val(customer.profileDetails.identificationDetails.placeOfIssue);
		ExtentCucumberAdapter.addTestStepLog("Entered Place of Issue as " + customer.profileDetails.identificationDetails.placeOfIssue);
		txt_doc_date_of_issue.val(customer.profileDetails.identificationDetails.issuedDate).pressTab();
		txt_doc_expiry_date.val(customer.profileDetails.identificationDetails.expiryDate).pressTab();
		//DEMOGRAPHICS
		lst_qual.selectOption(customer.profileDetails.demographics.highestQualification);
		ExtentCucumberAdapter.addTestStepLog("Select Higher Qualification as " + customer.profileDetails.demographics.highestQualification);
		lst_range.selectOption(customer.profileDetails.demographics.incomeRange);
		ExtentCucumberAdapter.addTestStepLog("Select IncomeRange as " + customer.profileDetails.demographics.incomeRange);
		lst_occupation.selectOption(customer.profileDetails.demographics.occupation);
		ExtentCucumberAdapter.addTestStepLog("Select occupation as " + customer.profileDetails.demographics.occupation);
		txt_organization.val(customer.profileDetails.demographics.organizationName);
		ExtentCucumberAdapter.addTestStepLog("Select organizationName as " + customer.profileDetails.demographics.organizationName);
		txt_contact.val(customer.profileDetails.demographics.organizationContactNumber);
		ExtentCucumberAdapter.addTestStepLog("Select organization Contact Number as " + customer.profileDetails.demographics.organizationContactNumber);
		//SALES REPRESENTATIVE
		lst_sale.selectOption(customer.accountDetails.others.salesRepresentative);
		ExtentCucumberAdapter.addTestStepLog("Select salesRepresentative  as " + customer.accountDetails.others.salesRepresentative);
		//NOTE
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}
