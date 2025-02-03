package librarymanagement.driverclass;

import java.util.List;

import librarymanagement.models.book;
import librarymanagement.services.libraryservice;


public class driver
{
	public static void main(String[] args)
	{
		libraryservice library = new libraryservice();

        // Add books
        library.addBook("1234567890", "Effective Java", "Joshua Bloch");
        library.addBook("0987654321", "Clean Code", "Robert C. Martin");

        // Register users
        library.registerUser(1, "Alice", "alice@example.com");
        library.registerUser(2, "Bob", "bob@example.com");

        // Borrow a book
        library.borrowBook(1, "1234567890");

        // List available books
        List<book> availableBooks = library.listAvailableBooks();
        availableBooks.forEach(book -> System.out.println(book.getTitle()));

        // Return a book
        library.returnBook(1, "1234567890");
    }
}
