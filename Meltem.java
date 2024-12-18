import java.util.ArrayList;

public class Meltem {
    // Attributes
    private String id;
    private String name;
    private Instructor instructor; // Instructor bir class aslında o classı sonra yapçam
    private ArrayList<Student> students;

    // Constructor
    public Meltem (String courseID, String courseName) {
        id = courseID; // this kullansam daha mı anlaşılır olurdu?
        name = courseName;
        students = new ArrayList<>(); // başta öğrenci boş liste
        instructor = null; // başta hoca yok
    }

    // Method 1 - Add a student to the course
    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
            System.out.println(student.getName() + " added to " + name ); } // buradaki getter Student sınıfının içinden geliyor aslında, o yüzden Student class'ta tanımlanmalı getter!
        else {
            System.out.println("Error: student is null"); }
    }

    // Method 2 - Remove a student from the course
    public void removeStudent(Student student) {
        if () // if elseler
    }

    }

