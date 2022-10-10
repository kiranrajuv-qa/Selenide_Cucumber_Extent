/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.hooks;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import framework.constants.Generic;
import framework.constants.Registration;
import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.enums.RegistrationContext;
import framework.utils.OracleDataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class RegistrationHooks {
	TestContext testContext;
	OracleDataProvider oracle;
	String msisdn;

	public RegistrationHooks(TestContext context) {
		testContext = context;
		oracle = new OracleDataProvider();
		OracleDataProvider.getConnection();
	}

	@Before("@RetailRegistration or @CorporateRegistration")
	public void switchRegistrationFlow(Scenario scenario) {
		// System.out.println("Scenario tags:");
		List<String> tagList = new ArrayList<String>();
		if (scenario.getSourceTagNames() != null) {
			for (String tag : scenario.getSourceTagNames()) {
				tagList.add(tag.substring(1));
				// System.out.println(tag.substring(1));
			}
			if (tagList.contains("CorporateRegistration")) {
				testContext.getScenarioContext().setContext(RegistrationContext.REG_TYPE, Registration.REG_TYPE_CORP);
				if (tagList.contains("Direct"))
					testContext.getScenarioContext().setContext(RegistrationContext.REG_TYPE,
							Registration.REG_TYPE_CORP_DIR);
				else if (tagList.contains("StarterKit"))
					testContext.getScenarioContext().setContext(RegistrationContext.REG_TYPE,
							Registration.REG_TYPE_CORP_SP);
			}
			// Set Business Type
			if (tagList.contains("Postpaid"))
				testContext.getScenarioContext().setContext(GenericContext.BUSINESS_TYPE,
						Generic.BUSINESS_TYPE_POSTPAID);
			else if (tagList.contains("Prepaid"))
				testContext.getScenarioContext().setContext(GenericContext.BUSINESS_TYPE,
						Generic.BUSINESS_TYPE_PREPAID);
			else if (tagList.contains("Hybrid"))
				testContext.getScenarioContext().setContext(GenericContext.BUSINESS_TYPE, Generic.BUSINESS_TYPE_HYBRID);
			// Set MSISDN Selection
			if (tagList.contains("Manual"))
				testContext.getScenarioContext().setContext(RegistrationContext.MSISDN_SELECTION,
						Registration.MSISDN_SEL_MANUAL);
			else if (tagList.contains("Automatic"))
				testContext.getScenarioContext().setContext(RegistrationContext.MSISDN_SELECTION,
						Registration.MSISDN_SEL_AUTO);
			if (tagList.contains("RetailRegistration")) {
				// Set Registration Type
				if (tagList.contains("WhiteSIM"))
					testContext.getScenarioContext().setContext(RegistrationContext.REG_TYPE,
							Registration.REG_TYPE_RETAIL_WS);
				else if (tagList.contains("StarterKit"))
					testContext.getScenarioContext().setContext(RegistrationContext.REG_TYPE,
							Registration.REG_TYPE_RETAIL_SP);
			}
		}
	}

	@After("@RetailRegistration or @CorporateRegistration")
	public void validateRegistrationStatus() {
		msisdn = (String) testContext.scenarioContext.getContext(GenericContext.MSISDN);
		oracle.getServiceInfo(msisdn);
		try {
			assertEquals(oracle.validateSchedulesStatus("INST"),"A");
			assertEquals(oracle.validateProvisioningStatus(),"E");
			assertEquals(oracle.validateOrderStatus(),"E");
			assertEquals(oracle.validateServiceStatus(msisdn,"AC"),"AC");
		}
		finally {
			OracleDataProvider.closeConnection();
		}
	}
}