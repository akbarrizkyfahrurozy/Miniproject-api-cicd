@ProdukKategori
Feature: As user i want to see categories and add new categories

  Scenario: POST - As a user I want to create a new kategori
    Given user set endpoint for kategori
    And user success login with valid account
    When user input token in authorization
    And user send request to endpoint kategori
    Then user see status code 200
    And user see new kategori response

  Scenario: GET - As a user I want to get all categories
    Given user set endpoint for kategori
    When user send request kategori
    Then user see status code 200
    And user see all kategori