import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static String menuTop = "▛" + "▀".repeat(98) + "▜";
    private static String menuBottom = "▙" + "▄".repeat(98) + "▟";
    private static String menuSpace = "▌" + " ".repeat(98) + "▐";
    private static void menuItem(String text) {
        System.out.println("▌" + centerInField(text, 98) + "▐");
    }
    static String centerInField(String text, int fieldWidth){
        int spacesToAdd = fieldWidth - text.length();
        int leftPad = spacesToAdd / 2;
        int rightPad = spacesToAdd - leftPad;
        return " ".repeat(leftPad) + text + " ".repeat(rightPad);
    }

    private static Scanner scanner;
    private static BookDatabase db;

    public static void main(String[] args) {
        System.out.println("Initializing book database...\n");
        db = new BookDatabase();
        initializeDB(db);

        scanner = new Scanner(System.in);

        mainMenu();

        scanner.close();
    }

    private static void mainMenu() {

        int input;
        boolean running = true;
        while (running) {
            System.out.println(menuTop);
            System.out.println(menuSpace);
            menuItem("Welcome");
            System.out.println(menuSpace);
            menuItem("1. Search For A Book");
            menuItem("2. Checkout A Book");
            menuItem("3. Return A Book");
            menuItem("4. Exit");
            System.out.println(menuSpace);
            System.out.println(menuBottom);

            int selection = getMenuSelection(4);

            switch (selection) {
                case 1:
                    searchMenu();
                    break;
                case 2:
//                    checkoutMenu();
                    break;
                case 3:
//                    returnMenu();
                    break;
                case 4:
                    System.out.println("Thanks! Have a nice day!");
                    running = false;
                    break;
            }
        }
    }

    private static void searchMenu() {
        int input;
        boolean running = true;
        System.out.println(menuTop);
        System.out.println(menuSpace);
        menuItem("Welcome");
        System.out.println(menuSpace);
        menuItem("1. Search By Title");
        menuItem("2. Search By Author");
        menuItem("3. Search By ISBN");
        menuItem("4. Exit");
        System.out.println(menuSpace);
        System.out.println(menuBottom);

        int selection = getMenuSelection(4);

        switch (selection) {
            case 1:
                search("title");
                break;
            case 2:
                search("author");
                break;
            case 3:
                search("isbn");
                break;
            case 4:
                break;
        }
    }

    private static void search(String type) {
        String searchString;
        while (true) {
            System.out.print("Enter Search String: ");
            searchString = scanner.next();
            scanner.nextLine();
            if (type.equals("isbn")) {
                if (searchString.length() != 10) {
                    System.out.println("Must be 10 characters!");
                    continue;
                }
            }
            break;
        }
        System.out.println();
        System.out.println(menuTop);
        menuItem("Results");
        System.out.println(menuBottom);

        ArrayList<Integer> results;
        switch (type) {
            case "title":
                results = db.titleSearch(searchString);
                break;
            case "author":
                results = db.AuthorSearch(searchString);
                break;
            case "isbn":
                results = db.isbnSearch(searchString);
                break;
            default:
                results = null;
        }

        if (results != null) {
            for (int result : results) {
                System.out.println(db.getBookInfo(result));
                System.out.println();
            }
        } else {
            System.out.println("No results.");
        }

        System.out.println("Press Enter To Continue...");
        try {
            System.in.read();
        } catch (Exception e) {}
    }

    static int getMenuSelection(int numberOfChoices) {
        int input;
        while (true) {
            System.out.println();
            System.out.print("Enter Selection: ");
            try {
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.nextLine();
                continue;
            }
            if (input >= 1 && input <= numberOfChoices) {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
        return input;
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
