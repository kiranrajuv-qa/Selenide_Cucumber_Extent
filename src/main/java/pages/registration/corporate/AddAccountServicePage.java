package pages.registration.corporate;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import pages.common.BasePage;

public class AddAccountServicePage extends BasePage {

	public AddAccountServicePage(TestContext context) {
		super(context);
	}

	private SelenideElement lnk_newAccount = $(By.partialLinkText("NEW BILLING ACCOUNT"));
	private SelenideElement txt_searchAccount = $(By.xpath("//input[@type='text']"));
	private SelenideElement rb_existingAccount = null;

	// Direct
	private SelenideElement lst_msisdn_category = $(By.name("msisdnCategory"));
	private SelenideElement lst_msisdn_selection = $(By.name("msisdnSelection"));
	private SelenideElement lst_msisdn_prefix = $(By.name("prefix"));
	private SelenideElement txt_search_msisdn = $(By.name("manualServiceNumber"));
	private SelenideElement txt_auto_msisdn = $(By.name("autoServiceNumber"));
	private SelenideElement txt_msisdn = $("//*[@id=\"serviceRequestDetails\"]/div/span/sr-select-number/div/div/div[4]/div/div/ul/li");
	private SelenideElement lnk_search = $(By.xpath("(//*[@id=\"serviceRequestDetails\"]/div/span/sr-select-number/div/div/div[4]/div/div/button[1]"));
	private SelenideElement btn_reserve = $(By.xpath("//button[contains(.,' Reserve')]"));
	private SelenideElement txt_sim_number = $(By.name("simNumber"));
	private SelenideElement txt_imsi_number = $(By.name("imsiNumber"));

	// Starter Kit
	private SelenideElement rd_gsmServiceSelection = $(By.name("gmsservice"));
	private SelenideElement txt_kit_number = $(By.id("starterKitID"));
	private SelenideElement txt_sp_sim_number = $(By.id("SIMNumber"));
	private SelenideElement txt_sp_msisdn = $(By.id("MSISDN1"));
	private SelenideElement txt_sp_imsi_number = $(By.id("IMSINumber"));

	public void select_existing_account(String accountId) {
		txt_searchAccount.val(accountId);
		rb_existingAccount = $(By.xpath("//tr//td[text()='" + accountId + "']/../td/input"));
		rb_existingAccount.should(appear);
		rb_existingAccount.click();
		btn_next.shouldBe(visible);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_Account");
		go_to_next_page();
	}

	public void capture_new_account(CorpCustomer customer) {
		lnk_newAccount.click();
	}

	public void select_number(CorpCustomer customer, String msisdnSelection, String msisdn) {
		lst_msisdn_category.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Entered Select Number page");
		lst_msisdn_category.selectOption(customer.serviceDetails.offering.msisdnCategory);
		ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Category as - " + customer.serviceDetails.offering.msisdnCategory);
		lst_msisdn_selection.selectOption(msisdnSelection);
		lst_msisdn_selection.pressTab();
		ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Selection as - " + msisdnSelection);
		if (msisdnSelection.equals("Manual")) {
			if(opcoValue.equals("MTNIC") || opcoValue.equals("MTNC")) {
				lst_msisdn_prefix.selectOption(msisdn.substring(0, 2));
				ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Prefix as - " + msisdn.substring(0, 2));
			}
			else if(opcoValue.equals("MTNB")) {
				lst_msisdn_prefix.selectOption(msisdn.substring(0, 1));
				ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Prefix as - " + msisdn.substring(0, 1));
			}
			txt_search_msisdn.val(msisdn);
			txt_msisdn.click();
			ExtentCucumberAdapter.addTestStepLog("Entered MSISDN");
			lnk_search.click();
			ExtentCucumberAdapter.addTestStepLog("Clicked Search button");
			btn_reserve.click();
			ExtentCucumberAdapter.addTestStepLog("Select MSISDN");
		} else {
			txt_auto_msisdn.should(appear);
			ExtentCucumberAdapter.addTestStepLog("MSISDN is: " + txt_auto_msisdn.getText());
		}
	}

	public void enter_sim(String simNumber, String imsiNumber) {		
		txt_sim_number.val(simNumber).pressTab();
		ExtentCucumberAdapter.addTestStepLog("Entered SIM Number");
		txt_imsi_number.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"nearest\"}");
		txt_imsi_number.shouldHave(value(imsiNumber));
		ExtentCucumberAdapter.addTestStepLog("Validated IMSI Number");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		go_to_next_page();
	}

	public void enter_starter_kit(String kitNumber, String msisdn, String simNumber, String imsiNumber) {
		rd_gsmServiceSelection.selectRadio("Starter Kit");
		txt_kit_number.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Selected Starter Kit");
		txt_kit_number.val(kitNumber).pressTab();
		ExtentCucumberAdapter.addTestStepLog("Entered Kit Number");
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