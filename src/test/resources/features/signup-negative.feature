Feature: Flipcart Online Shopping Website Sign Up

  Scenario: New user sign up negative
    Given User is in the flipcart website opening page
    Then A new login page opens
    When User clicks create an account button
    Then Looks like you are new here page opens
    When User entered his phone number
    When User clicks continue button
    Then Invalid mobile number message appears