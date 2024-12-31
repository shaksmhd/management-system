# Library Management System

This is a simple library management system implemented in Java using an event-driven architecture. The system allows users to add books, register users, borrow and return books, and search for books by title, author, or ISBN. The system also enforces a maximum borrow limit for users.

## Prerequisites

- **Java**: Ensure you have Java Development Kit (JDK) version 11 or higher installed. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Git**: Ensure you have Git version 2.20.0 or higher installed. You can download it from [Git's official website](https://git-scm.com/).

## Technologies Used

- **Java**: The programming language used for development.
- **Event-Driven Architecture**: Used to decouple the operations and improve the maintainability and scalability of the code.
- **Annotations**: Custom annotations (`@MaxBorrowLimit` and `@ValidateISBN`) are used for validation.
- **Java Reflection**: Used to enforce validation rules defined by annotations.

## Features

- Add books with validation for ISBN format.
- Register users.
- Borrow and return books with a maximum borrow limit.
- Search for books by title, author, or ISBN.
- Event-driven architecture to handle different operations.

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/shaksmhd/management-system.git
   cd management-system
   ```
   
2. **Compile the code**:
    ```bash
   javac -d bin src/*.java
   ```
3. **Run the application**:
   ```bash
   java Main
   ```
   
## Usage

- Once the application is running, you will be presented with a menu of options:

- Add Book: Allows you to add a new book to the library. You will be prompted to enter the book title, author, and ISBN. If the ISBN is invalid (not 5 characters long), an error message will be displayed.

- Register User: Allows you to register a new user. You will be prompted to enter the user's name and ID.

- Borrow Book: Allows a registered user to borrow a book. You will be prompted to enter the user ID and book ISBN. If the user has already borrowed the maximum allowed number of books (default is 5), an error message will be displayed.

- Return Book: Allows a user to return a borrowed book. You will be prompted to enter the user ID and book ISBN.

- Search Books: Allows you to search for books by title, author, or ISBN. You will be prompted to enter a search query, and the matching books will be displayed.


## Code Structure

The code is organized into the following classes:

- **Main**: The Main class contains the main logic for running the application. It presents a menu to the user and handles user input.
- **Book**: The Book class represents a book with properties such as title, author, and ISBN.
- **User**: The User class represents a user with properties such as name and ID.
- **Library**: The Library class contains the logic for managing books and users. It provides methods for adding books, registering users, borrowing and returning books, and searching for books.
- **Event-Driven Architecture**: The system uses an event-driven architecture to handle different operations. Events such as BookAddedEvent, UserRegisteredEvent, BookBorrowedEvent, and BookReturnedEvent are dispatched and handled by corresponding event handlers.
- **Annotations and Validators**: Custom annotations (`@MaxBorrowLimit` and `@ValidateISBN`) are used for validation. The `Validator` class uses Java Reflection to enforce validation rules defined by annotations.
- **Validators**: The `MaxBorrowLimitValidator` and `ISBNValidator` classes implement the validation logic for the `@MaxBorrowLimit` and `@ValidateISBN` annotations, respectively.

## Example

Here is an example of using the library management system:

1. Add a book:
   - Enter book title: men of stones
   - Enter book author: shaka
   - Enter book ISBN: 00000
   - Book added successfully.
2. Register a user:
   - Enter username: john
   - Enter user ID: 123
   - User registered successfully.
3. Borrow a book:
    - Enter user ID: 123
    - Enter book ISBN: 00000
    - Book borrowed successfully.
4. Return a book:
    - Enter user ID: 123
    - Enter book ISBN: 00000
    - Book returned successfully.
5. Search for books:
    - Enter search
6. Exit the application.
7. The application will exit.

## Conclusion

This library management system demonstrates the use of an event-driven architecture in Java to implement a simple library management system. The system allows users to add books, register users, borrow and return books, and search for books by title, author, or ISBN. The system enforces a maximum borrow limit for users and uses custom annotations and validators for validation. The code is organized into classes such as Main, Book, User, Library, and event handlers, following object-oriented principles. The use of annotations and Java Reflection provides a flexible and extensible way to enforce validation rules. The system can be further extended by adding new features or improving existing functionality.

© 2024 Shaka Muhammed
