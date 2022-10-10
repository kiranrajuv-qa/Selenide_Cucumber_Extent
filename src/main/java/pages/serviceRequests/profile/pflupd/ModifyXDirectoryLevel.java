package pages.serviceRequests.profile.pflupd;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import pages.common.BasePage;

public class ModifyXDirectoryLevel extends BasePage {
	public ModifyXDirectoryLevel(TestContext context) {
		super(context);
	}

	private SelenideElement lst_directory_level = $(By.name("selectLevel"));

	public void modify_xdirectory(String level) {
		lst_directory_level.selectOption(level);
		ExtentCucumberAdapter.addTestStepLog("Selected X directory level as " + level);
		go_to_next_page();
	}
}