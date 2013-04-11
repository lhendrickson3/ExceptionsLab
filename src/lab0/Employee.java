package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }

    /**
     * Do not allow zero. Must be positive integers. 
     * Is there a limit on how many vacation days available?
     * 
     * @param daysVacation 
     */
    public void setDaysVacation(int daysVacation) {
        if(daysVacation <= 0) {
            throw new IllegalArgumentException("Valid Vacation Days Required");
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

    
    
    /**
     * Do not allow null or zero length. ask about number first name
     * maybe allow number at the end only. allow hyphens or spaces only in first name
     * allow any letter case for the test and message later in code
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() == 0){
            throw new IllegalArgumentException("Entry required");
        }
        this.firstName = firstName;
    }

    
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * Do not allow null or zero length(cant do with Date). 
     * date format (if possible)
     * 
     * 
     * @param hireDate 
     */
    public void setHireDate(Date hireDate) {
        if(hireDate == null){
            throw new IllegalArgumentException("Date Entry Required");
        }
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Do not allow null or zero length. allow hyphens in the last name
     * allow numbers following the last name possibly a set of Is, V, or X as roman numerals 
     * 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException("Entry Required");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    /**
 * 
 * Sets a social security number 
 * -next 2 lines are not needed if throws is set properly
 * where the incoming data
 * is composed of 9 digits and optionally 2 "-" characters.
 * @param ssn - validated using above rules and throws IllegalArgumentException
 * if rules are violated
 * @throws IllegalArgumentException if ssn does not contain 9 digits, and
 * optionally, two "-" characters
 */

    public void setSsn(String ssn) throws IllegalArgumentException{
        if(ssn == null){
            
        }
        String[] pieces = ssn.split("-");
        if(ssn.contains("-") && pieces.length != 3){
            throw new IllegalArgumentException("must have two hyphens");
        }
        ssn = ssn.replaceAll("-", "");
        if(ssn.length() != 9){
        throw new IllegalArgumentException("must be nine digits");
        }
        char[] chars = ssn.toCharArray();
        for (char c : chars){
            if(Character.isDigit(c)){
                throw new IllegalArgumentException("must have 9 digits");
            }   
        }
        this.ssn = ssn;
    }
}
