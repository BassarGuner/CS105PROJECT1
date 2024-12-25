import java.util.ArrayList;

public class Course {
    // Attributes
    private String id;
    private String name;
    private Instructor instructor;
    private ArrayList<Student> students;

    // Constructor
    public Course(String courseID, String courseName) {
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
            System.out.println("Error: Student is null"); }
    }

    // Method 2 - Remove a student from the course
    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println(student.getName() + " removed from " + name);
        }
        else {
            System.out.println("Error: Student not found in the " + name);
        }
    }

    // Getters and Setters:

        // Getter1 - getID()
    public String getId() {
        return id;
    }

        // Getter2 - getName()
    public String getName() {
        return name;
    }

        // Getter3 - getInstructor()
    public Instructor getInstructor() {
        return instructor;
    }

        // Getter4 - getStudents()
    public ArrayList<Student> getStudents() {
        return students;
    }


        // Setter1 - setInstructor()
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        System.out.println("Instructor " + instructor.getName() + " assigned to course " + name);
    }

    // Reports (Prints):

        // Prints the names of all enrolled students
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + name); }
        else {
            System.out.println("Students enrollen in " + name + ":");
            for (Student s : students) {
                System.out.println("Name: " + s.getName());
                }
            }
        }

        // Prints course details
    @Override
    public String toString() {
        return "Course ID [ID= " + id + " Course Name = " + name + " Instructor = " +
                (instructor != null ? instructor.getName() : "None") + "]"; // koşul ? doğruysa_dönen_değer : yanlışsa_dönen_değer

    }
}

