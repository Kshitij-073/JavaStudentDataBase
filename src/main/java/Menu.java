
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Menu {

    Scanner scanner;

    private int userOption;
    ArrayList<Student> studentList;
    AddStudentDetails studentCreator;

    private StudentUtils studentUtils;

    Menu() {
        studentCreator = new AddStudentDetails();
        scanner = new Scanner(System.in);
        studentUtils = new StudentUtils();

        //if data is already stored , assign it to list and display it
        if (PersistentStore.readData().size() > 0){
            studentList = PersistentStore.readData();
            displayStudentList();
        }
        else{
            studentList = new ArrayList<>();
        }
        setUserOption();
    }

    //validate and set option inputted by the user
    public void setUserOption() {
        System.out.println("Please choose from the following options");
        System.out.println("1---->Enter Details     2------>Display User Details   3---->Delete certain roll number     4----->Sava data to disk      5---->Terminate program");
        String option = scanner.nextLine();
        if (Validation.isOptionValid(option)) {
            userOption = Integer.parseInt(option);
            performOptionBasedAction();
        } else {
            setUserOption();
        }
    }

    private int getUserOption() {
        return userOption;
    }

    //implement action according to option inputted by the user
    private void performOptionBasedAction() {
        switch (userOption) {

            //add user details
            case 1:
                studentList.add(studentCreator.createNewStudentItem());
                setUserOption();
                break;

            //display user details
            case 2:
                displayStudentList();
                setUserOption();
                break;

            //delete particular roll number
            case 3:
                System.out.println("Enter Roll Number to be deleted");
                String roll = scanner.nextLine();
                if (Validation.isRollNumberValid(roll)) {
                     deleteRollNum(Integer.parseInt(roll));
                } else {
                    System.out.println("Invalid roll number");
                    setUserOption();
                }
                break;

            //save data to disk
            case 4:
                if (studentList.size() == 0){
                    System.out.println("No details have been entered yet");
                }
                else{
                    studentUtils.sortRecords(studentList);
                    PersistentStore.writeData(studentList);
                }
                setUserOption();
                break;

            //terminate the program
            case 5:
                handleTerminateFlow();
                break;

            default:
                break;
        }
    }

    private void displayStudentList() {
        if (studentList.size() == 0){
            System.out.println("No details have been entered yet");
        }
        else{
            initialTablePrint();
            studentUtils.sortRecords(studentList);
            for(Student student: studentList){
                System.out.format("%30s %5s %5s %30s",
                        student.getName(), student.getRollNum(), student.getAge(), student.getAddress());
                System.out.println();
            }
        }
    }

    private boolean deleteRollNum(Integer rollToDelete){
        for (Student item: studentList){
            if (item.getRollNum().equals(rollToDelete)){
                studentList.remove(item);
                System.out.println("This roll number was deleted successfully");
                setUserOption();
                return true;
            }
        }
        System.out.println("This roll number does not exist");
        setUserOption();
        return false;
    }

    private void initialTablePrint(){
        // Print the list objects in tabular format.
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%30s %5s %5s %30s", "STUDENT Name", "Roll Number", "Age", "Address");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
    }

    //ask if user wants to save his data to disk or not before termination of program
    private void handleTerminateFlow(){
        System.out.print("Do you want to save your data (Y/N)? ");
        char shouldContinue = scanner.next(".").charAt(0);
        if (shouldContinue == 'Y' || shouldContinue == 'y') {
            PersistentStore.writeData(studentList);
        }
        else if (shouldContinue == 'N' || shouldContinue == 'n'){
            //flush data on disk
            try {
                new FileOutputStream("StudentData.dat").close();
            }
            catch (IOException ioe){
                ioe.printStackTrace();
                System.out.println("Data not flushed successfully");
            }
        }
    }
}
