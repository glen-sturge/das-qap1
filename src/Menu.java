import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    private static BookDatabase db;
    private static Scanner scanner;
    public static void setDb(BookDatabase dbase) {
        db = dbase;
    }
    public static void setScanner(Scanner sc) {
        scanner = sc;
    }

    private static void menuTop() {
        System.out.println("▛" + "▀".repeat(98) + "▜");
    }
    private static void menuBottom() {
        System.out.println("▙" + "▄".repeat(98) + "▟");
    }
    private static void menuSpace() {
        System.out.println("▌" + " ".repeat(98) + "▐");
    }
    private static void menuItem(String text) {
        System.out.println("▌" + centerInField(text, 98) + "▐");
    }
    static String centerInField(String text, int fieldWidth){
        int spacesToAdd = fieldWidth - text.length();
        int leftPad = spacesToAdd / 2;
        int rightPad = spacesToAdd - leftPad;
        return " ".repeat(leftPad) + text + " ".repeat(rightPad);
    }

    public static void mainMenu() {

        int input;
        boolean running = true;
        while (running) {
            menuTop();
            menuSpace();
            menuItem("Library Catalog System");
            menuSpace();
            menuItem("1. Search For A Book");
            menuItem("2. Checkout A Book  ");
            menuItem("3. Return A Book    ");
            menuItem("4. Exit             ");
            menuSpace();
            menuBottom();

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
        menuTop();
        menuSpace();
        menuItem("Welcome");
        menuSpace();
        menuItem("1. Search By Title");
        menuItem("2. Search By Author");
        menuItem("3. Search By ISBN");
        menuItem("4. Exit");
        menuSpace();
        menuBottom();

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
        menuTop();
        menuItem("Results");
        menuBottom();

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
            System.out.println();
            for (int i = 0; i < results.size(); i++) {
                System.out.printf("(%s)\n", i + 1);
                System.out.println(db.getBookInfo(results.get(i)));
                System.out.println();
            }
        } else {
            System.out.println("No results.");
        }

        System.out.println("Press Enter To Continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {}
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
}
