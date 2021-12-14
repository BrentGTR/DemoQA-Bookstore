@BookFeatures
Feature: As a user, I want to search for a book so that I can perform various actions on the book

  Background: I am on the Home Page
    Given I am on the Home Page

  @SearchForBooks
  Scenario: I want to search for a book with the title of "Speaking Javascript"
    When I search for "Speaking JavaScript"
    Then verify that the book displayed has a title of "Speaking JavaScript"

  @DeleteBooksInCollection @AddBookToCollection @SearchForBooks
  Scenario: I want to delete all books in my collection
    Given I am on the Home Page
    When I go to the login page
    And I log into the bookstore using the username of "spriteCloudUser" and "Indominus1*"
    Then verify that the Profile page is displayed
    Given I am on the Home Page
    And I search for "Speaking JavaScript"
    And I add the book to my collection
    Then I can see a pop-up that says "Book added to your collection."
    When I delete all books in my collection
    Then I can see a pop-up that says "All Books deleted."