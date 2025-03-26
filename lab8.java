import java.util.Scanner;

class StudentRegistration implements Runnable {

    private String studentName;

    public StudentRegistration(String studentName) {
        this.studentName = studentName;
    }

    public void run() {
        System.out.println("Registering " + studentName + "...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(studentName + " has been registered successfully!");
    }
}

class FeePayment implements Runnable {

    private String studentName;
    private int amount;

    public FeePayment(String studentName, int amount) {
        this.studentName = studentName;
        this.amount = amount;
    }

    public void run() {
        System.out.println("Processing fee payment for " + studentName + ": Rupees " + amount + "...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Payment of Rupees " + amount + " received for " + studentName + "!");
    }
}

class ReportGeneration implements Runnable {

    private static final Object lock = new Object();

    public void run() {
        synchronized (lock) {
            System.out.println("Generating academic report...");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Report generated successfully!");
        }
    }
}

public class lab8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = "";
        while (true) {
            System.out.print("Enter student name for registration: ");
            studentName = scanner.nextLine().trim();
            if (studentName.isEmpty()) {
                System.out.println("Error: Student name cannot be empty. Please enter a valid name.");
            } else {
                break;
            }
        }

        String feeStudentName = "";
        while (true) {
            System.out.print("Enter student name for fee payment: ");
            feeStudentName = scanner.nextLine().trim();
            if (feeStudentName.isEmpty()) {
                System.out.println("Error: Fee student name cannot be empty. Please enter a valid name.");
            } else {
                break;
            }
        }

        int amount = -1;
        while (true) {
            System.out.print("Enter amount for fee payment: ");
            if (scanner.hasNextInt()) {
                amount = scanner.nextInt();
                if (amount <= 0) {
                    System.out.println("Error: Amount must be greater than zero.");
                } else {
                    break;
                }
            } else {
                System.out.println("Error: Please enter a valid amount.");
                scanner.next(); 
            }
        }
        scanner.nextLine();
        Thread t1 = new Thread(new StudentRegistration(studentName));
        Thread t2 = new Thread(new FeePayment(feeStudentName, amount));
        Thread t3 = new Thread(new ReportGeneration());
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
        System.out.println("All tasks completed!");
    }
}
