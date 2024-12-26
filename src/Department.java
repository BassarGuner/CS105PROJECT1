package src;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Department {
    private String name;
    private static ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;
    private static ArrayList<Student> students;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
        students = new ArrayList<>();
    }

    public static ArrayList<Course> getCourses() {
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
        Course courseFound = null;
        for(int course = 0; course < this.courses.size(); course++) {
            if(this.courses.get(course).getCourseName().equals(courseid)){
                courseFound = this.courses.get(course);
                break;
            }
        }
        return courseFound;
    }

    public void getCourseName(){
        for (Course course : this.courses) {

        }
    }


    public static ArrayList<Student> getStudents() {
        return students;
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