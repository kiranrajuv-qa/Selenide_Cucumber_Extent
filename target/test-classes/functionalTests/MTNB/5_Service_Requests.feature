@ServiceRequests @WIP
Feature: CLM Service Requests

  Background: User is Logged In
    Given user is logged in

  @Prepaid @Service @COS @PACK
  Scenario: Prepaid Change Plan
    Given search with "Active" msisdn
      | MSISDN | 62971887 |
    When go to service request page

  @Postpaid @Account @ACCUPD @ACCBLPRE
  Scenario: Postpaid Modify Billing Preferences
    Given search with "Active" msisdn
      | MSISDN | 62971887 |
    When go to service request page
