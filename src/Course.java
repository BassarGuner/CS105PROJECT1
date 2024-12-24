package src;

import java.util.ArrayList;

public class Course {
    private String coursename;
    private String courseid;
    private Instructor instructor;
    private ArrayList<Student> students;

    public Course(String courseid, String coursename) {
        this.coursename = coursename;
        this.courseid = courseid;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (this.instructor == null) {
            System.out.println("No instructor assigned. Enrollment is denied for course: " + this.coursename);
        } else {
            students.add(student);
            System.out.println("Student " + student.getName() + " successfully enrolled in " + this.coursename);
        }
    }

    public void removeStudent(Student wantedStudent) {
        students.removeIf(student -> student.equals(wantedStudent));
    }

    public String getId() {
        return courseid;
    }

    public String getCourseName() {
        return coursename;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void listStudents() {
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public String toString() {
        return "\nName: " + coursename + "\nID: " + courseid;
    }
}