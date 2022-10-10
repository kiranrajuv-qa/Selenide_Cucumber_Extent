@CorporateRegistration @WIP
Feature: CLM Registration

Background: User is Logged In
	Given user is logged in
	And enter registration flow

@Hybrid
Scenario: Corporate Hybrid Registration
	When capture corporate customer profile
	And define corporate billing account
		| Business Type	| Hybrid	|
	And capture corporate service info
		| Plan Name			|	SERVICE CLAS HYBRID-AMBCH	|
		|	MSISDN				|	62972305									|
		|	SIM						|	8922903115110726297				|
	And submit the flow
	Then customer registered successfully

@Postpaid
Scenario: Corporate Postpaid Registration
	When capture corporate customer profile
	And define corporate billing account
		| Business Type	| Postpaid	|
	And capture corporate service info
		| Plan Name			|	GROUPE 1145-TEST		|
		|	MSISDN				|	62972305						|
		|	SIM						|	8922903115110726297	|
	And submit the flow
	Then customer registered successfully