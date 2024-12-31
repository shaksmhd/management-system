package execption;

import model.Book;

import java.util.HashSet;
import java.util.Set;

public class BookValidator {
    private static final Set<String> isbnSet = new HashSet<>();

    public static void validate(Book book) throws InvalidIsbnException {
        // Validate ISBN format (example: checking length)
        if (book.getIsbn().length() != 5) {
            throw new InvalidIsbnException("Invalid ISBN format.");
        }

        // Check for unique ISBN
        if (!isbnSet.add(book.getIsbn())) {
            throw new InvalidIsbnException("ISBN must be unique.");
        }
    }
}
