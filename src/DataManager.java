package src;
import java.io.*;


import java.util.*;

public class DataManager {
    private List<Student> students;
    private List<Instructor> instructors;
    private List<Course> courses;

    public DataManager() {
        this.students = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.courses = new ArrayList<>();
        loadAllData();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        saveInstructors();
    }

    public void addCourse(Course course) {
        courses.add(course);
        saveCourses();
    }

    private void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getEmail() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Student student = new Student(parts[0]);
                student.setEmail(parts[1]);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveInstructors() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("instructors.txt"))) {
            for (Instructor instructor : instructors) {
                writer.write(instructor.getName() + "," + instructor.getEmail() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadInstructors() {
        try (BufferedReader reader = new BufferedReader(new FileReader("instructors.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Instructor instructor = new Instructor(parts[0]);
                instructor.setEmail(parts[1]);
                instructors.add(instructor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCourses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"))) {
            for (Course course : courses) {
                writer.write(course.getId() + "," + course.getCourseName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCourses() {
        try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Course course = new Course(parts[0], parts[1]);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAllData() {
        loadStudents();
        loadInstructors();
        loadCourses();
    }
}