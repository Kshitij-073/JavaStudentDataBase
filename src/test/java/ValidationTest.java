import org.junit.Assert;
import org.junit.Test;


public class ValidationTest {

    @Test
    public void nameValidation() {
        Assert.assertEquals(true, Validation.isNameValid("Aman") );
        Assert.assertEquals(false, Validation.isNameValid(""));
    }

    @Test
    public void ageValidation() {
        Assert.assertEquals(false, Validation.isAgeValid("300"));
        Assert.assertEquals(true, Validation.isAgeValid("30"));
    }

    @Test
    public void addressValidation() {
        Assert.assertEquals(false, Validation.isAddressValid(""));
        Assert.assertEquals(true, Validation.isAddressValid("avenue 3rd street"));
    }

    @Test
    public  void rollNumValidation(){
        Assert.assertEquals(false, Validation.isRollNumberValid("200"));
        Assert.assertEquals(true, Validation.isRollNumberValid("20"));
    }

    @Test
    public  void isCourseNameValid(){
        Assert.assertEquals(false, Validation.isCourseNameValid('Z'));
        Assert.assertEquals(true, Validation.isCourseNameValid('D'));
    }

    @Test
    public  void isOptionValid(){
        Assert.assertEquals(false, Validation.isOptionValid("10"));
        Assert.assertEquals(true, Validation.isOptionValid("4"));
    }


    }
