@cucumber
@adding
@SuccessfulPurchase
Feature: Add new products to the cart

  In order to have a list of products
  As a potential buyer
  I want to be able to add products to the cart
  Scenario: Successful purchase of products
    Given a list of products on the main page
    Then there should be more than 3 products on the main page

    When the user clicks a product
    Then the user should be on the product page with product1 and URL "https://www.demoblaze.com/prod.html?idp_="
    And the user clicks the add to cart button on the product page

    When the user clicks the main page button
    Then the user should be on the main page "https://www.demoblaze.com/index.html"

    Then the user clicks another product
    Then the user should be on the product page with product2 and URL "https://www.demoblaze.com/prod.html?idp_="
    Then the user clicks add to cart button

    And the user navigates to the cart page
    Then the user should be on the cart page "https://www.demoblaze.com/cart.html"
    Then selected products should be on the cart page

    When the user clicks the place order button
    Then the user fills the fields and sweet alert is shown
