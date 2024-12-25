package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

//import static src.Department.students;
import src.Course;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Department department = new Department("Computer Science");
        department.addInstructor("John Doe");
        department.createCourse("CS101", "Introduction to Programming");

        LoginHandler loginHandler = new LoginHandler(department);
        loginHandler.showLoginScreen();
    }
}

class LoginHandler {
    private Department department;

    public LoginHandler(Department department) {
        this.department = department;
    }

    public void showLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        JButton createAccountButton = new JButton("Create Account");
        JButton loginStudentButton = new JButton("Login as Student");
        JButton loginInstructorButton = new JButton("Login as Instructor");
        JButton loginDepartmentButton = new JButton("Login as Department");

        panel.add(createAccountButton);
        panel.add(loginStudentButton);
        panel.add(loginInstructorButton);
        panel.add(loginDepartmentButton);

        createAccountButton.addActionListener(e -> showCreateAccountScreen(frame));
        loginStudentButton.addActionListener(e -> showStudentLogin(frame));
        loginInstructorButton.addActionListener(e -> showInstructorLogin(frame));
        loginDepartmentButton.addActionListener(e -> showDepartmentLogin(frame));

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showCreateAccountScreen(JFrame parentFrame) {
        parentFrame.setVisible(false);
        JFrame frame = new JFrame("Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField nameField = new JTextField();
        JComboBox<String> roleBox = new JComboBox<>(new String[]{"Student", "Instructor"});
        JButton createButton = new JButton("Create");
        JButton cancelButton = new JButton("Cancel");

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Role:"));
        panel.add(roleBox);
        panel.add(createButton);
        panel.add(cancelButton);

        createButton.addActionListener(e -> {
            String name = nameField.getText();
            String role = (String) roleBox.getSelectedItem();
            if (role.equals("Student")) {
                Student student = new Student(name);
                department.addStudent(student.getName());
                JOptionPane.showMessageDialog(frame, "Student account created: " + student.getEmail());
            } else {
                Instructor instructor = new Instructor(name);
                department.addInstructor(instructor.getName());
                JOptionPane.showMessageDialog(frame, "Instructor account created: " + instructor.getEmail());
            }
            frame.dispose();
            showLoginScreen();
        });
        cancelButton.addActionListener(e -> {
            frame.dispose();
            new LoginHandler(department).showLoginScreen();
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showStudentLogin(JFrame parentFrame) {
        parentFrame.setVisible(false);
        JFrame frame = new JFrame("Student Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JTextField emailField = new JTextField();
        JButton loginButton = new JButton("Login");
        JButton logoutButton = new JButton("cancel");

        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(loginButton);
        panel.add(logoutButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            // for (Student student : department.getStudents()) {}
            for (int i = 0; i < Department.getStudents().size(); i++) {
                Student student = Department.getStudents().get(i);
                if (student.getEmail().equals(email)) {
                    frame.dispose();
                    new StudentDashboard(student, department);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Student not found.");
        });
        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginHandler(department).showLoginScreen();
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showInstructorLogin(JFrame parentFrame) {
        parentFrame.setVisible(false);
        JFrame frame = new JFrame("Instructor Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JTextField emailField = new JTextField();
        JButton loginButton = new JButton("Login");
        JButton logoutButton  = new JButton("Cancel");

        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(loginButton);
        panel.add(logoutButton);


        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            for (Instructor instructor : department.getInstructors()) {
                if (instructor.getEmail().equals(email)) {
                    frame.dispose();
                    new InstructorDashboard(instructor, department);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Instructor not found.");
        });
        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginHandler(department).showLoginScreen();
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void showDepartmentLogin(JFrame parentFrame) {
        parentFrame.setVisible(false);
        JFrame frame = new JFrame("Department Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton logoutButton = new JButton("Cancel");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(logoutButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("admin") && password.equals("password123")) {
                frame.dispose();
                new DepartmentDashboard(department);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials.");
            }
        });
        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginHandler(department).showLoginScreen();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}

class StudentDashboard {
    public StudentDashboard(Student student, Department department) {
        JFrame frame = new JFrame("Student Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(new JLabel("Welcome, " + student.getName()));
        panel.add(new JLabel("ID: " + student.getId()));
        panel.add(new JLabel("Email: " + student.getEmail()));

        JButton registerCourseButton = new JButton("Register to Course");
        JButton dropCourseButton = new JButton("Drop Course");
        JButton listGradesButton = new JButton("List Grades");
        JButton logoutButton = new JButton("Logout");

        panel.add(registerCourseButton);
        panel.add(dropCourseButton);
        panel.add(listGradesButton);
        panel.add(logoutButton);

        registerCourseButton.addActionListener(e -> {
            String courseId = JOptionPane.showInputDialog("Enter Course ID:");
            Course course = department.getCourse(courseId);
            if (course != null) {
                student.registerToCourse(course);
            } else {
                JOptionPane.showMessageDialog(frame, "Course not found.");
            }
        });

        dropCourseButton.addActionListener(e -> {
            String courseId = JOptionPane.showInputDialog("Enter Course ID:");
            Course course = department.getCourse(courseId);
            if (course != null) {
                student.dropCourse(course);
            } else {
                JOptionPane.showMessageDialog(frame, "Course not found.");
            }
        });

        listGradesButton.addActionListener(e -> {
            StringBuilder grades = new StringBuilder();
            for (GradeItem grade : student.getGrades()) {
                grades.append(grade.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, grades.toString());
        });
        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginHandler(department).showLoginScreen();
        });
        frame.add(panel);
        frame.setVisible(true);
    }
}

class InstructorDashboard {
    public InstructorDashboard(Instructor instructor, Department department) {
        JFrame frame = new JFrame("Instructor Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(new JLabel("Welcome, " + instructor.getName()));
        panel.add(new JLabel("ID: " + instructor.getId()));
        panel.add(new JLabel("Email: " + instructor.getEmail()));

        JButton registerExamGradesButton = new JButton("Register Exam Grades");
        JButton listGradesButton = new JButton("List Grades for Exam");
        JButton logoutButton = new JButton("Logout");

        panel.add(registerExamGradesButton);
        panel.add(listGradesButton);
        panel.add(logoutButton);

        registerExamGradesButton.addActionListener(e -> {
            String courseId = JOptionPane.showInputDialog("Enter Course ID:");
            String examId = JOptionPane.showInputDialog("Enter Exam ID:");
            Course course = department.getCourse(courseId);
            if (course != null) {
                instructor.registerExamGrades(courseId, examId, course.getStudents());
            } else {
                JOptionPane.showMessageDialog(frame, "Course not found.");
            }
        });

        listGradesButton.addActionListener(e -> {
            String courseId = JOptionPane.showInputDialog("Enter Course ID:");
            String examId = JOptionPane.showInputDialog("Enter Exam ID:");
            Course course = department.getCourse(courseId);
            if (course != null) {
                instructor.listGradesForExam(courseId, examId, course.getStudents());
            } else {
                JOptionPane.showMessageDialog(frame, "Course not found.");
            }
        });
        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginHandler(department).showLoginScreen();
        });
        frame.add(panel);
        frame.setVisible(true);
    }
}

class DepartmentDashboard {
    public DepartmentDashboard(Department department) {
        JFrame frame = new JFrame("Department Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.add(new JLabel("Department: " + department.toString()));

        JButton listCoursesButton = new JButton("List All Courses");
        JButton listStudentsButton = new JButton("List All Students");
        JButton listInstructorsButton = new JButton("List All Instructors");
        JButton createCourseButton = new JButton("Create New Course");
        JButton assignInstructorButton = new JButton("Assign Instructor to Course");
        JButton logoutButton = new JButton("Logout");

        panel.add(listCoursesButton);
        panel.add(listStudentsButton);
        panel.add(listInstructorsButton);
        panel.add(createCourseButton);
        panel.add(assignInstructorButton);
        panel.add(logoutButton);

        listCoursesButton.addActionListener(e -> {
            StringBuilder courses = new StringBuilder("Courses:\n");
            for (Course course : department.getCourses()) {
                courses.append(course.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, courses.toString());
        });

        listStudentsButton.addActionListener(e -> {
            StringBuilder students = new StringBuilder("Students:\n");
            for (Student student : Department.getStudents()) {
                students.append(student.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, students.toString());
        });

        listInstructorsButton.addActionListener(e -> {
            StringBuilder instructors = new StringBuilder("Instructors:\n");
            for (Instructor instructor : department.getInstructors()) {
                instructors.append(instructor.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, instructors.toString());
        });


        createCourseButton.addActionListener(e -> {
            String createdCourseId = JOptionPane.showInputDialog("Enter Course ID:");
            String createdCourseName = JOptionPane.showInputDialog("Enter Course Name:");
            if (createdCourseId != null && createdCourseName != null) {
                Course course = new Course(createdCourseId, createdCourseName);
                //department.createCourse(createdCourseId, createdCourseName);

                JOptionPane.showMessageDialog(frame, "Course created: " + createdCourseName);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid input.");
            }
        });

        assignInstructorButton.addActionListener(e -> {
            String courseName = JOptionPane.showInputDialog("Enter Course Name:");
            String instructorName = JOptionPane.showInputDialog("Enter Instructor Name:");
            if (courseName != null && instructorName != null) {
                if (Objects.equals(Course.getCoursename(), courseName)) { // equals instead of  Course.getCoursename() == courseName
                    department.assignInstructorToCourse(instructorName, courseName);
                    JOptionPane.showMessageDialog(frame, "Instructor " + instructorName + " assigned to course " + courseName);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid input.");
            }
        });
        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginHandler(department).showLoginScreen();
        });
        frame.add(panel);
        frame.setVisible(true);
    }
}
