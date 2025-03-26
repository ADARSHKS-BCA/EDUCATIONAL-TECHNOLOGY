package educational;
public abstract class Person {
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String address;
    public Person(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public void displayBasicDetails() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }
    public abstract void displayDetails();
}
