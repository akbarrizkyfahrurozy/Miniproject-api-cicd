@Register
Feature: As user i want to create account So that i can login and see home page

  Scenario: POST - As a user I success to create account with valid data
    Given user set endpoint for register
    When user send create account with valid data
    Then user see status code 200 after send register
    And user see new detail account

@register-invalid
  Scenario: POST - As a user I failed to create account with empty password
    Given user set endpoint for register
    When user send POST HTTP request with empty password data register
    Then user see status code 400 and fail to create account