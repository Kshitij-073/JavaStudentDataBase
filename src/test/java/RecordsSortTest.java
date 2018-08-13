import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class RecordsSortTest {
    ArrayList<Student> students;
    ArrayList<Student> expectedStudentList;
    List<CourseInfo> courseList = new ArrayList<>();
    AddStudentDetails studentCreator;

    @BeforeEach
    public void createList() {
        for (int i = 0; i < 4; i++) {
            CourseInfo courseObject = new CourseInfo();
            courseObject.setCourseCode((char) (65 + i));
            courseList.add(courseObject);
        }
        studentCreator = new AddStudentDetails();
        students = new ArrayList<>();
        students.add(studentCreator.createNewStudentItem("Karan", 10, "dede", 14, courseList));
        students.add(studentCreator.createNewStudentItem("Akshay", 10, "dede", 13, courseList));
        students.add(studentCreator.createNewStudentItem("Aakash", 10, "dede", 12, courseList));
        students.add(studentCreator.createNewStudentItem("Amay", 10, "dede", 11, courseList));
        students.add(studentCreator.createNewStudentItem("Amay", 10, "dede", 10, courseList));

    }

    @Test
    public void sortTesting() {
        StudentUtils studentUtils  = new StudentUtils();
        createList();
        studentUtils.sortRecords(students);

        Assert.assertEquals(students.get(0).getName(), "Aakash");
    }
}
