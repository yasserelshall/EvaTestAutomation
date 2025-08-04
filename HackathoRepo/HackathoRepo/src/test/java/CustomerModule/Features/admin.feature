
Feature: Test request medication
  @delivery
  Scenario: To do medication requests home delivery
    Given User opened admin portal successfully
    When User navigate to home delivery page
    Then User should be able to check his home delivery requests
@pickup
    Scenario: To do medication requests pick up
      Given User opened admin portal successfully
      When User navigate to pickup page
      Then User should be able to check his pick up requests