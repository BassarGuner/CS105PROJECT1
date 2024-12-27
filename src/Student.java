package src;

import java.util.*;
import javax.swing.JOptionPane;


public class Student extends Person {
    private Map<String, Course> enrolledCourses;
    private List<GradeItem> grades;

    public Student(String name) {
        super(name);
        this.enrolledCourses = new HashMap<>();
        this.grades = new ArrayList<>();
        initEmail();
    }

    @Override
    protected void initEmail() {
        String[] parts = getName().toLowerCase().split(" ");
        if (parts.length < 2) {
            JOptionPane.showMessageDialog(null,"Name must contain both first and last name for email generation.");
            setEmail(null);
        } else{
        setEmail(parts[0] + "." + parts[parts.length - 1] + "@ozu.edu.tr");
        }
    }

    public void registerToCourse(Course course) {
        if (course.getInstructor() != null) {                       
            enrolledCourses.put(course.getCourseId(), course);               
            course.addStudent(this);
            JOptionPane.showMessageDialog(null,"Registered to course: " + course.getCourseName()); 
        } else {
            JOptionPane.showMessageDialog(null,"Cannot register, no instructor assigned to course.");
        }
    }

    public void dropCourse(Course course) {
        if (enrolledCourses.remove(course.getCourseId()) != null) {
            course.removeStudent(this);
            JOptionPane.showMessageDialog(null,"Dropped course: " + course.getCourseName());
        }
    }

    public void addGrade(GradeItem grade) {
        grades.add(grade);
    }

    public GradeItem getGradeItem(String courseId, String examId) {
        for (GradeItem grade : grades) {
            if (grade.getCourseId().equals(courseId) && grade.getExamId().equals(examId)) {
                return grade;
            }
        }
        return null;
    }
    public List<GradeItem> getGrades() {
        return grades;
    }
}
