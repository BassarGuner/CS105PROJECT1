package src;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null,"No instructor assigned. Enrollment is denied for course: " + this.coursename);
        } else {
            students.add(student);
            JOptionPane.showMessageDialog(null,"Student " + student.getName() + " successfully enrolled in " + this.coursename);
        }
    }

    public void removeStudent(Student wantedStudent) {
        students.removeIf(student -> student.equals(wantedStudent));
    }

    public String getCourseId() {
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
        if (this.instructor != null) {
            JOptionPane.showMessageDialog(null, "This course already has an instructor assigned.");
        } else {
            this.instructor = instructor;
            JOptionPane.showMessageDialog(null, "Instructor " + instructor.getName() + " assigned to course: " + this.coursename);
        }
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
