package src;

import java.util.*;


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
            System.out.println("Name must contain both first and last name for email generation.");
            setEmail(null);
        } else{
        setEmail(parts[0] + "." + parts[parts.length - 1] + "@ozyegin.edu.tr");
        }
    }

    public void registerToCourse(Course course) {
        if (course.getInstructor() != null) {                          // düzelttim
            enrolledCourses.put(course.getId(), course);               // getCourseId yok
            course.addStudent(this);
            System.out.println("Registered to course: " + course.getCourseName()); // getName olcak getCourseName yok
        } else {
            System.out.println("Cannot register, no instructor assigned to course.");
        }
    }

    public void dropCourse(Course course) {
        if (enrolledCourses.remove(course.getId()) != null) {
            course.removeStudent(this);
            System.out.println("Dropped course: " + course.getCourseName());
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