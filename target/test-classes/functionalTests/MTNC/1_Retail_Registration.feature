@RetailRegistration
Feature: CLM Retail Registrations
  Description: The purpose of this feature is to test E2E Retail Registrations

  Background: User is Logged In
    Given user is logged in
    And enter registration flow

  @Hybrid @WhiteSIM @Manual
  Scenario: Retail WS Manual Hybrid Registration
    When select offering
      | Offering Name | MTN PRO BIZ |
    And select number
      | MSISDN      |          670003564 |
      | SIM Number  | 892370007503664321 |
      | IMSI Number |    624017503664321 |
    And capture customer profile
    And define billing account
    And submit the registration flow
    Then customer registered successfully
    When start credit vetting

  @Prepaid @WhiteSIM @Automatic
  Scenario: Retail WS Automatic Prepaid Registration
    When select offering
      | Offering Name | MTN BEST |
    And select number
      | MSISDN      |                    |
      | SIM Number  | 892370007503660851 |
      | IMSI Number |    624017503660851 |
    And capture customer profile
    And submit the registration flow
    Then customer registered successfully

  @Postpaid @StarterKit
  Scenario: Retail Postpaid StarterKit Registration
    When select offering
      | Offering Name | MTN PRO BIZ |
    And enter starter kit details
      | Kit Number  | 				  112802933 |
      | MSISDN      |            67254406 |
      | SIM Number  | 8922903415128029332 |
      | IMSI Number |     616030112802933 |
    And capture customer profile
    And define billing account
    And submit the registration flow
    Then customer registered successfully
    When start credit vetting
