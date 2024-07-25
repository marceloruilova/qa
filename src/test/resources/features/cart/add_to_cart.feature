@cucumber
@adding
Feature: Add new products to the cart

  In order to have a list of products
  As a potential buyer
  I want to be able to add products to the cart
  @SuccessfulAddToCart
  Scenario: Adding a product to the cart
    Given a list of products on the main page
    When the user clicks a product
    Then product should be added to the cart
