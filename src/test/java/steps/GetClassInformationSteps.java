package steps;

import com.diary.constant.ApplicationConstant;
import com.diary.exception.WrongGradeValueException;
import com.diary.model.Class;
import com.diary.model.Student;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class GetClassInformationSteps extends StepsUtil {

    private Class aClass;

    @Given("There is a valid class that has a teacher")
    public void thereIsClassWithATeacher() throws WrongGradeValueException {
        aClass = getClassInformation();
        Assert.assertNotNull(aClass);
    }

    @And("There are valid students assigned to the teacher")
    public void thereAreStudents() {
        aClass.getClassTeacher().getStudentGrades().forEach(s -> {
            boolean hasStudent = s.containsKey(new Student(ApplicationConstant.STUDENT_FIRST_NAME, ApplicationConstant.STUDENT_LAST_NAME));
            Assert.assertTrue(hasStudent);
        });
    }

}
