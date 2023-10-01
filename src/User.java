public class User {
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;

    public User(String firstName, String lastName, Address address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
