Feature: Test Create Prescriptions
@test
  Scenario: Create and Edit prescriptions
    Given User opened Doctor portal successfully
    When Doctor Create prescription to patient
    Then prescription should appear in pending prescription
    And Doctor can edit the prescription
