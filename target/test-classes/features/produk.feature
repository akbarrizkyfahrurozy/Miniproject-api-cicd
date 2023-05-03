@Produk
Feature: As user i want to see product, create new product, see product by id, delete a product, see product comments

  Scenario: POST - As a user I want to create a new product
    Given user set endpoint for product
    When user send POST HTTP request with valid data product
    Then user see status code 200
    And user see new detail product

  Scenario: GET - As a user I want to get all product
    Given user set endpoint for product
    When user send request
    Then user see status code 200
    And user see product

  Scenario: DELETE - As a user I want to delete a product
    Given user set endpoint for delete product
    When user send request for delete product
    Then user see status code 200
    And user receive valid data for deleting product

  Scenario: GET - As a user I want to see product comments
    Given user set endpoint for product comments
    When user send request for product comments
    Then user see status code 200
    And user receive valid data for product comments