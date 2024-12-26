package src;

import java.util.*;

public class Instructor extends Person {
    private List<String> assignedCourses;

    public Instructor(String name) {
        super(name);
        this.assignedCourses = new ArrayList<>();
        initEmail();
    }

    @Override
    protected void initEmail() {
        String[] parts = getName().toLowerCase().split(" ");
        if (parts.length < 2) {
            System.out.println("Name must contain both first and last name for email generation.");
            setEmail(null);
        } else{
        setEmail(parts[0] + "." + parts[parts.length - 1] + "@ozyegin.edu.tr");
        }
    }

    public void assignCourse(String courseId) {
        assignedCourses.add(courseId);
        System.out.println("Instructor assigned to course: " + courseId);
    }

    public void registerExamGrades(String courseId, String examId, List<Student> students) {
        Random rand = new Random();
        for (Student student : students) {
            int grade = rand.nextInt(101);
            student.addGrade(new GradeItem(courseId, examId, grade));
        }
        System.out.println("Grades registered for exam " + examId + " in course " + courseId);
    }

    public void listGradesForExam(String courseId, String examId, List<Student> students) {
        System.out.println("Grades for Course: " + courseId + ", Exam: " + examId);
        for (Student student : students) {
            GradeItem grade = student.getGradeItem(courseId, examId);
            if (grade != null) {
                System.out.println(student.getName() + ": " + grade.getGrade());
            }
        }
    }
}