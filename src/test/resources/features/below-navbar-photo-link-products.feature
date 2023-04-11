Feature: Just below navbar products photo links
  Background:
    Given User is in the flipcart website opening page

  Scenario: Grocery links
    When User clicks grocery photo link
    Then User can landed in the grocery page

  Scenario: Mobile links
    When User clicks mobile photo link
    Then User can landed in the mobile electronic page

  Scenario: Fashion links
    When User hover over fashion photo link then Men Footwear then Men's Casual Shoes
    Then New Casual shoes page opened

  Scenario: Electronic links
    When User hover over electronics photo link then gaming link then clicks games link
    Then User can see Games video games and game devices

  Scenario: Home links
    When User hover over home link then kitchen & dining link then cookware link and clicks
    Then User can see kitchen cookwares