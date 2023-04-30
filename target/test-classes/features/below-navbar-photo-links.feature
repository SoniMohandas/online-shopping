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
    When User clicks fashion photo link
    Then User landed in the whole fashion link page

  Scenario: Electronic links
    When User clicks electronics photo link
    Then User landed in the whole electronics page

  Scenario: Home links
    When User clicks home and furniture link
    Then User can see whole home and furniture appliances page

  Scenario: Appliance link
    When User clicks appliance link
    Then User can land in the appliance page

  Scenario: Travel link
    When User clicks travel link
    Then User land in travel page

  Scenario: Top Offers link
    When User clicks top offers link
    Then User land in deals of the day page

  Scenario: Beauty, Toys and More link
    When User hower over beauty, toys and more and hover over baby care and clicks baby wipes
    Then User lands in baby wipes page

  Scenario: Two Wheelers link
    When User hover over two wheelers link and clicks electric vehicles
    Then User lands electric vehicles store page