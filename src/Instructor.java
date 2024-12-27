package src;

import javax.swing.JOptionPane;

import java.util.*;

public class Instructor extends Person {
    private List<Course> assignedCourses;

    public Instructor(String name) {
        super(name);
        this.assignedCourses = new ArrayList<>();
        initEmail();
    }

    @Override
    protected void initEmail() {
        String[] parts = getName().toLowerCase().split(" ");
        if (parts.length < 2) {
            JOptionPane.showMessageDialog(null,"Name must contain both first and last name for email generation.");
            setEmail(null);
        } else{
        setEmail(parts[0] + "." + parts[parts.length - 1] + "@ozyegin.edu.tr");
        }
    }

    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public void registerExamGrades(String courseId, String examId, List<Student> students) {
        Random rand = new Random();
        for (Student student : students) {
            int grade = rand.nextInt(101);
            student.addGrade(new GradeItem(courseId, examId, grade));
        }
        JOptionPane.showMessageDialog(null,"Grades registered for exam " + examId + " in course " + courseId);
    }

    public void listGradesForExam(String courseId, String examId, List<Student> students) {
        JOptionPane.showMessageDialog(null,"Grades for Course: " + courseId + ", Exam: " + examId);
        for (Student student : students) {
            GradeItem grade = student.getGradeItem(courseId, examId);
            if (grade != null) {
                JOptionPane.showMessageDialog(null,student.getName() + ": " + grade.getGrade());
            }
        }
    }
    public void printAverageGradeForExam(String courseId, String examId, List<Student> students) {
        double totalGrades = 0;
        int count = 0;

        for (Student student : students) {
            GradeItem grade = student.getGradeItem(courseId, examId);
            if (grade != null) {
                totalGrades += grade.getGrade();
                count++;
            }
        }
            
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No grades found for Course: " + courseId + ", Exam: " + examId);
        } else {
            double average = totalGrades / count;
            JOptionPane.showMessageDialog(null,"Average grade for Course: " + courseId + ", Exam: " + examId + " is " + average);
        }
    }
    public void assignCourse(Course course) {
        if (course.getInstructor() == null) {
            course.setInstructor(this);
            assignedCourses.add(course);
        } else {
            JOptionPane.showMessageDialog(null, "This course already has an instructor assigned.");
        }
    }
}
