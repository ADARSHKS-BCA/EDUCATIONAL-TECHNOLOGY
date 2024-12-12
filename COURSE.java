import java.util.*;
class Course {
    private int id;
    private String title;
    private String description;
    private String lang;
    private int credits;
    private int maxEnroll;
    private int duration;
    private int instructorId;
    public Course() {
        this.id = 0;
        this.title = "";
        this.description = "";
        this.lang = "";
        this.credits = 0;
        this.maxEnroll = 0;
        this.duration = 0;
        this.instructorId = 0;
    }
    public Course(int id, String title, String description, String lang, int credits, int maxEnroll, int duration, int instructorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lang = lang;
        this.credits = credits;
        this.maxEnroll = maxEnroll;
        this.duration = duration;
        this.instructorId = instructorId;
    }
    void getdata() {
        Scanner a = new Scanner(System.in);
        System.out.print("ENTER THE ID:");
        id = a.nextInt();
        a.nextLine();
        System.out.print("ENTER THE Title: ");
        title = a.nextLine();
        System.out.print("ENTER THE Description: ");
        description = a.nextLine();
        System.out.print("ENTER THE Language: ");
        lang = a.nextLine();
        System.out.print("ENTER THE Credits: ");
        credits = a.nextInt();
        a.nextLine();
        System.out.print("ENTER THE Max Enrollment: ");
        maxEnroll = a.nextInt();
        a.nextLine();
        System.out.print("ENTER THE Duration: ");
        duration = a.nextInt();
        a.nextLine();
        System.out.print("ENTER THE Instructor ID: ");
        instructorId = a.nextInt();
    }
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Language: " + lang);
        System.out.println("Credits: " + credits);
        System.out.println("Max Enrollment: " + maxEnroll);
        System.out.println("Duration: " + duration);
        System.out.println("Instructor ID: " + instructorId);
    }
    void checkCredits() {
        if (credits > 5) {
            System.out.println("This course has more than 5 credits.");
        } else {
            System.out.println("This course has less than or equal to 5 credits.");
        }
    }
    void checkEnrollment() {
        if (maxEnroll > 50) {
            System.out.println("This course has more than 50 students enrolled.");
        } else {
            System.out.println("This course has less than or equal to 50 students enrolled.");
        }
    }
    void checkDuration() {
        if (duration > 3) {
            System.out.println("This course has a duration of more than 3 months.");
        } else {
            System.out.println("This course has a duration of less than or equal to 3 months.");
        }
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many courses do you want to : ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();
        Course[] courses = new Course[numCourses];
        int ch = 1; // Initialize ch to 1
        while(ch==1)
        {
            for (int i = 0; i < numCourses; i++) {
                System.out.println("\nEnter details for Course " + (i + 1) + ":");
                courses[i] = new Course();
                courses[i].getdata();
            }
            System.out.println("\nCourse Details:\n");
            for (int i = 0; i < numCourses; i++) {
                System.out.println("Details for Course " + (i + 1) + ":");
                courses[i].display();
                courses[i].checkCredits();
                courses[i].checkEnrollment();
                courses[i].checkDuration();
                System.out.println("----------------------");
            }
            Scanner c=new Scanner(System.in);
            System.out.println("ENTER 1 FOR CONTINUING OR 0 TO EXIT:");
            ch=c.nextInt();
        }
    }
}
