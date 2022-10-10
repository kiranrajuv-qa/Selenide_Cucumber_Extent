/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.common;

import framework.cucumberContext.TestContext;
import io.cucumber.java.en.Given;
import pages.common.LoginPage;

public class LoginPageSteps {

	LoginPage loginPageActions;
	TestContext testContext;
	
	public LoginPageSteps(TestContext context) {
		loginPageActions = new LoginPage(context);
		testContext = context;
	}

	@Given("^user is logged in$")
	public void user_is_logged_in() {
		loginPageActions.launchApplication();
		loginPageActions.do_login();
	}
}