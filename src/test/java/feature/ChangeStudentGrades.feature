Feature: Grades are being changed

  Scenario: A teacher can change a student's grade
    Given a valid student exists
    When the teacher attempts to change a grade
    Then grade is changed

  Scenario: Grades are only changed within a range
    Given student is on an exam
    And student passes the exam
    When teacher attempts to grade with invalid grade
    Then an error occurs