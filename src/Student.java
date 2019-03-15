import java.util.ArrayList;

/**
 * An abstract class for maintaing basic information about a student attending this college.
 * This class defines public methods to provide the following functionality to a student object:
 * - register and drop courses
 * - record a grade for a completed course
 * - get transcripts / a list of completed courses
 * sub-classes of this class will specify how student rgistration is to be performed (depending
 * on the level of the student), and also grade assignments.
 *
 * @author CS211 GMU
 */

public abstract class Student {
    /**
     * Attributes.
     * note how the class is defining its instance variables as protected so
     * that they are accessible to its sub-classes.
     */
    protected String first, last;
    protected long gnum;
    protected String major;
    protected String degree;
    protected TranscriptEntry[] transcripts; // an array of objects
    protected final int PROGRAM; // a constant which will be initilized to 0 or 1
    // in the constructor method

    /**
     * Attributes.
     * note how the class is defining its instance variables as protected so
     * that they are accessible to its sub-classes.
     */
    public Student(int level, String first, String last, long gnum, String major,
                   String degree) {
        // TODO initialize the instance variables
        //  Also use the parameter variable "level" as follows
        //     1) use its value to initialized the PROGRAM constant
        //     2) create the transcripts array to be of size [50] if is level 0,
        //        or to be of size [15] if level is 1.
        // note that level refers to the student type and we use a value of 0 for
        // an undergrad and a value of 1 for a grad
        PROGRAM = level;
        this.first = first;
        this.last = last;
        this.gnum = gnum;
        this.major = major;
        this.degree = degree;
        if (level == 0) {
            transcripts = new TranscriptEntry[50];
        } else if (level == 1) {
            transcripts = new TranscriptEntry[15];
        }
    }

    /**
     * Accessor methods.
     */
// TODO: define a setter and a getter method for each of the instance variables
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public long getGnum() {
        return gnum;
    }

    public void setGnum(long gnum) {
        this.gnum = gnum;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getPROGRAM() {
        return PROGRAM;
    }

    /**
     * Public methods.
     */
    public boolean registerAClass(Course c, String semester, int year) {
        // this method will call the approvedForClass method defined by
        // the subclasses before enrolling the student into the course.
        //  This method also checks if the studnet is already enrolled in
        // in the current semester and will return false if thats the case.
        // hint: a student would be currently enrolled if the .isActive() method returned true.
        //

        for (TranscriptEntry course : transcripts) {
            if (course == null) {
                break;
            } else if (course.getCode().contains(c.getCode())) {
                if (course.isActive()) {
                    return false;
                } else {
                    break;
                }
            }
        }

        if (approvedForClass(c)) {
            for (int i = 0; i < transcripts.length; i++) {
                if (transcripts[i] == null) {
                    transcripts[i] = new TranscriptEntry(c, semester, year);
                    break;
                }
            }

            return true;
        }

        return false;
    }


    public boolean dropAClass(String courseCode) {
        // We may only drop a student if he/she is currently enrolled (ie no grade posted yet).
        // Find the course entry in transcripts array and literally remove it, don't just
        // replace it with a null value, shift array elementsleft-ward to replace it!
        // hint: create a new array when removing a course from the transcripts array
        int indexToRemove = -1;

        //Search if the class in in @trancripts
        for (int i = 0; i < transcripts.length; i++) {
            if (transcripts[i] == null) {
                return false;
            }
            if (transcripts[i].getCode().contains(courseCode)) {
                if (transcripts[i].isActive()) {
                    indexToRemove = i;
                    break;
                } else {
                    return false;
                }

            }
        }

        //remove the course
        if (indexToRemove == -1) {
            return false;
        }

        transcripts[indexToRemove] = null;

        ArrayList<TranscriptEntry> tempList = new ArrayList<>();

        for (TranscriptEntry course: transcripts) {
            if (course == null) {
                continue;
            }

            tempList.add(course);
        }

        transcripts = new TranscriptEntry[transcripts.length];

        for (int i = 0; i < tempList.size(); i++) {
            transcripts[i] = tempList.get(i);
        }

        return true;
    }


    public boolean obtainAGrade(String courseCode, int score) {
        // this method will search the transcripts array to find a course and will
        // then assigne a letter grade for the student in that course.  if the course is not found
        // in the array, or if its a past course then return false (should overwrite a past course grade).
        //TODO
        for (TranscriptEntry course : transcripts) {
            if (course == null) {
                break;
            }
            if (course.getCode().contains(courseCode)) {
                if (course.isActive()) {
                    setCourseGrade(course, score);
                    return true;
                }
            }
        }

        return false;
    }

    public String getClassList(String semester, int year) {
        String str = String.format(" %s %d\n", semester, year);
        for (TranscriptEntry en : transcripts) {
            if (en == null) break;
            else if ((en.getSemester().equalsIgnoreCase(semester)) &&
                    (en.getYear() == year))
                str += en.toString() + "\n";
        }
        return str;
    }

    @Override
    public boolean equals(Object anotherStudent) {
        // two student onjects are equal if they have the same G#
        // TODO

        if (anotherStudent instanceof Student) {
            return getGnum() == ((Student) anotherStudent).getGnum();
        }

        return false;
    }

    @Override
    public String toString() {
        // return a string with the following format:
        //  “Smith, John (G#0000000000)”
        //TODO

        return getLast() + ", " + getFirst() + " (G#" + getGnum() + ")";
    }


    /**
     * Private methods.
     * you may add as much helper methods as you need.
     */

    protected abstract boolean approvedForClass(Course c);

    protected abstract void setCourseGrade(TranscriptEntry entry, int score);
}
