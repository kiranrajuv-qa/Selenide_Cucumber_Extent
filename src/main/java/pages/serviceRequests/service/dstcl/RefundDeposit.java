package pages.serviceRequests.service.dstcl;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class RefundDeposit extends BasePage {
	public RefundDeposit(TestContext context) {
		super(context);
	}
	private SelenideElement txt_amount = $(By.xpath("depositAmount"));
	public void refund_deposit(String amount) {
		txt_amount.should(appear);
		txt_amount.val(amount);
		ta_notes.should(appear);
		ta_notes.val(scenarioName + " added Successfully ");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_2");
		go_to_next_page();
	}
}
