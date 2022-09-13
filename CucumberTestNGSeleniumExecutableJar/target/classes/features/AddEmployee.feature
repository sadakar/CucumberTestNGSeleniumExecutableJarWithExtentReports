@AddEmployeeFeature
Feature: Add Employee
  I want to use this template for my Directory Page

  Background: 
    Given User login to HRM application with UserName and Password
      | Admin | admin123 |

  @AddEmployee @SmokeTest
  Scenario: Navigation to Add Employee page
    Then User navigates to Add Employee page