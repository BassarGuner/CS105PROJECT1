package src;
import java.util.ArrayList;
import java.util.Objects;

public class Department {
    private String name;
    private static ArrayList<Course> courses;               // getCourses func i için
    private ArrayList<Instructor> instructors;
    private static ArrayList<Student> students;

    Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public static ArrayList<Course> getCourses(){           // Course den course oluşturunca burdaki courses e eklemk için
        return courses;
    }

    public void addInstructor(String name) {
        this.instructors.add(new Instructor(name));
    }
    public void addStudent(String name) {
        this.students.add(new Student(name));
    }

    public void assignInstructorToCourse(String instructorName, String courseName) {
        for(int course = 0; course < this.courses.size(); course++){
            if(Objects.equals(this.courses.get(course).getCourseName(), courseName)) {
                this.courses.get(course).setInstructor(new Instructor(instructorName));
            }
        }

    }

    public void createCourse(String courseId, String courseName) {
        // Course newCourse = new Course(courseId, courseName);
        this.courses.add(new Course(courseId, courseName));
        for (int course = 0; course < this.courses.size(); course++) {
            if(this.courses.get(course).getInstructor() == null) {
                this.students.clear();
                System.out.println("Course " + courseId + " has no instructor " +
                        " wont be able to allow any enrollments.");
                break;
            }
            else {
                System.out.println("Students can enroll this course. "
                        + "students number:" + this.students.size());
                break;

            }
        }
    }

    public ArrayList<Instructor> getInstructors(){
        return this.instructors;
    }
    public Course getCourse(String courseName) {
        Course courseFound = null;
        for(int course = 0; course < this.courses.size(); course++) {
            if(Course.getCoursename() == courseName){
                courseFound = this.courses.get(course);
                break;
            }
        }
        return courseFound;
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }
    public Instructor getInstructorByName(String instructorName){
        Instructor instructorFound = null;
        for(int instructor = 0; instructor < this.instructors.size(); instructor++){
            if(this.instructors.get(instructor).getName() == instructorName){
                instructorFound = instructors.get(instructor);
            }
        }
        return instructorFound;
    }

    public void listInstructors(){
        int counter = 0;
        for(int instructor = 0; instructor < this.instructors.size(); instructor++){
            System.out.println(instructors.get(instructor).getName());
            counter++;
        }
        System.out.println("Total number of instructors: " + counter);
    }

    public void listCourses(){
        int counter = 0;
        for(int course = 0; course < this.courses.size(); course++){
            System.out.println(Course.getCoursename());
            counter++;
        }
        System.out.println("Total number of courses: " + counter);
    }

    public void listStudents(){
        int counter = 0;
        for(int student = 0; student< this.students.size(); student++){
            System.out.println(students.get(student).getName());
            counter++;
        }
        System.out.println("Total students: " + counter);
    }

    public String toString() {
        return "\nThe department is: " + name;
    }


}