import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookDatabase db = new BookDatabase();
        UserDatabase userDb = new UserDatabase();
        if (FileExistenceChecker.checkPath("users.ser")) {
            try {
                userDb.readUserDatabaseFromFile();
                System.out.println("Users loaded from file...");
            } catch (IOException | ClassNotFoundException e ) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Initializing user database...\n");
            initializeUserDb(userDb);
        }
        if (FileExistenceChecker.checkPath("books.ser")) {
            try {
                db = BookDatabase.readBookDatabaseFromFile();
                System.out.println("Books loaded from file...");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Initializing book database...\n");
            initializeDB(db);
        }
        Scanner scanner = new Scanner(System.in);

        Menu.setDb(db);
        Menu.setUserDb(userDb);
        Menu.setScanner(scanner);
        Menu.mainMenu();

        scanner.close();
        try {
            userDb.writeUserDatabaseToFile();
            BookDatabase.writeUserDatabaseToFile(db);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void initializeUserDb(UserDatabase userDb) {
        userDb.addUser("Bob", "Loblaw", "7771112463");
        userDb.addUser("Lindsay", "Looper", "7685441515");
        userDb.addUser("Mark", "Smith", "2224204334");
        userDb.addUser("Harriet", "Hainseley", "2402226427");
    }

    static void initializeDB(BookDatabase db) {
        db.addBook(
                "Rich Dad Poor Dad: What the Rich Teach Their Kids About Money That the Poor and Middle Class Do Not!",
                "Robert T. Kiyosaki",
                "1612681131"
        );
        db.addBook(
                "The Psychology of Money: Timeless lessons on wealth, greed, and happiness",
                "Morgan Housel",
                "0857197681"
        );
        db.addBook(
                "The 48 Laws of Power",
                "Robert Greene",
                "0140280197"
        );
        db.addBook(
                "The Art of War",
                "Sun Tzu",
                "144133985X"
        );
        db.addBook(
                "Scientific Advertising: Original Classic Edition",
                "Claude Hopkins",
                "1640954252"
        );
        db.addBook(
                "Expressly Human: Decoding the Language of Emotion",
                "Mark Changizi",
                "1637740484"
        );
        db.addBook(
                "The Parasitic Mind: How Infectious Ideas Are Killing Common Sense",
                "Gad Saad",
                "1684512298"
        );
        db.addBook(
                "Start with Why: How Great Leaders Inspire Everyone to Take Action",
                "Simon Sinek",
                "1591846444"
        );
        db.addBook(
                "The Phoenix Project: A Novel about IT, DevOps, and Helping Your Business Win",
                "Gene Kim",
                "1942788290"
        );
        db.addBook(
                "Accelerate: The Science of Lean Software and DevOps: Building and Scaling High Performing Technology Organizations",
                "Nicole Forsgren PhD",
                "1942788339"
        );
    }
}
