/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.threesixty;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.constants.ServiceRequest;
import framework.cucumberContext.TestContext;
import framework.enums.ServiceRequestContext;
import pages.common.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class OverviewPage extends BasePage {
	private SelenideElement lnk_create_request = $(By.linkText("Create Request"));
	private SelenideElement lnk_add_account_service = $(By.linkText("Add Account/Service"));
	private SelenideElement lnk_type, lnk_subType;

	private SelenideElement rd_account = $(By.xpath("(//label[@role='tab'])[4]"));
	private SelenideElement rd_profile = $(By.xpath("(//label[@role='tab'])[3]"));
	
	private SelenideElement btn_changeSR = $(By.xpath("//input[@value='Change Service Request']"));
	private SelenideElement tab_acc = $(By.xpath("//button[text()='Account']"));
	private SelenideElement rd_mul_profile = $(By.xpath("//input[@value='option1']"));
	private SelenideElement txt_msidnSearch = $(By.xpath("//input[@placeholder='Search Service ID / Service User']"));
	private SelenideElement btn_search = $(By.xpath("//span/em[@class='fa fa-search']"));
	private SelenideElement lnk_acc = $(By.xpath("//tr[1]/td[@data-title-text='Account Code']/a"));

	String reqLevel, reqType, reqSubtype = null;

	public OverviewPage(TestContext testContext) {
		super(testContext);
		reqLevel = (String) testContext.getScenarioContext().getContext(ServiceRequestContext.REQ_LEVEL);
		reqType = (String) testContext.getScenarioContext().getContext(ServiceRequestContext.REQ_TYPE);
		reqSubtype = (String) testContext.getScenarioContext().getContext(ServiceRequestContext.REQ_SUBTYPE);

		lnk_type = $(By.partialLinkText(reqType));
		lnk_subType = $(By.partialLinkText(reqSubtype));
	}

	public void go_to_add_account_service_page() {
		lnk_create_request.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		lnk_add_account_service.click();
	}

	public void open_service_request_page() {
		lnk_create_request.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		if(lnk_create_request.exists() && lnk_create_request.isDisplayed() && lnk_create_request.isEnabled()) {
			lnk_create_request.click();
			Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		}
		if (reqLevel.equalsIgnoreCase(ServiceRequest.REQ_LEVEL_SERVICE)) {
			if (!reqType.equalsIgnoreCase(ServiceRequest.REQ_COS)) {
				lnk_type.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
			}
			lnk_subType.click();
		} else if (reqLevel.equalsIgnoreCase(ServiceRequest.REQ_LEVEL_PROFILE)) {
			if(btn_changeSR.exists() && btn_changeSR.isDisplayed()) {
				btn_changeSR.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
				rd_mul_profile.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_4");
			}
			else {
				rd_profile.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
			}
			if (!reqType.equalsIgnoreCase(ServiceRequest.REQ_PFLUPD)) {
				lnk_type.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_4");
			}
			lnk_subType.click();
		} else if (reqLevel.equalsIgnoreCase(ServiceRequest.REQ_LEVEL_ACCOUNT)) {
			if(btn_changeSR.exists() && btn_changeSR.isDisplayed()) {
				btn_changeSR.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
				txt_msidnSearch.val(msisdn);
				btn_search.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_4");
				tab_acc.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_5");
				lnk_acc.click();
			}
			else {
				rd_account.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
			}
			if (!reqType.equalsIgnoreCase(ServiceRequest.REQ_ACCUPD)) {
				lnk_type.click();
				Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_3");
			}
			lnk_subType.click();
		}
	}
}