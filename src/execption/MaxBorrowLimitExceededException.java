package execption;

public class MaxBorrowLimitExceededException extends Exception {
    public MaxBorrowLimitExceededException(String message) {
        super(message);
    }
}
