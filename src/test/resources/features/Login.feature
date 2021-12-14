@LoginFeatures
Feature: I want to log into the book store so that I can access all of the features

  Background: Log into the book store website
    Given I am on the Home Page
    When I go to the login page
    And  I log into the bookstore using the username of "spriteCloudUser" and "Indominus1*"

    @Login
  Scenario: Verify that the Profile page is displayed when I log in
    Then verify that the Profile page is displayed

      @Logout
  Scenario: I want to log out of the book store
    When I log out
    Then I can see the login page