# new feature
# Tags: optional

Feature: The students' grades are returned

  Scenario: Parent can get information about a student
    Given The student has grades
    And There is a student with name 'Peshko'
    When Parent requests to see the grades
    Then The grades are returned