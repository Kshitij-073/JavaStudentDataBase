import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentUtils {

    public void sortRecords(ArrayList<Student> studentList){
        Collections.sort(studentList, (o1, o2) -> {
            int res = o1.getName().compareTo(o2.getName());
            if (res != 0){
                return res;
            }
            return o1.getRollNum().compareTo(o2.getRollNum());
        });
    }
}
