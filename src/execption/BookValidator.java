package execption;

import model.Book;

public class BookValidator {
    public static void validate(Book book) throws InvalidIsbnException {
        // Validate ISBN format (example: checking length)
        if (book.getIsbn().length() != 5) {
            throw new InvalidIsbnException("Invalid ISBN format.");
        }
    }
}
