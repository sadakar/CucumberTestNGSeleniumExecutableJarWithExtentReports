@HRMLoginFeature
Feature: Login to HRM Application
  I want to use this template for HRM Login page

  @HRMLogin @SmokeTest
  Scenario: Login to HRM applicaiton
    Given User login to HRM application with UserName and Password
      | Admin | admin123 |
    Then User navigates to Employee list page