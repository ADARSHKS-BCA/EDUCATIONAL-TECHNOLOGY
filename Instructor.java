package educational;
public final class Instructor extends Employee{
    private String specialization;
    private int yearsOfExperience;
    private float rating;
    public Instructor(String name, String email, String phoneNumber, String address, String employeeID,
    String joiningDate, String specialization, int yearsOfExperience, float rating) {
        super(name, email, phoneNumber, address, employeeID, joiningDate);
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.rating = rating;
    }
    public void displayDetails() {
        super.displayEmployeeDetails();
        System.out.println("Specialization: " + specialization);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Rating: " + rating);
    }
}
