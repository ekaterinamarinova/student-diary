package steps;

import com.diary.model.Class;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;

public class GetClassInformationSteps extends StepsUtil {

    private Class aClass;

    @Given("There is a valid class that has a teacher")
    public void thereIsClassWithATeacher() {
        aClass = getClassInformation();
        Assert.assertNotNull(aClass);
    }

    @And("There are valid subjects in that class")
    public void thereAreValidSubjects() {
        Assert.assertFalse(aClass.getSubjectList().isEmpty());
    }

    @And("There are valid students assigned to the teacher")
    public void thereAreStudents() {
        Assert.assertFalse(aClass.getClassTeacher().getStudentList().isEmpty());
    }

    @When("Check for a subject named {string}")
    public void checkForASubject(String subjName) {
        Assert.assertTrue(aClass.getSubjectList().contains(subjName));
    }

    @Then("The subject is returned")
    public void theSubjectIsReturned() {
        Assert.assertNotNull(aClass.getSubjectList().get(0));
    }
}
