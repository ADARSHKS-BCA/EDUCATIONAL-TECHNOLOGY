package educational.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int ch = 1;

        while (ch == 1) {
            System.out.println("Enter the instructor's name:");
            String name = a.nextLine();
            if (name.length() <= 8) {
                System.out.println("Name should be more than 8 characters");
            }
            System.out.println("Enter the instructor's email:");
            String email = a.nextLine();
            if (email.indexOf('@') == -1) {
                System.out.println("Email should contain @");
                email = a.nextLine();
            }
            System.out.println("Enter the instructor's phone number:");
            String phoneNumber = a.nextLine();
            if (phoneNumber.length() != 10) {
                System.out.println("Phone number should be 10 digits");
                phoneNumber = a.nextLine();
            }
            System.out.println("Enter the instructor's address:");
            String address = a.nextLine();
            System.out.println("Enter the instructor's employee ID:");
            String employeeID = a.nextLine();
            System.out.println("Enter the instructor's joining date (YYYY-MM-DD):");
            String joiningDate = a.nextLine();
            System.out.println("Enter the instructor's specialization:");
            String specialization = a.nextLine();
            System.out.println("Enter the instructor's years of experience:");
            int yearsOfExperience = a.nextInt();
            if (yearsOfExperience < 3) {
                System.out.println("Years of experience should be greater than 3");
            }
            System.out.println("Enter the instructor's rating:");
            float rating = a.nextFloat();
            a.nextLine(); 

            Instructor instructor = new Instructor(
                name, email, phoneNumber, address, employeeID, joiningDate, specialization, yearsOfExperience, rating
            );
            System.out.println("\nInstructor Details:");
            instructor.displayDetails();
            System.out.println("\nDo you want to continue? 1. Yes 2. No");
            ch = a.nextInt();
            a.nextLine(); 
        }
        System.out.println("Thanks for using the application.");
    }
}
