package studentgradesystem;

import java.util.ArrayList;
import java.util.Scanner;

// 1. Abstraction: Abstract class definition
abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Encapsulation: Getter and Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Abstract method
    public abstract void displayDetails();
}

// 2. Course details class
class Course {
    private String courseName;
    private double mid, assignment, project, finalExam, totalMarks;
    private char courseGrade;
    private double gradePoint;

    public Course(String name, double m, double a, double p, double f) {
        this.courseName = name;
        this.mid = m;
        this.assignment = a;
        this.project = p;
        this.finalExam = f;
        this.totalMarks = m + a + p + f; // Total out of 100
        calculateCourseGrade();
    }

    private void calculateCourseGrade() {
        // Grading scale based on 100%
        if (totalMarks >= 90) { courseGrade = 'A'; gradePoint = 4.0; }
        else if (totalMarks >= 80) { courseGrade = 'B'; gradePoint = 3.0; }
        else if (totalMarks >= 75) { courseGrade = 'C'; gradePoint = 2.5; }
        else if (totalMarks >= 70) { courseGrade = 'D'; gradePoint = 2.0; }
        else if (totalMarks >= 60) { courseGrade = 'E'; gradePoint = 1.0; }
        else { courseGrade = 'F'; gradePoint = 0.0; }
    }

    public String getCourseName() { return courseName; }
    public double getTotalMarks() { return totalMarks; }
    public char getCourseGrade() { return courseGrade; }
    public double getGradePoint() { return gradePoint; }
}

// 3. Inheritance: Student inheriting from Person
class Student extends Person {
    private String id;
    private ArrayList<Course> courses;
    private double gpa;

    public Student(String id, String name) {
        super(name);
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public String getId() { return id; }
    
    public void addCourse(Course course) {
        courses.add(course);
        calculateGPA();
    }

    public void clearCourses() { courses.clear(); }

    private void calculateGPA() {
        if (courses.isEmpty()) return;
        double sum = 0;
        for (Course c : courses) sum += c.getGradePoint();
        this.gpa = sum / courses.size();
    }

    @Override
    public void displayDetails() {
        System.out.println("\n[ Student ID: " + id + " | Name: " + getName() + " ]");
        if (courses.isEmpty()) {
            System.out.println("  -> No courses assigned yet.");
        } else {
            System.out.println("  Course Details (Out of 100):");
            for (Course c : courses) {
                System.out.println("  - " + c.getCourseName() + ": Total Marks = " + c.getTotalMarks() + " | Grade = " + c.getCourseGrade());
            }
            System.out.printf("  OVERALL GPA: %.2f\n", gpa);
        }
    }
}

// Main System Class
public class StudentGradeSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getIntInput("Select an option: ");
            switch (choice) {
                case 1: registerStudent(); break;
                case 2: assignMarks(); break;
                case 3: displayAll(); break;
                case 4: searchByID(); break;
                case 5: updateMarks(); break;
                case 6: deleteByID(); break;
                case 7: studentList.clear(); System.out.println("All records deleted."); break;
                case 0: System.out.println("Exiting System..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n======= STUDENT GRADE SYSTEM (100% SCALE) =======");
        System.out.println("1. Register Student");
        System.out.println("2. Assign Course Marks (Final 40%)");
        System.out.println("3. Display All Students");
        System.out.println("4. Search Student by ID");
        System.out.println("5. Update Student Marks");
        System.out.println("6. Delete Student by ID");
        System.out.println("7. Delete All Records");
        System.out.println("0. Exit");
    }

    private static void registerStudent() {
        System.out.print("Enter Unique ID: ");
        String id = scanner.next();
        if (findStudent(id) != null) {
            System.err.println("Error: ID " + id + " already exists!");
            return;
        }

        scanner.nextLine();
        String name;
        while (true) {
            System.out.print("Enter Name (Letters only): ");
            name = scanner.nextLine();
            if (name.matches("^[a-zA-Z\\s]+$")) break;
            System.err.println("Error: Name must only contain letters.");
        }

        studentList.add(new Student(id, name));
        System.out.println("Student registered successfully.");
    }

    private static void assignMarks() {
        System.out.print("Enter Student ID: ");
        String id = scanner.next();
        Student s = findStudent(id);
        if (s == null) {
            System.err.println("Error: Student not found.");
            return;
        }

        String more;
        do {
            System.out.print("Enter Course Name: ");
            String cName = scanner.next();
            
            // Validation using the specified weights
            double mid = getValidMark("Mid Exam (20%)", 20);
            double ass = getValidMark("Assignment (20%)", 20);
            double proj = getValidMark("Project (20%)", 20);
            double fin = getValidMark("Final Exam (40%)", 40);

            s.addCourse(new Course(cName, mid, ass, proj, fin));
            System.out.print("Add another course for this student? (yes/no): ");
            more = scanner.next();
        } while (more.equalsIgnoreCase("yes"));
    }

    private static void updateMarks() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.next();
        Student s = findStudent(id);
        if (s != null) {
            s.clearCourses(); // Reset courses to re-enter
            System.out.println("Updating marks (Final is 40%)...");
            assignMarks();
        } else {
            System.err.println("Error: Student not found.");
        }
    }

    private static void searchByID() {
        System.out.print("Enter ID: ");
        String id = scanner.next();
        Student s = findStudent(id);
        if (s != null) s.displayDetails();
        else System.err.println("Error: ID not found.");
    }

    private static void deleteByID() {
        System.out.print("Enter ID to delete: ");
        String id = scanner.next();
        Student s = findStudent(id);
        if (s != null) {
            studentList.remove(s);
            System.out.println("Record removed.");
        } else {
            System.err.println("Error: Student not found.");
        }
    }

    private static void displayAll() {
        if (studentList.isEmpty()) System.out.println("No records found.");
        for (Student s : studentList) s.displayDetails();
    }

    private static Student findStudent(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }

    // Updated validation method to accept maximum limit
    private static double getValidMark(String label, double max) {
        double val;
        while (true) {
            System.out.print(label + ": ");
            if (scanner.hasNextDouble()) {
                val = scanner.nextDouble();
                if (val >= 0 && val <= max) return val;
            } else {
                scanner.next();
            }
            System.err.println("Invalid input! Enter a value between 0 and " + max);
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.err.print("Enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}