package pages.registration.corporate;

import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.testDataTypes.corporate.CorpCustomer;
import pages.common.BasePage;

public class ServiceDetailsPage extends BasePage {

	public ServiceDetailsPage(TestContext context) {
		super(context);
	}
	//OFFER SELECTION
	private SelenideElement list_subService = $(By.id("sub-service"));
	private SelenideElement list_technology = $(By.id("technology"));
	private SelenideElement list_country = $(By.id("country"));
	private SelenideElement list_Region = $(By.id("province"));
	private SelenideElement list_city = $(By.id("city"));
	private SelenideElement btn_search = $(By.xpath("(//button[@type='button'])[3]"));
	private SelenideElement txt_search_offer = $(By.xpath("//input[@type='search']"));
	private SelenideElement lnk_select_offer = $(By.linkText("SELECT"));
	private SelenideElement lnk_unselect_offer = $(By.linkText("UNSELECT"));
	private SelenideElement offer_name_select = $(By.xpath("//li/div/ul/li/div/ul/li/span/span"));
	//MSISDN SELECTION
	private SelenideElement lst_msisdn_category = $(By.name("msisdnCategory"));
	private SelenideElement lst_msisdn_selection = $(By.name("msisdnSelection"));
	private SelenideElement txt_search_msdisn = $(By.name("searchMSDISN"));
	private SelenideElement lnk_search = $(By.xpath("//div[contains(@class, \"modal_content\")]/div/div/div/div/div[1]/div/div[2]/div[1]/div[1]/div[5]/div/div/button[1]/span"));
	private SelenideElement list_msisdn_prefix = $(By.name("prefix"));
	private SelenideElement lnk_select = $(By.xpath("//div[contains(@class, \"modal_content\")]/div/div/div/div/div[1]/div/div[2]/div[1]/div[1]/div[5]/div/div/div[1]/div"));
	private SelenideElement lnk_confirm = $(By.xpath("//div[contains(@class, \"panel-footer\")]/button[1]"));
	//SIM NUMBER
	private SelenideElement txt_sim_num = $(By.name("directSimNumber"));
	private SelenideElement txt_imsi_num = $(By.name("directImsiNumber"));
	
	public void capture_service_details_county(CorpCustomer customer) {
		if (customer.serviceDetails.offering.subService != null || !customer.serviceDetails.offering.subService.equals("")
				|| !customer.serviceDetails.offering.subService.equals("Voice")) {
			list_subService.selectOption(customer.serviceDetails.offering.subService);
			ExtentCucumberAdapter.addTestStepLog("Selected sub service as " + customer.serviceDetails.offering.subService);
		}
		if (customer.serviceDetails.offering.technology != null || !customer.serviceDetails.offering.technology.equals("")
				|| !customer.serviceDetails.offering.technology.equals("GSM")) {
			list_technology.selectOption(customer.serviceDetails.offering.technology);
			ExtentCucumberAdapter.addTestStepLog("Selected technology as " + customer.serviceDetails.offering.technology);
		}
		list_country.selectOption(customer.profileDetails.addressDetails.country);
		ExtentCucumberAdapter.addTestStepLog("Selected country as " + customer.profileDetails.addressDetails.country);
		list_Region.selectOption(customer.profileDetails.addressDetails.province);
		ExtentCucumberAdapter.addTestStepLog("Selected province as " + customer.profileDetails.addressDetails.province);
		list_city.selectOption(customer.profileDetails.addressDetails.city);
		ExtentCucumberAdapter.addTestStepLog("Selected city as " + customer.profileDetails.addressDetails.city);
	}
	
	public void capture_service_details(CorpCustomer customer, String offeringName) {
		btn_search.click();
		ExtentCucumberAdapter.addTestStepLog("Clicked Search button");
		txt_search_offer.val(offeringName);
		ExtentCucumberAdapter.addTestStepLog("Entered offering name");
		lnk_select_offer.click();
		lnk_unselect_offer.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Selected the offering as");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		offer_name_select.click();
	}	
	
	public void msisdn_selection(CorpCustomer customer, String msisdnSelection, String msisdn) {
		lst_msisdn_category.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Entered Select Number page");
		lst_msisdn_category.selectOption(customer.serviceDetails.offering.msisdnCategory);
		ExtentCucumberAdapter.addTestStepLog("Selected MSISDN Category as - " + customer.serviceDetails.offering.msisdnCategory);
		lst_msisdn_selection.selectOption(msisdnSelection);
		lst_msisdn_selection.pressTab();
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
			txt_search_msdisn.val(msisdn);
			ExtentCucumberAdapter.addTestStepLog("Entered MSISDN");
			lnk_search.click();
			ExtentCucumberAdapter.addTestStepLog("Clicked Search button");
			lnk_select.click();
			ExtentCucumberAdapter.addTestStepLog("Select MSISDN");
			lnk_confirm.click();
			ExtentCucumberAdapter.addTestStepLog("confirm MSISDN");
		} else {
			txt_search_msdisn.should(appear);
			ExtentCucumberAdapter.addTestStepLog("MSISDN is: " + txt_search_msdisn.getText());
		}
	}
	public void sim_number_enter(CorpCustomer customer,String simNumber) {		
		txt_sim_num.val(simNumber).pressTab();
		txt_imsi_num.should(appear);
		txt_sim_num.pressTab();
		ExtentCucumberAdapter.addTestStepLog("Entered SIM Number");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
	}
	
}