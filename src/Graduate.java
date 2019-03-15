


/**
 * TODO : write the class definition for the Graduate class.  This class extends Student and includes 
 * the following two attribute definitions: 
 *      private String undergraduateMajor;
 *      private String undergraduateInstitution;
 *
 * the class must define the following public and protected methods:
 *
 *       public Graduate(String fname, String lname, long ssn, String major, String degree, 
 *                              String undergraduateMajor, String undergraduateInstitution) 
 *
 *       public String getUndergraduateMajor() 
 *
 *       public String getUndergraduateInstitution() 
 *
 *       @Override
 *        public String toString() 
 *
 *      protected boolean approvedForClass(Course c) 
 *       // A GraduateStudent can only register to a course if either it belongs to the program he majors in,
 *       // for example if the student majors in Physics, then the course's program must be physics
 *
 *      protected void setCourseGrade(TranscriptEntry entry, int score) 
 *       // no plus/minus ,, and no D option for a graduate
 **/
public class Graduate extends Student {

    private String undergraduateMajor;
    private String undergraduateInstitution;

    public Graduate(String fname, String lname, long gnum, String major, String degree, String undergraduateMajor, String undergraduateInstitution) {

        super(1, fname, lname, gnum, major, degree);

        this.undergraduateMajor = undergraduateMajor;
        this.undergraduateInstitution = undergraduateInstitution;
    }

    public String getUndergraduateMajor() {
        return this.undergraduateMajor;
    }

    public String getUndergraduateInstitution() {
        return this.undergraduateInstitution;
    }

    protected boolean approvedForClass(Course c) {
        if (c.getDept().equals(getMajor())){
            for (TranscriptEntry course : transcripts) {
                if (course == null) {
                    break;
                }
            }

            return true;
        }

        return false;
    }

    protected void setCourseGrade(TranscriptEntry entry, int score) {
        if (score >= 90) {
            entry.setGrade("A");
        }
        else if (score >= 80) {
            entry.setGrade("B");
        }
        else if (score >= 70) {
            entry.setGrade("C");
        }
        else {
            entry.setGrade("F");
        }
    }


    @Override
    public String toString() {
        // overrides the toString() method defined in its parent class, returns a String in the following format:
        //                 ?John Smith, Degree: B.S., Major: Computer Science?
        // TODO

        return getLast() + ", " + getFirst() +" (G#" + getGnum() +  "), " + "Degree: " + getDegree() + ", Major: " + getMajor();

    }
}
 



