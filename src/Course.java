/**
 * A class which maintains basic information about an academic course.
 *
 * @author CS211 GMU
 */

public class Course {

    /**
     * Attributes.
     */
    private String code;
    private String title;
    private String dept; // name of department offering the course
    private int credits;

    /**
     * Constructor.
     */
    public Course(String code, String title, int credits) {
        // TODO : initilize instance variables, use the static method defined in
        // Registrar to initialize the dept name variable

        this.code = code;
        this.title = title;
        this.credits = credits;
        dept = Registrar.getDeptName(code);
    }

    /**
     * Accessor methods.
     */
// TODO: define a setter and a getter method for each of the instance variables
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * public methods.
     */
    @Override
    public String toString() {
        // TODO: implement so that a string is returned in the following format:
        //  "\tINFS 612 Communication Systems”
        return code + " " + title;
    }

    public String fullString() {
        // TODO: implement so that a string is returned in the following format:
        //"\tINFS 612 Communication Systems (3) credit hours”
        return toString() + ", (" + credits + ") credit hours.";
    }

}
