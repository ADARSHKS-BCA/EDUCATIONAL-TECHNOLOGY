import java.util.*;
import java.time.*;
class STUDENT {
    int sid, marks;
    long num;
    LocalDateTime enroll;
    String name, room, email, address, gender;

    void get() {
        Scanner a = new Scanner(System.in);
        System.out.println("ENTER THE NAME OF THE STUDENT:");
        name = a.nextLine();
        System.out.println("ENTER THE CLASS OF THE STUDENT:");
        room = a.nextLine();
        System.out.println("ENTER THE ROLL NUMBER OF THE STUDENT:");
        sid = a.nextInt();
        System.out.println("ENTER THE PHONE NUMBER OF THE STUDENT:");
        num = a.nextLong();
        System.out.println("ENTER THE EMAIL OF THE STUDENT:");
        email = a.next();
        System.out.println("ENTER THE ADDRESS OF THE STUDENT:");
        address = a.next();
        System.out.println("ENTER THE GENDER OF THE STUDENT:");
        gender = a.next();
        enroll = LocalDateTime.now();
        System.out.println("ENTER THE MARKS OF THE STUDENT:");
        marks = a.nextInt();
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + room);
        System.out.println("Roll Number: " + sid);
        System.out.println("Phone Number: " + num);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Gender: " + gender);
        System.out.println("Enrollment Number: " + enroll);
        System.out.println("Marks: " + marks);
    }

    void validation() {
        if (sid <= 0) {
            System.out.println("THE ROLL NUMBER IS INVALID.");
        } else if (name.length() > 15) {
            System.out.println("THE LENGTH OF THE NAME IS GREATER THAN 15.");
        }

        if (marks >= 85) {
            System.out.println("THE STUDENT IS PASSED IN DISTINCTION.");
        } else if (marks >= 75) {
            System.out.println("THE STUDENT PASSED IN FIRST CLASS.");
        } else if (marks >= 50) {
            System.out.println("THE STUDENT IS JUST PASSED IN SECOND CLASS.");
        } else {
            System.out.println("THE STUDENT HAS FAILED.");
        }
    }

    public static void main(String args[]) {
        STUDENT ob = new STUDENT();
        ob.get();
        ob.display();
        ob.validation();
    }
}
