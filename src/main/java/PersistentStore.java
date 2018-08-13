import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract public class PersistentStore {

    public static void writeData(List<Student> list){

        try{
            FileOutputStream fos = new FileOutputStream("StudentData.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
            System.out.println("Data saved successfully");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static ArrayList<Student> readData(){
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("StudentData.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            System.out.println("No Pre Populated data available");
        }
        catch (IOException ioe){
            System.out.println("No Pre Populated data available");
        }
        return studentList;
    }

}
