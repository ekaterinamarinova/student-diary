package steps;

import com.diary.model.*;
import com.diary.model.Class;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StepsUtil {

    protected Student getStudentWithRandomGrade() {
        List<Grade> grades = new ArrayList<>();
        grades.add(getGrade());
        return new Student("Peshko", "Peshev", grades);
    }

    protected Class getClassInformation() {
        Class clazz = new Class();
        List<Student> students = new ArrayList<>(1);
        students.add(getStudentWithRandomGrade());

        List<String> subjects = new ArrayList<>(1);
        subjects.add("Calculus");

        clazz.setClassTeacher(getTeacher());
        clazz.setSubjectList(new ArrayList<>());

        return clazz;
    }

    protected Teacher getTeacher() {
        List<Student> students = new ArrayList<>();
        students.add(getStudentWithRandomGrade());
        return new Teacher("Gosho", students);
    }

    protected Parent getParent() {
        List<Student> students = new ArrayList<>(1);
        students.add(getStudentWithRandomGrade());
        return new Parent(students);
    }

    protected Grade getGrade() {
        return new Grade(returnRandomValueInRange(2,6), "random1");
    }

    private static int returnRandomValueInRange(int min, int max) {
        int stackOverFlowIndicator = 0;
        stackOverFlowIndicator += 1;
        int hour = LocalDateTime.now().getHour();
        int random = LocalDateTime.now().getSecond() * hour;

        int res = Integer.parseInt(Integer.toString(random).substring(0,1));

        if (stackOverFlowIndicator > 3) {
            return 5;
        }

        if ((res > min) & (res < max)){
            return res;
        } else {
            return returnRandomValueInRange(min, max);
        }

    }
}
