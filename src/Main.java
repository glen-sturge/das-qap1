import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing book database...\n");
        BookDatabase db = new BookDatabase();
        initializeDB(db);
        Scanner scanner = new Scanner(System.in);

        Menu.setDb(db);
        Menu.setScanner(scanner);
        Menu.mainMenu();

        scanner.close();
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
