package steps;

import com.diary.exception.WrongGradeValueException;
import com.diary.model.Student;
import com.diary.model.Subject;
import com.diary.model.admin.Teacher;
import com.diary.model.enums.SubjectName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChangeStudentGradesStep extends StepsUtil {

    private Teacher teacher;
    private Student student = getStudent();

    @Given("a valid student exists")
    public void aValidStudentExists() throws WrongGradeValueException {
        teacher = getTeacher();

        teacher.getStudentGrades()
                .forEach(m -> {
                    boolean hasStudent = m.containsKey(new Student("Peshko", "Peshev"));
                    Assert.assertTrue(hasStudent);
                });

    }

    @When("the teacher attempts to change a grade")
    public void theTeacherAttemptsChange() throws WrongGradeValueException {
        teacher.getStudentGrades().get(0).get(student).set(0, Teacher.createGrade(3, new Subject(SubjectName.SPORTS.getName())));
    }

    @Then("grade is changed")
    public void gradeIsChanged() {
        Assert.assertEquals(SubjectName.SPORTS.getName(), teacher.getStudentGrades().get(0)
                .get(student)
                .get(0)
                .getSubject()
                .getSubjectName());
    }

    /**==============================================================================================================*/

    @Given("student is on an exam")
    @And("student passes the exam")
    @When("teacher attempts to grade with invalid grade")
    @Then("an error occurs")
    public void teacherAttemptsToGradeWithInvalidGrade() {
        boolean exceptionThrown;
        try {
            Teacher.createGrade(1, new Subject(SubjectName.CALCULUS.getName()));
        } catch (WrongGradeValueException e) {
            exceptionThrown = true;
            Assert.assertTrue(exceptionThrown);
        }

    }

}
