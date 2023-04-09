@Sample

Feature: E2E Checkout flow
  As a user should be able to proceed with E2E checkout flow

  Scenario Outline: Verify Home Page while click on Let's Shop Tab
    When User Select Country "Algeria"
    Then User Enters Name "<enterYourName>" Click on Search Input Box
    And User Choose Gender as "Male"
    And User clicks on Lets Shop Button


    Examples:
      | enterYourName |
      | test user     |

  Scenario: Verify Toast message Error validation
    And User clicks on Lets Shop Button
    Then Verify toast message

  Scenario: Verify User able to add product to basket
    When User Select Country "Algeria"
    Then User Enters Name "<enterYourName>" Click on Search Input Box
    And User Choose Gender as "Male"
    And User clicks on Add to basket