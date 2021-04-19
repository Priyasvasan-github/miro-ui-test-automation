Feature: Verify Authorization of MiroService

  @Regression
  Scenario: Verify a valid user is able to authorize into Miro portal successfully
    Given A valid user is accessing Miro login portal
    When He attempts to Login with his credentials
    Then User is authorized into the portal

  @Regression
  Scenario: Verify a inValid user is unable to authorize into Miro portal
    Given A inValid user is accessing Miro login portal
    When He attempts to Login with his credentials
    Then User is not authorized into the portal

  @manual @Regression
  Scenario Outline: Verify a inValid user is displayed with expected error message
    Given A <userType>  is accessing Miro login portal
    When He attempts to Login with his credentials
    Then User is not authorized into the portal
    And <ErrorMessage> is displayed as expected
    Examples:
      | userType  |  ErrorMessage |
      | inValid        |  The email or password you entered is incorrect|
      | noPasswordDetails | Please enter your password|
      | noEmailDetails | Please enter your email address|
