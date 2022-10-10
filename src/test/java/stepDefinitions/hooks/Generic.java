/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.hooks;

import org.openqa.selenium.OutputType;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.utils.FileReaderUtils;
import framework.utils.OracleDataProvider;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Generic {
	TestContext testContext;

	public Generic(TestContext context) {
		testContext = context;
	}

	@Before(order = 1)
	public void setUp(Scenario scenario) {
		Configuration.browser = FileReaderUtils.getInstance().getConfigReader().getBrowser();
		Configuration.fastSetValue = true;
		Configuration.baseUrl = FileReaderUtils.getInstance().getConfigReader().getApplicationUrl();
		Configuration.startMaximized = FileReaderUtils.getInstance().getConfigReader().getBrowserWindowSize();
		Configuration.timeout = FileReaderUtils.getInstance().getConfigReader().getImplicitlyWait();
		Configuration.clickViaJs = FileReaderUtils.getInstance().getConfigReader().clickViaJs();
		Configuration.headless = FileReaderUtils.getInstance().getConfigReader().isHeadless();
		Configuration.downloadsFolder = "target/downloads";
		Configuration.reportsFolder = "target/reports/tests";

		testContext.getScenarioContext().setContext(GenericContext.SCENARIO_NAME, scenario.getName());
	}

	@After(order = 2)
	public void captureScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed() || FileReaderUtils.getInstance().getConfigReader().screenshotRequiredForPassedAlso())
			scenario.attach(Selenide.screenshot(OutputType.BYTES), "image/png", "");
		if (scenario.isFailed())
			Configuration.holdBrowserOpen = FileReaderUtils.getInstance().getConfigReader().holdBrowserOpen();
	}

	@After(order = 0)
	public void closeBrowser() {
		Selenide.closeWebDriver();
		OracleDataProvider.closeConnection();
	}
}