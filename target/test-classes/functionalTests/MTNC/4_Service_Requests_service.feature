@ServiceRequests @Service
Feature: CLM Service Requests - Service

  Background: User is Logged In
    Given user is logged in

  @Postpaid @COS @PACK
  Scenario: Postpaid - Change Plan
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And choose a plan
      | Plan Name | GPRS HYBRID PACKAGE |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @COS @ACUG
  Scenario: Hybrid - Add CUG
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And add a CUG
      | Cug Name   | ELITE 750 CUG |
      | Group Name | 1013_MIGEC SA |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @COS @DCUG
  Scenario: Hybrid - Remove CUG
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And remove a CUG
      | Cug Name | ELITE 125 CUG |
    And submit the flow
    Then flow submitted successfully

  @Prepaid @COS @VAS
  Scenario: Prepaid - Add VAS
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And add a VAS
      | Category | Generic                  |
      | Name     | BTL_MIX_W12/4999F=45500F |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @COS @RVAS
  Scenario: Prepaid - Remove VAS
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And remove a VAS
      | Name | BILL DISCOUNT 14% - HB |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @COS @SIMC
  Scenario: Hybrid - SIMSWAP
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And sim swap
      | SIM Number  | 892370007503659857 |
      | IMSI Number |    624017503659857 |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @COS @BARUBAR
  Scenario: Hybrid - BARUNBAR
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And bar a service
      | Service type | UnBarred Service               |
      | Name         | AVAIL OUT GOING CALLS FACILITY |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @COS @HPRT
  Scenario: Hybrid to Prepaid Migration
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And Hybrid to Prepaid
      | Plan Name | PRO100 |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @COS @HTON
  Scenario: Hybrid to Postpaid Migration
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And Hybrid to Postpaid
      | Plan Name | GROUPE 1145-PEF |
    And submit the flow
    Then flow submitted successfully

  @Postpaid @COS @NTOH
  Scenario: Postpaid to Hybrid Migration
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And Postpaid to Hybrid
      | Plan | SERVICE HYBRID MAERSK-BANKH |
    And submit the flow
    Then flow submitted successfully

  @Postpaid @COS @PPRT
  Scenario: Postpaid to Prepaid Migration
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And Postpaid to Prepaid
      | Plan | MTN STAFF-PRP1 |
    And submit the flow
    Then flow submitted successfully

  @Prepaid @COS @PRPO
  Scenario: Prepaid to Postpaid Migration
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And Prepaid to Postpaid
      | Plan | GROUPE 1145-GOLD |
    And submit the flow
    Then flow submitted successfully

  @Prepaid @COS @HRPO
  Scenario: Prepaid to Hybrid Migration
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And Prepaid to Hybrid
      | Plan | GPRS HYBRID PACKAGE |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @SERUPD @SERGEN
  Scenario: Hybrid - Modify Service Details
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And Modify Service Details
    And submit the flow
    Then flow submitted successfully

  @Hybrid @SERUPD @RPWD
  Scenario: Hybrid - Reset Password
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And reset the password
      | Type | Me2U PIN Reset |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @SERUPD @CHLG
  Scenario: Hybrid - Change Language
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And Modify Preferred Language
      | Language | ENGLISH |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @SERINF @PINPUKREQ
  Scenario: Hybrid - PIN/PUK Request
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And request for pin puk
    And submit the flow
    Then flow submitted successfully

  @Hybrid @LCS @SUSP
  Scenario: Hybrid - Suspension of Service
    Given search with "Active" msisdn
      | MSISDN | 680975856 |
    When go to service request page
    And choose suspension type
      | Type | Hard |
    And submit the flow
    Then flow submitted successfully
    And validate service request status

  @Hybrid @LCS @RESP
  Scenario: Hybrid - Revoke Suspension
    Given search with "Suspended" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And revoke suspension of service
    And submit the flow
    Then flow submitted successfully

  @Hybrid @LCS @ERAS
  Scenario: Hybrid - Service Termination
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And terminate a service
    And submit the flow
    Then flow submitted successfully

  @Hybrid @DSTCL @ADST
  Scenario: Hybrid - Add Deposit
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And add a deposit
      | Amount | 10 |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @DSTCL @RDST
  Scenario: Hybrid - Refund Deposit
    Given search with "Active" msisdn
      | MSISDN | 670962280 |
    When go to service request page
    And refund a deposit
      | Amount | 10 |
    And submit the flow
    Then flow submitted successfully

  @Hybrid @DSTCL @MSL
  Scenario: Hybrid - Modify Service Limit
    Given search with "Active" msisdn
      | MSISDN | 670998529 |
    When go to service request page
    And modify service limit
      | Type   | Temparaely |
      | Amount |        100 |
    And submit the flow
    Then flow submitted successfully
