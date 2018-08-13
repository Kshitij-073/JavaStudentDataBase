import java.io.Serializable;
import java.util.List;

public class CourseInfo implements Serializable {

    private char courseCode;
    private List<CourseInfo> courseList;

    public void setCourseCode(char code) {

        this.courseCode = code;
    }

    public char getCourseCode() {

        return courseCode;
    }

    public void setCourseList(List<CourseInfo> courseList){
        this.courseList = courseList;
    }

    public List<CourseInfo> getCourseList(){
        return courseList;
    }
}
