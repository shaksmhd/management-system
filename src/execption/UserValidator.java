package execption;

import model.User;

import java.lang.reflect.Field;

public class UserValidator {
    public static void validate(User user) throws MaxBorrowLimitExceededException {
        try {
            Field borrowedBooksField = User.class.getDeclaredField("borrowedBooks");
            if (borrowedBooksField.isAnnotationPresent(MaxBorrowLimit.class)) {
                MaxBorrowLimit maxBorrowLimit = borrowedBooksField.getAnnotation(MaxBorrowLimit.class);
                if (user.getBorrowedBooks().size() >= maxBorrowLimit.value()) {
                    throw new MaxBorrowLimitExceededException("User cannot borrow more than " + maxBorrowLimit.value() + " books.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
