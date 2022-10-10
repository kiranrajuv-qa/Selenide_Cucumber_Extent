@ServiceRequests @Profile @PFLUPD
Feature: CLM Service Requests - Profile

  Background: User is Logged In
    Given user is logged in

  @Hybrid @PFLGEN
  Scenario: Prepaid Modify Profile
    Given search with "Active" msisdn
      | MSISDN | 670962284 |
    When go to service request page
    And modify profile details
      | FirstName   | Autotest1  |
      | lastName    | profile    |
      | gender      | Male       |
      | DateofBirth | 03/04/1997 |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @PFLNOT
  Scenario: Hybrid Modify Profile Contact & Notification Preferences
    Given search with "Active" msisdn
      | MSISDN | 680975855 |
    When go to service request page
    And modify contact & notification details
      | email   | modify10@gmail.com |
      | contact |        8755353533 |
    And submit the flow
    Then flow submitted successfully
    And verify modified info

  @Hybrid @PFLID
  Scenario: Hybrid Modify Profile Identification Details
    Given search with "Active" msisdn
      | MSISDN | 670962284 |
    When go to service request page
    And modify identification details
      | placeOfIssue | Bangalore  |
      | issuedDate   | 14/03/1995 |
      | expiryDate   | 13/03/2045 |
      | contactnum   | 9763754443 |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @PFLADD
  Scenario: Postpaid Modify Profile Address
    Given search with "Active" msisdn
      | MSISDN | 670962284 |
    When go to service request page
    And changed address details
      | addresstype | Permanent |
      | postboxnum  | CHE124    |
      | country     | Cameroon  |
      | nationality | Centre    |
      | city        | Bamoko    |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @MXDIR
  Scenario: Postpaid Modify Profile X-Directory Level
    Given search with "Active" msisdn
      | MSISDN | 670962284 |
    When go to service request page
    And modify x directory level
      | LEVEL | Level 5 |
    And submit the flow
    Then flow submitted successfully
