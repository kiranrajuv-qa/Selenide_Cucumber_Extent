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

public class KitDetailsPage extends BasePage {
	public KitDetailsPage(TestContext context) {
		super(context);
	}
	// Starter Kit
	private SelenideElement txt_kit_number = $(By.name("serviceDetails.gsmService.stSIMConnection.SIMConnectionId"));
	private SelenideElement txt_sp_sim_number = $(By.name("serviceDetails.gsmService.stSIMConnection.SIMNumber"));
	private SelenideElement txt_sp_msisdn = $(By.name("serviceDetails.gsmService.stSIMConnection.MSISDN"));
	private SelenideElement txt_sp_imsi_number = $(By.name("serviceDetails.gsmService.stSIMConnection.IMSINumber"));
	//White SIM
	private SelenideElement list_msisdn_category = $(By.name("serviceDetails.gsmService.stDirect.MSISDNCategory.masterCode"));
	private SelenideElement list_msisdn_selection = $(By.name("serviceDetails.gsmService.stDirect.MSISDNSelection.masterCode"));
	private SelenideElement list_msisdn_prefix = $(By.name("serviceDetails.gsmService.stDirect.MSISDNPrefix"));
	private SelenideElement txt_search_msisdn = $(By.name("serviceDetails.gsmService.stDirect.MSISDN"));
	private SelenideElement txt_msisdn = $("body > div > div > div > div > ui-view > div.row.ng-scope > div.equal-col.ng-scope > div.col-md-8.section-main > ui-view > div > ng-form > div > div:nth-child(2) > h2 > span");
	private SelenideElement lnk_search = $(By.xpath("(//button[@type='button'])[3]"));
	private SelenideElement btn_reserve = $(By.xpath("//button[contains(.,' Reserve')]"));
	private SelenideElement txt_sim_number = $(By.name("serviceNumber.SIMNumber"));
	private SelenideElement txt_imsi_number = $(By.name("serviceNumber.IMSINumber"));

	public void choose_msisdn(Customer customer, String msisdnSelection, String msisdn) {
		list_msisdn_category.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Entered Select Number page");
		list_msisdn_category.selectOption(customer.whiteSim.msisdnCategory);
		ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Category as - " + customer.whiteSim.msisdnCategory);
		list_msisdn_selection.selectOption(msisdnSelection);
		list_msisdn_selection.pressTab();
		ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Selection as - " + msisdnSelection);
		if (msisdnSelection.equals("Manual")) {
			if(opcoValue.equals("MTNIC") || opcoValue.equals("MTNC")) {
				list_msisdn_prefix.selectOption(msisdn.substring(0, 2));
				ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Prefix as - " + msisdn.substring(0, 2));
			}
			else if(opcoValue.equals("MTNB")) {
				list_msisdn_prefix.selectOption(msisdn.substring(0, 1));
				ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Prefix as - " + msisdn.substring(0, 1));
			}
			txt_search_msisdn.val(msisdn);
			ExtentCucumberAdapter.addTestStepLog("Entered MSISDN");
			lnk_search.click();
			ExtentCucumberAdapter.addTestStepLog("Clicked Search button");
			btn_reserve.click();
			ExtentCucumberAdapter.addTestStepLog("Clicked Reserve button");
		} else {
			txt_msisdn.should(appear);
			ExtentCucumberAdapter.addTestStepLog("MSISDN is: " + txt_msisdn.getText());
		}
	}

	public void enter_sim(String simNumber, String imsiNumber) {		
		txt_sim_number.val(simNumber).pressTab();
		ExtentCucumberAdapter.addTestStepLog("Entered SIM Number");
		txt_imsi_number.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_imsi_number.shouldHave(value(imsiNumber));
		ExtentCucumberAdapter.addTestStepLog("Validated IMSI Number");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}

	public void enter_starter_kit(String kitNumber, String msisdn, String simNumber, String imsiNumber) {
		txt_kit_number.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Entered Kit Details page");
		txt_kit_number.val(kitNumber).pressTab();
		ExtentCucumberAdapter.addTestStepLog("Entered KIT Number");
		txt_sp_msisdn.shouldHave(value(msisdn));
		ExtentCucumberAdapter.addTestStepLog("Validated MSISDN");
		txt_sp_sim_number.shouldHave(value(simNumber));
		ExtentCucumberAdapter.addTestStepLog("Validated SIM Number");
		txt_sp_imsi_number.shouldHave(value(imsiNumber));
		ExtentCucumberAdapter.addTestStepLog("Validated IMSI Number");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		go_to_next_page();
	}
}