import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookDatabase implements Serializable {
    private final ArrayList<String> titles;
    private final ArrayList<String> authors;
    private final ArrayList<String> ISBNs;
    private final ArrayList<Boolean> availability;

    private final ArrayList<String> heldBy;

    public BookDatabase() {
        titles = new ArrayList<>();
        authors = new ArrayList<>();
        ISBNs = new ArrayList<>();
        availability = new ArrayList<>();
        heldBy = new ArrayList<>();
    }

    public static void writeUserDatabaseToFile(BookDatabase books) throws IOException {
        FileOutputStream fos = new FileOutputStream("books.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(books);
        System.out.println("Book records saved to disk...");
        oos.close();
        fos.close();
    }

    public static BookDatabase readBookDatabaseFromFile() throws IOException, ClassNotFoundException {
        BookDatabase books = null;
        try {
            FileInputStream fis = new FileInputStream("books.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            books = (BookDatabase) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void addHeldBy(int index, String uuid) {
        heldBy.set(index, uuid);
        availability.set(index, false);
    }

    public void removeHeldBy(int index) {
        heldBy.set(index, null);
        availability.set(index, true);
    }

    public String getTitle(int index) {
        return titles.get(index);
    }

    public String getAuthor(int index) {
        return authors.get(index);
    }

    public String getISBN(int index) {
        return ISBNs.get(index);
    }

    public Boolean getAvailability(int index) {
        return availability.get(index);
    }

    public String getHeldBy(int index) {return heldBy.get(index);}

    public String getBookInfo(int index) {
        return String.format(
                "Title: %s\nAuthor: %s\nISBN-10: %s\nAvailable: %s\nHeldBy: %s",
                this.getTitle(index),
                this.getAuthor(index),
                this.getISBN(index),
                this.getAvailability(index),
                this.getHeldBy(index) == null ? "Is Available" : this.getHeldBy(index)
        );
    }

    public void addBook(String title, String author, String ISBN) {
        titles.add(title);
        authors.add(author);
        ISBNs.add(ISBN);
        availability.add(true);
        heldBy.add(null);
    }

    public void removeBook(String isbn) {
        int index = isbnSearch(isbn).get(0);
        titles.remove(index);
        authors.remove(index);
        ISBNs.remove(index);
        availability.remove(index);
    }

    public ArrayList<Integer> search(String searchString, ArrayList<String> arrayListToSearch) {
        String searchPattern =
                String.format("(?i)%s", searchString);
        Pattern p = Pattern.compile(searchPattern);

        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 0; i < arrayListToSearch.size(); i++) {
            Matcher m = p.matcher(arrayListToSearch.get(i));
            if (m.find()) {
                results.add(i);
            }
        }
        return results;
    }

    public ArrayList<Integer> titleSearch(String searchString) {
        return this.search(searchString, titles);
    }

    public ArrayList<Integer> AuthorSearch(String searchString) {
        return this.search(searchString, authors);
    }

    public ArrayList<Integer> isbnSearch(String searchString) {
        return this.search(searchString, ISBNs);
    }
}
