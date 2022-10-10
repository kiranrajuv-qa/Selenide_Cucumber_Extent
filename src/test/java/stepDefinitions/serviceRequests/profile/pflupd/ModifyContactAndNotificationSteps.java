package stepDefinitions.serviceRequests.profile.pflupd;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import framework.cucumberContext.TestContext;
import framework.enums.ServiceRequestContext;
import framework.utils.OracleDataProvider;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pages.serviceRequests.profile.pflupd.ModifyContactAndNotification;

public class ModifyContactAndNotificationSteps {
	ModifyContactAndNotification ModifyContactAndNotificationAction;
	TestContext testContext;
	OracleDataProvider oracle;
	String customerCode, emailId, contactNum;

	public ModifyContactAndNotificationSteps(TestContext context) {
		testContext = context;
		oracle = new OracleDataProvider();
		ModifyContactAndNotificationAction = new ModifyContactAndNotification(context);
		customerCode = (String) testContext.scenarioContext.getContext(ServiceRequestContext.CUSTOMER_CODE);
	}

	@When("modify contact & notification details")
	public void modify_Profile_details(DataTable email) {
		List<List<String>> data = email.asLists();
		emailId = data.get(0).get(1);
		contactNum = data.get(1).get(1);
		ModifyContactAndNotificationAction.modify_profile_notification_details(emailId, contactNum);
	}

	@Then("verify modified info")
	public void verify_modified_info() {
		String[] profileData = oracle.getProfileInfo(customerCode, "notification_email_id_v");
		try {
			assertEquals(profileData[0], emailId, "Email not modified");
			ExtentCucumberAdapter.addTestStepLog("Notification Email modified successfully");
		} finally {
			OracleDataProvider.closeConnection();
		}
	}
}