

// The main driver for the command-line driven version of the Registration Program.

public class RegistrationProgram {

    public static void main(String[] args) {
        Registrar regSystem = new Registrar("Fall", 2018);

        // Create various objects by calling the appropriate constructors.  (We'd normally be reading in such data
        // from a database or file ...)

        // Instantiate general Courses: Build the Course Catalog.
        regSystem.addCourse("CS 101", "Beginning Computer Technology", 3);
        regSystem.addCourse("CS 212", "Object Methods for Software Development", 3);
        regSystem.addCourse("CS 238", "Higher Level Languages (Java)", 3);
        regSystem.addCourse("PHYS 101", "Introduction to Physics", 3);
        regSystem.addCourse("PHYS 399", "Quantum Mechanics", 3);
        regSystem.addCourse("PHYS 233", "Theory of Relativity", 3);
        regSystem.addCourse("INFS 201", "Communication Today", 3);
        regSystem.addCourse("MATH 203", "Pre-algebra", 3);
        regSystem.addCourse("MATH 301", "Linear Algebra", 3);
        regSystem.addCourse("MATH 302", "Linear Algebra II", 3);
        regSystem.addCourse("Math 210", "Discrete Mathematics", 3);
        regSystem.addCourse("IT 301", "Object-Oriented Modeling", 3);

        regSystem.addCourse("CS 521", "Computer Networks", 3);
        regSystem.addCourse("INFS 510", "Database Systems", 3);
        regSystem.addCourse("CS 583", "Computer Algorithms", 3);
        regSystem.addCourse("INFS 612", "Communication Systems", 3);
        regSystem.addCourse("CS 683", "Program Data and Design", 3);
        regSystem.addCourse("INFS 521", "Data Science", 3);
        regSystem.addCourse("INFS 630", "Distributed Computing", 3);
        regSystem.addCourse("INFS 700", "Independent Studies", 3);


        System.out.println("\n====================");
        System.out.println("   Course Catalog ");
        System.out.println("====================");
        System.out.println(regSystem.getCourseCatalog());


        // Instantiate student objects with differet levels: Build the student body.
        regSystem.addStudent("Joe", "Bazuka", 12345666, "Mathematics", "B.S.", "Joshua Heights HS");
        regSystem.addStudent("Lisa", "Spain", 11222222, "Computer Science", "General Studies", null);
        regSystem.addStudent("Mary", "Alice", 11333333, "Physics", "General Studies", "George Marshall HS");
        regSystem.addStudent("Jane", "Doe", 22444444, "Physics", "B.S.", "Justice HS");
        regSystem.addStudent("John", "Becker", 22434455, "Computer Science", "B.S.", "Fairfax HS");
        regSystem.addStudent("Kerry", "Cool", 33111111, "Mathematics", "Ph. D.", "Math", "TAU");
        regSystem.addStudent("Bruce", "Hoff", 33011101, "Information Systems", "M.S.", "CS", "TAU");

        System.out.println("\n\n===============================");
        System.out.println("Student registration has begun!  (Fall 2018)");
        System.out.println("==================================");

        // Simulate students attempting to enroll in courses of various departments.
        System.out.println(regSystem.register(12345666L, "MATH 301"));  // this will work: true
        System.out.println(regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        System.out.println(regSystem.register(12345666L, "MATH 203"));  // true
        System.out.println(regSystem.register(12345666L, "INFS 201"));  // true
        System.out.println(regSystem.register(12345666L, "MATH 111"));  // should fail since the class doesnot exist: false
        System.out.println(regSystem.getProgress(12345666L, "Fall", 2018));

        // now try a graduate student
        System.out.println(regSystem.register(33011101, "INFS 612")); // true
        System.out.println(regSystem.register(33011101, "CS 683")); // this will fail since major doesnot match: false
        System.out.println(regSystem.register(33011101, "INFS 612")); // this should fail since student already added to the course: false
        System.out.println(regSystem.register(33011101, "INFS 611")); // this will fail since course doesnot exist: false
        System.out.println(regSystem.register(33011101, "INFS 510")); // true
        System.out.println(regSystem.getProgress(33011101, "Fall", 2018));

        // lets assign grades for the students
        System.out.println(regSystem.postGrade(12345666L, "MATH 301", 97)); // true
        System.out.println(regSystem.postGrade(12345666L, "PHYS 101", 68));  // assigning a score to a class which the student didnt register to!
        System.out.println(regSystem.postGrade(12345666L, "MATH 203", 91));  // true
        System.out.println(regSystem.postGrade(12345666L, "INFS 201", 78)); // this will work: true
        System.out.println(regSystem.postGrade(12345666L, "MATH 111", 83));    // should fail since the class doesnot exist: flse
        System.out.println(regSystem.getProgress(12345666L, "Fall", 2018));

        System.out.println(regSystem.postGrade(33011101, "INFS 612", 100)); // true
        System.out.println(regSystem.postGrade(33011101, "CS 683", 98)); // student is not registered for the course: false
        System.out.println(regSystem.postGrade(33011101, "INFS 612", 79)); // this should fail since score already recorded: false
        System.out.println(regSystem.postGrade(33011101, "INFS 510", 68)); // true
        System.out.println(regSystem.getProgress(33011101, "Fall", 2018));

        // start a new semester
        System.out.println("\n\n===========================================");
        System.out.println("Student registration has begun!  (Spring 2019)");
        System.out.println("===============================================");
        regSystem.setSemester("Spring");
        regSystem.setYear(2019);


        // now lets try the course drop function, add new courses first
        System.out.println(regSystem.register(12345666L, "MATH 302"));  // this will work: true
        System.out.println(regSystem.register(12345666L, "PHYS 101"));  // this will fail: false
        System.out.println(regSystem.register(12345666L, "MATH 210"));  // true
        System.out.println(regSystem.register(12345666L, "INFS 201"));  // true
        System.out.println(regSystem.register(12345666L, "PHYS 101"));  // false
        System.out.println(regSystem.register(12345666L, "CS 212"));  // true
        System.out.println(regSystem.getProgress(12345666L, "Fall", 2018));
        System.out.println(regSystem.getProgress(12345666L, "Spring", 2019));

        // now drop courses
        System.out.println(regSystem.drop(12345666L, "PHYS 233"));  // student is not registered in this course: false
        System.out.println(regSystem.drop(12345666L, "CS 212"));  // true
        System.out.println(regSystem.drop(12345666L, "INFS 201"));  // true
        System.out.println(regSystem.getProgress(12345666L, "Spring", 2019));

        // now try dropping courses for a graduate student
        // first add courses for the new semester
        System.out.println(regSystem.register(33011101, "INFS 510")); // true
        System.out.println(regSystem.register(33011101, "INFS 521")); // true
        System.out.println(regSystem.register(33011101, "INFS 630")); // true
        System.out.println(regSystem.register(33011101, "INFS 700")); // true
        System.out.println(regSystem.getProgress(33011101, "Fall", 2018));
        System.out.println(regSystem.getProgress(33011101, "Spring", 2019));

        System.out.println(regSystem.drop(33011101, "INFS 521")); // true
        System.out.println(regSystem.drop(33011101, "INFS 700")); // true

        System.out.println(regSystem.postGrade(33011101, "INFS 510", 96)); // true
        System.out.println(regSystem.postGrade(33011101, "INFS 521", 98)); // false course dropped
        System.out.println(regSystem.postGrade(33011101, "INFS 630", 79)); // true
        System.out.println(regSystem.postGrade(33011101, "INFS 630", 79)); // false
        System.out.println(regSystem.postGrade(33011101, "INFS 700", 68)); // false course dropped
        System.out.println(regSystem.getProgress(33011101, "Fall", 2018));
        // now drop courses
        System.out.println(regSystem.drop(33011101, "INFS 521")); // false grade alreasy posted
        System.out.println(regSystem.drop(33011101, "INFS 700")); // false grade already posted
        System.out.println(regSystem.getProgress(33011101, "Spring", 2019));

    }


}


