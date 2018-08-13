import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//this acts like a manager class which has helper functions to create instances of 'Student' after proper validations
public class AddStudentDetails {

    Scanner scanner;
    Student student;

    AddStudentDetails() {
        scanner = new Scanner(System.in);
    }

    public Student createNewStudentItem(String name , Integer age , String address , Integer rollNum , List<CourseInfo> courseList){
        student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        student.setRollNum(rollNum);
        student.setCourseList(courseList);
        return student;
    }

    public Student createNewStudentItem() {
        student = new Student();
        student.setName(getStudentName());
        student.setAge(getStudentAge());
        student.setAddress(getStudentAddress());
        student.setRollNum(getStudentRollNum());
        student.setCourseList(getSudentCourseList());
        return student;
    }

    private String getStudentName() {
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        if (Validation.isNameValid(name)) {
            return name;  //return if name is valid else make recursive call
        } else {
            System.out.println("Please enter a valid name");
            return getStudentName();
        }
    }

    private Integer getStudentAge() {
        System.out.println("Please enter your age");
        String age = scanner.nextLine();
        if (Validation.isAgeValid(age)) {
            return Integer.parseInt(age);  //return if name is valid else make recursive call
        } else {
            System.out.println("Please enter a valid age");
            return getStudentAge();
        }
    }

    private String getStudentAddress() {
        System.out.println("Please enter your address");
        String address = scanner.nextLine();
        if (Validation.isAddressValid(address)) {
            return address;  //return if name is valid else make recursive call
        } else {
            System.out.println("Please enter a valid address");
            return getStudentAddress();
        }
    }

    private Integer getStudentRollNum() {
        System.out.println("Please enter your roll number");
        String rollNum = scanner.nextLine();
        if (Validation.isRollNumberValid(rollNum)) {
            return Integer.parseInt(rollNum);  //return if name is valid else make recursive call
        } else {
            System.out.println("Please enter a valid roll number");
            return getStudentRollNum();
        }
    }


    private List<CourseInfo> getSudentCourseList() {
        System.out.println("Please choose four courses from the following - A , B ,C , D , E of F");
        List<CourseInfo> courseList = new ArrayList<>();
        char courseName;
        //minimum number of courses to be selected is four
        while (courseList.size() != 4) {
            courseName = scanner.next(".").charAt(0);
            if (Validation.isCourseNameValid(courseName)) {
                CourseInfo courseObject = new CourseInfo();
                courseObject.setCourseCode(courseName);
                courseList.add(courseObject);
            } else {
                System.out.println("Invalid course name . Try again");
            }
        }
        return courseList;
    }
}
