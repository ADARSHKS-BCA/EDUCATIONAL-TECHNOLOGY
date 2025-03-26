
import java.util.*;

class Student implements Comparable<Student> {

    private int studentId;
    private String studentName;
    private List<String> enrolledCourses;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void enrollCourse(String course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            System.out.println(studentName + " enrolled in " + course);
        } else {
            System.out.println("Student already enrolled in this course.");
        }
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Enrolled Courses: " + enrolledCourses);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentId, other.studentId);
    }
}

class Course implements Comparable<Course> {

    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
    }

    @Override
    public int compareTo(Course other) {
        return this.courseCode.compareTo(other.courseCode);
    }
}

class EducationalManagementSystem {

    private List<Student> students;
    private List<Course> courses;
    private Scanner scanner;

    public EducationalManagementSystem() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId() == id) {
                System.out.println("Student ID already exists.");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty.");
            return;
        }

        students.add(new Student(id, name));
        System.out.println("Student added successfully.");
    }

    public void addCourse() {
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine().trim();

        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(code)) {
                System.out.println("Course code already exists.");
                return;
            }
        }

        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Course name cannot be empty.");
            return;
        }

        courses.add(new Course(code, name));
        System.out.println("Course added successfully.");
    }

    public void enrollStudentInCourse() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine().trim();

        Student student = null;
        Course course = null;

        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                student = s;
                break;
            }
        }

        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                course = c;
                break;
            }
        }

        if (student == null) {
            System.out.println("Invalid Student ID.");
            return;
        }
        if (course == null) {
            System.out.println("Invalid Course Code.");
            return;
        }

        student.enrollCourse(courseCode);
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = students.removeIf(student -> student.getStudentId() == id);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteCourse() {
        System.out.print("Enter Course Code to delete: ");
        String code = scanner.nextLine().trim();

        boolean removed = courses.removeIf(course -> course.getCourseCode().equalsIgnoreCase(code));
        if (removed) {
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            student.displayStudentInfo();
        }
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course course : courses) {
            course.displayCourseInfo();
        }
    }

    public void sortStudentsById() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }
        Collections.sort(students);
        System.out.println("\nStudents sorted by ID:");
        for (Student student : students) {
            student.displayStudentInfo();
        }
    }

    public void sortCoursesByCode() {
        if (courses.isEmpty()) {
            System.out.println("No courses to sort.");
            return;
        }
        Collections.sort(courses);
        System.out.println("\nCourses sorted by Course Code:");
        for (Course course : courses) {
            course.displayCourseInfo();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nEducational Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Display All Students");
            System.out.println("5. Display All Courses");
            System.out.println("6. Delete Student");
            System.out.println("7. Delete Course");
            System.out.println("8. Sort Students by ID");
            System.out.println("9. Sort Courses by Code");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudentInCourse();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    displayAllCourses();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    deleteCourse();
                    break;
                case 8:
                    sortStudentsById();
                    break;
                case 9:
                    sortCoursesByCode();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class lab9 {

    public static void main(String[] args) {
        EducationalManagementSystem ems = new EducationalManagementSystem();
        ems.menu();
    }
}
