@Login
Feature: As user I want to see home page So that i can buy product

  Scenario: POST - As a user I success to login with valid data
    Given user set endpoint for login
    When user send POST HTTP request with valid data
    Then user see status code 200
    And get valid data

  Scenario: POST - As a user i want to login with invalid data
    Given user set endpoint for login
    When user send POST HTTP request with invalid data
    Then user see status code 400
    And user get error message