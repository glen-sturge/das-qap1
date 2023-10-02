import java.util.ArrayList;

public class UserDatabase {
    private ArrayList<User> users;

    public UserDatabase() {
        users = new ArrayList<>();
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }
}
