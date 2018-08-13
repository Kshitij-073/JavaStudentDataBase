import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract  public class Validation {

    //name validation using regex
    public static boolean isNameValid(String name){
        String regx = "[a-zA-Z]+\\.?";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    //age validation
    public static boolean isAgeValid(String age){
        Integer ageInt ;
        try{
            ageInt = Integer.parseInt(age) ;
        }catch (NumberFormatException nfe){
            return false ;
        }
        return ageInt > 0 && ageInt < 100;
    }

    //address validation
    public static Boolean isAddressValid(String addr){
        return addr.length() > 0 ;
    }

    //roll number validation
    public static boolean isRollNumberValid(String rollNum){
        Integer rollInt ;
        try{
            rollInt = Integer.parseInt(rollNum) ;
        }catch (NumberFormatException nfe){
            return false ;
        }
        return rollInt > 0 && rollInt < 100;
    }

    //command line menu option validation
    public static boolean isCourseNameValid(char courseName){
        return courseName == 'A' || courseName == 'B' || courseName == 'C' || courseName == 'D' || courseName == 'E' || courseName == 'F';
    }

    //command line menu option validation
    public static boolean isOptionValid(String option){
        Integer optionInt ;
        try{
            optionInt = Integer.parseInt(option) ;
        }catch (NumberFormatException nfe){
            return false ;
        }
        return optionInt == 1 || optionInt == 2 || optionInt == 3 || optionInt == 4 || optionInt == 5;
    }
}
