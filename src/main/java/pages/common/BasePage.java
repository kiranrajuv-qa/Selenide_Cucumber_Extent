/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.common;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;

import framework.constants.Generic;
import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.enums.RegistrationContext;
import framework.enums.ServiceRequestContext;
import framework.utils.FileReaderUtils;

public class BasePage {
	private final SelenideElement lnk_cancel = $(By.xpath("//span[contains(.,'Cancel')]"));
	private final SelenideElement lnk_confirm = $(".btn-default:nth-child(1)");

	private final SelenideElement btn_previous = $(By.xpath("//button[text()='Previous']"));
	protected final SelenideElement btn_next = $(By.xpath("//button[text()='Next']"));
	private final SelenideElement btn_submit = $(By.xpath("//button[text()='Submit']"));
	private final SelenideElement btn_done = $(By.xpath("//button[text()='Done']"));
	private final SelenideElement btn_close = $(By.xpath("//button[text()='Close']"));
	
	private SelenideElement txt_search = $(By.xpath("//input[@type='text']"));
	private SelenideElement lnk_select = $(By.linkText("Select"));
	private SelenideElement lnk_unselect = $(By.linkText("unselect"));
	private SelenideElement lbl_planName = $(By.xpath("//request-charges/div/div/div[1]/table/tbody/tr[1]/td[1]"));

	private final SelenideElement txt_regId = $("div:nth-child(3) > div > span:nth-child(1)");
	private final SelenideElement txt_regStatus = $("div:nth-child(3) > div > span:nth-child(3)");

	protected final SelenideElement ta_notes = $("#request-notes > div > div > textarea");
	private final SelenideElement txt_srqNum = $(By.xpath("//span[contains(.,'Request Number')]"));
	private final SelenideElement txt_srqStatus = $(By.xpath("//span[contains(.,'Service Request Status')]"));
	private final SelenideElement txt_errorMessage = $("div.alert.alert-warning.ng-scope > strong");
	private final SelenideElement lnk_moreDetails = $("div.panel-heading > h3 > span > span > span");
	private final SelenideElement txt_subErrorMessage = $("div.panel-collapse.in.collapse > div > span > span");	

	protected final String opcoValue = FileReaderUtils.getInstance().getConfigReader().getOpco();
	protected final String baseDir = System.getProperty("user.dir") + "\\target\\reports\\tests\\";
	protected String scenarioName, businessType, customerType, registrationId, registrationStatus, msisdn, srqNum, srqStatus;
	protected TestContext testContext;

	public BasePage(TestContext context) {
		testContext = context;
		scenarioName = (String) testContext.getScenarioContext().getContext(GenericContext.SCENARIO_NAME);
		businessType = (String) testContext.getScenarioContext().getContext(GenericContext.BUSINESS_TYPE);
		customerType = (String) testContext.getScenarioContext().getContext(GenericContext.CUSTOMER_TYPE);
		msisdn = (String) testContext.getScenarioContext().getContext(GenericContext.MSISDN);
	}

	public final void cancel_flow() {
		lnk_cancel.click();
		ExtentCucumberAdapter.addTestStepLog("Clicked Cancel link");
		lnk_confirm.click();
		ExtentCucumberAdapter.addTestStepLog("Confirmed Cancel");
	}

	public final void confirm_flow() {
		lnk_confirm.click();
		ExtentCucumberAdapter.addTestStepLog("Confirmed flow");
	}

	public final void go_to_previous_page() {
		btn_previous.click();
		ExtentCucumberAdapter.addTestStepLog("Moving to previous page");
	}

	public final void go_to_next_page() {
		btn_next.click();
		ExtentCucumberAdapter.addTestStepLog("Moving to next page");
	}

	public final void submit_reg_flow() {
		btn_next.click();
		btn_submit.should(appear);
		btn_submit.click();
		lnk_confirm.click();
		if (businessType.equals(Generic.BUSINESS_TYPE_PREPAID))
			btn_next.click();
		ExtentCucumberAdapter.addTestStepLog("Flow submitted");
		txt_regId.should(appear);
	}

	public final void submit_srq_flow() {
		btn_submit.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_review_submit");
		btn_submit.click();
		ExtentCucumberAdapter.addTestStepLog("Flow submitted");
	}

	public final void do_submit() {
		btn_submit.click();
	}

	public final void do_close() {
		btn_close.click();
	}

	public void choose_plan(String planName) {
		txt_search.should(appear);
		txt_search.val(planName);
		lnk_select.should(appear);
		lnk_select.click();
		lnk_unselect.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Selected plan");
		lbl_planName.should(appear);
		lbl_planName.shouldHave(text(planName));
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		go_to_next_page();
	}

	public final void finish_reg_flow() {
		registrationId = txt_regId.getText().substring(12);
		registrationStatus = txt_regStatus.getText().substring(15);
		testContext.getScenarioContext().setContext(RegistrationContext.REG_REQ_ID, registrationId);
		testContext.getScenarioContext().setContext(RegistrationContext.REG_REQ_STATUS, registrationStatus);
		ExtentCucumberAdapter.addTestStepLog(txt_regId.getText());
		ExtentCucumberAdapter.addTestStepLog(txt_regStatus.getText());
		btn_done.click();
	}

	public final String finish_srq_flow() {
		String testStatus = "";
			try {
				txt_srqNum.should(appear);
				srqNum = txt_srqNum.getText().substring(16);
				srqStatus = txt_srqStatus.getText().substring(24);
				testStatus = "PASSED";
				ExtentCucumberAdapter.addTestStepLog(txt_srqNum.getText());
				ExtentCucumberAdapter.addTestStepLog(txt_srqStatus.getText());
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_thankYou");
				btn_done.click();
			} catch(UIAssertionError err){
				ExtentCucumberAdapter.addTestStepLog(txt_errorMessage.getText());
				if(lnk_moreDetails.exists()) {
					lnk_moreDetails.click();
					ExtentCucumberAdapter.addTestStepLog(txt_subErrorMessage.getText());
				}
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_FAILED");
				srqNum = txt_errorMessage.getText().substring(txt_errorMessage.getText().indexOf(":")+1);
				srqStatus = "FAILED";
				testStatus = "FAILED";
			}
			finally {
				testContext.getScenarioContext().setContext(ServiceRequestContext.SERVICE_REQ_NUM, srqNum);
				testContext.getScenarioContext().setContext(ServiceRequestContext.SERVICE_REQ_STATUS, srqStatus);
			}
		return testStatus;
	}
}