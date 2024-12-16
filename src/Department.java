package src;

import java.util.ArrayList;

public class Department {

    private String name;
    /*
    private ArrayList<Course> courses;           // kodların hepsi teorik suan nesneler oluşmadığı için
    private ArrayList<Instructor> instructors;
    private ArrayList<Student> students;
     */
    Department(String name) {
        this.name = name;
    }

    public void addInstructor(String name) {
        instructors.add(name);
    }
    public void addStudent(String name) {
        students.add(name);
    }
    public void assignInstructorToCourse(String instructorName, String courseName) {
        for(int course = 0; course < courses.size(); course++){
            if(courses.get(course).getName() == courseName) {
                courses.get(course).setInstructor(instructorName);
            }
        }

    }

    public void createCourse(String courseId, String courseName) {
        Course newCourse = new Course(courseId, courseName);
        courses.add(newCourse);
        for (int course = 0; course < courses.size(); course++) {
            if(courses.get(course).getId() == courseId && courses.get(course).getInstructor() == null) {
                System.out.println("Course " + courseId + " has no instructor " +
                         " wont be able to allow any enrollments.");
            }
        }
    }

    public ArrayList<Instructor> getInstructors(){
        return instructors;
    }
    public Course getCourse(String courseName) {
        Course courseFound = null;
        for(int course = 0; course < courses.size(); course++) {
            if(courses.get(course).getName() == courseName){
                courseFound = courses.get(course);
            }
        }
        return courseFound;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public Instructor getInstructorByName(String instructorName){
        Instructor instructorFound;
        for(int instructor = 0; instructor < instructors.size(); instructor++){
            if(instructors.get(instructor).getName() == instructorName){
                instructorFound = instructors.get(instructor);
            }
        }
        return instructorFound;
    }

    public void listInstructors(){
        for(int instructor = 0; instructor < instructors.size(); instructor++){
            System.out.println(instructor);
        }
    }

    public void listCourses(){
        for(int course = 0; course < courses.size(); course++){
            System.out.println(course);
        }
    }

    public void listStudents(){
        for(int student = 0; student< students.size(); student++){
            System.out.println(student);
        }
    }
}