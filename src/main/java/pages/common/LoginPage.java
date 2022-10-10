/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package pages.common;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import framework.cucumberContext.TestContext;
import framework.utils.FileReaderUtils;

public class LoginPage extends BasePage {

	public LoginPage(TestContext context) {
		super(context);
	}

	private SelenideElement txt_userName = $("#username");
	private SelenideElement txt_password = $("#password");
	private SelenideElement lnk_language = $("#lang-selector");

	public void launchApplication() {
		open("/");
		ExtentCucumberAdapter.addTestStepLog("CLM has been launched");
		if(lnk_language.exists())
			if(lnk_language.getText().equals("English")) {
				lnk_language.click();
				ExtentCucumberAdapter.addTestStepLog("Language changed to English");
			}
	}

	public void do_login() {
		txt_userName.should(appear);
		ExtentCucumberAdapter.addTestStepLog("Login page loaded");
		txt_userName.val(FileReaderUtils.getInstance().getConfigReader().getCLMUserName());
		ExtentCucumberAdapter.addTestStepLog("Entered username");
		txt_password.val(FileReaderUtils.getInstance().getConfigReader().getCLMPassword());
		ExtentCucumberAdapter.addTestStepLog("Entered password");
		Selenide.screenshot(scenarioName + "\\" + getClass().getSimpleName());
		txt_password.pressEnter();
		ExtentCucumberAdapter.addTestStepLog("Pressed enter and logged in");
	}
}