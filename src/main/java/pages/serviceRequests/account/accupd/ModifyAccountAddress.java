package pages.serviceRequests.account.accupd;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyAccountAddress extends BasePage {
	public ModifyAccountAddress(TestContext context) {
		super(context);
	}

	private SelenideElement txt_post_box_num = $(By.name("postBoxNumber"));
	private SelenideElement txt_street = $(By.name("streetName"));
	private SelenideElement txt_address1 = $(By.name("address1"));
	private SelenideElement txt_address2 = $(By.name("address2"));
	private SelenideElement lst_Region = $(By.name("region"));
	private SelenideElement lst_Town = $(By.name("locality"));

	public void account_address(String postnum, String street, String Address, String Address2, String region,
			String city) {
		txt_post_box_num.val(postnum);
		ExtentCucumberAdapter.addTestStepLog("Entered Post Box Number as " + postnum);
		txt_street.val(street);
		ExtentCucumberAdapter.addTestStepLog("Entered Street as " + street);
		txt_address1.val(Address);
		ExtentCucumberAdapter.addTestStepLog("Entered Address1 as " + Address);
		txt_address2.val(Address2);
		ExtentCucumberAdapter.addTestStepLog("Entered Address2 as " + Address2);
		lst_Region.selectOption(region);
		ExtentCucumberAdapter.addTestStepLog("Enter province as " + region);
		lst_Town.selectOption(city);
		ExtentCucumberAdapter.addTestStepLog("Enter city as " + city);
		ta_notes.should(appear);
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_Review");
		go_to_next_page();
	}
}