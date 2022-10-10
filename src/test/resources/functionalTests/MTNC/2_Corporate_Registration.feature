@CorporateRegistration
Feature: CLM Registration

  Background: User is Logged In
    Given user is logged in
    And enter registration flow

  @Hybrid @Manual
  Scenario: Corporate Hybrid Registration
    When capture corporate customer profile
    And define corporate billing account
    And capture corporate service info
      | Plan Name | GPRS HYBRID PACKAGE |
      | MSISDN    |           670016792 |
      | SIM       |  892370007503660851 |
    And submit the flow
    Then customer registered successfully

  @Postpaid @Manual
  Scenario: Corporate Postpaid Registration
    When capture corporate customer profile
    And define corporate billing account
    And capture corporate service info
      | Plan Name | MTN ELITE CORPORATE PACKAGE |
      | MSISDN    |                   670004534 |
      | SIM       |          892370007503657884 |
    And submit the flow
    Then customer registered successfully

  @Hybrid @AddAccountService @Direct @Manual
  Scenario: Corporate Hybrid Add Service to Existing Account
    When search with "Active" msisdn
      | MSISDN | 67254406 |
    And add new account service
    And select offering
      | Plan Name | GPRS HYBRID PACKAGE |
    And add new service
    	| Kit Number  | 8922903415128029332|
    	| MSISDN      |          670995647 |
      | SIM Number  | 892370007503654427 |
      | IMSI Number |    624017503654427 |
    And select "existing" account
      | Account ID |  |
    And submit the flow
    Then customer registered successfully

  @Hybrid @AddAccountService @Direct @Automatic
  Scenario: Corporate Hybrid Add Service to Existing Account
    When search with "Active" msisdn
      | MSISDN | 67254406 |
    And add new account service
    And select offering
      | Plan Name | GPRS HYBRID PACKAGE |
    And add new service
    	| Kit Number  | 8922903415128029332|
    	| MSISDN      |          670995647 |
      | SIM Number  | 892370007503654427 |
      | IMSI Number |    624017503654427 |
    And select "existing" account
      | Account ID |  |
    And submit the flow
    Then customer registered successfully

  @Postpaid @AddAccountService @StarterKit
  Scenario: Corporate Postpaid Add Service to New Account
    When search with "Active" msisdn
      | MSISDN | 67254406 |
    And add new account service
    And select offering
      | Plan Name | GPRS HYBRID PACKAGE |
    And add new service
    	| Kit Number  | 8922903415128029332 |
      | MSISDN      |            67254406 |
      | SIM Number  | 8922903415128029332 |
      | IMSI Number |     616030112802933 |
    And select "new" account
      | Account ID |  |
    And submit the flow
    Then customer registered successfully
