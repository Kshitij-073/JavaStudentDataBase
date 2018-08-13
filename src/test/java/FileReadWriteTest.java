import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class FileReadWriteTest {

    ArrayList<Student> students;
    ArrayList<Student> expectedStudentList;
    List<CourseInfo> courseList = new ArrayList<>();
    AddStudentDetails studentCreator;

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
    public void fileReadWriteTest() {
        StudentUtils studentUtils  = new StudentUtils();
        createList();
        studentUtils.sortRecords(students);
        PersistentStore.writeData(students);
        ArrayList<Student> expectedStudentList = PersistentStore.readData();

        Assert.assertEquals(expectedStudentList.get(4).getName(), "Karan");

    }

}
