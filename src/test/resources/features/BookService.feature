Feature: Crud Service for Book Database

  Scenario: readAll book by Author
    When  calling findAll book by Author
    Then  check findAllBookByAuthor called

  Scenario: read book by name
    When  calling find by name
    Then  check findBookName called

  Scenario: read book by id
    When  calling find by id
    Then  check findBookId called