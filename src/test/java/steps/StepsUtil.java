package steps;

import com.diary.constant.ApplicationConstant;
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

    protected Class getClassInformation() throws InterruptedException {
       return new Class(getTeacher());
    }

    protected Teacher getTeacher() throws InterruptedException {
        Map<Student, List<Grade>> studentListMap = new HashMap<>(1);
        List<Grade> grades = new ArrayList<>();
        List<Map<Student, List<Grade>>> listOfMapOfStudents = new ArrayList<>(1);

        Student student = getStudent();
        grades.add(getGrade());

        studentListMap.put(student, grades);
        listOfMapOfStudents.add(studentListMap);
        return new Teacher(ApplicationConstant.TEACHER_NAME, listOfMapOfStudents);
    }

    protected Parent getParent() throws InterruptedException {
        Map<Student, List<Grade>> studentListMap = getTeacher().getStudentGrades().get(0);
        return new Parent(studentListMap);
    }

    protected Grade getGrade() throws InterruptedException {
        return Teacher.getGrade(returnRandomValueInRange(2, 6), new Subject(SubjectName.ARTS.getName()));
    }

    private int returnRandomValueInRange(int min, int max) {
        Random random = new Random();
        int current = random.nextInt(6);
        int res = Integer.parseInt(Double.toString(current).substring(0,1));

        if ((res >= min) & (res <= max)){
            return res;
        } else {
            return returnRandomValueInRange(min, max);
        }
    }
}
