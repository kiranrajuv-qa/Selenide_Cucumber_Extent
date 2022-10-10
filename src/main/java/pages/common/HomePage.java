/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.common;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.focused;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.enums.RegistrationContext;
import framework.enums.ServiceRequestContext;

public class HomePage extends BasePage {
	String customerCode, accountCode;

	public HomePage(TestContext context) {
		super(context);
	}

	// REGISTERED CUSTOMERS
	private SelenideElement txt_msisdn = $("div:nth-child(2) > input");
	private SelenideElement btn_search = $("div:nth-child(1) > div > form > button");
	private SelenideElement pick_record = null;
	// private SelenideElement pick_record = $("div:nth-child(1) > div > table >
	// tbody > tr:nth-child(1) > td:nth-child(1) > a");
	// PENDING CUSTOMERS
	private SelenideElement txt_regId = $("td:nth-child(2) > div > input");
	private SelenideElement btn_search_pending = $("td:nth-child(4) > div > button");
	private SelenideElement pick_pending_record = $("div:nth-child(3) > div > table > tbody > tr > td:nth-child(2)");
	private SelenideElement btn_start_vetting = $(By.xpath("//button[text()='START VETTING']"));
	private SelenideElement btn_approve_vetting = $(By.xpath("//button[text()='APPROVE']"));
	private SelenideElement lst_reason = $("span:nth-child(1) > select");
	// REGISTER NEW CUSTOMER
	private SelenideElement lnk_retail_ws_registration = $(By.linkText("GSM White SIM"));
	private SelenideElement lnk_retail_sk_registration = $(By.linkText("GSM Starter Kit"));
	private SelenideElement lnk_corporate_registration = $(By.linkText("Corporate"));

	public void is_loaded() {
		btn_search_pending.should(appear).should(visible);
		txt_msisdn.should(focused);
		ExtentCucumberAdapter.addTestStepLog("CLM Home Page loaded");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}

	public void go_to_registration_flow(String type) {
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		if (type.equalsIgnoreCase("GSM Starter Kit"))
			lnk_retail_sk_registration.click();
		else if (type.equalsIgnoreCase("GSM White SIM"))
			lnk_retail_ws_registration.click();
		else if (type.equalsIgnoreCase("Corporate"))
			lnk_corporate_registration.click();
		ExtentCucumberAdapter.addTestStepLog("Clicked link - " + type);
	}

	public void search_by_msisdn(String msisdn, String status) {
		lnk_retail_ws_registration.should(appear);
		txt_msisdn.val(msisdn);
		ExtentCucumberAdapter.addTestStepLog("Entered MSISDN");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		btn_search.click();
		btn_search.click();
		ExtentCucumberAdapter.addTestStepLog("Clicked Search");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		pick_record = $(By.xpath("//tr/td[contains(text(),'" + status + "')]/../td/a"));
		accountCode = $(By.xpath("//tr/td[contains(text(),'" + status + "')]/../td[2]")).getOwnText();
		customerCode = pick_record.getOwnText();
		testContext.scenarioContext.setContext(ServiceRequestContext.CUSTOMER_CODE, customerCode);
		testContext.scenarioContext.setContext(ServiceRequestContext.ACCOUNT_CODE, accountCode);
		pick_record.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
		pick_record.click();
		ExtentCucumberAdapter.addTestStepLog("Clicked " + status + " record");
	}

	public void start_vetting() {
		txt_regId.val((String) testContext.scenarioContext.getContext(RegistrationContext.REG_REQ_ID));
		btn_search_pending.click();
		pick_pending_record.click();
		confirm_flow();
		btn_start_vetting.click();
		btn_approve_vetting.click();
		lst_reason.selectOption("Good Credit Score");
		do_submit();
		do_close();
	}
}