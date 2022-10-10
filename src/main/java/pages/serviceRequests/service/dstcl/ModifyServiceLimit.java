package pages.serviceRequests.service.dstcl;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyServiceLimit extends BasePage {
	public ModifyServiceLimit(TestContext context) {
		super(context);
	}
	private SelenideElement lst_per = $(By.name("creditLimitType"));
	private SelenideElement lst_temp = $(By.xpath("(//input[@name='creditLimitType'])[2]"));
	private SelenideElement txt_crd_amount = $(By.name("modifiedCreditAmount"));
	public void service_limit(String limittype, String amount) {
		lst_per.should(appear);
		if(limittype.equals("Permanently")) {
			lst_per.click();
		}
		else {
			lst_temp.click();
		}
		txt_crd_amount.val(amount);
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_1");
		go_to_next_page();
	}
}
