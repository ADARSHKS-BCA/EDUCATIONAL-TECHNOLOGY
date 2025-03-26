package educational;
public class Employee extends Person {
    protected String employeeID;
    protected String joiningDate;

    public Employee(String name, String email, String phoneNumber, String address, String employeeID, String joiningDate) {
        super(name, email, phoneNumber, address);
        this.employeeID = employeeID;
        this.joiningDate = joiningDate;
    }
    public final void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Joining Date: " + joiningDate);
    }
    public void displayDetails() {
        displayEmployeeDetails();
    }
}
