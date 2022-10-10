/*
 * @author vysyaki (Kiranraju Vysyaraju)
 * @email kiranraju.vysyaraju@tecnotree.com
*/

package stepDefinitions.hooks;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import framework.constants.ServiceRequest;
import framework.cucumberContext.TestContext;
import framework.enums.GenericContext;
import framework.enums.ServiceRequestContext;
import framework.utils.OracleDataProvider;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class ServiceRequestHooks {
	TestContext testContext;
	OracleDataProvider oracle;
	String msisdn, serviceStatus, cbsSubType;

	public ServiceRequestHooks(TestContext context) {
		testContext = context;
		oracle = new OracleDataProvider();
		OracleDataProvider.getConnection();
	}

	@Before("@ServiceRequests")
	public void switchFlow(Scenario scenario) {
		System.out.println(scenario.getName() + " flow started");
		List<String> list = new ArrayList<String>();
		if (scenario.getSourceTagNames() != null) {
			for (String tag : scenario.getSourceTagNames()) {
				list.add(tag.substring(1));
			}
			if (list.contains("ServiceRequests")) {
				if (list.contains("Service")) {
					// Set Service Request Level
					testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_LEVEL,
							ServiceRequest.REQ_LEVEL_SERVICE);
					if (list.contains("COS")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_COS);
						// Set Service Request Sub Type
						if (list.contains("PACK"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_PACK);
						else if (list.contains("SIMC"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_SIMC);
						else if (list.contains("MOBC"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_MOBC);
						else if (list.contains("BARUBAR")) {
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_BARUBAR);
							cbsSubType = "MACT";
						} else if (list.contains("VAS"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_VAS);
						else if (list.contains("RVAS"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_RVAS);
						else if (list.contains("ACUG"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_ACUG);
						else if (list.contains("DCUG"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_DCUG);
						else if (list.contains("TROW"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_TROW);
						else if (list.contains("PRPO"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_PRPO);
						else if (list.contains("PPRT"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_PPRT);
						else if (list.contains("HRPO"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_HRPO);
						else if (list.contains("HPRT"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_HPRT);
						else if (list.contains("HTON"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_HTON);
						else if (list.contains("NTOH"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_COS_NTOH);
					} else if (list.contains("LCS")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_LCS);
						// Set Service Request Sub Type
						if (list.contains("SUSP"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_LCS_SUSP);
						else if (list.contains("RESP"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_LCS_RESP);
						else if (list.contains("ERAS"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_LCS_ERAS);
					} else if (list.contains("SERINF")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_SERINF);
						// Set Service Request Sub Type
						if (list.contains("PINPUKREQ"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_SERINF_PINPUKREQ);
					} else if (list.contains("SERUPD")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_SERUPD);
						// Set Service Request Sub Type
						if (list.contains("CHLG"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_SERUPD_CHLG);
						else if (list.contains("RPWD"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_SERUPD_RPWD);
						else if (list.contains("SERGEN"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_SERUPD_SERGEN);
					} else if (list.contains("DSTCL")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_DSTCL);
						// Set Service Request Sub Type
						if (list.contains("ADST"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_DSTCL_ADST);
						else if (list.contains("RDST"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_DSTCL_RDST);
						else if (list.contains("MSL"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_DSTCL_MSL);
					}
				} else if (list.contains("Account")) {
					// Set Service Request Level
					testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_LEVEL,
							ServiceRequest.REQ_LEVEL_ACCOUNT);
					if (list.contains("ACCUPD")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_ACCUPD);
						// Set Service Request Sub Type
						if (list.contains("ACCBLPRE"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_ACCUPD_ACCBLPRE);
						else if (list.contains("ACCADDR"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_ACCUPD_ACCADDR);
						else if (list.contains("PTP"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_ACCUPD_PTP);
					} else if (list.contains("PAYMENT")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_PAYMENT);
						// Set Service Request Sub Type
						if (list.contains("PAYINV"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_PAYMENT_PAYINV);
					}
				} else if (list.contains("Profile")) {
					// Set Service Request Level
					testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_LEVEL,
							ServiceRequest.REQ_LEVEL_PROFILE);
					if (list.contains("PFLUPD")) {
						// Set Service Request Type
						testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_TYPE,
								ServiceRequest.REQ_PFLUPD);
						// Set Service Request Sub Type
						if (list.contains("PFLGEN"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_PFLUPD_PFLGEN);
						else if (list.contains("PFLADD"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_PFLUPD_PFLADD);
						else if (list.contains("PFLNOT"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_PFLUPD_PFLNOT);
						else if (list.contains("PFLID"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_PFLUPD_PFLID);
						else if (list.contains("MXDIR"))
							testContext.getScenarioContext().setContext(ServiceRequestContext.REQ_SUBTYPE,
									ServiceRequest.REQ_PFLUPD_MXDIR);
					}
				}
			}
		}
	}

	@Then("validate service request status")
	public void validateSRStatus() {
		msisdn = (String) testContext.scenarioContext.getContext(GenericContext.MSISDN);
		if (cbsSubType == null)
			cbsSubType = (String) testContext.scenarioContext.getContext(ServiceRequestContext.REQ_SUBTYPE);
		oracle.getServiceInfo(msisdn);
		try {
			assertEquals(oracle.validateSchedulesStatus(cbsSubType), "A");
			assertEquals(oracle.validateProvisioningStatus(), "E");
			assertEquals(oracle.validateOrderStatus(), "E");
			if (cbsSubType.equals("SUSP"))
				serviceStatus = "SP";
			else if (cbsSubType.equals("RESP"))
				serviceStatus = "AC";
			else if (cbsSubType.equals("ERAS"))
				serviceStatus = "ER";
			if (cbsSubType.equals("SUSP") || cbsSubType.equals("RESP") || cbsSubType.equals("ERAS"))
				assertEquals(oracle.validateServiceStatus(msisdn, serviceStatus), serviceStatus);
		} finally {
			OracleDataProvider.closeConnection();
		}
	}
}