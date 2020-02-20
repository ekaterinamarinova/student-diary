package steps;

import com.diary.model.Parent;
import com.diary.model.Student;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Objects;

public class GetStudentGradeSteps extends StepsUtil {

    private Student student;
    private Parent parent;

    @Given("The student has grades")
    public void theStudentHasGrades() {
        student = getStudentWithRandomGrade();
        Assert.assertTrue(Objects.nonNull(student));
    }

    @And("There is a student with name {string}")
    public void thereIsAStudentNamedString(String name) {
        Assert.assertEquals(name, student.getStudentFirstName());
    }

    @When("Parent requests to see the grades")
    public void whenParentRequestsToSeeGrades() {
        parent = getParent();
        parent.getStudentList().forEach(
                stud -> {
                    Assert.assertFalse(stud.getGradeList().isEmpty());
                }
        );
    }

    @Then("The grades are returned")
    public void theGradesAreReturned() {
        parent.getStudentList().forEach(stud -> {
                Assert.assertFalse(stud.getGradeList().isEmpty());
        });
    }
//    @Given("I have a valid employee id with name {string}")
//    public void iHaveAValidEmployeeId(String name) {
//        PostEmployeeSteps postEmployeeSteps = new PostEmployeeSteps();
//        postEmployeeSteps.iCreateAnEmployeeWithTheSameNameName(name);
//        RestAssuredResponseImpl restAssuredResponse = postEmployeeSteps.getResponse();
//        employeeId = new Converter().stringToDto(restAssuredResponse, EmployeeDto.class).getId();
//    }
//
//    @When("I get that employee by id")
//    public void iGetThatEmployeeById() {
//        response = getEmployeeById(employeeId);
//    }
//
//    @Then("Employee with name {string} is returned")
//    public void employeeWithNameGetByIdNameIsReturned(String name) {
//        EmployeeDto employeeDto = new Converter().stringToDto(response, EmployeeDto.class);
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(employeeDto.getName(), name);
//        softAssert.assertAll();
//    }
}
