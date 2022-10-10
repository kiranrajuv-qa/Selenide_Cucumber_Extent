package pages.serviceRequests.profile.pflupd;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyIdentificationDetails extends BasePage {
	public ModifyIdentificationDetails(TestContext context) {
		super(context);
	}
	
	//private SelenideElement lst_doc_type = $(By.name("idType0"));
	//private SelenideElement txt_doc_id = $(By.name("idNumber0"));
	private SelenideElement txt_doc_place_of_issue = $(By.name("placeOfIssue0"));
	private SelenideElement txt_doc_date_of_issue = $(By.name("dateOfIssue0"));
	private SelenideElement txt_doc_expiry_date = $(By.name("expiryDate0"));
	
	
	
	public void modify_profile_identification_details(String place,String dateofissue,String expirydate) {
		
		txt_doc_place_of_issue.val(place);
		ExtentCucumberAdapter.addTestStepLog("Modified Place of Issue as " + place);
		txt_doc_date_of_issue.val(dateofissue);
		ExtentCucumberAdapter.addTestStepLog("Modified Date of issue " + dateofissue);
		txt_doc_expiry_date.val(expirydate);
		ExtentCucumberAdapter.addTestStepLog("Modified expiry Date " + expirydate);
		go_to_next_page();
		
	}
}