@RetailRegistration
Feature: CLM Retail Registrations
Description: The purpose of this feature is to test E2E Retail Registrations

Background: User is Logged In
	Given user is logged in
	And enter registration flow

@Postpaid @WhiteSIM @Manual
Scenario: Retail WS Manual Postpaid Registration
	When select offering
		|	Offering Name	|	GROUPE 1145-TEST		|
	And select number
		|	MSISDN				|	62504852						|
		| SIM Number		|	8922903070300065560	|
		| IMSI Number		|	616030200006556			|
	And capture customer profile
	And define billing account
	And cancel the flow
	Then registration cancelled successfully

@Hybrid @WhiteSIM @Automatic
Scenario: Retail WS Automatic Hybrid Registration
	When select offering
		|	Offering Name	|	SERVICE CLAS HYBRID-AMBCH	|
	And select number
		|	MSISDN				|														|
		| SIM Number		|	8922903115110726297				|
		| IMSI Number		|	616030111072629						|
	And capture customer profile
	And define billing account
	And cancel the flow
	Then registration cancelled successfully

@Prepaid @StarterKit
Scenario: Retail Starter Kit Prepaid Registration
	When enter starter kit details
		|	Kit Number		|	8922903415128029332	|
		|	MSISDN				|	67254406						|
		| SIM Number		|	8922903415128029332	|
		| IMSI Number		|	616030112802933			|
	And select VAS
		| VAS Name			|	GENVAS	|
	And capture customer profile
	And cancel the flow
	Then registration cancelled successfully
