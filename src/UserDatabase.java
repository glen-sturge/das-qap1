import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDatabase {
    private ArrayList<User> users;

    public void writeUserDatabaseToFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        System.out.println("User records saved to disk...");
        oos.close();
        fos.close();
    }

    public void readUserDatabaseFromFile() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserDatabase() {
        users = new ArrayList<>();
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public void addUser(String firstName, String lastName, String phoneNumber) {
        User newUser = new User(firstName, lastName, phoneNumber);
        users.add(newUser);
    }

    public User getUserByIndex(int index) {
        return users.get(index);
    }

    public void displaySearchList(ArrayList<Integer> indexList) {
        for (int i = 0; i < indexList.size(); i ++) {
            System.out.printf("(%s)\n", i + 1);
            System.out.println(users.get(indexList.get(i)));
        }
    }

    public ArrayList<Integer> getUserByFirstName(String firstName) {
        return getUserBySearchType("firstName", firstName);
    }
    public ArrayList<Integer> getUserByLastName(String lastName) {
       return getUserBySearchType("lastName", lastName);
    }
    public ArrayList<Integer> getUserByPhoneNumber(String phoneNumber) {
       return getUserBySearchType("phoneNumber", phoneNumber);
    }
    public ArrayList<Integer> getUserByUUID(String uuid) {
        return getUserBySearchType("uuid", uuid);
    }
    public ArrayList<Integer> getUserBySearchType(String type, String searchString){
        String searchPattern =
                String.format("(?i)%s", searchString);
        Pattern p = Pattern.compile(searchPattern);

        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            Matcher m = null;
            switch (type){
                case "firstName":
                    m = p.matcher(users.get(i).getFirstName());
                    break;
                case "lastName":
                    m = p.matcher(users.get(i).getLastName());
                    break;
                case "phoneNumber":
                    m = p.matcher(users.get(i).getPhoneNumber());
                    break;
                case "uuid":
                    m = p.matcher(users.get(i).getUserUUID());
                    break;
            }
            if (m.find()) {
                results.add(i);
            }
        }
        return results;
    }


    public void showAllUsers() {
        for (int i = 0; i < users.size(); i++) {
            System.out.printf("(%s)\n", i + 1);
            System.out.println(users.get(i));
        }
    }
}
