# new feature
# Tags: optional

Feature: Information about classes is returned

  Scenario: Class contains correct information
    Given There is a valid class that has a teacher
    And There are valid subjects in that class
    And There are valid students assigned to the teacher
    When Check for a subject named 'Calculus'
    Then The subject is returned