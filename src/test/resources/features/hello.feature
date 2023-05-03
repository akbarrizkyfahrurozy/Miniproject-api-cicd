@Hello
Feature: As user i want to test page hello

  Scenario: GET - As a user I want to test hello page
    Given user set endpoint for hello
    When user send request to endpoint
    And user see status code 200
    Then user show hello message