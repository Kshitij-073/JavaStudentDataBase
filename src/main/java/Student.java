import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {

    private String name;
    private Integer age;
    private String address;
    private Integer rollNum;
    private List<CourseInfo> courseList;

    Student() {

    }

    Student(String name, Integer age, String address, Integer rollNum, List<CourseInfo> courseList) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNum = rollNum;
        this.courseList = courseList;
    }

    //setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRollNum(Integer rollNum) {

        this.rollNum = rollNum;
    }

    public void setCourseList(List<CourseInfo> courseList) {
        this.courseList = courseList;
    }

    //getter methods
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Integer getRollNum() {
        return rollNum;
    }

    public List<CourseInfo> getCourseList() {
        return courseList;
    }

    public void printCourseList() {
        for (CourseInfo item : courseList) {
            System.out.print(item.getCourseCode());
        }
    }
}
