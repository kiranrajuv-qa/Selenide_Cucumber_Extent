/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.serviceRequests.service.lcs;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class SuspensionOfService extends BasePage {
	private SelenideElement rd_softSusp = $(By.xpath("//input[@value='SOSU']"));

	public SuspensionOfService(TestContext context) {
		super(context);
	}

	public void choose_susp_type(String suspType) {
		ta_notes.shouldBe(visible);
		if (suspType.equalsIgnoreCase("Soft"))
			rd_softSusp.click();
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		go_to_next_page();
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName() + "_Review");
	}
}