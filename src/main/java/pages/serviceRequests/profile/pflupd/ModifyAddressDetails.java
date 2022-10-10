package pages.serviceRequests.profile.pflupd;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyAddressDetails extends BasePage {
	public ModifyAddressDetails(TestContext context) {
		super(context);
	}

	private SelenideElement lst_address_type = $(By.name("addressType"));
	private SelenideElement txt_post_box_num = $(By.name("postBoxNumber"));
	private SelenideElement lst_country = $(By.name("country"));
	private SelenideElement lst_region = $(By.name("region"));
	private SelenideElement lst_town = $(By.name("locality"));

	public void modify_profile_address_details(String addtype, String postnum, String country, String region,
			String town) {
		lst_address_type.selectOption((addtype));
		ExtentCucumberAdapter.addTestStepLog("modified Address Type as " + addtype);
		txt_post_box_num.val(postnum);
		ExtentCucumberAdapter.addTestStepLog("modified Post Box Number as " + postnum);
		lst_country.selectOption((country));
		ExtentCucumberAdapter.addTestStepLog("modified Country as " + country);
		lst_region.selectOption(region);
		ExtentCucumberAdapter.addTestStepLog("modified region as " + region);
		lst_town.selectOption(town);
		ExtentCucumberAdapter.addTestStepLog("modified town as " + town);
		go_to_next_page();

	}
}