package src;

import java.util.ArrayList;

public class Department {

    private String name;
    /*
    private ArrayList<Course> courses;
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

    public ArrayList<Instructor> getInstructors(){
        return instructors;
    }
    public Course getCourse(String courseName) {
        Course courseFound;
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