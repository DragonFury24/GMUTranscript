import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import org.junit.jupiter.api.Test;

public class RegistrationProgramTest {

//    public static void main(String[] args) {
//        org.junit.runner.JUnitCore.main("RegistrationProgramTest");
//    }

    @Test
    // #0
    public void testAddCourses0() {
        Registrar regSystem = new Registrar("Fall", 2018);

        assertEquals("", regSystem.getCourseCatalog());
    }

    private Object[][] courseList = {
            {"CS 101", "Beginning Computer Technology", 3, "CS 101 Beginning Computer Technology, (3) credit hours."},
            {"CS 212", "Object Methods for Software Development", 3, "CS 212 Object Methods for Software Development, (3) credit hours."},
            {"CS 238", "Higher Level Languages (Java)", 3, "CS 238 Higher Level Languages (Java), (3) credit hours."},
            {"PHYS 101", "Introduction to Physics", 3, "PHYS 101 Introduction to Physics, (3) credit hours."},
            {"PHYS 399", "Quantum Mechanics", 3, "PHYS 399 Quantum Mechanics, (3) credit hours."},
            {"PHYS 233", "Theory of Relativity", 3, "PHYS 233 Theory of Relativity, (3) credit hours."},
            {"INFS 201", "Communication Today", 3, "INFS 201 Communication Today, (3) credit hours."},
            {"MATH 203", "Pre-algebra", 3, "MATH 203 Pre-algebra, (3) credit hours."},
            {"MATH 301", "Linear Algebra", 3, "MATH 301 Linear Algebra, (3) credit hours."},
            {"MATH 302", "Linear Algebra II", 3, "MATH 302 Linear Algebra II, (3) credit hours."},
            {"MATH 210", "Discrete Mathematics", 3, "MATH 210 Discrete Mathematics, (3) credit hours."},
            {"IT 301", "Object-Oriented Modeling", 3, "IT 301 Object-Oriented Modeling, (3) credit hours."},
            {"CS 521", "Computer Networks", 3, "CS 521 Computer Networks, (3) credit hours."},
            {"INFS 510", "Database Systems", 3, "INFS 510 Database Systems, (3) credit hours."},
            {"CS 583", "Computer Algorithms", 3, "CS 583 Computer Algorithms, (3) credit hours."},
            {"INFS 612", "Communication Systems", 3, "INFS 612 Communication Systems, (3) credit hours."},
            {"CS 683", "Program Data and Design", 3, "CS 683 Program Data and Design, (3) credit hours."},
            {"INFS 521", "Data Science", 3, "INFS 521 Data Science, (3) credit hours."},
            {"INFS 630", "Distributed Computing", 3, "INFS 630 Distributed Computing, (3) credit hours."},
            {"INFS 700", "Independent Studies", 3, "INFS 700 Independent Studies, (3) credit hours."},
    };
    private int UGRD_MAX = 12;
    private int GRAD_START = UGRD_MAX;
    private int GRAD_MAX = courseList.length;
    private int LIST_MAX = GRAD_MAX;
    private int MATH301 = 8;

    private String initRegSystemCourses(Registrar regSystem, int start, int end) {
        String val = "";
        for (int i = start; i < end; i++) {
            Object[] courseEntry = courseList[i];
            String cnum = (String) courseEntry[0];
            String cname = (String) courseEntry[1];
            Integer ccred = (Integer) courseEntry[2];
            String cstr = (String) courseEntry[3];
            assertTrue("adding new courses", regSystem.addCourse(cnum, cname, ccred));
            if (val.length() > 0) val += "\n";
            val += cstr;
        }
        return val;
    }

    private String initRegSystemCourses(Registrar r, int s) {
        return initRegSystemCourses(r, s, s + 1);
    }

    private String initRegSystemCourses(Registrar r) {
        return initRegSystemCourses(r, 0, LIST_MAX);
    }

    private String initRegSystemCoursesUG(Registrar r) {
        return initRegSystemCourses(r, 0, UGRD_MAX);
    }

    private String initRegSystemCoursesGrad(Registrar r) {
        return initRegSystemCourses(r, GRAD_START, GRAD_MAX);
    }

    @Test
    // #1
    public void testAddCourses1() {
        Registrar regSystem = new Registrar("Fall", 2018);
        String expected = initRegSystemCourses(regSystem, 0, 1);
        assertEquals(expected, regSystem.getCourseCatalog().trim());
    }

    @Test
    //# 2
    public void testAddCourses2() {
        Registrar regSystem = new Registrar("Fall", 2018);
        String expected = initRegSystemCourses(regSystem, 0, 2);
        assertEquals(expected, regSystem.getCourseCatalog().trim());
    }


    @Test
    //# 3
    public void testShowCatalog() {
        Registrar regSystem = new Registrar("Fall", 2018);
        String expected = initRegSystemCourses(regSystem);
        assertEquals(expected, regSystem.getCourseCatalog().trim());


    }

    @Test
    // #4
    public void testAddStudent1() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // adding one undergraduate student
        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));
    }

    @Test
    // #5
    public void testAddStudent2() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // adding one graduate student
        assertEquals(true, regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU"));
    }

    @Test
    // #6
    public void testAddStudent3() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // adding a bunch of graduate and undergraduate students
        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));
        assertEquals(true, regSystem.addStudent("Lisa", "Spain", 11222222, "Computer Science", "General Studies", null));
        assertEquals(true, regSystem.addStudent("Mary", "Alice", 11333333, "Physics", "General Studies", "George Marshall HS"));
        assertEquals(true, regSystem.addStudent("Jane", "Doe", 22444444, "Physics", "B.S.", "Justice HS"));
        assertEquals(true, regSystem.addStudent("John", "Becker", 22434455, "Computer Science", "B.S.", "Fairfax HS"));
        assertEquals(true, regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU"));
        assertEquals(true, regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU"));
    }

    @Test
    // #7
    public void testAddStudentsAndCourses1() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // add courses
        initRegSystemCoursesUG(regSystem);

        // add students
        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));
        assertEquals(true, regSystem.addStudent("Lisa", "Spain", 11222222, "Computer Science", "General Studies", null));
        assertEquals(true, regSystem.addStudent("Mary", "Alice", 11333333, "Physics", "General Studies", "George Marshall HS"));
        assertEquals(true, regSystem.addStudent("Jane", "Doe", 22444444, "Physics", "B.S.", "Justice HS"));
        assertEquals(true, regSystem.addStudent("John", "Becker", 22434455, "Computer Science", "B.S.", "Fairfax HS"));
        assertEquals(true, regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU"));
        assertEquals(true, regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU"));
    }

    @Test
    // #8
    public void testAddStudentsAndCourses2() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // add graduate courses
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        assertEquals(true, regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU"));
        assertEquals(true, regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU"));
    }

    @Test
    // #9 testing registration of an undergraduate student
    public void testRegisterStudents1() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // add courses
        initRegSystemCoursesUG(regSystem);
        // add 1 undergrad
        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));
        // register undergrad student
        assertEquals(true, regSystem.register(12345666L, "MATH 301"));  // this will work: true
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        assertEquals(true, regSystem.register(12345666L, "MATH 203"));  // true
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));  // true
        assertEquals(false, regSystem.register(12345666L, "MATH 111"));  // should fail since the class doesnot exist: false
    }

    @Test
    // #10
    // testing the displayAllClasses for an undergrad
    public void testRegisterStudents2() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // testing registration for an undergrad "Joe Bazuka"
        // first add undergrad courses
        initRegSystemCoursesUG(regSystem);
        // now add undergrad students
        regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS");
        regSystem.addStudent("Lisa", "Spain", 11222222, "Computer Science", "General Studies", null);
        regSystem.addStudent("Mary", "Alice", 11333333, "Physics", "General Studies", "George Marshall HS");
        regSystem.addStudent("Jane", "Doe", 22444444, "Physics", "B.S.", "Justice HS");
        regSystem.addStudent("John", "Becker", 22434455, "Computer Science", "B.S.", "Fairfax HS");
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register students
        assertEquals(true, regSystem.register(12345666L, "MATH 301"));  // this will work: true
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        assertEquals(true, regSystem.register(12345666L, "MATH 203"));  // true
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));  // true
        assertEquals(false, regSystem.register(12345666L, "MATH 111"));  // should fail since the class doesnot exist: false
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Fall 2018\n" +
                        "\tMATH 301 Linear Algebra,   credits: 3\n" +
                        "\tMATH 203 Pre-algebra,   credits: 3\n" +
                        "\tINFS 201 Communication Today,   credits: 3"
                , regSystem.getProgress(12345666L, "Fall", 2018).trim());
    }


    @Test
    // #11 testing the registration of a graduate student
    public void testRegisterStudents3() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // add graduate courses
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students
        assertEquals(true, regSystem.register(33011101, "INFS 612")); // true
        assertEquals(false, regSystem.register(33011101, "CS 683")); // this will fail since major doesnot match: false
        assertEquals(false, regSystem.register(33011101, "INFS 612")); // this should fail since student already added to the course: false
        assertEquals(false, regSystem.register(33011101, "INFS 611")); // this will fail since course doesnot exist: false
        assertEquals(true, regSystem.register(33011101, "INFS 510")); // true
    }

    @Test
    // #12 testing the registration of a graduate student
    public void testRegisterStudents5() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // add graduate courses
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students
        assertEquals(true, regSystem.register(33011101, "INFS 612")); // true
        assertEquals(false, regSystem.register(33011101, "CS 683")); // this will fail since major doesnot match: false
        assertEquals(false, regSystem.register(33011101, "INFS 612")); // this should fail since student already added to the course: false
        assertEquals(false, regSystem.register(33011101, "INFS 611")); // this will fail since course doesnot exist: false
        assertEquals(true, regSystem.register(33011101, "INFS 510")); // true
    }


    @Test
    // #13 testing the registration of a graduate student
    public void testRegisterStudents6() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // add graduate courses
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students
        assertEquals(true, regSystem.register(33011101, "INFS 612")); // true
        assertEquals(false, regSystem.register(33011101, "CS 683")); // this will fail since major doesnot match: false
        assertEquals(false, regSystem.register(33011101, "INFS 612")); // this should fail since student already added to the course: false
        assertEquals(false, regSystem.register(33011101, "INFS 611")); // this will fail since course doesnot exist: false
        assertEquals(true, regSystem.register(33011101, "INFS 510")); // true
        assertEquals("Hoff, Bruce (G#33011101), Degree: M.S., Major: Information Systems\n" +
                        " Fall 2018\n" +
                        "\tINFS 612 Communication Systems,   credits: 3\n" +
                        "\tINFS 510 Database Systems,   credits: 3"
                , regSystem.getProgress(33011101, "Fall", 2018).trim());
    }

    @Test
    // #14 testing Assigning grades to an undergradautre (who does not exist)
    public void testAssignGrades0() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCourses(regSystem, MATH301);
        //assigning a grade for a non-existing student, should return false
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 301", 97));
    }

    @Test
    // #15 testing Assigning grades to an undergradautre (who does not exist)
    public void testAssignGrades1() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCourses(regSystem, MATH301);
        //assigning a grade for an existing student, but not registered in the course
        regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS");
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 301", 97)); // true
    }

    @Test
    // #16 testing Assigning grades to an undergradautre (who does not exist)
    public void testAssignGrades1b() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCourses(regSystem, MATH301);
        //assigning a grade for an existing student (graduate), but not registered in the course
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 301", 97)); // true
    }

    @Test
    // #17 testing Assigning grades to an undergradautre
    public void testAssignGrades2() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // add courses
        initRegSystemCoursesUG(regSystem);
        regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS");
        regSystem.register(12345666L, "MATH 301");
        regSystem.register(12345666L, "PHYS 101");
        regSystem.register(12345666L, "MATH 203");
        regSystem.register(12345666L, "INFS 201");
        regSystem.register(12345666L, "MATH 111");
        // now assign grades for the students
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 301", 97)); // true
        assertEquals(false, regSystem.postGrade(12345666L, "PHYS 101", 68));  // assigning a score to a class which the student didnt register to!
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 203", 91));  // true
        assertEquals(true, regSystem.postGrade(12345666L, "INFS 201", 78)); // this will work: true
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 111", 83));    // should fail since the class doesnot exist: flse
    }

    @Test
    // #18 testing Assigning grades to an undergradautre and printing transcripts
    public void testAssignGrades4() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCoursesUG(regSystem);
        regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS");
        regSystem.register(12345666L, "MATH 301");
        regSystem.register(12345666L, "PHYS 101");
        regSystem.register(12345666L, "MATH 203");
        regSystem.register(12345666L, "INFS 201");
        regSystem.register(12345666L, "MATH 111");
        // now assign grades for the students
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 301", 97)); // true
        assertEquals(false, regSystem.postGrade(12345666L, "PHYS 101", 68));  // assigning a score to a class which the student didnt register to!
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 203", 91));  // true
        assertEquals(true, regSystem.postGrade(12345666L, "INFS 201", 78)); // this will work: true
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 111", 83));    // should fail since the class doesnot exist: flse
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Fall 2018\n" +
                        "\tMATH 301 Linear Algebra,   credits: 3, GRADE: A\n" +
                        "\tMATH 203 Pre-algebra,   credits: 3, GRADE: A-\n" +
                        "\tINFS 201 Communication Today,   credits: 3, GRADE: C+",
                regSystem.getProgress(12345666L, "Fall", 2018).trim());
    }

    @Test
    // #19 testing Assigning grades to a graduate student
    public void testAssignGrades5() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students
        assertEquals(true, regSystem.register(33011101, "INFS 612")); // true
        assertEquals(false, regSystem.register(33011101, "CS 683")); // this will fail since major doesnot match: false
        assertEquals(false, regSystem.register(33011101, "INFS 612")); // this should fail since student already added to the course: false
        assertEquals(false, regSystem.register(33011101, "INFS 611")); // this will fail since course doesnot exist: false
        assertEquals(true, regSystem.register(33011101, "INFS 510")); // true
        assertEquals(true, regSystem.postGrade(33011101, "INFS 612", 100)); // true
        assertEquals(false, regSystem.postGrade(33011101, "CS 683", 98)); // student is not registered for the course: false
        assertEquals(false, regSystem.postGrade(33011101, "INFS 612", 79)); // this should fail since score already recorded: false
        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 68)); // true
    }

    @Test
    // #20 testing Assigning grades to a graduate student and printing transcripts
    public void testAssignGrades6() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students
        assertEquals(true, regSystem.register(33011101, "INFS 612")); // true
        assertEquals(false, regSystem.register(33011101, "CS 683")); // this will fail since major doesnot match: false
        assertEquals(false, regSystem.register(33011101, "INFS 612")); // this should fail since student already added to the course: false
        assertEquals(false, regSystem.register(33011101, "INFS 611")); // this will fail since course doesnot exist: false
        assertEquals(true, regSystem.register(33011101, "INFS 510")); // true
        assertEquals(true, regSystem.postGrade(33011101, "INFS 612", 100)); // true
        assertEquals(false, regSystem.postGrade(33011101, "CS 683", 98)); // student is not registered for the course: false
        assertEquals(false, regSystem.postGrade(33011101, "INFS 612", 79)); // this should fail since score already recorded: false
        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 68)); // true
        assertEquals("Hoff, Bruce (G#33011101), Degree: M.S., Major: Information Systems\n" +
                        " Fall 2018\n" +
                        "\tINFS 612 Communication Systems,   credits: 3, GRADE: A\n" +
                        "\tINFS 510 Database Systems,   credits: 3, GRADE: F",
                regSystem.getProgress(33011101, "Fall", 2018).trim());
    }

    @Test
    // #21 starting a new semester
    public void testStartANewSemester1() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCourses(regSystem);
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);
    }

    @Test
    public void testStartANewSemester2() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #22 starting a new semeste
        initRegSystemCourses(regSystem);

        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));
        assertEquals(true, regSystem.register(12345666L, "MATH 301"));
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));
        assertEquals(true, regSystem.register(12345666L, "MATH 203"));
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));
        assertEquals(false, regSystem.register(12345666L, "MATH 111"));

        assertEquals(true, regSystem.postGrade(12345666L, "MATH 301", 97));
        assertEquals(false, regSystem.postGrade(12345666L, "PHYS 101", 68));
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 203", 91));
        assertEquals(true, regSystem.postGrade(12345666L, "INFS 201", 78));
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 111", 83));

        regSystem.setSemester("Spring");
        regSystem.setYear(2019);

        assertEquals(true, regSystem.register(12345666L, "MATH 302"));  // this will work: true
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        assertEquals(true, regSystem.register(12345666L, "MATH 210"));  // true
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));  // true
        assertEquals(true, regSystem.register(12345666L, "PHYS 101"));  // true
        assertEquals(true, regSystem.register(12345666L, "CS 212"));  // true
    }


    @Test
    // #23 starting a new semeste doing new registration and displaying transcripts
    public void testStartANewSemester3() {
        Registrar regSystem = new Registrar("Fall", 2018);
        initRegSystemCourses(regSystem);

        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));
        assertEquals(true, regSystem.register(12345666L, "MATH 301"));
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));
        assertEquals(true, regSystem.register(12345666L, "MATH 203"));
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));
        assertEquals(false, regSystem.register(12345666L, "MATH 111"));

        assertEquals(true, regSystem.postGrade(12345666L, "MATH 301", 97));
        assertEquals(false, regSystem.postGrade(12345666L, "PHYS 101", 68));
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 203", 91));
        assertEquals(true, regSystem.postGrade(12345666L, "INFS 201", 78));
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 111", 83));

        regSystem.setSemester("Spring");
        regSystem.setYear(2019);

        assertEquals(true, regSystem.register(12345666L, "MATH 302"));  // this will work: true
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        assertEquals(true, regSystem.register(12345666L, "MATH 210"));  // true
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));  // true
        assertEquals(true, regSystem.register(12345666L, "PHYS 101"));  // false
        assertEquals(true, regSystem.register(12345666L, "CS 212"));  // true
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Fall 2018\n" +
                        "\tMATH 301 Linear Algebra,   credits: 3, GRADE: A\n" +
                        "\tMATH 203 Pre-algebra,   credits: 3, GRADE: A-\n" +
                        "\tINFS 201 Communication Today,   credits: 3, GRADE: C+",
                regSystem.getProgress(12345666L, "Fall", 2018).trim());
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Spring 2019\n" +
                        "\tMATH 302 Linear Algebra II,   credits: 3\n" +
                        "\tMATH 210 Discrete Mathematics,   credits: 3\n" +
                        "\tINFS 201 Communication Today,   credits: 3\n" +
                        "\tPHYS 101 Introduction to Physics,   credits: 3\n" +
                        "\tCS 212 Object Methods for Software Development,   credits: 3",
                regSystem.getProgress(12345666L, "Spring", 2019).trim());
    }

    @Test
    public void testStartANewSemester4() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #24 new semester for the graduate student
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students
        assertEquals(true, regSystem.register(33011101, "INFS 612"));
        assertEquals(false, regSystem.register(33011101, "CS 683"));
        assertEquals(false, regSystem.register(33011101, "INFS 612"));
        assertEquals(false, regSystem.register(33011101, "INFS 611"));
        assertEquals(true, regSystem.register(33011101, "INFS 510"));
        assertEquals(true, regSystem.postGrade(33011101, "INFS 612", 100));
        assertEquals(false, regSystem.postGrade(33011101, "CS 683", 98));
        assertEquals(false, regSystem.postGrade(33011101, "INFS 612", 79));
        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 68));
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);
    }

    @Test
    public void testStartANewSemester5() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #25 new semester for a graduate student, and registering in the Spring
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students for Fall 2018
        assertEquals(true, regSystem.register(33011101, "INFS 612"));
        assertEquals(false, regSystem.register(33011101, "CS 683"));
        assertEquals(false, regSystem.register(33011101, "INFS 612"));
        assertEquals(false, regSystem.register(33011101, "INFS 611"));
        assertEquals(true, regSystem.register(33011101, "INFS 510"));
        // post grades for Fall 2018
        assertEquals(true, regSystem.postGrade(33011101, "INFS 612", 100));
        assertEquals(false, regSystem.postGrade(33011101, "CS 683", 98));
        assertEquals(false, regSystem.postGrade(33011101, "INFS 612", 79));
        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 68));

        // new semester starts
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);
        // add new courses for the Spring semester
        assertEquals(true, regSystem.register(33011101, "INFS 510"));
        assertEquals(true, regSystem.register(33011101, "INFS 521"));
        assertEquals(true, regSystem.register(33011101, "INFS 630"));
        assertEquals(false, regSystem.register(33011101, "INFS 630"));
        assertEquals(true, regSystem.register(33011101, "INFS 700"));

        // semester over , post grades
        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 96)); // true
        assertEquals(true, regSystem.postGrade(33011101, "INFS 521", 98)); // true
        assertEquals(true, regSystem.postGrade(33011101, "INFS 630", 79)); // true
        assertEquals(false, regSystem.postGrade(33011101, "INFS 630", 79)); // false
        assertEquals(true, regSystem.postGrade(33011101, "INFS 700", 68)); // true
    }

    @Test
    public void testStartANewSemester6() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #26 new semester is over for a graduate student, show transcripts
        initRegSystemCoursesGrad(regSystem);
        // now add graduate students
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");
        // register graduate students for Fall 2018
        assertEquals(true, regSystem.register(33011101, "INFS 612"));
        assertEquals(false, regSystem.register(33011101, "CS 683"));
        assertEquals(false, regSystem.register(33011101, "INFS 612"));
        assertEquals(false, regSystem.register(33011101, "INFS 611"));
        assertEquals(true, regSystem.register(33011101, "INFS 510"));
        // post grades for Fall 2018
        assertEquals(true, regSystem.postGrade(33011101, "INFS 612", 100));
        assertEquals(false, regSystem.postGrade(33011101, "CS 683", 98));
        assertEquals(false, regSystem.postGrade(33011101, "INFS 612", 79));
        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 68));

        // new semester starts
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);
        // add new courses for the Spring semester
        assertEquals(true, regSystem.register(33011101, "INFS 510"));
        assertEquals(true, regSystem.register(33011101, "INFS 521"));
        assertEquals(true, regSystem.register(33011101, "INFS 630"));
        assertEquals(false, regSystem.register(33011101, "INFS 630"));
        assertEquals(true, regSystem.register(33011101, "INFS 700"));

        // semester over , post grades
        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 96)); // true
        assertEquals(true, regSystem.postGrade(33011101, "INFS 521", 98)); // true
        assertEquals(true, regSystem.postGrade(33011101, "INFS 630", 89)); // true
        assertEquals(false, regSystem.postGrade(33011101, "INFS 630", 79)); // false
        assertEquals(true, regSystem.postGrade(33011101, "INFS 700", 98)); // true
        assertEquals("Hoff, Bruce (G#33011101), Degree: M.S., Major: Information Systems\n" +
                        " Fall 2018\n" +
                        "\tINFS 612 Communication Systems,   credits: 3, GRADE: A\n" +
                        "\tINFS 510 Database Systems,   credits: 3, GRADE: F",
                regSystem.getProgress(33011101, "Fall", 2018).trim());
        assertEquals("Hoff, Bruce (G#33011101), Degree: M.S., Major: Information Systems\n" +
                        " Spring 2019\n" +
                        "\tINFS 510 Database Systems,   credits: 3, GRADE: A\n" +
                        "\tINFS 521 Data Science,   credits: 3, GRADE: A\n" +
                        "\tINFS 630 Distributed Computing,   credits: 3, GRADE: B\n" +
                        "\tINFS 700 Independent Studies,   credits: 3, GRADE: A",
                regSystem.getProgress(33011101, "Spring", 2019).trim());
    }

    @Test
    public void testDropingCourses0() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #27 an undergraduate student dropping courses
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);
        assertTrue("adding full catalog", regSystem.addCourse("CS 101", "Beginning Computer Technology", 3));
        assertTrue(regSystem.addCourse("CS 212", "Object Methods for Software Development", 3));
        assertTrue(regSystem.addCourse("CS 238", "Higher Level Languages (Java)", 3));
        assertTrue(regSystem.addCourse("PHYS 101", "Introduction to Physics", 3));
        assertTrue(regSystem.addCourse("PHYS 399", "Quantum Mechanics", 3));
        assertTrue(regSystem.addCourse("PHYS 233", "Theory of Relativity", 3));
        assertTrue(regSystem.addCourse("INFS 201", "Communication Today", 3));
        assertTrue(regSystem.addCourse("MATH 203", "Pre-algebra", 3));
        assertTrue(regSystem.addCourse("MATH 301", "Linear Algebra", 3));
        assertTrue(regSystem.addCourse("MATH 302", "Linear Algebra II", 3));
        assertTrue(regSystem.addCourse("MATH 210", "Discrete Mathematics", 3));
        assertTrue(regSystem.addCourse("IT 301", "Object-Oriented Modeling", 3));

        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));

        // now lets try the course drop function, add new courses first
        assertEquals(true, regSystem.register(12345666L, "MATH 302"));  // this will work: true
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        assertEquals(true, regSystem.register(12345666L, "MATH 210"));  // true
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));  // true
        assertEquals(true, regSystem.register(12345666L, "PHYS 101"));  // true
        assertEquals(true, regSystem.register(12345666L, "CS 212"));  // true
        //   assertEquals(regSystem.getProgress(12345666L, "Fall", 2018));
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Spring 2019\n" +
                        "\tMATH 302 Linear Algebra II,   credits: 3\n" +
                        "\tMATH 210 Discrete Mathematics,   credits: 3\n" +
                        "\tINFS 201 Communication Today,   credits: 3\n" +
                        "\tPHYS 101 Introduction to Physics,   credits: 3\n" +
                        "\tCS 212 Object Methods for Software Development,   credits: 3",
                regSystem.getProgress(12345666L, "Spring", 2019).trim());

        // now drop courses
        assertEquals(false, regSystem.drop(12345666L, "PHYS 233"));  // student is not registered in this course: false
        assertEquals(true, regSystem.drop(12345666L, "CS 212"));  // true
        assertEquals(true, regSystem.drop(12345666L, "INFS 201"));  // true
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Spring 2019\n" +
                        "\tMATH 302 Linear Algebra II,   credits: 3\n" +
                        "\tMATH 210 Discrete Mathematics,   credits: 3\n" +
                        "\tPHYS 101 Introduction to Physics,   credits: 3",
                regSystem.getProgress(12345666L, "Spring", 2019).trim());
    }

    @Test
    public void testDropingCourses1() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #27 an undergraduate student dropping courses
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);
        initRegSystemCoursesUG(regSystem);

        assertEquals(true, regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS"));

        // now lets try the course drop function, add new courses first
        assertEquals(true, regSystem.register(12345666L, "MATH 302"));  // this will work: true
        assertEquals(false, regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        assertEquals(true, regSystem.register(12345666L, "MATH 210"));  // true
        assertEquals(true, regSystem.register(12345666L, "INFS 201"));  // true
        assertEquals(true, regSystem.register(12345666L, "PHYS 101"));  // true
        assertEquals(true, regSystem.register(12345666L, "CS 212"));  // true
        //   assertEquals(regSystem.getProgress(12345666L, "Fall", 2018));
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Spring 2019\n" +
                        "\tMATH 302 Linear Algebra II,   credits: 3\n" +
                        "\tMATH 210 Discrete Mathematics,   credits: 3\n" +
                        "\tINFS 201 Communication Today,   credits: 3\n" +
                        "\tPHYS 101 Introduction to Physics,   credits: 3\n" +
                        "\tCS 212 Object Methods for Software Development,   credits: 3",
                regSystem.getProgress(12345666L, "Spring", 2019).trim());

        // now drop courses
        assertEquals(false, regSystem.drop(12345666L, "PHYS 233"));  // student is not registered in this course: false
        assertEquals(true, regSystem.drop(12345666L, "CS 212"));  // true
        assertEquals(true, regSystem.drop(12345666L, "INFS 201"));  // true
        assertEquals("Bazuka, Joe (G#12345666), Degree: B.S., Major: Mathematics\n" +
                        " Spring 2019\n" +
                        "\tMATH 302 Linear Algebra II,   credits: 3\n" +
                        "\tMATH 210 Discrete Mathematics,   credits: 3\n" +
                        "\tPHYS 101 Introduction to Physics,   credits: 3",
                regSystem.getProgress(12345666L, "Spring", 2019).trim());
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 302", 98));
        assertEquals(true, regSystem.postGrade(12345666L, "MATH 210", 88));
        assertEquals(true, regSystem.postGrade(12345666L, "PHYS 101", 76));
        // now try dropping courses after grades are posted
        assertEquals(false, regSystem.drop(12345666L, "PHYS 101"));  // student is not registered in this course: false
        assertEquals(false, regSystem.drop(12345666L, "PHYS 233"));  // student is not registered in this course: false
        assertEquals(false, regSystem.drop(12345666L, "CS 212"));  // true
        assertEquals(false, regSystem.drop(12345666L, "INFS 201"));  // true

    }

    @Test
    public void testDropingCourses2() {

        Registrar regSystem = new Registrar("Fall", 2018);
        // #29 a graduate student dropping courses
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);
        // add courses
        initRegSystemCourses(regSystem);
        // add student
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");

        // now try dropping courses for a graduate student
        // first add courses for the new semester
        assertEquals(true, regSystem.register(33011101, "INFS 510")); // true
        assertEquals(true, regSystem.register(33011101, "INFS 521")); // true
        assertEquals(true, regSystem.register(33011101, "INFS 630")); // true
        assertEquals(true, regSystem.register(33011101, "INFS 700")); // true

        assertEquals(true, regSystem.drop(33011101, "INFS 521")); // true
        assertEquals(true, regSystem.drop(33011101, "INFS 700")); // true

        assertEquals(true, regSystem.postGrade(33011101, "INFS 510", 96)); // true
        assertEquals(false, regSystem.postGrade(33011101, "INFS 521", 98)); // false course dropped
        assertEquals(true, regSystem.postGrade(33011101, "INFS 630", 79)); // true
        assertEquals(false, regSystem.postGrade(33011101, "INFS 630", 79)); // false
        assertEquals(false, regSystem.postGrade(33011101, "INFS 700", 68)); // false course dropped
        // now try to drop courses after grades were posted
        assertEquals(false, regSystem.drop(33011101, "INFS 521")); // false grade alreasy posted
        assertEquals(false, regSystem.drop(33011101, "INFS 700")); // false grade already posted
    }

    @Test
    public void testRegisterNonexistingStudent() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #30
        assertEquals(false, regSystem.register(12345666L, "MATH 302"));
    }

    @Test
    public void testPostGradeNonexistingStudent() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #31
        assertEquals(false, regSystem.postGrade(12345666L, "MATH 302", 88));
    }

    @Test
    public void testDropNonexistingStudent() {
        Registrar regSystem = new Registrar("Fall", 2018);
        // #32
        assertEquals(false, regSystem.drop(12345666L, "MATH 302"));
    }
}
