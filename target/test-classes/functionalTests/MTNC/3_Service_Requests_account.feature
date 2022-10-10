@ServiceRequests @Account @WIP
Feature: CLM Service Requests - Account

Background: User is Logged In
	Given user is logged in

@Postpaid @ACCUPD @ACCBLPRE
Scenario: Postpaid - Modify Billing Preferences
	Given search with "Active" msisdn
  	|	MSISDN	|	670998529	|
  When go to service request page
  And change email for billing
  	| Language	     |		ENGLISH	  |
  	| Email          |test@gmail.com  |
  	| Billing Region | Region1        |
  And submit the flow
  Then flow submitted successfully

@Hybrid @ACCUPD @ACCADDR
Scenario: Hybrid - Modify Billing Address
	Given search with "Active" msisdn
  	|	MSISDN	|	670998529	|
  When go to service request page
  And modify billing address
  	|postBoxNumber | 49373       |
  	|streetName    |Bangalore     |
  	|address1	   |Mahadevapura  |
  	|address2	   |Tin Factory	  |
  	|region		   |North	        |
  	|city 		   |Home          |
  And submit the flow
  Then flow submitted successfully

@Postpaid @ACCUPD @PTP
Scenario: Postpaid - Promise To Pay
	Given search with "Active" msisdn
  	|	MSISDN	|	670998529	|
  When go to service request page
  And choose promise to pay date
  | Date | 11/09/2021  |
  And submit the flow
  Then flow submitted successfully
