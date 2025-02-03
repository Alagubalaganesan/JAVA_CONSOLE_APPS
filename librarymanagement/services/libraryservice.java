package librarymanagement.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import librarymanagement.models.*;
public class libraryservice
{
	 private Map<String, book> bookCatalog = new HashMap<>();
	    private Map<Integer, user> userDatabase = new HashMap<>();
	    private static final int BORROW_LIMIT = 5;
	    private static final int PENALTY_DAYS = 14;
	    
	    public void addBook(String isbn, String title, String author) {
	        book book = new book();
	        book.setIsbn(isbn);
	        book.setTitle(title);
	        book.setAuthor(author);
	        book.setStatus(bookstatus.AVAILABLE);
	        bookCatalog.put(isbn, book);
	    }
	    
	    public void registerUser(int id, String name, String email) {
	        user user = new user();
	        user.setId(id);
	        user.setName(name);
	        user.setEmail(email);
	        user.setBorrowedBooksCount(0);
	        userDatabase.put(id, user);
	    }
	    public boolean borrowBook(int userId, String isbn) {
	        user user = userDatabase.get(userId);
	        book book = bookCatalog.get(isbn);

	        if (user == null || book == null) {
	            System.out.println("Invalid user or book.");
	            return false;
	        }

	        if (user.getBorrowedBooksCount() >= BORROW_LIMIT) {
	            System.out.println("User has reached the borrowing limit.");
	            return false;
	        }

	        if (book.getStatus() != bookstatus.AVAILABLE) {
	            System.out.println("Book is not available.");
	            return false;
	        }

	        book.setStatus(bookstatus.BORROWED);
	        book.setBorrowedDate(new Date());
	        user.setBorrowedBooksCount(user.getBorrowedBooksCount() + 1);
	        System.out.println("Book borrowed successfully.");
	        return true;
	    }
	    
	    
	    public boolean returnBook(int userId, String isbn) {
	        user user = userDatabase.get(userId);
	        book book = bookCatalog.get(isbn);

	        if (user == null || book == null || book.getStatus() != bookstatus.BORROWED) {
	            System.out.println("Invalid return operation.");
	            return false;
	        }

	        Date borrowedDate = book.getBorrowedDate();
	        long daysBorrowed = (new Date().getTime() - borrowedDate.getTime()) / (1000 * 60 * 60 * 24);

	        if (daysBorrowed > PENALTY_DAYS) {
	            System.out.println("Book is overdue. A penalty applies.");
	        }

	        book.setStatus(bookstatus.AVAILABLE);
	        book.setBorrowedDate(null);
	        user.setBorrowedBooksCount(user.getBorrowedBooksCount() - 1);
	        System.out.println("Book returned successfully.");
	        return true;
	    }
	    
	    
	    
	    
	    public List<book> listAvailableBooks() {
	        List<book> availableBooks = new ArrayList<>();
	        for (book book : bookCatalog.values()) {
	            if (book.getStatus() == bookstatus.AVAILABLE) {
	                availableBooks.add(book);
	            }
	        }
	        return availableBooks;
	    }
}
