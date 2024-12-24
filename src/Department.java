package src;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Course> courses; // Removed static keyword
    private ArrayList<Instructor> instructors;
    private ArrayList<Student> students;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addInstructor(String name) {
        this.instructors.add(new Instructor(name));
    }

    public void addStudent(String name) {
        this.students.add(new Student(name));
    }

    public void assignInstructorToCourse(String instructorName, String courseName) {
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseName)) {
                course.setInstructor(new Instructor(instructorName));
                return;
            }
        }
        System.out.println("Course not found: " + courseName);
    }

    public void createCourse(String courseId, String courseName) {
        Course newCourse = new Course(courseId, courseName);
        this.courses.add(newCourse);

        if (newCourse.getInstructor() == null) {
            System.out.println("Course " + courseId + " has no instructor and will not allow enrollments.");
        }
    }

    public ArrayList<Instructor> getInstructors() {
        return this.instructors;
    }

    public Course getCourse(String courseid) {
        for (Course course : this.courses) {
            if (course.getCourseName().equals(courseid)) {
                return course;
            }
        }
        return null; // Course not found
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Instructor getInstructorByName(String instructorName) {
        for (Instructor instructor : this.instructors) {
            if (instructor.getName().equals(instructorName)) {
                return instructor;
            }
        }
        return null; // Instructor not found
    }

    public void listInstructors() {
        for (Instructor instructor : this.instructors) {
            System.out.println(instructor.getName());
        }
    }

    public void listCourses() {
        for (Course course : this.courses) {
            System.out.println(course.getCourseName());
        }
    }

    public void listStudents() {
        for (Student student : this.students) {
            System.out.println(student.getName());
        }
    }

    public String toString() {
        return "\nThe department is: " + name;
    }
} 