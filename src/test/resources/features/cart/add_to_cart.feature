@cucumber
@adding
Feature: Add new products to the cart

  In order to have a list of products
  As a potential buyer
  I want to be able to add products to the cart
  @SuccessfulAddToCart
  Scenario: Adding multiple products to the cart
    Given a list of products on the main page
    Then there should be more than 3 products on the main page
    When the user clicks a product
    And the user clicks the add to cart button on the product page
    And the user returns to the main page
    Then the user clicks another product
    And the user navigates to the cart page
    Then products should be added to the cart
    When the user clicks the place order button
    Then the user fills the fields and sweet alert is shown
