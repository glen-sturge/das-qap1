import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookDatabase {
    private final ArrayList<String> titles;
    private final ArrayList<String> authors;
    private final ArrayList<String> ISBNs;
    private final ArrayList<Boolean> availability;

    public BookDatabase() {
        titles = new ArrayList<>();
        authors = new ArrayList<>();
        ISBNs = new ArrayList<>();
        availability = new ArrayList<>();
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

    public String getBookInfo(int index) {
        return String.format(
                "Title: %s\nAuthor: %s\nISBN-10: %s\nAvailable: %s",
                this.getTitle(index),
                this.getAuthor(index),
                this.getISBN(index),
                this.getAvailability(index)
        );
    }

    public void addBook(String title, String author, String ISBN) {
        titles.add(title);
        authors.add(author);
        ISBNs.add(ISBN);
        availability.add(true);
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
