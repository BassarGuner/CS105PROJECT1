import java.util.ArrayList;
import java.util.Random;

public class Instructor {

    public class Instructor extends Person {
    private ArrayList<Course> courses;

    // Constructor
    public Instructor(String name) {
        super(name);
        this.courses = new ArrayList<>();
    }

    // Email
    @Override
    protected void initEmail() {
        String[] nameParts = name.split(" ");
        String firstName = nameParts[0].toLowerCase();
        String lastName = nameParts[1].toLowerCase();
        this.email = firstName + "." + lastName + "ozyegin.edu.tr";
    }

    // Add a course
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course " + course.getName() + " assigned to the instructor " + name);}
        else {
            System.out.println("Error: Course already assigned to this instructor."); }
    }

    // Registers random exam grades for all students in a specific course
    public void registerExamGrades (String courseId, String examId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                ArrayList<Student> students = course.getStudents();
                if (students.isEmpty()) {
                    System.out.println("No students enrolled in the course " + course.getName());
                    return;
                }

                Random random = new Random();
                for (Student student : students) {
                    int grade = random.nextInt(101);
                    GradeItem gradeItem = new GradeItem (courseId, examId, grade);
                    student.addGrade(gradeItem);
                }
                System.out.println("Grades registered for exam " + examId + " in course " + course.getName());
                return;
            }
        }
        System.out.println("Error: Course with ID " + courseId + " does not exist.");
    }

    // Lists the grades for a specific exam in a course
    public void listGradesForExam (String courseId, String examId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                ArrayList<Student> students = course.getStudents();
                if (students.isEmpty()) {
                    System.out.println("No students enrolled in the course " + course.getName());
                    return;
                }
                System.out.println("Grades for exam " + examId + " in course " + course.getName() + ":");
                for (Student student : students) {
                    GradeItem gradeItem = student.getGradeItem (courseId, examId);
                    if (gradeItem != null) {
                        System.out.println(student.getName() + ": " + gradeItem.getGrade());}
                    else {
                        System.out.println(student.getName() + ": No grade recorded");}
                    }
                return;
                }
            }
        System.out.println("Error: Course with ID " + courseId + " does not exist.");

        // Prints the average grade for a specific exam in a course
        public void printAverageGradeForExam (String courseId, String examId) {
            for (Course course : courses) {
                if (course.getId().equals(courseId)) {
                    ArrayList<Student> students = course.getStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students enrolled in the course " + course.getName());
                        return;
                    }
                    int totalGrade = 0;
                    int gradeCount = 0;
                    for (Student student : students) {
                        GradeItem gradeItem = student.getGradeItem(courseId, examId);
                        if (gradeItem != null) {
                            totalGrade += gradeItem.getGrade();
                            gradeCount++;
                        }
                    }
                    if (gradeCount == 0) {
                        System.out.println("No grade recorded for exam " + examId);
                    }
                    return;
                }
            }
            System.out.println("Error: Course with ID " + courseId + " does not exist.");
        }
        @Override
        public String toString() {
            return "Instructor [Name = " + name + "E-mail=" + email + "ID =" + id + "]";

        }
    }

    }
}