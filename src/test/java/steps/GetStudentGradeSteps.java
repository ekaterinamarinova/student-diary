package steps;

import com.diary.exception.WrongGradeValueException;
import com.diary.model.Parent;
import com.diary.model.Student;
import com.diary.model.admin.Grade;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class GetStudentGradeSteps extends StepsUtil {

    private Student student;
    private Parent parent;

    @Given("The student has grades")
    public void theStudentHasGrades() {
        student = getStudent();
        Assert.assertTrue(Objects.nonNull(student));
    }

    @And("There is a student with name {string}")
    public void thereIsAStudentNamedString(String name) {
        Assert.assertEquals(name, student.getStudentFirstName());
    }

    @When("Parent requests to see the grades")
    public void whenParentRequestsToSeeGrades() throws WrongGradeValueException {
        parent = getParent();
        parent.getStudentList().forEach(
                (stud, grList) -> {
                    Assert.assertFalse(grList.isEmpty());
                }
        );
    }

    @Then("The grades are returned")
    public void theGradesAreReturned() {
        Optional<Grade> grade = parent.getStudentList().getOrDefault(student, new ArrayList<>())
                .stream()
                .findFirst();

        Assert.assertTrue(grade.isPresent());
        Assert.assertTrue(grade.get().getGradeValue() != 0);
    }

}
