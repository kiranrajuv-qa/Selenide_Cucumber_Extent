@Retail @Registration
Feature: CLM Retail Registrations
Description: The purpose of this feature is to test E2E Retail Registrations

Background: User is Logged In
	Given user is logged in

@WhiteSIM @Manual
Scenario Outline: Retail Registration
	Given enter "<reg_type>" registration flow
	When select "<business_type>" with plan "<plan_name>"
	And select MSISDN "<msisdn>" and SIM "<sim_number>"
	And capture customer profile
	And define billing account
	And cancel the flow
	Then registration cancelled successfully

	Examples:
	|	reg_type				|	business_type	|	plan_name									| msisdn					| sim_number					|
	|	GSM White SIM		|	Postpaid			|	GROUPE 1145-TEST					| 62504852				| 8922903070300065560	|
	|	GSM White SIM		|	Hybrid				|	SERVICE CLAS HYBRID-AMBCH	| 62504852				| 8922903070300065560	|
##	|	GSM White SIM		|	Postpaid			|	GROUPE 1145-TEST					| 								| 8922903115110728353	|
##	|	GSM Starter Kit	|	Prepaid				|	GENVAS										| 								| 892330100301004873	|
##	|	Corporate				|	Postpaid			|	GROUPE 1145-TEST					| 62971887				| 8922903115110726115	|
##	|	Corporate				|	Hybrid				|	SERVICE CLAS HYBRID-AMBCH	| 62972305				| 8922903115110726297	|
