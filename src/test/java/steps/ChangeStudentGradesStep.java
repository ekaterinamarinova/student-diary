package steps;

import com.diary.model.Student;
import com.diary.model.Subject;
import com.diary.model.admin.Teacher;
import com.diary.model.enums.SubjectName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChangeStudentGradesStep extends StepsUtil {

    private Teacher teacher;
    private Student student = getStudent();

    @Given("a valid student exists")
    public void aValidStudentExists() throws InterruptedException {
        teacher = getTeacher();

        teacher.getStudentGrades()
                .forEach(m -> {
                    boolean hasStudent = m.containsKey(new Student("Peshko", "Peshev"));
                    Assert.assertTrue(hasStudent);
                });

    }

    @When("the teacher attempts to change a grade")
    public void theTeacherAttemptsChange() {
        teacher.getStudentGrades().get(0).get(student).set(0, Teacher.getGrade(3, new Subject(SubjectName.SPORTS.getName())));
    }

    @Then("grade is changed")
    public void gradeIsChanged() {
        Assert.assertEquals(SubjectName.SPORTS.getName(), teacher.getStudentGrades().get(0)
                .get(student)
                .get(0)
                .getSubject()
                .getSubjectName());
    }
}
