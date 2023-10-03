import java.io.Serializable;
import java.util.UUID;
public class User implements Serializable {
    private final String userUUID;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User(String firstName, String lastName, String phoneNumber) {
        UUID uuid = UUID.randomUUID();
        userUUID = uuid.toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return String.format("User[uuid:%s,firstName:%s,lastName:%s,phone:%s]",userUUID,firstName,lastName,phoneNumber);
    }
}
