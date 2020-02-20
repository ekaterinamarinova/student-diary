Feature: Grades are being changed

  Scenario: A teacher can change a student's grade
    Given a valid student exists
    When the teacher attempts to change a grade
    Then grade is changed