package steps;

import com.diary.constant.ApplicationConstant;
import com.diary.exception.WrongGradeValueException;
import com.diary.model.Class;
import com.diary.model.Parent;
import com.diary.model.Student;
import com.diary.model.Subject;
import com.diary.model.admin.Grade;
import com.diary.model.admin.Teacher;
import com.diary.model.enums.SubjectName;

import java.util.*;

public class StepsUtil {

    protected Student getStudent() {
        return new Student(ApplicationConstant.STUDENT_FIRST_NAME, ApplicationConstant.STUDENT_LAST_NAME);
    }

    protected Class getClassInformation() throws WrongGradeValueException {
       return new Class(getTeacher());
    }

    protected Teacher getTeacher() throws WrongGradeValueException {
        Map<Student, List<Grade>> studentListMap = new HashMap<>(1);
        List<Grade> grades = new ArrayList<>();
        List<Map<Student, List<Grade>>> listOfMapOfStudents = new ArrayList<>(1);

        Student student = getStudent();
        grades.add(getGrade());

        studentListMap.put(student, grades);
        listOfMapOfStudents.add(studentListMap);
        return new Teacher(ApplicationConstant.TEACHER_NAME, listOfMapOfStudents);
    }

    protected Parent getParent() throws WrongGradeValueException {
        Map<Student, List<Grade>> studentListMap = getTeacher().getStudentGrades().get(0);
        return new Parent(studentListMap);
    }

    protected Grade getGrade() throws WrongGradeValueException {
        return Teacher.createGrade(returnRandomValueInRange(2, 6), new Subject(SubjectName.ARTS.getName()));
    }

    public int returnRandomValueInRange(int min, int max) {
        Random random = new Random();
        int current = random.nextInt(max);

        if ((current >= min) & (current <= max)){
            return current;
        } else {
            return returnRandomValueInRange(min, max);
        }
    }
}
