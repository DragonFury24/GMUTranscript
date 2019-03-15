/**
 * A sub-class which extends the Course class to keep track of a student
 * registration in a course, and also perform
 *
 * @author CS211 GMU
 */
public class TranscriptEntry extends Course {
    /**
     * Attributes
     */
    private String semester;
    private int year;
    private String grade;
    private boolean active;

    public TranscriptEntry(Course c, String semester, int year) {
        // TODO
        // note: active must be initialized to true.
        super(c.getCode(), c.getTitle(), c.getCredits());

        this.semester = semester;
        this.year = year;
        grade = "N/A";
        active = true;
    }

    /**
     * Accessor methods methods.
     * // TODO
     * define a setter and a getter for each instance variable.
     * note: Do not write accessor methods for the active variable since its an internal variable:
     * if a course is flagged active, then the student is currently enrolled in that course.
     * When a grade is posted for a course, active is set to false.
     */
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        active = false;
    }

    /**
     * Public Mathods.
     */

    public boolean isActive() {
        //TODO
        return active;
    }


    @Override
    public String toString() {
        // return a string with the following format:
        //  "\tINFS 510 Database Systems,   credits: 3, GRADE: A"
        //TODO
        if (getGrade().equalsIgnoreCase("N/A")) {
            return super.toString() + ",   credits: " + getCredits();
        }

        return super.toString() + ",   credits: " + getCredits() + ", GRADE: " + getGrade();
    }
}