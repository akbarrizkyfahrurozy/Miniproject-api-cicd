@Orders
Feature: As user i want to test order on website

  Scenario: POST - As a user I want to create a new order
    Given user set endpoint for order
    And user success login with valid account
    When user input token in authorization
    Then user see status code 200
    And user see new order response

  Scenario: GET - As a user I want to list all my order
    Given user set endpoint for order
    When user send request to endpoint order
    When user input token in authorization
    And user see status code 200
    Then user show list of the order
